package com.tj.ex;
public class Example01 {
	public static void main(String[] args) {
		int kor=100, eng=99, mat=100;
		/* ���� = 100, ���� = 99, ���� = 100
		 * �հ� = 299, ���=99.67
		 * ������ ���� ���� ��� : ���� / �����ͽǼ� ���� ��� : �Ǽ�  */
		int tot = kor+eng+mat;
		double avg = tot /3.0;
		//System.out.printf("����=%d, ����=%d, ����=%d\n", kor, eng, mat);
		System.out.println("����="+kor+", ����="+eng+", ����="+mat);
		System.out.printf("�հ�=%d, ���=%.2f", tot, avg);
		
	}
}
