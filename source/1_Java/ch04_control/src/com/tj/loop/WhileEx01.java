package com.tj.loop;
//10, 9, 8, 7, 6, 5, 4, 3, 2, 1
public class WhileEx01 {
	public static void main(String[] args) {
		for(int i=10 ; i>0 ; i--) {
			if(i==1) {
				System.out.print(i);
			}else {
				System.out.print(i+ ", ");
			}
		}
		System.out.println("while������");
		int i = 10;
		while(i>0) {
			if(i==1) {
				System.out.println(i);
			}else {
				System.out.print(i+", ");
			}
			i--;
		}
	}
}
