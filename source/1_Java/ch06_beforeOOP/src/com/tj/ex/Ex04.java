package com.tj.ex;
import java.util.Scanner;
// ����ڷκ��� 1~9���� ���� �� �ϳ��� �޾� �ش� �������� ���(methodó��)
public class Ex04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�� �� ������(2~9��)? ");
		int dansu = scanner.nextInt();
		gugudanOut(dansu);
		scanner.close();
	}
	private static void gugudanOut(int dansu) {// �޼ҵ� �����
		for(int i=1 ; i<=9 ; i++) {                         //�޼ҵ� ������
			System.out.println(dansu+"*"+i+"="+(dansu*i));
		}
	}
}
