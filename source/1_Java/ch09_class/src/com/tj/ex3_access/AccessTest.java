package com.tj.ex3_access;
// public - protected - default - private
public class AccessTest {
	public int publicVar;
	protected int protectedVar;
	int defaultVar;
	private int privateVar;	
	public AccessTest() {
		System.out.println("�Ű����� ���� ������ ȣ��");
	}
	public void publicM() {
		System.out.println("public ���������ڴ� �� ��� ����");
	}
	protected void protectedM() {
		System.out.println("protected ���������ڴ� ���� ��Ű���� ��ӹ��� Ŭ�������� ��� ����");
	}
	void defaultM() {
		System.out.println("default ���������ڴ� ���� ��Ű�� Ŭ�������� ��� ����");
	}
	private void privateM() {
		System.out.println("private ���������ڴ� �� Ŭ���������� ��� ����");
	}
}
