package com.tj.loop;
//1~100���� 3�� ����� �� ���
public class WhileEx02 {
	public static void main(String[] args) {
		int tot = 0; // ��������
		int i = 3;
		while(i<=100) {
			//if(i%3==0) {
				tot += i;
			//}
			i+=3;
		}
		System.out.println("1~100���� 3�� ����� ���� "+tot);
	}
}
