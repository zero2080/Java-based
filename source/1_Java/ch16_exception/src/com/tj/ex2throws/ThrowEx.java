package com.tj.ex2throws;
public class ThrowEx {
	public ThrowEx() throws Exception{
		actionA();
	}
	private void actionA() throws Exception {
		System.out.println("actionA ���ݺ�");
		actionB();
		System.out.println("actionA �Ĺݺ�");
	}
	private void actionB() throws Exception{
		System.out.println("-actionB ���ݺ�");
		actionC();
		System.out.println("-actionB �Ĺݺ�");
	}
	private void actionC() throws ArrayIndexOutOfBoundsException{
		System.out.println("- - actionC ���ݺ�");
		int[] arr = {0,1};
		System.out.println(arr[2]);
		System.out.println("- - actionC �Ĺݺ�");
	}
}
