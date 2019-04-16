package com.tj.ex1string;
// String, StringBuffer, StringBuilder
public class Ex07 {
	public static void main(String[] args) {
		String str = "A";
		//String����
		long st = System.currentTimeMillis();// 1970.1.1~2018.12.11����
		for(int i=0 ; i<50000 ; i++)
			str += "B";
		long et = System.currentTimeMillis();// 1970.1.1~����
		System.out.println("String ���� ����ð� : "+(et-st));
		//StringBuffer����
		st = System.currentTimeMillis(); //���۽���
		StringBuffer strBuff = new StringBuffer("A");
		for(int i=0 ; i<50000 ; i++)
			strBuff.append("B");
		et = System.currentTimeMillis(); //������ ����
		System.out.println("StringBuffer���� ����ð� : "+(et-st));
		//StringBuilder ����
		st = System.currentTimeMillis();
		StringBuilder strBuil = new StringBuilder("A");
		for(int i=0 ; i<50000 ; i++)
			strBuil.append("B");
		et = System.currentTimeMillis();
		System.out.println("StringBuilder���� ���� �ð� : "+(et-st));
	}
}
