package com.tj.ex1_inputStreamOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
//d:/mega_IT/inTest.txt : 65 66 \r \n 65 66 EOF
public class Ex02_inputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("d:/mega_IT/inTest.txt"); // ① 파일열기(스트림객체생성)
			byte[] bs = new byte[5];
			while(true) { // ② 읽는다
				int cnt = is.read(bs); // 읽은 것을 bs배열에 넣고 몇 byte를 넣었는지 return
				if(cnt==-1) break;
				for(int idx=0 ; idx<cnt ; idx++) {
					System.out.println((char)bs[idx]+":"+bs[idx]);
				}
				System.out.println("----------------");
			}
		}catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음 예외 : "+e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally { // ③ 파일닫기(스트림close)
			try {
				if(is!=null) is.close();
			}catch (IOException e) { }
		}
	}
}
