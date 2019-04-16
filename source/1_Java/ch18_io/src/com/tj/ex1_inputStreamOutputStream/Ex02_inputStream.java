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
			is = new FileInputStream("d:/mega_IT/inTest.txt"); // �� ���Ͽ���(��Ʈ����ü����)
			byte[] bs = new byte[5];
			while(true) { // �� �д´�
				int cnt = is.read(bs); // ���� ���� bs�迭�� �ְ� �� byte�� �־����� return
				if(cnt==-1) break;
				for(int idx=0 ; idx<cnt ; idx++) {
					System.out.println((char)bs[idx]+":"+bs[idx]);
				}
				System.out.println("----------------");
			}
		}catch (FileNotFoundException e) {
			System.out.println("���� �� ã�� ���� : "+e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally { // �� ���ϴݱ�(��Ʈ��close)
			try {
				if(is!=null) is.close();
			}catch (IOException e) { }
		}
	}
}
