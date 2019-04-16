package com.tj.ex6_init;
public class InitTest {
	private int i=10; // ② 코드에 직접 초기화
	private static int si;
	{	// ③ 초기화 블럭 내에 초기화
		i=10;
	}
	static {
		si = 11;
	}
	public InitTest() {//① 생성자를 통한 초기화
		this.i = 10;
	}
}
