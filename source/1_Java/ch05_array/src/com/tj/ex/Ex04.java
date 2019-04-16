package com.tj.ex;
// 배열 복사 - for문을 이용한 복사, API를 이용한 복사
public class Ex04 {
	public static void main(String[] args) {
		int[] num = {0,1,2,3,4};
		int[] newNum = new int[5];
		for(int idx=0 ; idx<num.length ; idx++) {
			newNum[idx] = num[idx];
		}
		newNum[0] = 99;
		for(int idx=0 ; idx<num.length ; idx++) {
		  System.out.println("num["+idx+"]="+num[idx]+"  newNum["+idx+"]="+newNum[idx]);
		}
	}
}
