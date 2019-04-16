package com.tj.ex;

public class Ex03 {
	public static void main(String[] args) {
		int i = 10;
		int j = i;
		j = 100;
		System.out.println("i="+i+"\t j="+j);
		int[] s = {10,20,30,40,50};
		int[] ss = s;
		ss[0] = 99; ss[3]=99;
		for(int idx=0 ; idx<s.length ; idx++) {
			System.out.println("s["+idx+"] = "+s[idx]);
		}
	}
}
