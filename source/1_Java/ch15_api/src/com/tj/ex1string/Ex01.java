package com.tj.ex1string;

public class Ex01 {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = new String("java");
		System.out.println(str1==str2? "1�� 2�� ���� �ּ�":"1�� 2�� �ٸ��ּ�");
		System.out.println(str1.equals(str2)? "���� ���ڿ�":"�ٸ� ���ڿ�");
		System.out.println(str2==str3? "2�� 3�� ���� �ּ�":"2�� 3�� �ٸ��ּ�");
		System.out.println(str2.equals(str3)? "��������":"�ٸ�����");
		System.out.println(str3==str4? "3�� 4�� ���� �ּ�":"3�� 4�� �ٸ��ּ�");
		System.out.println(str3.equals(str4)? "��������":"�ٸ�����");
		System.out.println(str3==str1? "3�� 3�� ���� �ּ�":"3�� 1�� �ٸ��ּ�");
		System.out.println(str1.equals(str3)? "1��3�� ��������":"1�� 3�� �ٸ�����");
		String str5 = "Java";
		System.out.println(str1.equals(str5)? "��������":"�ٸ�����");
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
	}
}
