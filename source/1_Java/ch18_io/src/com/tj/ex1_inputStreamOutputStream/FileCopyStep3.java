package com.tj.ex1_inputStreamOutputStream;
import java.io.*;
public class FileCopyStep3 {
	public static void main(String[] args) {
		InputStream  is = null;
		OutputStream os = null;
		File originalFile = new File("d:/mega_IT/sul.jpg");
		try {
			is = new FileInputStream(originalFile);
			os = new FileOutputStream("txtFile/sul.jpg");
			byte[] bs = new byte[(int) originalFile.length()];
			while(true) {
				int cnt = is.read(bs);
				if(cnt==-1) break;
				os.write(bs, 0, cnt);
			}
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			}catch (IOException e) {System.out.println(e.getMessage());}
		}
	}
}
