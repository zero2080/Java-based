package com.tj.ex;
public class Ex02 {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		// 일반 for 문
		for(int idx=0 ; idx<5 ; idx++) {
			System.out.println("arr["+idx+"] = "+arr[idx]);
		}
		// 확장 for문 - 배열의 값을 출력할 때
		int idx = 0;
		for(int temp : arr) {
			System.out.println("arr["+idx+"]="+temp);
			idx++;
		}
	}
}
