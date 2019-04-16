package com.tj.xx;
//메소드(인자, 매개변수)
public class Step3 {
	public static void main(String[] args) {
		line('■', 30);
		System.out.println("Hello, A");
		line(25);
		System.out.println("Hello, B");
		line();
		System.out.println("Hello, C");
		line('■');
	}
	private static void line(char c, int i) {
		for(int cnt=0 ; cnt<i ; cnt++)
			System.out.print(c);
		System.out.println();
	}
	private static void line(int i) {
		for(int cnt=0 ; cnt<i ; cnt++)
			System.out.print('*');
		System.out.println();
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
