package com.tj.ex;
public class Example01 {
	public static void main(String[] args) {
		int kor=100, eng=99, mat=100;
		/* 국어 = 100, 영어 = 99, 수학 = 100
		 * 합계 = 299, 평균=99.67
		 * 정수와 정수 연수 결과 : 정수 / 정수와실수 연산 결과 : 실수  */
		int tot = kor+eng+mat;
		double avg = tot /3.0;
		//System.out.printf("국어=%d, 영어=%d, 수학=%d\n", kor, eng, mat);
		System.out.println("국어="+kor+", 영어="+eng+", 수학="+mat);
		System.out.printf("합계=%d, 평균=%.2f", tot, avg);
		
	}
}
