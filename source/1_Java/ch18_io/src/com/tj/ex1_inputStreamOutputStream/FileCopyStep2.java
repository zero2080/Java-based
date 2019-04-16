package com.tj.ex1_inputStreamOutputStream;
import java.io.*;
public class FileCopyStep2 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("d:/mega_IT/sul.jpg");
			os = new FileOutputStream("txtFile/sul.jpg");
			byte[] bs = new byte[1024];
			int count = 0;
			while(true) {
				int cnt = is.read(bs); // 파일읽은 내용을 bs에 넣고, cnt에는 읽은 byte 수를 넣는다.
				if(cnt==-1) break;
				os.write(bs, 0, cnt);
				System.out.println("복사중");
				count++;
			}
			System.out.println("while 반복문 수행 횟수 : "+count);
		}catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음 : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IO 예외 : "+e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			}catch (IOException e) {}
		}
	}
}
