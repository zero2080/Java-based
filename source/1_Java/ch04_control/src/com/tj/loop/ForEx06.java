package com.tj.loop;
//	1~10���� ���� �� Ȧ���� ���� ���غ���
public class ForEx06 {
	public static void main(String[] args) {
		int tot = 0;
		for(int i=1 ; i<=10 ; i+=2) {
			//if(i%2==1) {
				tot += i;
			//}
		}
		System.out.println("�������� "+tot);
	}
}
