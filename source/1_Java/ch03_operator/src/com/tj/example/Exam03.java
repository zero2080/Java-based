package com.tj.example;
// 두수의 비교연산자 결과가 true면 0를 출력, false면 x를 출력
public class Exam03 {
	public static void main(String[] args) {
		int point = 75;
		int target = 80;
		System.out.println(point+"=="+target+"의 결과는 "+
				((point==target)? "O":"X"));
	}
}
