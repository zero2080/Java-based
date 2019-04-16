package com.tj.method;

public class Arithmetic {
	public /*static*/ int sum(int i, int j) {
		int resultTot = 0;
		for(int su=i ; su<=j ; su++) {
			resultTot += su;
		}
		return resultTot;
	}
	public /*static*/ String evenOdd(int value) {
		String result = (value%2==0)? "Â¦¼öÀÔ´Ï´Ù":"È¦¼öÀÔ´Ï´Ù";
		return result;
	}
	int abs(int value) {
		int result = (value<0)? -value : value;
		return result;
	}
}
