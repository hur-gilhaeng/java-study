package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 8000;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩 : 'Socket Address'(IP Address + Port) Binding
			// "127.0.0.1"와 같이 절대주소 보다는 naming된 주소를 쓰자... ex) www.naver.com등등
			// serverSocket.bind(new InetSocketAddress("127.0.0.1", 5000));
			serverSocket.bind(new InetSocketAddress(SERVER_IP, PORT));
			log("Start... [port:" + PORT + "]");

			while (true) {

				// 3. accept
				Socket socket = serverSocket.accept(); // blocking
				// accept하면 Socket객체를 생성.

				// 에코 서비스를 하는 스레드 시작 (4 ~ 6)
				new EchoServerRecevieThread(socket).start();
			}

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

	public static void log(String log) {
		System.out.println("[server#" + Thread.currentThread().getId() + "] " + log);
	}

}
