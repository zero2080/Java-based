package com.tj.condition;
import java.util.Scanner;
// 국, 영, 수 점수를 입력받아 각 과목별 평균이상인지 이하인지 출력
public class Ex05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor, eng, mat; double avg;
		System.out.print("국어점수는 ?");
		kor = sc.nextInt();
		System.out.print("영어점수는 ?");
		eng = sc.nextInt();
		System.out.print("수학점수는 ?");
		mat = sc.nextInt();
		avg = (kor+eng+mat) / 3.0 ;
		if(kor>=avg) {
			System.out.printf("국어가 평균(%.2f)이상입니다", avg);
		}else {
			System.out.printf("국어가 평균(%.2f)미만입니다", avg);
		}
		if(eng>=avg) {
			System.out.printf("영어가 평균(%.2f)이상입니다", avg);
		}else {
			System.out.printf("영어가 평균(%.2f)미만입니다", avg);
		}
		if(mat>=avg) {
			System.out.printf("수학이 평균(%.2f)이상입니다", avg);
		}else {
			System.out.printf("수학이 평균(%.2f)미만입니다", avg);
		}
	}
}
