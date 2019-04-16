package com.tj.ex2throws;
public class ThrowEx {
	public ThrowEx() throws Exception{
		actionA();
	}
	private void actionA() throws Exception {
		System.out.println("actionA 전반부");
		actionB();
		System.out.println("actionA 후반부");
	}
	private void actionB() throws Exception{
		System.out.println("-actionB 전반부");
		actionC();
		System.out.println("-actionB 후반부");
	}
	private void actionC() throws ArrayIndexOutOfBoundsException{
		System.out.println("- - actionC 전반부");
		int[] arr = {0,1};
		System.out.println(arr[2]);
		System.out.println("- - actionC 후반부");
	}
}
