package com.tj.ex1_inputStreamOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true);
			String temp = "�̹� �ܿ��� ���� ���� �ʰ� ���� ���\r\n";
			byte[] bs = temp.getBytes();
			//os.write(bs); // bs�迭 0�ε������� ������ �� write
			os.write(bs, 0, bs.length);
			//bs�迭 0�� �ε������� bs.length byte��ŭ write
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
			}catch (IOException e) {
				System.out.println("close() ����:"+e.getMessage());
			}
		}
	}
}
