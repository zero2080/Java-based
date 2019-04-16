package com.tj.condition;
import java.util.Scanner;
// 정수입력 받아 짝수,홀수인지 출력(switch)
public class Ex10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력하는 수?");
		int su = scanner.nextInt();
		switch(su%2) {
		case 0 : System.out.println("짝수 입력했네");break;
		case 1: case -1:
			System.out.println("홀수 입력했네");break;
		}
	}
}
