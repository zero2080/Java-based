package com.tj.ex4_finalVar;
// final ���� - �ʱ�ȭ �� �� ���� �Ұ� 
public class FinalVarTest {
	public static void main(String[] args) {
		final double PI = 3.141592;
		// PI = 3.14; final������ ����Ұ�
		double r = 3;
		double area = PI*r*r;
		double round = 2*PI*r;
		System.out.println("�������� "+r+"�� ���� ���̴� "+area);
		System.out.println("�������� "+r+"�� ���� �ѷ��� "+round);
	}
}
