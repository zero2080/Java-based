package com.tj.ex;
import java.util.Scanner;
// �迭�� �̿��Ͽ� �л���(����, ö��, �浿, ����, ����)�� Ű�� �Է¹ް� ���ġ�� ���غ���
public class Ex06 {
	public static void main(String[] args) {
		String[] arrName = {"����","ö��","�浿","����","����"};
		int[]    arrHeight = new int[arrName.length];
		Scanner scanner = new Scanner(System.in);
		int totHeight = 0;
		for(int idx=0 ; idx<arrName.length ; idx++) {
			System.out.print(arrName[idx]+"�� Ű��? ");
			arrHeight[idx] = scanner.nextInt();
		}
		scanner.close();
		for(int idx=0 ; idx<arrHeight.length ; idx++) {
			totHeight += arrHeight[idx];
		}
		System.out.println("���Ű�� "+totHeight/arrHeight.length);
	}
}








