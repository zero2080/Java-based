package com.tj.condition;
import java.util.Scanner;
// �����Է� �޾� ¦��,Ȧ������ ���(switch)
public class Ex10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�Է��ϴ� ��?");
		int su = scanner.nextInt();
		switch(su%2) {
		case 0 : System.out.println("¦�� �Է��߳�");break;
		case 1: case -1:
			System.out.println("Ȧ�� �Է��߳�");break;
		}
	}
}
