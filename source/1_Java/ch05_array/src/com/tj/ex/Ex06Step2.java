package com.tj.ex;
import java.util.Scanner;
// �迭�� �̿��Ͽ� �л���(����, ö��, �浿, ����, ����)�� Ű�� �Է¹ް� ���ġ ���
// �ִܽŰ� ����ģ ģ���� �̸��� Ű�� ���
public class Ex06Step2 {
	public static void main(String[] args) {
		String[] arrName = {"����","ö��","�浿","����","����"};
		int[]    arrHeight = new int[arrName.length];
		Scanner scanner = new Scanner(System.in);
		int totHeight = 0;
		int min=999, max=0; // �� �� ��   
		int maxIndex=-1, minIndex=-1; // ����Ű� �ִܽ� index
		for(int idx=0 ; idx<arrName.length ; idx++) {
			System.out.print(arrName[idx]+"�� Ű��? ");
			arrHeight[idx] = scanner.nextInt();
		}
		scanner.close();
		for(int idx=0 ; idx<arrHeight.length ; idx++) {
			totHeight += arrHeight[idx];
		}
		System.out.println("���Ű�� "+totHeight/arrHeight.length);
		for(int idx=0 ; idx<arrHeight.length ; idx++) {
			if(arrHeight[idx]>max) { //max���� ũ��?
				max = arrHeight[idx];
				maxIndex = idx;
			}
			if(arrHeight[idx]<min) { // min���� �۴�?
				min = arrHeight[idx];
				minIndex = idx;
			}
		}// �ִܽŰ� ������� �ִ� index
		System.out.println("����� : "+arrName[maxIndex] +" Ű : "+arrHeight[maxIndex]);
		System.out.println("�ִܽ� : "+arrName[minIndex] +" Ű : "+arrHeight[minIndex]);
	}
}








