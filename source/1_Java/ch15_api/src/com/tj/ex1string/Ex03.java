package com.tj.ex1string;
public class Ex03 {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("abcXabc");
		String str3 = "     Java    ";
		System.out.println(str1.concat(str2)); //abcXabcabcXabc
		System.out.println(str1.substring(3)); //Xabc
		System.out.println(str1.substring(3, 5));//3��°����5��°�ձ��� Xa
		System.out.println(str1.length() );      // 7(���ڰ���)
		System.out.println(str1.toUpperCase());  // ABCXABC (�빮�ڷ�)
		System.out.println(str1.toLowerCase());  // abcxabc (�ҹ��ڷ�)
		System.out.println(str2.charAt(3));  // X (3��° ����)
		System.out.println(str2.indexOf('b')); // 1(ó������ ������ 'b'�� ��ġ)
		System.out.println(str2.lastIndexOf('b'));// 5(������ 'b'�� ��ġ)
		System.out.println(str2.indexOf('@')); // '@'�� ������ -1
		String str4 = "abcXabcXabc";
		System.out.println(str4.lastIndexOf('b'));//9
		System.out.println(str4.indexOf('b')); // 1(0��°���� ó�� ������ 'b'�� ��ġ)
		System.out.println(str4.indexOf('b', 2));//5(2��°���� ó�������� 'b'�� ��ġ)
		System.out.println(str1.equals("abcXabc")); //true(������������)
		System.out.println(str1.equals("ABCXabc")); //false
		System.out.println(str1.equalsIgnoreCase("ABCXabc"));//true(��ҹ��ڱ��о���)
		System.out.println(str3.trim()); // �յڰ������� "java"
		System.out.println(str1.replace('a', 'A')); // a�� A�� �ٲ�
		System.out.println(str1.replaceAll("a", "���̹ٲ�")); //���ڿ� ��ü
		System.out.println();
		System.out.println("str1="+str1);
		System.out.println("str2="+str2);
		System.out.println("str3="+str3);
	}
}
