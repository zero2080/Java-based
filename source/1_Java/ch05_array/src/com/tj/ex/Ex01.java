package com.tj.ex;
public class Ex01 {
	public static void main(String[] args) {
		int i = 10;   // ������ ����� �ʱ�ȭ
		int[] iArr = {10,20,30}; // �� �迭�� ����� �ʱ�ȭ
		int[] jArr = new int[3]; // �� �迭 ���� �ϰ�, �迭 ���� Ȯ��
		jArr[0] = 0;
		jArr[1] = 1; 
		jArr[2] = 2;
		int[] arr; // �� �迭 ���� ���� ��. �迭 ������ Ȯ������ �ʰ�
		arr = new int[3]; // �迭 ���� �к�
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
	}
}
