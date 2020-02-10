package io;

import java.io.*;
import java.util.Arrays;

public class IOExample {

	public static void main(String[] args) throws IOException {
		byte[] src = {1, 2, 3, 4};
		byte[] dest = null;
		
		InputStream is = new ByteArrayInputStream(src);
		OutputStream os = new ByteArrayOutputStream();
		
		int data = -1;
		while((data = is.read()) != -1 ) {
			os.write(data);
		}
		
		dest = ((ByteArrayOutputStream)os).toByteArray();
		
		System.out.println(src);
		System.out.println(Arrays.toString(src));
		
		System.out.println(dest);
		System.out.println(Arrays.toString(dest));
		
	}

}
