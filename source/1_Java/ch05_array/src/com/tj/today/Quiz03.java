package com.tj.today;
// �迭�� �ʱ�ȭ �ϰ� �հ�, ���, �ּҰ�, �ְ� ���
public class Quiz03 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92}; // �ʱ�ȭ
		int tot=0, min=999, max=-999;
		double avg;
		for(int a : arr) {
			tot += a; // �հ� ����
			if(a>max) { // �ְ����� Ȯ��
				max = a;
			}
			if(a<min) { // ���������� Ȯ��
				min = a;
			}//if
		}//for
		avg = (double)tot/arr.length;
		System.out.println("�հ� : "+tot+", ��� : "+avg);
		System.out.println("������ : "+min+", �ְ� :"+max);
	}//main
}//class






