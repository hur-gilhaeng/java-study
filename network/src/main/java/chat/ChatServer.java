package chat;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class ChatServer {
	private static final String SERVER_IP = "127.0.0.1"; 
	// 고정된 루프백 아이피 주소
	private static final int PORT = 8028;
	// 포트번호는 임의로 지정
	private static Hashtable<String,PrintWriter> listWriters = 
			new Hashtable<String,PrintWriter>();

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩
			serverSocket.bind(new InetSocketAddress(SERVER_IP, PORT));
			log("연결 기다림 " + SERVER_IP + ":" + PORT);

			// 3. 요청 대기
			while (true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String string) {
		System.out.println("[server:"+Thread.currentThread().getName()+"]: "+string);
	}
}