package com.tj.ex8wrapper;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		int j = 20;
		System.out.println("합은 "+(i+j));
		Integer iObj = new Integer(10);
		Integer jObj = new Integer(20);
		int sum = iObj.intValue() + jObj.intValue();
		System.out.println("합은 "+sum);
	}
}
