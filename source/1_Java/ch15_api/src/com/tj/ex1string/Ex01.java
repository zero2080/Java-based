package com.tj.ex1string;

public class Ex01 {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = new String("java");
		System.out.println(str1==str2? "1과 2는 같은 주소":"1과 2는 다른주소");
		System.out.println(str1.equals(str2)? "같은 문자열":"다른 문자열");
		System.out.println(str2==str3? "2과 3는 같은 주소":"2과 3는 다른주소");
		System.out.println(str2.equals(str3)? "같은문자":"다른문자");
		System.out.println(str3==str4? "3과 4는 같은 주소":"3과 4는 다른주소");
		System.out.println(str3.equals(str4)? "같은문자":"다른문자");
		System.out.println(str3==str1? "3과 3는 같은 주소":"3과 1는 다른주소");
		System.out.println(str1.equals(str3)? "1과3은 같은문자":"1과 3은 다른문자");
		String str5 = "Java";
		System.out.println(str1.equals(str5)? "같은문자":"다른문자");
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
	}
}
