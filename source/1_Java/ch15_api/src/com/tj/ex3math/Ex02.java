package com.tj.ex3math;
// �ݿø�, �ø�, ����
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("�Ҽ������� �ݿø�, �ø�, ����");
		System.out.println("9.69�� �ݿø� :"+Math.round(9.69));
		System.out.println("9.69�� �ø� :"+Math.ceil(9.69));
		System.out.println("9.69�� ���� :"+Math.floor(9.69));
		System.out.println("�Ҽ������� ù��°�ڸ����� �ݿø�, �ø�, ����");
		System.out.println("9.69�� �ݿø� :"+Math.round(9.69*10)/10.0);
		System.out.println("9.69�� �ø� :"+Math.ceil(9.69*10)/10.0);
		System.out.println("9.69�� ���� :"+Math.floor(9.69*10)/10.0);
		System.out.println("���� �ڸ����� �ݿø�, �ø�, ����");
		System.out.println("19�� �ݿø� : "+Math.round(19/10.0)*10);
		System.out.println("19�� �ø� : "+(int)Math.ceil(19/10.0)*10);
		System.out.println("19�� ���� : "+(int)Math.floor(19/10.0)*10);
	}
}