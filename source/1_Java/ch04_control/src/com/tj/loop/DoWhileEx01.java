package com.tj.loop;
import java.util.Scanner;
// ¦���� �Է��� ������ �Է��� �ް� ¦���� �Է��ϸ� �� �� ���
public class DoWhileEx01 {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("����(0), ����(1), ��(2) �� �ϳ� :");
			num=sc.nextInt();
		}while(num!=0 && num!=1 && num!=2);
		System.out.println("����� �� �Ŵ�"+num);
	}
}
