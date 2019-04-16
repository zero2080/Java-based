package com.tj.ex;

public class VarEx06 {
	public static void main(String[] args) {
		float f=(float)10.2;
		f = 10.0000017F;
		double d = 10.000017;
		System.out.printf("f=%.7f\n",f);
		System.out.println("d="+d);
		if(f==d)
			System.out.println("f와 d는 같다");
		else
			System.out.println("f와 d는 다르다");
	}
}
