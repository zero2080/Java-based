package com.tj.homework;

import java.util.Scanner;

public class Work1129_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dansu;
		do {
			System.out.print("원하는 단수는(단, 2~9단만 가능)");
			dansu = sc.nextInt();
			if (dansu < 2 || dansu > 9) {
				System.out.print("2단부터 9단만 가능하다구. 때끼");
			}
		} while (dansu < 2 || dansu > 9);
		gugudan(dansu);
		sc.close();
	}

	private static void gugudan(int dansu) {
		System.out.println("원하신 " + dansu + "단 구구단입니다");
		for (int i = 1; i < 10; i++)
			System.out.println(dansu + "*" + i + "=" + (dansu * i));
	}

}
