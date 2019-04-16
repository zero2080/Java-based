package com.tj.ex3;

public class ABCTestMain {
	public static void main(String[] args) {
		S a = new A();
		S b = new B();
		S c = new C();
		S[] arr = {a, b, c};
		for(S temp : arr) {
			System.out.println(temp.s);
		}
		/*System.out.println(a.s);
		System.out.println(b.s);
		System.out.println(c.s);*/
	}
}
