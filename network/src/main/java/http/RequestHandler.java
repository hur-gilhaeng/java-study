package http;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT = "./webapp";
	private Socket socket;

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// get IOStream
			BufferedReader br 
				= new BufferedReader(
						new InputStreamReader(socket.getInputStream(), "UTF-8"));
			OutputStream outputStream = socket.getOutputStream();

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress 
					= (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog("connected from " 
					+ inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());

			String requset = null;
			while (true) {
				String line = br.readLine();
				// line == null : 브라우저가 연결을 끊음
				if (line == null) {
					break;
				}

				// "".equals(line) : Request(요청)의 헤더만 읽음
				if ("".equals(line)) {
					break;
				}

				// requset == null : Header의 첫번째 라인만 읽음
				if (requset == null) {
					requset = line;
					break;
				}
			}
			consoleLog(requset);

			String[] token = requset.split(" ");
			if ("GET".equals(token[0])) {
				responseStaticResource(outputStream, token[1], token[2]);
			} else { // [POST, DELETE, PUT], HEAD, CPNNECT
				// 응답 예시
				// HTTP/1.1 400 Bad Request\r\n
				// Content-Type:text/html; charset=utf-8\r\n
				// \r\n
				// HTML 에러 문서(./webapp/error/400.html)

				//response400Error(ouputStream, protocol);
				response400Error(outputStream, token[2]);
			}

			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
			// outputStream.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8"));
			// outputStream.write("Content-Type:text/html;charset=utf-8\r\n".getBytes("UTF-8"));
			// outputStream.write("\r\n".getBytes());
			// outputStream.write("<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes("UTF-8"));

		} catch (Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}

	private void responseStaticResource(
			OutputStream outputStream, 
			String uri, 
			String protocol) throws IOException {

		if ("/".equals(uri)) {
			uri = "/index.html";
		}

		File file = new File(DOCUMENT_ROOT + uri);
		if (!file.exists()) {
			// 응답 예시
			// HTTP/1.1 404 Not Found\r\n
			// Content-Type:text/html; charset=utf-8\r\n
			// \r\n
			// HTML 에러 문서(./webapp/error/404.html)

			//response404Error(ouputStream, protocol);
			response404Error(outputStream, protocol);

			return;
		}

		// nio
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());

		// 응답
		outputStream.write((protocol+" 200 OK\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}

	private void response400Error( 
			OutputStream outputStream, 
			String protocol) throws IOException{
		File error400 = new File(DOCUMENT_ROOT + "/error/400.html");
		byte[] body = Files.readAllBytes(error400.toPath());
		String contentType = Files.probeContentType(error400.toPath());

		// 오류 응답 400
		outputStream.write((protocol+" 400 Bad Request\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}

	private void response404Error(
			OutputStream outputStream, 
			String protocol) throws IOException{

		File error404 = new File(DOCUMENT_ROOT + "/error/404.html");
		byte[] body = Files.readAllBytes(error404.toPath());
		String contentType = Files.probeContentType(error404.toPath());

		// 오류 응답 404
		outputStream.write((protocol+" 404 Not Found\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}

	public void consoleLog(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
}
