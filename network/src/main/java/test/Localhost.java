package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Localhost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostname = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			byte[] address = inetAddress.getAddress();
			
			System.out.println(Arrays.toString(address));
			
			System.out.print("[");
			for(byte b : address) {
				System.out.print((b & 0x000000ff)+". ");
			}
			System.out.println("]");
			
			System.out.println(hostname);
			System.out.println(hostAddress);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
