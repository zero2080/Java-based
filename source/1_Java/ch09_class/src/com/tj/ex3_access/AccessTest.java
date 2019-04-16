package com.tj.ex3_access;
// public - protected - default - private
public class AccessTest {
	public int publicVar;
	protected int protectedVar;
	int defaultVar;
	private int privateVar;	
	public AccessTest() {
		System.out.println("매개변수 없는 생성자 호출");
	}
	public void publicM() {
		System.out.println("public 접근제한자는 다 사용 가능");
	}
	protected void protectedM() {
		System.out.println("protected 접근제한자는 같은 패키지와 상속받은 클래스까지 사용 가능");
	}
	void defaultM() {
		System.out.println("default 접근제한자는 같은 패키지 클래스까지 사용 가능");
	}
	private void privateM() {
		System.out.println("private 접근제한자는 본 클래스에서만 사용 가능");
	}
}
