package com.tj.example;
import java.util.Scanner;
/*(연습문제4) 나이를 입력받아 입력받은 나이가 65세 이상일 때, 
              “경로우대” 출력, 아니면 “일반”출력*/
public class Exam04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이를 입력하슈 : ");
		int age = scanner.nextInt();
		System.out.println((age>=65)? "경로우대":"일반");
		scanner.close();
	}
}
