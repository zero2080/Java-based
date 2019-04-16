package com.tj.ex;

import com.tj.method.Arithmetic;

public class Ex03 {
	public static void main(String[] args) {
		Arithmetic tool = new Arithmetic();
		int tot = tool.sum(1,2);
		System.out.println(tool.evenOdd(tot));
		// System.out.println(tool.abs(-5)); public 만 다른 패키지에서 사용 가능
	}
}
