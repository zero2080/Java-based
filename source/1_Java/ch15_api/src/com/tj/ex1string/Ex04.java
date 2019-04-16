package com.tj.ex1string;
import java.util.Scanner;
/*  1. 번호(031-234-5678)입력 하면 (sc.next())
	"입력한 전화번호 : 031-234-5678
	짝수번째 문자열  : 0 1 2 6 5 7
	문자를 꺼꾸로    : 8765-432-130
	전화번호 앞자리는: 031
	전화번호 뒷자리는: 5678"을 sysout
  2. x를 입력하면 프로그램 끝*/
public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tel;
		while(true) {
			System.out.print("전화번호는 (단, 종료를 원하면 X) ");
			tel = sc.next();
			if(tel.equalsIgnoreCase("x")) break;
			System.out.println("입력한 전화번호 : "+tel);
			System.out.print("짝수번째 문자열 : ");
			for(int idx=0 ; idx<tel.length() ; idx++) {
				System.out.print(idx%2==0? tel.charAt(idx): " ");
				/*if(idx%2==0) {
					System.out.print(tel.charAt(idx));
				}else {
					System.out.print(" ");
				}*/
			}
			System.out.print("\n문자를 꺼꾸로   : ");
			for(int idx=tel.length()-1 ; idx>=0 ; idx--) {
				System.out.print(tel.charAt(idx));
			}// 02-712-1234 010-9999-9999 010-435-8888
			int idx = tel.indexOf("-");//전화번호 앞자리
			String preTel = tel.substring(0, idx);
			int lastIdx = tel.lastIndexOf("-");//전화번호 뒷자리
			String postTel = tel.substring(lastIdx+1);
			System.out.println("\n전화번호 앞자리 : "+preTel);
			System.out.println("전화번호 뒷자리 : "+postTel);			
		}//while
	}//main
}//class








