package com.tj.ex5etc;
import java.util.Scanner;
public class Ex01Main {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.print("�̸�");
		String name = sc1.next();
		nicknamePrint();
		int age = sc1.nextInt();
		System.out.println("�̸��� "+name+", ����"+age);
		sc1.close();
	}
	private static void nicknamePrint() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������?");
		System.out.println("�Է��Ͻ� ������ "+sc.next());
	}
}
