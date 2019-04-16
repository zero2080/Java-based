package com.tj.condition;
import java.util.Scanner;
// 두수를 입력받아 큰수가 얼마나 더 큰지 출력
public class Ex02 {
	public static void main(String[] args) {
		int num1, num2;
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 수는 ? ");
		num1 = scanner.nextInt();
		System.out.print("두번째 수는 ? ");
		num2 = scanner.nextInt();
		if(num1>num2) {
			System.out.println("큰수는 "+num1+" 두수의 차는"+(num1-num2));
		}else if(num2>num1){
			System.out.println("큰수는 "+num2+" 두수의 차는 "+(num2-num1));
		}else {
			System.out.println("두수는 같다");
		}
	}
}