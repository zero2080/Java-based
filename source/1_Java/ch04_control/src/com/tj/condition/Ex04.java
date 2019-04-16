package com.tj.condition;
import java.util.Scanner;
// 입력받은 값의 절대값 출력
public class Ex04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력한 수?");
		int su = scanner.nextInt();
		//System.out.println("절대값은 "+((su>=0)? su:-1*su));
		if(su>=0) {
			System.out.println("절대값은 "+su);
		}else {
			System.out.println("절대값은 "+(-su));
		}
	}
}
