package com.tj.ex1_inputStreamOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true);
			String temp = "이번 겨울은 많이 춥지 않고 조금 춥길\r\n";
			byte[] bs = temp.getBytes();
			//os.write(bs); // bs배열 0인덱스부터 끝까지 다 write
			os.write(bs, 0, bs.length);
			//bs배열 0번 인덱스부터 bs.length byte만큼 write
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
			}catch (IOException e) {
				System.out.println("close() 예외:"+e.getMessage());
			}
		}
	}
}
