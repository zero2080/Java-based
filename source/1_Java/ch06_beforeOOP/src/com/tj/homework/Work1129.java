package com.tj.homework;

import java.util.Scanner;

public class Work1129 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dansu;
		do {
			System.out.print("���ϴ� �ܼ���(��, 2~9�ܸ� ����)");
			dansu = sc.nextInt();
			if (dansu < 2 || dansu > 9)
				System.out.print("2�ܺ��� 9�ܸ� �����ϴٱ�. ����");
		} while (dansu < 2 || dansu > 9);
		Work1129 work1129 = new Work1129();
		work1129.gugudan(dansu);
		sc.close();
	}

	private void gugudan(int dansu) {
		System.out.println("���Ͻ� " + dansu + "�� �������Դϴ�");
		for (int i = 1; i < 10; i++)
			System.out.println(dansu + "*" + i + "=" + (dansu * i));
	}

}
