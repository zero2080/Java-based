package com.tj.ex;
//배열 복사 - API를 이용한 복사
public class Ex05 {
	public static void main(String[] args) {
		int[] num= {0,1,2,3,4};
		int[] newNum = new int[num.length];
		for(int i=0 ; i<num.length ; i++) {
			System.out.println(num[i]);
		}
		for(int i=0 ; i<num.length ; i++) {
			System.out.println(newNum[i]);
		}
		System.arraycopy(num, 0, newNum, 0, num.length);// 배열 복사 api 메서드
		newNum[0]=newNum[1]=newNum[2]=99;
		for(int i=0 ; i<num.length ; i++) {
			System.out.println(num[i]);
		}
		for(int i=0 ; i<num.length ; i++) {
			System.out.println(newNum[i]);
		}
	}
}
