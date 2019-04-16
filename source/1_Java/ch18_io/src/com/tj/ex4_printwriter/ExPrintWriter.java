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
			/*outputStream = new FileOutputStream("txtFile/student.txt", true);//기본스트림
			printWriter = new PrintWriter(outputStream); //보조스트림*/
			
			writer = new FileWriter("txtFile/student.txt", true); //기본스트림
			printWriter = new PrintWriter(writer);
			
			printWriter.printf("%s\t%3d\t%3d\t%3d, %5.1f\r\n", 
							"홍길동", 90, 90, 90, 90.0);
			printWriter.printf("%s\t%3d\t%3d\t%3d, %5.1f\r\n", 
					"신길동", 100, 100, 100, 100.0);
			printWriter.printf("%s\t%3d\t%3d\t%3d, %5.1f\r\n", 
					"마길동", 9, 10, 10, 9.877777);
			printWriter.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초\r\n", 
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
