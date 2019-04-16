package com.tj.ex4_printwriter;
import java.io.*;
import java.util.Date;
public class ExPrintWriter {
	public static void main(String[] args) {
		PrintWriter  printWriter  = null;
		OutputStream outputStream = null;
		Writer       writer       = null;
		try {
			//printWriter = new PrintWriter("txtFile/student.txt", true);
			/*outputStream = new FileOutputStream("txtFile/student.txt", true);//�⺻��Ʈ��
			printWriter = new PrintWriter(outputStream); //������Ʈ��*/
			
			writer = new FileWriter("txtFile/student.txt", true); //�⺻��Ʈ��
			printWriter = new PrintWriter(writer);
			
			printWriter.printf("%s\t%3d\t%3d\t%3d, %5.1f\r\n", 
							"ȫ�浿", 90, 90, 90, 90.0);
			printWriter.printf("%s\t%3d\t%3d\t%3d, %5.1f\r\n", 
					"�ű浿", 100, 100, 100, 100.0);
			printWriter.printf("%s\t%3d\t%3d\t%3d, %5.1f\r\n", 
					"���浿", 9, 10, 10, 9.877777);
			printWriter.printf("%1$tY�� %1$tm�� %1$td�� %1$tH�� %1$tM�� %1$tS��\r\n", 
					new Date());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(printWriter!=null) printWriter.close();
				//if(outputStream!=null) outputStream.close();
				if(writer!=null) writer.close();
			}catch (Exception e) {}
		}
	}
}
