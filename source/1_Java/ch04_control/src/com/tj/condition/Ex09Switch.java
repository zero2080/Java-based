package com.tj.condition;
import java.util.Scanner;
// �Է¹��� ������ ������ ���
public class Ex09Switch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ ");
		int score = scanner.nextInt();
		int tempScore = (score==100)? score-1 : score;
		switch(tempScore/10) {
			case 9 : System.out.println("A����");break;
			case 8 : System.out.println("B����");break;
			case 7 : System.out.println("C����");break;
			case 6 : System.out.println("D����");break;
			case 5 : case 4: case 3: case 2: case 1: case 0:
				System.out.println("F����");break;
			default: System.out.println("��ȿ�� ������ �ƴմϴ�");
		}
	}
}
