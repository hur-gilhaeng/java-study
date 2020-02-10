package chat;

import java.io.BufferedReader;

public class ChatClientThread extends Thread {
	private BufferedReader bufferedReader;

	public ChatClientThread(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void run() {
		try {
			String data = bufferedReader.readLine();
			/* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */
			while (true) {
				if(data==null) {
					// client(remote)에서 정상종료
					ChatClient.log("closed by Server");
					return;
				}
				if(data.equals("quit")) {
					ChatClient.log("채팅을 종료합니다.");
					return;
				}
				ChatClient.log(data);
				data = bufferedReader.readLine();
			}
		} catch (Exception e) {
			ChatClient.log("갑작스러운 오류로 서버가 연결 끊김! : "+e);
			ChatClient.Close();
		}
	}
}
