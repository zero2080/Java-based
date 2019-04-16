package com.tj.ex1string;

public class Ex05 {
	public static void main(String[] args) {
		String str1 = "Hello!";
		String str2 = "Hello!";
		System.out.println("str1==str2 ?"+(str1==str2));
		str1 = str1 +" Java";
		System.out.println("데이터 수정 후");
		System.out.println("str1="+str1);
		System.out.println("str2="+str2);
		System.out.println("str1==str2 ?"+(str1==str2));
	}
}
