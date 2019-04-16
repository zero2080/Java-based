package com.tj.xx;

public class Step2 {
	public static void main(String[] args) {
		line('бс');
		System.out.println("Hello, A");
		line('*');
		System.out.println("Hello, B");
		line();
		System.out.println("Hello, C");
		line('бс');
	}
	private static void line(char c) {
		for(int cnt=0 ; cnt<30 ; cnt++)
			System.out.print(c);
		System.out.println();
	}
	private static void line() {
		System.out.println("*****************************");
	}
}
