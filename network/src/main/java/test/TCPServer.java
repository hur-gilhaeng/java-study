package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();

			// 1-1. Time-Wait 시간에 소켓에 포트번호 할당을 가능하게 하기 위해서 작성
			// Time-wait 상태에서 서버 재실행이 가능하게 끔 함
			// 2020_01_20_수정
			serverSocket.setReuseAddress(true);

			// 2. 바인딩 : 'Socket Address'(IP Address + Port) Binding
			// "127.0.0.1"와 같이 절대주소 보다는 naming된 주소를 쓰자... ex) www.naver.com등등
			// serverSocket.bind(new InetSocketAddress("127.0.0.1", 5000));
			serverSocket.bind(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			// 3. accept
			Socket socket = serverSocket.accept(); // blocking
			// accept하면 Socket객체를 생성.

			InetSocketAddress remoteInetSocketAddress =
					(InetSocketAddress) socket.getRemoteSocketAddress();

			InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
			String remoteHostAddress = remoteInetAddress.getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();

			System.out.println(
					"[server] connected by client[" 
							+ remoteHostAddress + ":" + remotePort + "]");

			try {
				// 4. IOStream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				while (true) {
					// 5. 데이터 읽기
					byte[] buffer = new byte[256];

					int readByteCount = is.read(buffer); // blocking

					if (readByteCount == -1) {
						// client(remote)에서 정상종료
						System.out.println("[server] closed by client");
						break;
					}

					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server] received: " + data);

					// 잠깐 대기 (2.000초정도)
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					// 6. 데이터 쓰기
					os.write(data.getBytes("UTF-8"));
				}
			} catch (SocketException e) {
				System.out.println("[server] sedden closed by client!!!");
			} finally {
				try {
					if (socket != null && (!socket.isClosed())) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println("[server] The End");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
