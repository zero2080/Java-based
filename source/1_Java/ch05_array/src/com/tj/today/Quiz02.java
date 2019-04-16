package com.tj.today;
// 2차원 배열값들의 누적합 출력
public class Quiz02 {
	public static void main(String[] args) {
		int[][] arr = {{5,5,5,5,5},{10,10,10,10,10},{20,20,20,20,20},{30,30,30,30,30}};
		int tot = 0; // 전체 누적 변수
		int[] rowTot = new int[arr.length]; // rowTot[0] ~ rowTot[3]
		for(int i=0 ; i<arr.length ; i++) { // 0~3 행까지
			for(int j=0 ; j<arr[i].length ; j++) { // i행의 0~4 열까지
				tot += arr[i][j]; //tot = tot + arr[i][j]; 전체 누적
				rowTot[i] += arr[i][j]; // 행별 누적
			}
		}
		// 계산된 행별 누적과 전체 누적 출력
		for(int i=0 ; i<rowTot.length ; i++) {
			System.out.println(i+"번째 행의 합은 "+rowTot[i]);
		}
		System.out.println("전체 누적합은 "+tot);
	}
}
