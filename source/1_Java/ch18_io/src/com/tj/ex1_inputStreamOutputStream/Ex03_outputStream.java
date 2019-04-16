package com.tj.ex1_inputStreamOutputStream;
import java.io.*;
// �������� ����(��Ʈ����ü����) �� write() ���Ͽ� ���� �� ������ �ݴ´�(��Ʈ����ü�� close)
public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("outTest.txt", true);// ��
			                             // ���� ��½� append�� ���ϸ� true
			//byte[] bs = {'H','e','l','l','o',',','J','a','v','a'};
			String temp = "AB\r\nAB";
			byte[] bs = temp.getBytes();
			for(int idx=0 ; idx<bs.length ; idx++) { // �� 
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
