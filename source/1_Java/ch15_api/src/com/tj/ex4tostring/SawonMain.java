package com.tj.ex4tostring;

public class SawonMain {
	public static void main(String[] args) {
		Sawon kang = new Sawon("23a501", "강동원", "전산실");
		Sawon kim  = new Sawon("22a011", "김길동", "비서실");
		//System.out.println(kang.infoString());
		System.out.println(kang);
		System.out.println(kim);
	}
}
