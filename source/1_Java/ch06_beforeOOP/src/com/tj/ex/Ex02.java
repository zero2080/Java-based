package com.tj.ex;
// 1~10±îÁöÀÇ ÇÕ + Â¦¼öÀÎÁö È¦¼öÀÎÁö ÆÄ¾Ç
public class Ex02 {
	public static void main(String[] args) {
		int tot = sum(1, 10);
		System.out.println("ÇÕÀº "+tot);

		System.out.println(evenOdd(tot));
	}
	private static String evenOdd(int value) {
		String result = (value%2)==0 ? "Â¦¼ö":"È¦¼ö";
		return result;
	}
	private static int sum(int i, int j) {
		int resultTot = 0;
		for(int su=i ; su<=j ; su++) {
			resultTot += su;
		}
		return resultTot;
	}
}
