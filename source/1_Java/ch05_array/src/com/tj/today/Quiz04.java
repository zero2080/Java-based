package com.tj.today;
// 1���� �迭�� ����(������������)�ϱ�
public class Quiz04 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		int[] sortArr = new int[arr.length];
		System.arraycopy(arr, 0, sortArr, 0, arr.length);
		for(int i=0 ; i<sortArr.length ; i++) {
			for(int j=i+1 ; j<sortArr.length ; j++) {
				if(sortArr[i]>sortArr[j]) {
					int temp = sortArr[i];
					sortArr[i] = sortArr[j];
					sortArr[j] = temp;
				}
			}
		}// �������� ���� �Ϸ�
		System.out.print("������:");
		for(int a : arr) { 
			System.out.print(a + "  ");
		}
		System.out.print("\n������:");
		for(int s : sortArr) {
			System.out.print(s + "  ");
		}
	}
}
