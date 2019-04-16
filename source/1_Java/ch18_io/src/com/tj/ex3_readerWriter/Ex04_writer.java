package com.tj.ex3_readerWriter;
import java.io.*;
public class Ex04_writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest.txt");
			/*char[] arr = {'오','늘','은',' ','좋','다'};
			for(char a : arr) {
				writer.write(a);
			}*/
			String str = "오늘은 날씨가 좋다\r\n내일도 좋아라";
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
