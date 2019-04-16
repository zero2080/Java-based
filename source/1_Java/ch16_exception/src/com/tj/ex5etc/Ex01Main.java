package com.tj.ex5etc;
import java.util.Scanner;
public class Ex01Main {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.print("이름");
		String name = sc1.next();
		nicknamePrint();
		int age = sc1.nextInt();
		System.out.println("이름은 "+name+", 나이"+age);
		sc1.close();
	}
	private static void nicknamePrint() {
		Scanner sc = new Scanner(System.in);
		System.out.print("별명은?");
		System.out.println("입력하신 별명은 "+sc.next());
	}
}
