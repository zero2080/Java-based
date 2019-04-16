package com.tj.ex1try_catch;

public class Ex04 {
	public static void main(String[] args) {
		int[] iArr = {0,1,2};
		for(int i=0 ; i<=iArr.length ; i++) {
			try {
				System.out.println(iArr[i]);
			}catch(IndexOutOfBoundsException e) {
				System.out.println("예외 : "+e.getMessage());
			}finally {
				System.out.println("~~~~~~~이곳은 꼭~~~~~~~~~~~~");
			}
		}
	}
}
