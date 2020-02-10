package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerRecevieThread extends Thread {

	private Socket socket;

	public EchoServerRecevieThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// (1 ~ 3)은 EchoServer 클래스 참고

		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		// InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
		// String remoteHostAddress = remoteInetAddress.getHostAddress();
		// 위 주석 줄들을 하나로 표현하면 다음 아래 한 줄과 같다.
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
		int remotePort = remoteInetSocketAddress.getPort();

		EchoServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

		try {
			// 4. IOStream 생성(받아오기)

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			// true 는 자동 Flush() 기능 on을 의미한다
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			while (true) {
				// 5. 데이터 읽기

				String data = br.readLine();

				if (data == null) {
					// client(remote)에서 정상종료
					EchoServer.log("closed by client");
					break;
				}

				EchoServer.log("received: " + data);

				// 6. 데이터 쓰기
				pw.println(data);
			}
		} catch (SocketException e) {
			EchoServer.log("seddenly closed by client!!!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && (!socket.isClosed())) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
