package com.tj.ex1try_catch;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i=0, j;
		System.out.print("첫번째 수는?");
		try {
			i = sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("수를 입력하지 않으면 0으로 초기화"+e.getMessage());
			sc.nextLine();
		}
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
