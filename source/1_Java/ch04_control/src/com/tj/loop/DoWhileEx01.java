package com.tj.loop;
import java.util.Scanner;
// 짝수를 입력할 때까지 입력을 받고 짝수를 입력하면 그 수 출력
public class DoWhileEx01 {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("가위(0), 바위(1), 보(2) 중 하나 :");
			num=sc.nextInt();
		}while(num!=0 && num!=1 && num!=2);
		System.out.println("당신이 낸 거는"+num);
	}
}
