package com.tj.ex;
//�迭 ���� - API�� �̿��� ����
public class Ex05 {
	public static void main(String[] args) {
		int[] num= {0,1,2,3,4};
		int[] newNum = new int[num.length];
		for(int i=0 ; i<num.length ; i++) {
			System.out.println(num[i]);
		}
		for(int i=0 ; i<num.length ; i++) {
			System.out.println(newNum[i]);
		}
		System.arraycopy(num, 0, newNum, 0, num.length);// �迭 ���� api �޼���
		newNum[0]=newNum[1]=newNum[2]=99;
		for(int i=0 ; i<num.length ; i++) {
			System.out.println(num[i]);
		}
		for(int i=0 ; i<num.length ; i++) {
			System.out.println(newNum[i]);
		}
	}
}
