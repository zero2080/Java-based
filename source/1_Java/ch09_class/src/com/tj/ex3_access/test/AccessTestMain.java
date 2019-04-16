package com.tj.ex3_access.test;

import com.tj.ex3_access.AccessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		obj.publicM(); // 가능
		//obj.defaultM();  //불가능
		//obj.protectedM();//불가능
		//obj.privateM();  //불가능
		System.out.println(obj.publicVar);
	}
}
