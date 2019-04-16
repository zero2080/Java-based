package com.tj.loop;
// break vs. continue
public class BreakEx {
	public static void main(String[] args) {
		for(int i=0 ; i<=5 ; i++) {
			if(i==3) break; // 반복문을 빠져나와 반복문 종료
			System.out.println(i);
		}
		for(int i=0 ; i<=5 ; i++) {
			if(i==3) continue; // 반복문을 빠져와서 증감부로 감
			System.out.println(i);
		}
	}
}
