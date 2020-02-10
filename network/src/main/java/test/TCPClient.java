package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {

		Socket socket = null;
		Scanner sc = null;

		try {
			// 1. 소켓생성
			socket = new Socket();

			// 1-1. 소켓 버퍼 사이즈 확인
			// 2020_01_20_수정
			int receiveBufferSize = socket.getReceiveBufferSize();
			int SendBufferSize = socket.getSendBufferSize();
			System.out.println(receiveBufferSize + ":" + SendBufferSize);

			// 1-2. 버퍼 사이즈 변경
			socket.setReceiveBufferSize(1024 * 10);
			socket.setSendBufferSize(1024 * 10);
			receiveBufferSize = socket.getReceiveBufferSize();
			SendBufferSize = socket.getSendBufferSize();
			System.out.println(receiveBufferSize + ":" + SendBufferSize);

			// 1-3. SO_NODELAY(Nagle off)
			socket.setTcpNoDelay(true); //

			// 1-4. SO_TIMEOUT
			// 데이터 읽기에 타임아웃 설정
			socket.setSoTimeout(1000);
			// 1.000초 안에 데이터의 읽기/쓰기가 없다면 소켓 타임아웃 익셉션 발생

			// 2. 서버연결
			// socket.connect(new InetSocketAddress("127.0.0.1", 5000));
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			System.out.println("[client] connected");

			// 3. IOStream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			sc = new Scanner(System.in);

			while (true) {

				// 4. 쓰기
				// String data = "hello world";
				String data = sc.nextLine();
				if ("q".equals(data)) {
					break;
				}
				os.write(data.getBytes("UTF-8"));

				// 5. 읽기
				byte[] buffer = new byte[256];

				int readByteCount = is.read(buffer); // blocking

				if (readByteCount == -1) {
					// client(remote)에서 정상종료
					System.out.println("[client] closed by Server");
					return;
				}

				data = new String(buffer, 0, readByteCount, "UTF-8");
				System.out.println("[client] received: " + data);
			}
		} catch (SocketTimeoutException e) {
			System.out.println("[client] Time OUT!!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[client] closed by Server!!");
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && (!socket.isClosed())) {
					socket.close();
				}
				if (sc != null) {
					sc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
