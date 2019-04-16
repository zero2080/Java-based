package com.tj.example;
import java.util.Scanner;
// 사용자로부터 입력받은 수가 3의 배수인지 판단하기
public class Exam01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("3의 배수인지 확인할 정수는 ? ");
		int su = sc.nextInt(); // 키보드로부터 정수 입력 받아 su에 할당
		if(su%3 == 0)
			System.out.println("입력한 수는 3의 배수입니다");
		else
			System.out.println("입력한 수는 3의 배수가 아닙니다");
		sc.close();
	}
}
