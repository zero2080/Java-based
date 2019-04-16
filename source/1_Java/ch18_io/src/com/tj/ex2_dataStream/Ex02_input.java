package com.tj.ex2_dataStream;
import java.io.*;
import java.util.ArrayList;
//"이준석" / 95.9 / 2
public class Ex02_input {
	public static void main(String[] args) {
		InputStream     fis = null;
		DataInputStream dis = null;
		String name; double score; int hak;
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			fis = new FileInputStream("txtFile/dataFile.dat");
			dis = new DataInputStream(fis);
			while(true) {
				name = dis.readUTF(); // "이준석"
				score = dis.readDouble(); // 95.9
				hak = dis.readInt(); // 2
				students.add(new Student(name, score, hak));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();
			}catch (Exception e) {}
		}
		for(Student s : students) {
			System.out.println(s);
		}
		
	}
}









