package com.tj.ex;
public class Ex02 {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		// �Ϲ� for ��
		for(int idx=0 ; idx<5 ; idx++) {
			System.out.println("arr["+idx+"] = "+arr[idx]);
		}
		// Ȯ�� for�� - �迭�� ���� ����� ��
		int idx = 0;
		for(int temp : arr) {
			System.out.println("arr["+idx+"]="+temp);
			idx++;
		}
	}
}
