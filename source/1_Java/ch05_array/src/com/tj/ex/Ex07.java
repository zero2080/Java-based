package com.tj.ex;
// 확장 for문(데이터 변경이 없을 시) vs. 일반 for문(데이터 변경이 있을 시)
public class Ex07 {
	public static void main(String[] args) {
		int[] arr = {10,20,30};
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = arr[i]*10;
		}
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		// 확장 for문
		for(int temp : arr) {
			temp = temp *10;
		}
		for(int a : arr) {
			System.out.print(a+"\t");
		}
	}
}
