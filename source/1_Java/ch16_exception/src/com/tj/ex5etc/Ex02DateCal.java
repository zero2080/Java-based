package com.tj.ex5etc;
import java.util.Date;
import java.util.Scanner;
public class Ex02DateCal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Date checkIn = new Date();            //2018.12.13반납
		Date checkOut = new Date(118, 10, 31);//2018.11.28대출
		long day = (checkIn.getTime() - checkOut.getTime()) /(1000*60*60*24);
		if(day>14) {
			System.out.print((day-14)*100+"원의 연체료를 받으셨나요(Y/N)?");
			String answer = sc.next();
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("반납처리후 도서상태 출력");
			}else if(answer.equalsIgnoreCase("n")) {
				System.out.println("연체료 독촉하시고 반납처리 안된다하슈");
			}else {
				System.out.println("입력이 유효하지 않아요");
			}
		}else {
			System.out.println("반납처리후 도서상태 출력");
		}
	}
}
