package com.tj.today;
// 1차원 배열 값의 누적합 출력하기
public class Quiz01 {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int tot = 0;
		for(int i=0 ; i<arr.length ; i++) {
			tot += arr[i];
		}
		/*for(int a : arr) {
			tot += a;
		}*/
		System.out.println("누적합은 "+tot);
	}
}
