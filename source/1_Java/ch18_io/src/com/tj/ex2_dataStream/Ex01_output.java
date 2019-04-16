package com.tj.ex2_dataStream;
import java.io.*;
// "이준석" / 95.9 / 2
public class Ex01_output {
	public static void main(String[] args) {
		OutputStream     fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat", true);
			dos = new DataOutputStream(fos);
			dos.writeUTF("이준석");
			dos.writeDouble(95.9);
			dos.writeInt(2);
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();
			}catch (IOException e) { }
		}
	}
}
