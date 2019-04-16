package com.tj.ex3_readerWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
//2byte단위의 입력스트림 : reader
public class Ex01_reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("D:\\mega_IT\\inTest.txt");
			while(true) {
				int data = reader.read();
				if(data==-1) break;
				System.out.print((char)data);
			}
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(reader!=null) reader.close();
			}catch (IOException e) { }
		}
	}
}
