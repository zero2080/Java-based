package com.tj.ex;
// 1~10������ �� + ¦������ Ȧ������ �ľ�
public class Ex01 {
	public static void main(String[] args) {
		int tot = 0;
		for(int i=1 ; i<=10 ; i++) {
			tot += i;
		}
		System.out.println("���� "+tot);
		String result = (tot%2)==0 ? "¦��":"Ȧ��";
		System.out.println(result);
	}
}
