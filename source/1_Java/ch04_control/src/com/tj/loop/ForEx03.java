package com.tj.loop;
/* 15 16 17 18 19
 * 20 21 22 23 24
 * .....       49
 * 50
 */
public class ForEx03 {
	public static void main(String[] args) {
		for(int i=15 ; i<=50 ; i++) {
			System.out.print(i+"\t");
			if(i%5==4) {
				System.out.println();
			}//if
		}//for
	}//main
}//class
