package com.tj.ex3_access;
public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		System.out.println(obj.publicVar);;  // ����
		System.out.println(obj.protectedVar);// ���� - ���� ��Ű��
		System.out.println(obj.defaultVar);  // ���� - ���� ��Ű��
		// System.out.println(obj.privateVar); �Ұ���
		obj.publicM();   //����
		obj.protectedM();//����
		obj.defaultM();  //����
		// obj.privateM(); �Ұ���
	}
}
