package chat.client.win;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 8028;

	public static void main(String[] args) {
		
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (!name.isEmpty()) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		Socket socket = null;
		
		try {
			// 1. 소켓생성
			socket = new Socket();
			
			// 2. connect to server
			socket.connect(new InetSocketAddress(SERVER_IP, PORT));
			
			// 3. IOstream 생성
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			PrintWriter printWriter = new PrintWriter(
					new OutputStreamWriter(
							socket.getOutputStream(), StandardCharsets.UTF_8), true);
			printWriter.println("join:" + name);
			
			// 4. join 프로토콜 요청 및 처리
			String joinCheck = bufferedReader.readLine();
			// 중복 이름 체크 반복문.
			while(!"200 ok!".equals(joinCheck)) { // "200 ok!"를 받으면 탈출!
				System.out.println("공백이거나, 중복된 대화명입니다.다시입력하세요\n");
				System.out.print(">>> ");
				name = scanner.nextLine();
				name.trim();
				if(name.isEmpty()) {
					continue;
				}
				printWriter.println(name);
				joinCheck = bufferedReader.readLine();
			} // "200 ok!"는 join 프로토콜의 성공 응답이다.
			
			// 5. join 프로토콜이 성공 응답을 받으면 win실행
			new ChatWindow(name, socket).show();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
