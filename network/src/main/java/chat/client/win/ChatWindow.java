package chat.client.win;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	private Socket socket;
	private PrintWriter printWriter;

	public ChatWindow(String name, Socket socket) {
		frame = new Frame("대화명 : " + name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);

		this.socket = socket;
	}

	public void show() throws Exception {
		/***
		 * 1. UI초기화 작업
		 */

		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});// enter키 입력시 발생.

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
		/**
		 * 2. IO스트림 초기화 작업
		 */
		BufferedReader bufferedReader = 
				new BufferedReader(
						new InputStreamReader(socket.getInputStream(), "UTF-8"));
		printWriter = new PrintWriter(
				new OutputStreamWriter(
						socket.getOutputStream(), StandardCharsets.UTF_8), true);

		/**
		 * 3. 스레드 생성작업
		 */
		new ChatClientThread(bufferedReader).start();

	}

	private void sendMessage() {
		String message = textField.getText();
		String[] tokens = message.split("/");
		if (tokens.length > 1) {
			commends(tokens,message);
		} else if ("quit".equals(message)) {
			// quit 프로토콜 요청
			printWriter.println("quit:");
		} else {
			// 메시지 보내기
			printWriter.println("message:" + message);
		}

		textField.setText("");
		textField.requestFocus();
	}

	private void commends(String[] tokens, String msg) {
		if(!tokens[0].equals("")) {
			printWriter.println("message:"+msg);
			return;
		} else if ("quit".equals(tokens[1])) {
			//  quit 프로토콜 요청
			printWriter.println("quit:");
			return;
		} else if ("to".equals(tokens[1])) {
			if (tokens.length > 3) {
				String temp = tokens[3];
				for(int i=4; i<tokens.length; i++) {
					temp +="/"+tokens[i];
				}
				printWriter.println("whisper:"+tokens[2]+":"+temp);
				return;
			}
		} else if ("kick".equals(tokens[1])) {
			if (tokens.length > 2) {
				printWriter.println("kick:"+tokens[2]);
				return;
			}
		} else if ("help".equals(tokens[1])) {
			printWriter.println("help:");
			return;
		} else if ("count".equals(tokens[1])) {
			printWriter.println("count:");
			return;
		} else if ("time".equals(tokens[1])) {
			printWriter.println("time:");
			return;
		} else if ("clear".equals(tokens[1])) {
			printWriter.println("clear:");
			return;
		}
		textArea.append("/:잘못된 명령입니다 다시 확인해 주세요.\n");
	}

	private class ChatClientThread extends Thread {
		private BufferedReader bufferedReader;

		public ChatClientThread(BufferedReader bufferedReader) {
			this.bufferedReader = bufferedReader;
		}

		@Override
		public void run() {
			try {
				/* textArea 초기화 */
				textArea.append("----------------------------------------");
				textArea.append("----------------------------------------\n");
				textArea.append("  인터넷은 모두의 공간입니다. 바른말 고운말을 사용합시다.\n");
				textArea.append("  /help 명령어를 통하여 도움말을 열여 볼 수 있습니다.\n");
				textArea.append("----------------------------------------");
				textArea.append("----------------------------------------\n");

				/* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */
				while (true) {
					String data = bufferedReader.readLine();
					if (data == null) {
						// client(remote)에서 정상종료
						textArea.append("closed by Server.\n");
						break;
					}
					if ("quit:".equals(data)) {
						// quit명령으로 인한 종료
						break;
					}
					if ("kick:".equals(data)) {
						// kick명령으로 인한 종료
						textArea.append("강제로 퇴장 되었습니다.\n");
						printWriter.println("quit:");
						continue;
					}
					if ("clear:".equals(data)) {
						// clear 명령으로 textArea 정리
						textArea.setText("");
						continue;
					}
					// 소켓을 통해 메세지가 온 경우 ... (스레드에서 처리)
					textArea.append(data + "\n");
				}

			} catch (Exception e) {
				textArea.append("갑작스러운 오류로 서버가 연결 끊김!\n");
				System.out.println("[client]: 갑작스러운 오류로 서버가 연결 끊김!\n" + e);
			} finally {
				try {
					// 윈도우 자동 끄기!!
					textArea.append("채팅을 종료합니다.\n");
					Thread.sleep(1000);
					System.exit(0);
					// 1초후(sleep) 종료.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
