package com.tj.ex1string;
import java.util.StringTokenizer;
public class Ex08 {
	public static void main(String[] args) {
		String str1 = "������ Ȳ����     ������ ������";//�⺻
		String str2 = "2017/12/11";
		StringTokenizer token1 = new StringTokenizer(str1);
		StringTokenizer token2 = new StringTokenizer(str2,"/");
		System.out.println("token1�� ���� ���� ���� :"+token1.countTokens());
		System.out.println("token2�� ���� ���� ���� :"+token2.countTokens());
		while(token1.hasMoreTokens()) {
			System.out.println(token1.nextToken());
		}
		while(token2.hasMoreTokens()) {
			System.out.println(token2.nextToken());
		}
	}
}
