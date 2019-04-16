package com.tj.today;
// 배열을 초기화 하고 합계, 평균, 최소값, 최고값 출력
public class Quiz03 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92}; // 초기화
		int tot=0, min=999, max=-999;
		double avg;
		for(int a : arr) {
			tot += a; // 합계 누적
			if(a>max) { // 최고값인지 확인
				max = a;
			}
			if(a<min) { // 최저값인지 확인
				min = a;
			}//if
		}//for
		avg = (double)tot/arr.length;
		System.out.println("합계 : "+tot+", 평균 : "+avg);
		System.out.println("최저값 : "+min+", 최고값 :"+max);
	}//main
}//class






