package com.tj.example;
import java.util.Scanner;
// ����ڷκ��� �Է¹��� ���� ¦������ Ȧ������ �Ǵ��ϱ�
public class Exam02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ȯ���� ������ ? ");
		int su = sc.nextInt(); // Ű����κ��� ���� �Է� �޾� su�� �Ҵ�
		if(su%2 == 0)
			System.out.println("�Է��� ���� ¦���Դϴ�");
		else
			System.out.println("�Է��� ���� Ȧ���Դϴ�");
		sc.close();
	}
}
