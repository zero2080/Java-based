package com.tj.ex;
import java.util.Scanner;
// 사용자로부터 1~9까지 숫자 중 하나를 받아 해당 구구단을 출력(method처리)
public class Ex04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("몇 단 구구단(2~9단)? ");
		int dansu = scanner.nextInt();
		gugudanOut(dansu);
		scanner.close();
	}
	private static void gugudanOut(int dansu) {// 메소드 선언부
		for(int i=1 ; i<=9 ; i++) {                         //메소드 구현부
			System.out.println(dansu+"*"+i+"="+(dansu*i));
		}
	}
}
