package com.tj.ex1string;
public class Ex03 {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("abcXabc");
		String str3 = "     Java    ";
		System.out.println(str1.concat(str2)); //abcXabcabcXabc
		System.out.println(str1.substring(3)); //Xabc
		System.out.println(str1.substring(3, 5));//3번째부터5번째앞까지 Xa
		System.out.println(str1.length() );      // 7(글자갯수)
		System.out.println(str1.toUpperCase());  // ABCXABC (대문자로)
		System.out.println(str1.toLowerCase());  // abcxabc (소문자로)
		System.out.println(str2.charAt(3));  // X (3번째 문자)
		System.out.println(str2.indexOf('b')); // 1(처음으로 나오는 'b'의 위치)
		System.out.println(str2.lastIndexOf('b'));// 5(마지막 'b'의 위치)
		System.out.println(str2.indexOf('@')); // '@'가 없으면 -1
		String str4 = "abcXabcXabc";
		System.out.println(str4.lastIndexOf('b'));//9
		System.out.println(str4.indexOf('b')); // 1(0번째부터 처음 나오는 'b'의 위치)
		System.out.println(str4.indexOf('b', 2));//5(2번째부터 처음나오는 'b'의 위치)
		System.out.println(str1.equals("abcXabc")); //true(같은문자인지)
		System.out.println(str1.equals("ABCXabc")); //false
		System.out.println(str1.equalsIgnoreCase("ABCXabc"));//true(대소문자구분없이)
		System.out.println(str3.trim()); // 앞뒤공백제거 "java"
		System.out.println(str1.replace('a', 'A')); // a를 A로 바꿔
		System.out.println(str1.replaceAll("a", "많이바꿔")); //문자열 교체
		System.out.println();
		System.out.println("str1="+str1);
		System.out.println("str2="+str2);
		System.out.println("str3="+str3);
	}
}
