package com.tj.ex1_inputStreamOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
// d:/mega_IT/inTest.txt : 65 66 \r \n 65 66 EOF
public class Ex01_inputStream {
	public static void main(String[] args) {
		InputStream is=null;
		try {
			// 1. 파일을 연다(스트림 객체를 만든다=연결통로를 연다)
			is = new FileInputStream("D:/mega_IT/inTest.txt");
			// 2. 읽는다(read)
			while(true) {
				int data = is.read();
				if(data==-1) {//read() 메소드는 파일의 끝이면 -1을 return
					break;
				}
				System.out.println((char)data+" : "+data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 못찾은 예외 메세지 : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("읽기 예외 : "+e.getMessage());
		} finally {
			// 3. 파일을 닫는다(스트림 객체를 닫는다=연결통로를 닫는다)
			try {
				if(is!=null) is.close();
			}catch (IOException ignore) {System.out.println(ignore.getMessage());}
		}//try-catch-finally
	}//main
}//class






