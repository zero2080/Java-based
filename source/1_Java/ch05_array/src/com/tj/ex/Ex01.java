package com.tj.ex;
public class Ex01 {
	public static void main(String[] args) {
		int i = 10;   // 변수의 선언과 초기화
		int[] iArr = {10,20,30}; // ① 배열의 선언과 초기화
		int[] jArr = new int[3]; // ② 배열 선언만 하고, 배열 공간 확보
		jArr[0] = 0;
		jArr[1] = 1; 
		jArr[2] = 2;
		int[] arr; // ③ 배열 변수 선언만 함. 배열 공간이 확보되지 않게
		arr = new int[3]; // 배열 공간 학보
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
	}
}
