package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class KeyboardText {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			// 기반스트림 (표준입력, stdin, System.in)
			
			// 보조스트림1 ( byte|byte|byte -> char )
			InputStreamReader isr = new InputStreamReader(System.in,"UTF-8");
			
			// 보조스트림2 ( char|char|char -> line)
			br = new BufferedReader(isr);
			
			String line = null;
			while((line = br.readLine())!=null) {
				if("exit".equals(line)) { break;}
				System.out.println(line);
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("file can not open "+e);
		} catch (IOException e) {
			System.out.println("errer"+e);
		} finally {
			try {
				if(br!=null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
