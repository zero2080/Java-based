package com.tj.loop;
import java.util.Scanner;
// 특정 구구단 출력
public class ForEx07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("출력하고자 하는 구구단 단수는 ?");
		int dansu = sc.nextInt();
		for(int i=1 ; i<=9 ; i++) {
			System.out.println(dansu+"*"+i+"="+(dansu*i));
		}
	}
}
