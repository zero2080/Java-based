package com.tj.ex7scanner;
import java.util.Scanner;
public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���̸� �Է��� :");
		int age = sc.nextInt();
		System.out.println("�Է��� ���̴� "+age);
		System.out.print("�̸��� �Է��� ");
		String name = sc.next();
		System.out.println("�Է��� �̸��� "+name);
		System.out.print("�ּҸ� �Է��� ");
		sc.nextLine();// '\n'���������� �ν��ϰ� ���Ĵ� ����=����û��
		String add = sc.nextLine();
		System.out.println("�Է��� �ּҴ� "+add);
	}
}
