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
				int cnt = is.read(bs); // �������� ������ bs�� �ְ�, cnt���� ���� byte ���� �ִ´�.
				if(cnt==-1) break;
				os.write(bs, 0, cnt);
				System.out.println("������");
				count++;
			}
			System.out.println("while �ݺ��� ���� Ƚ�� : "+count);
		}catch (FileNotFoundException e) {
			System.out.println("���� �� ã�� : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IO ���� : "+e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			}catch (IOException e) {}
		}
	}
}
