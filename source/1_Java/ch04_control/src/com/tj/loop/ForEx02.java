package com.tj.loop;
// 1+2+3+4+5+6+7+8+9+10 = 55
public class ForEx02 {
	public static void main(String[] args) {
		int tot = 0; // ������ ����(1~10���� ����)
		for(int i=1 ; i<=10 ; i++) {
			if(i!=10) {
				System.out.print(i + " + ");
			} else {
				System.out.print(i+" = ");
			}
			tot += i; //tot = tot + i;
		}
		System.out.println(tot);
	}
}
