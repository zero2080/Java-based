package com.tj.ex3_access.test;

import com.tj.ex3_access.AccessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		obj.publicM(); // ����
		//obj.defaultM();  //�Ұ���
		//obj.protectedM();//�Ұ���
		//obj.privateM();  //�Ұ���
		System.out.println(obj.publicVar);
	}
}
