package com.tj.example;
import java.util.Scanner;
/*(��������4) ���̸� �Է¹޾� �Է¹��� ���̰� 65�� �̻��� ��, 
              ����ο�롱 ���, �ƴϸ� ���Ϲݡ����*/
public class Exam04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���̸� �Է��Ͻ� : ");
		int age = scanner.nextInt();
		System.out.println((age>=65)? "��ο��":"�Ϲ�");
		scanner.close();
	}
}
