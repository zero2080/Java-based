package com.tj.ex;

public class VarEx07 {
	public static void main(String[] args) {
		// �������� ����ȯ = ���� �ָӴϰ��� ū �ָӴϷ� �Ҵ��� ��
		int i = 10; 
		double d = i;
		// ������� ����ȯ = ū �ָӴϰ��� ���� �ָӴϷ� �Ҵ��� ��(������ �ս�, �ڵ���)
		i = (int)10.9;
		System.out.printf("i=%d \t d=%f", i, d);
	}
}
