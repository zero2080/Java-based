package com.tj.example;
import java.util.Scanner;
// �ֹι�ȣ 7��° �ڸ����� �Է¹޾� �������� �������� ���
public class Exam05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ֹι�ȣ 7��° �ڸ����� ?");
		int gender = scanner.nextInt();
		System.out.println((gender==1 || gender==3)? "����":"����");
		scanner.close();
	}
}
