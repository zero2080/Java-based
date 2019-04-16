package com.tj.ex1_inputStreamOutputStream;
import java.io.*;
// ①파일을 연다(스트림객체생성) ② write() 파일에 쓴다 ③ 파일을 닫는다(스트림객체를 close)
public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("outTest.txt", true);// ①
			                             // 파일 출력시 append를 원하면 true
			//byte[] bs = {'H','e','l','l','o',',','J','a','v','a'};
			String temp = "AB\r\nAB";
			byte[] bs = temp.getBytes();
			for(int idx=0 ; idx<bs.length ; idx++) { // ② 
				os.write(bs[idx]);
				System.out.print((char)bs[idx]);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
			}catch (IOException ignore) { }
		}//try
	}//main
}//class
