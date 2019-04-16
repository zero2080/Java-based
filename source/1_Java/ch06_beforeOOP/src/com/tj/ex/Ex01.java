package com.tj.ex;
// 1~10까지의 합 + 짝수인지 홀수인지 파악
public class Ex01 {
	public static void main(String[] args) {
		int tot = 0;
		for(int i=1 ; i<=10 ; i++) {
			tot += i;
		}
		System.out.println("합은 "+tot);
		String result = (tot%2)==0 ? "짝수":"홀수";
		System.out.println(result);
	}
}
