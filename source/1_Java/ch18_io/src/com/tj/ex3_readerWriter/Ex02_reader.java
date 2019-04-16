package com.tj.ex3_readerWriter;
import java.io.*;
// 5문자씩 안녕하세요자바
public class Ex02_reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("d:/mega_IT/inTest.txt");
			char[] buffer = new char[5];
			while(true) {
				int cnt = reader.read(buffer);//
				if(cnt==-1)break;
				for(int i=0 ; i<cnt ; i++) {
					System.out.print(buffer[i]);
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			
		}
	}
}
