package com.tj.ex7scanner;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("주소를 입력하세요 : ");
		//sc.nextLine(); // '\n'이전을 가져오고 '\n'이후는 버림
		String add = sc.nextLine();
		System.out.println("입력한 주소는 "+add);
		
	}
}
