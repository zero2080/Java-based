package com.tj.ex3_access;
public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		System.out.println(obj.publicVar);;  // 가능
		System.out.println(obj.protectedVar);// 가능 - 같은 패키지
		System.out.println(obj.defaultVar);  // 가능 - 같은 패키지
		// System.out.println(obj.privateVar); 불가능
		obj.publicM();   //가능
		obj.protectedM();//가능
		obj.defaultM();  //가능
		// obj.privateM(); 불가능
	}
}
