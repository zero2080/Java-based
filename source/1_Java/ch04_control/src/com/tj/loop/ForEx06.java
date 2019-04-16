package com.tj.loop;
//	1~10까지 숫자 중 홀수의 합을 구해보자
public class ForEx06 {
	public static void main(String[] args) {
		int tot = 0;
		for(int i=1 ; i<=10 ; i+=2) {
			//if(i%2==1) {
				tot += i;
			//}
		}
		System.out.println("누적합은 "+tot);
	}
}
