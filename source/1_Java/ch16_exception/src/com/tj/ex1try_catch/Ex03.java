package com.tj.ex1try_catch;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j=1;
		do {
			try {
				System.out.print("첫번째 수는?");
				i = sc.nextInt();
				break;
			}catch(Exception e) {
				System.out.println("첫번째 수를 입력할 때까지 계속 간다~");
				sc.nextLine(); // 버퍼를 지운다
			}
		}while(true);
		System.out.print("두번째 수는?");
		try {
			j = sc.nextInt();
			System.out.println("i=" + i + ", j=" + j);
			System.out.println("i/j=" + (i/j) );
		}catch(InputMismatchException e) {
			System.out.println("두번째 수를 입력하지 않으면 1로 초기화");
		}catch(ArithmeticException e) {
			System.out.println("0으로 나누면 패스~");
		}catch(Exception e) {
			System.out.println("기타 예외는 여기서 마지막으로 처리"+e.getMessage());
		}
		System.out.println("i*j=" + (i*j) );
		System.out.println("i+j=" + (i+j) );
		System.out.println("i-j=" + (i-j) );
		System.out.println("DONE");
		sc.close();
	}
}
