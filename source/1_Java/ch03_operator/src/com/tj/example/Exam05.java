package com.tj.example;
import java.util.Scanner;
// 주민번호 7번째 자리수를 입력받아 남자인지 여자인지 출력
public class Exam05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민번호 7번째 자리수는 ?");
		int gender = scanner.nextInt();
		System.out.println((gender==1 || gender==3)? "남자":"여자");
		scanner.close();
	}
}
