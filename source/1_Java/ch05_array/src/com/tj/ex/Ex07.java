package com.tj.ex;
// Ȯ�� for��(������ ������ ���� ��) vs. �Ϲ� for��(������ ������ ���� ��)
public class Ex07 {
	public static void main(String[] args) {
		int[] arr = {10,20,30};
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = arr[i]*10;
		}
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		// Ȯ�� for��
		for(int temp : arr) {
			temp = temp *10;
		}
		for(int a : arr) {
			System.out.print(a+"\t");
		}
	}
}
