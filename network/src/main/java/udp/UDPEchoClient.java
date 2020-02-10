package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPEchoClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 7000;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		DatagramSocket socket = null;
		Scanner sc = null;

		try {
			// 1. Scanner 생성(표준입력, 키보드 연결)
			sc = new Scanner(System.in);

			// 2. 소켓생성
			socket = new DatagramSocket();

			while (true) {

				// 3. 키보드 입력 받기
				System.out.print(">> ");
				String line = sc.nextLine();
				if ("quit".equals(line)) {
					log("Quit.");
					break;
				}

				// 4. 데이터 쓰기
				byte[] sendData = line.getBytes("UTF-8");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
						new InetSocketAddress(SERVER_IP, PORT));
				socket.send(sendPacket);

				// 5. 데이터 읽기
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(receivePacket); // blocking

				byte[] data = receivePacket.getData();
				int length = receivePacket.getLength();
				String message = new String(data, 0, length);

				System.out.println("<< " + message);
			}
		} catch (SocketException e) {
			System.out.println("[client] closed by Server!!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[client] closed by Server!!");
			e.printStackTrace();
		} finally {
			try {
				if (sc != null) {
					sc.close();
				}
				if (socket != null && (!socket.isClosed())) {
					socket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String log) {
		System.out.println("[client] " + log);
	}
}
