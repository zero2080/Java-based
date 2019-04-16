package com.tj.ex1try_catch;
import java.util.Scanner;
public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j;
		System.out.print("첫번째 수는?");
		i = sc.nextInt();
		System.out.print("두번째 수는?");
		j = sc.nextInt();
		System.out.println("i=" + i + ", j=" + j);
		System.out.println("i*j=" + (i*j) );
		try {
			System.out.println("i/j=" + (i/j) );
		}catch(ArithmeticException e) {
			System.out.println("0으로 나누지 않고 우회합니다");
			System.out.println(e.getMessage()); //간단한 예외메세지
			//e.printStackTrace(); // 자세한 뻘건 메세지
		}
		System.out.println("i+j=" + (i+j) );
		System.out.println("i-j=" + (i-j) );
		System.out.println("DONE");
		sc.close();
	}
}
