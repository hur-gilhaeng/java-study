package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	private Hashtable<String,PrintWriter> listWriters;

	public ChatServerThread(Socket socket, Hashtable<String,PrintWriter> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		BufferedReader bufferedReader;
		PrintWriter printWriter;
		try {
			// 1. Remote Host Information
			InetSocketAddress remoteInetSocketAddress = 
					(InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = 
					remoteInetSocketAddress.getAddress().getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			ChatServer.log(
					"connected by client["+remoteHostAddress+":"+remotePort+"]");

			// 2. 스트림 얻기
			bufferedReader = brStream();
			printWriter = pwStream();

			// 3. 요청 처리
			while (true) {
				String request = bufferedReader.readLine();
				if (request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					break;
				}

				// 4. 프로토콜 분석
				String[] tokens = request.split(":");
				// 입력된 값 없음
				if (tokens.length < 1) {
					ChatServer.log("에러:입력된 값 없음.");
				}
				// join
				else if ("join".equals(tokens[0])) {

					String name = tokens[1];

					while(listWriters.containsKey(name)) {
						printWriter.println("ReName:");
						name = bufferedReader.readLine();
					}

					doJoin(name, printWriter);
				} 
				// message
				else if ("message".equals(tokens[0])) {
					if (tokens.length > 1) {
						String temp = tokens[1];
						for(int i=2; i<tokens.length; i++) {
							temp+=":"+tokens[i];
						}
						doMessage(temp);
					} else {
						doMessage("");
					}
				} 
				// whisper
				else if ("whisper".equals(tokens[0])) {
					if (tokens.length > 2) {
						doWhisper(tokens[1], tokens[2]);
					}
				} 
				// kick
				else if ("kick".equals(tokens[0])) {
					if (tokens.length > 1) {
						doKick(tokens[1]);
					}
				} 
				// help
				else if ("help".equals(tokens[0])) {
					doHelp();
				}
				// count
				else if ("count".equals(tokens[0])) {
					doCount();
				} 
				// time
				else if ("time".equals(tokens[0])) {
					doTime();
				} 
				// clear
				else if ("clear".equals(tokens[0])) {
					doClear();
				}
				// quit
				else if ("quit".equals(tokens[0])) {
					// quit 명령 회신
					printWriter.println("quit:");
					// quit 명령 실행
					doQuit();
					break;
				} 
				// 기타
				else {
					ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
				}
			}
		} catch (Exception e) {
			ChatServer.log("갑작스러운 오류로 클라이언트가 연결 끊김!");
			ChatServer.log(e.toString());
			e.printStackTrace();
			doQuit();
		} finally {
			try {
				if (this.socket != null && (!this.socket.isClosed())) {
					this.socket.close();
				}
			} catch (Exception e) {
				ChatServer.log("error:" + e);
				e.printStackTrace();
			}
		}
	}

	// join 실행
	private void doJoin(String nickname, PrintWriter printWriter) {
		this.nickname = nickname;
		this.setName(this.nickname);

		printWriter.println("200 ok!");
		synchronized( listWriters ) {
			listWriters.put(nickname, printWriter);
		}
		ChatServer.log(nickname + " 참가!");
		doBroadcast("님이 입장하셨습니다.");
	}

	// message 실행
	private void doMessage(String data) {
		doBroadcast(": " + data);
	}

	// whisper(귓속말) 실행
	private void doWhisper(String toUser ,String Message) {
		if(nickname.equals(toUser)) {
			pwStream().println("[나에게 귓속말]: " + Message);
			ChatServer.log(nickname + "님이 자신에게 귓속말.");
			return;
		} // 자신에게 귓속말.

		PrintWriter c;
		synchronized( listWriters ) {
			c = listWriters.get(toUser);
		}
		if(c!=null) {
			c.println("[" + this.nickname + "님의 귓속말]: " + Message);
			pwStream().println("[" + toUser + "님에게 귓속말]: " + Message);
			ChatServer.log(nickname + "님이" + toUser + "님에게 귓속말.");
		} else {
			pwStream().println("[to Server]: 해당 유저는 접속중이 아닙니다.");
		}
	}

	// kick(강퇴) 실행
	private void doKick(String toUser) {
		if(nickname.equals(toUser)) {
			pwStream().println("[to Server]: 자기 자신을 강퇴 할 수 없습니다.");
			return;
		} // 자신을 강퇴 시도

		PrintWriter c;
		synchronized( listWriters ) {
			c = listWriters.get(toUser);
			listWriters.remove(toUser);
		}
		if(c!=null) {
			c.println("kick:");
			Iterator<PrintWriter> iterator;
			synchronized( listWriters ) {
				iterator = listWriters.values().iterator();
			}
			while (iterator.hasNext()) {
				PrintWriter pw = iterator.next();
				pw.println(toUser+"님이 강제 퇴장 되었습니다.");
			}
			ChatServer.log(nickname + "님이 " + toUser + "님을 강퇴.");
		} else {
			pwStream().println("[to Server]: 해당 유저는 접속중이 아닙니다.");
		}
	}

	// help(도움말) 실행
	private void doHelp() {
		pwStream().println("======================== 도움말 ========================\n"
				+"   /to/(닉네임)\t: (닉네임)에 해당하는 유저에게 귓속말을 합니다 .\n" 
				+"   /kick/(닉네임)\t: (닉네임)에 해당하는 유저를 강퇴 합니다 .\n" 
				+"   /count   \t: 현재 채팅방에 있는 인원을 보여줍니다.\n"
				+"   /time    \t: 현재 시간을 보여줍니다.\n"
				+"   /clear   \t: 자신의 채팅화면의 내용을 모두 지웁니다.\n"
				+"   /quit      \t: 채팅을 종료합니다.\n"
				+"    quit      \t: 채팅을 종료합니다.\n"
				+"=====================================================");
	}

	// count 실행
	private void doCount() {
		int count = listWriters.size();
		pwStream().println("[to Server]: 현채 채팅방의 인원은 " + count + "명 입니다.");
	}

	// time 실행
	private void doTime() {
		SimpleDateFormat time = new SimpleDateFormat( "yyyy년 MM월 dd일 HH시 mm분 ss초" );
		pwStream().println("[to Server]: 현재시간은 "+time.format(new Date())+" 입니다.");
	}

	// clear 실행
	private void doClear() {
		pwStream().println("clear:");
	}

	// Quit 실행
	private void doQuit() {
		// list에서 현재 소켓의 printWriter삭제
		synchronized( listWriters ) {
			listWriters.remove(nickname);
		}
		doBroadcast("님이 채팅방을 나가셨습니다.");
		ChatServer.log(this.nickname + " OUT of server.");
	}

	// 내용 송출!!
	private void doBroadcast(String Message) {
		Iterator<PrintWriter> iterator;
		synchronized( listWriters ) {
			iterator = listWriters.values().iterator();
		}
		while (iterator.hasNext()) {
			PrintWriter c = iterator.next();
			c.println(this.nickname + Message);
		}
	}

	// PrintWriter 받기;
	private PrintWriter pwStream(){
		try {
			return new PrintWriter(
					new OutputStreamWriter(
							socket.getOutputStream(), StandardCharsets.UTF_8), true);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// BufferedReade 받기;
	private BufferedReader brStream() {
		try {
			return new BufferedReader(new InputStreamReader(
					socket.getInputStream(), StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
