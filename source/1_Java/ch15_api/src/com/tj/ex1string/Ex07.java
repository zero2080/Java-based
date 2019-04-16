package com.tj.ex1string;
// String, StringBuffer, StringBuilder
public class Ex07 {
	public static void main(String[] args) {
		String str = "A";
		//String구간
		long st = System.currentTimeMillis();// 1970.1.1~2018.12.11현재
		for(int i=0 ; i<50000 ; i++)
			str += "B";
		long et = System.currentTimeMillis();// 1970.1.1~현재
		System.out.println("String 구간 실행시간 : "+(et-st));
		//StringBuffer구간
		st = System.currentTimeMillis(); //시작시점
		StringBuffer strBuff = new StringBuffer("A");
		for(int i=0 ; i<50000 ; i++)
			strBuff.append("B");
		et = System.currentTimeMillis(); //끝나는 시점
		System.out.println("StringBuffer구간 실행시간 : "+(et-st));
		//StringBuilder 구간
		st = System.currentTimeMillis();
		StringBuilder strBuil = new StringBuilder("A");
		for(int i=0 ; i<50000 ; i++)
			strBuil.append("B");
		et = System.currentTimeMillis();
		System.out.println("StringBuilder구간 실행 시간 : "+(et-st));
	}
}
