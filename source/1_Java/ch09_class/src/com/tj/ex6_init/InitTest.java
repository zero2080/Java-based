package com.tj.ex6_init;
public class InitTest {
	private int i=10; // �� �ڵ忡 ���� �ʱ�ȭ
	private static int si;
	{	// �� �ʱ�ȭ �� ���� �ʱ�ȭ
		i=10;
	}
	static {
		si = 11;
	}
	public InitTest() {//�� �����ڸ� ���� �ʱ�ȭ
		this.i = 10;
	}
}
