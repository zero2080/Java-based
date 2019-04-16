package com.tj.ex3math;
// 반올림, 올림, 내림
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("소숫점에서 반올림, 올림, 내림");
		System.out.println("9.69를 반올림 :"+Math.round(9.69));
		System.out.println("9.69를 올림 :"+Math.ceil(9.69));
		System.out.println("9.69를 내림 :"+Math.floor(9.69));
		System.out.println("소숫점이하 첫번째자리에서 반올림, 올림, 내림");
		System.out.println("9.69를 반올림 :"+Math.round(9.69*10)/10.0);
		System.out.println("9.69를 올림 :"+Math.ceil(9.69*10)/10.0);
		System.out.println("9.69를 내림 :"+Math.floor(9.69*10)/10.0);
		System.out.println("십의 자리에서 반올림, 올림, 내림");
		System.out.println("19를 반올림 : "+Math.round(19/10.0)*10);
		System.out.println("19를 올림 : "+(int)Math.ceil(19/10.0)*10);
		System.out.println("19를 내림 : "+(int)Math.floor(19/10.0)*10);
	}
}