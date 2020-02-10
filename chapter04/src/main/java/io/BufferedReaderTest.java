package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			// 기반스트림 
			FileReader fr = new FileReader("./src/io/BufferedReaderTest.java");

			// 보조스트림
			br = new BufferedReader(fr);
			
			int index = 0;
			String line = null;
			while((line = br.readLine())!=null) {
				System.out.print(index+": ");
				System.out.println(line);
				index++;
			}
			
		} catch (FileNotFoundException e) {
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
