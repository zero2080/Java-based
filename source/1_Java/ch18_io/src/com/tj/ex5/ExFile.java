package com.tj.ex5;
import java.io.File;
public class ExFile {
	public static void main(String[] args) {
		File file1 = new File("d:/mega_IT/aa.txt");// 파일을 이용해서 생성
		File fold  = new File("d:/mega_IT");       // 폴더를 이용해서 생성
		if(file1.exists()) {
			System.out.println("존재하는 파일이나 폴더입니다");
		}else {
			System.out.println("존재하지 않는 파일이나 폴더입니다");
		}
		File file = new File("."); // 내프로젝트 폴더
		String[] dirList = file.list(); // file 밑의 폴더와 파일의 이름만 dirList에 담음
		File[] files = file.listFiles();// file밑의 폴더및 파일을 File배열객체로 담음
		System.out.println("파일이름\t\t폴더인지\t파일크기");
		for(File f : files){
			if(f.getName().length()>=8)
				System.out.print(f.getName() + "\t");//파일이름출력
			else
				System.out.print(f.getName()+"\t\t");
			System.out.print(f.isDirectory()? "폴더":"파일");
			System.out.println("\t"+f.length()); //파일크기
		}
	}
}
