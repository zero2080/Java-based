package com.tj.condition;
import java.util.Scanner;
// ����(0), ����(1), ���ڱ�(2)
public class Ex06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("����(0), ����(1), ��(2) �� �ϳ��� ������?");
		int me = scanner.nextInt();
		if(me==0) {
			System.out.println("���� �³�");
		}else if(me==1) {
			System.out.println("���� �³�");
		}else if(me==2){
			System.out.println("�� �³�");
		}else {
			System.out.println("��ȿ���� �ʴ� �� �³�");
		}//if
	}//main
}//class
