package com.tj.loop;
//1~100까지 3의 배수의 합 출력
public class WhileEx02 {
	public static void main(String[] args) {
		int tot = 0; // 누적변수
		int i = 3;
		while(i<=100) {
			//if(i%3==0) {
				tot += i;
			//}
			i+=3;
		}
		System.out.println("1~100까지 3의 배수의 합은 "+tot);
	}
}
