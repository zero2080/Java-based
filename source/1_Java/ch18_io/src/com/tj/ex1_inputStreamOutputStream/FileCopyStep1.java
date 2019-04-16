package com.tj.ex1_inputStreamOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class FileCopyStep1 {
	public static void main(String[] args) {
		InputStream  is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("d:/mega_IT/sul.jpg");
			os = new FileOutputStream("d:/mega_IT/sulcopy.jpg");
			int cnt = 0;
			while(true) {
				int data = is.read();
				if(data==-1) break;
				os.write(data);
				System.out.println("������~~");
				cnt++;
			}
			System.out.println("while�ݺ��� ����Ƚ�� : "+cnt);
		}catch (FileNotFoundException e) {
			System.out.println("���� �� ã�� : "+e.getMessage());
		}catch(IOException e) {
			System.out.println("IO ���� : "+e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			}catch (IOException e) { }
		}
	}
}
