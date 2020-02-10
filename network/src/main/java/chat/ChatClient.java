package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	// 고정된 루프백 아이피 주소
	private static final int PORT = 8028;
	// 포트번호는 임의로 지정
	private static boolean CK_CLOSE = true;

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);

			// 2. socket 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, PORT));
			log("connected");

			// 4. reader/writer 생성
			InputStreamReader isr = 
					new InputStreamReader(socket.getInputStream(), "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			PrintWriter printWriter = new PrintWriter(
					new OutputStreamWriter(
							socket.getOutputStream(), StandardCharsets.UTF_8), true);

			// 5. join 프로토콜
			String nickname;
			while( true ) {
				System.out.print("닉네임>>> ");
				nickname = scanner.nextLine();
				if (!nickname.isEmpty()) {
					break;
				}
				System.out.println("닉네임은 한글자 이상 입력해야 합니다.\n");
			}
			printWriter.println("join:" + nickname);

			// 6. ChatClientReceiveThread 시작
			new ChatClientThread(br).start();

			// 7. 키보드 입력 처리
			while (CK_CLOSE) {
				String input = scanner.nextLine();
				if ("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					printWriter.println("quit:");
					break;
				} else {
					// 9. 메시지 처리
					printWriter.println("message:" + input);
				}
			}

		} catch (Exception e) {
			log("error:" + e);
		} finally {
			// 10. 자원정리
			try {
				if (scanner != null) {
					scanner.close();
				}
				if (socket != null && (!socket.isClosed())) {
					socket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void log(String string) {
		System.out.println("[client:"+Thread.currentThread().getId()+"]: "+string);
	}

	public static void Close() {
		CK_CLOSE=false;
	}
}
