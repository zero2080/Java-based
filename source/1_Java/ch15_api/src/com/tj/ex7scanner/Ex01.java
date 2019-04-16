package com.tj.ex7scanner;
import java.util.Scanner;
public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력해 :");
		int age = sc.nextInt();
		System.out.println("입력한 나이는 "+age);
		System.out.print("이름을 입력해 ");
		String name = sc.next();
		System.out.println("입력한 이름은 "+name);
		System.out.print("주소를 입력해 ");
		sc.nextLine();// '\n'이전까지만 인식하고 이후는 버림=버퍼청소
		String add = sc.nextLine();
		System.out.println("입력한 주소는 "+add);
	}
}
