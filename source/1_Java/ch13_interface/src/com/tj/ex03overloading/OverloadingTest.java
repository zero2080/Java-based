package com.tj.ex03overloading;
public class OverloadingTest {
	private int i1;
	private int i2;
	public OverloadingTest() {// new OverloadingTest()
		System.out.println("���ھ��� ������ ȣ��");
	}
	public OverloadingTest(int i) {// new OverloadingTest(1)
		System.out.println("���ڸ� "+i+"�� �ϳ� ���� ������ ȣ��");
		i1 = i2 = i;
	}
	public OverloadingTest(int i1, int i2) {// new OverloadingTest(1,1)
		System.out.println("���ڸ� "+i1+", "+i2+"�� �ΰ� ���� ������ ȣ��");
		this.i1 = i1; this.i2 = i2;
	}
	public OverloadingTest(String str) {// new OverloadingTest("10")
		// String("10")�� int(10)�� : Integer.parseInt(str)
		// int(10)�� String("10")����: String.valueOf(i)
		System.out.println("���ڸ� ��Ʈ������ ���� ������ ȣ��");
		i1 = i2 = Integer.parseInt(str);
	}
	public void calculate() {
		System.out.println(i1+"+"+i2+"="+(i1+i2));
	}
	/*public int calculate() {
		return i1+i2;
	}*/
	public void calculate(String msg) {
		System.out.println(msg);
	}
}





