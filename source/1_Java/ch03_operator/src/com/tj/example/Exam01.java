package com.tj.example;
import java.util.Scanner;
// ����ڷκ��� �Է¹��� ���� 3�� ������� �Ǵ��ϱ�
public class Exam01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("3�� ������� Ȯ���� ������ ? ");
		int su = sc.nextInt(); // Ű����κ��� ���� �Է� �޾� su�� �Ҵ�
		if(su%3 == 0)
			System.out.println("�Է��� ���� 3�� ����Դϴ�");
		else
			System.out.println("�Է��� ���� 3�� ����� �ƴմϴ�");
		sc.close();
	}
}
