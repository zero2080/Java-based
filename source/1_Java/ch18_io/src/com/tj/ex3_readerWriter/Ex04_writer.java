package com.tj.ex3_readerWriter;
import java.io.*;
public class Ex04_writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest.txt");
			/*char[] arr = {'��','��','��',' ','��','��'};
			for(char a : arr) {
				writer.write(a);
			}*/
			String str = "������ ������ ����\r\n���ϵ� ���ƶ�";
			writer.write(str);
			System.out.println(str);
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(writer!=null) writer.close();
			}catch (Exception e) { }
		}
	}
}
