package com.tj.loop;
// 2~9단까지 출력
public class ForEx08 {
	public static void main(String[] args) {
		for(int i=1 ; i<=9 ; i++) {
			for(int dansu=2 ; dansu<=9 ; dansu++) {
				System.out.print(dansu+"*"+i+"="+(dansu*i)+"\t");
			}
			System.out.println();//개행
		}//for-i
	}//main
}//class
