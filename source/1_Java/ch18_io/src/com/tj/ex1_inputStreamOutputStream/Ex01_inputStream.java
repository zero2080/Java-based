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
			// 1. ������ ����(��Ʈ�� ��ü�� �����=������θ� ����)
			is = new FileInputStream("D:/mega_IT/inTest.txt");
			// 2. �д´�(read)
			while(true) {
				int data = is.read();
				if(data==-1) {//read() �޼ҵ�� ������ ���̸� -1�� return
					break;
				}
				System.out.println((char)data+" : "+data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("������ ��ã�� ���� �޼��� : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("�б� ���� : "+e.getMessage());
		} finally {
			// 3. ������ �ݴ´�(��Ʈ�� ��ü�� �ݴ´�=������θ� �ݴ´�)
			try {
				if(is!=null) is.close();
			}catch (IOException ignore) {System.out.println(ignore.getMessage());}
		}//try-catch-finally
	}//main
}//class






