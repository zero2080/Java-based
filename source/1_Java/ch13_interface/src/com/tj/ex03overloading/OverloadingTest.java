package com.tj.ex03overloading;
public class OverloadingTest {
	private int i1;
	private int i2;
	public OverloadingTest() {// new OverloadingTest()
		System.out.println("인자없는 생성자 호출");
	}
	public OverloadingTest(int i) {// new OverloadingTest(1)
		System.out.println("인자를 "+i+"로 하나 받은 생성자 호출");
		i1 = i2 = i;
	}
	public OverloadingTest(int i1, int i2) {// new OverloadingTest(1,1)
		System.out.println("인자를 "+i1+", "+i2+"로 두개 받은 생성자 호출");
		this.i1 = i1; this.i2 = i2;
	}
	public OverloadingTest(String str) {// new OverloadingTest("10")
		// String("10")을 int(10)로 : Integer.parseInt(str)
		// int(10)를 String("10")으로: String.valueOf(i)
		System.out.println("인자를 스트링으로 받은 생성자 호출");
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





