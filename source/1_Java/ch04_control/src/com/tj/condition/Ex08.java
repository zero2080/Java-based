package com.tj.condition;
import java.util.Scanner;
/*(me +2 )%3 == computer�� ���, me�� �̱�
(me+1)%3 == computer �� ���, computer�� �̱�*/
public class Ex08 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("����(0), ����(1), ��(2) �� �ϳ� ����?");
		int me = scanner.nextInt();  // ����
		int computer = (int)(Math.random()*3); // 0,1,2
		if((me+2)%3 == computer) {
			System.out.println("��"+(me==0? "����, ":
									(me==1)? "����, ":"��, "));
			System.out.println("��ǻ�ʹ� "+(computer==0? "���� ":
				(computer==1)? "���� ":"�� "));
			System.out.println("= ���� �̰��");
		}else if((me+1)%3 == computer) {
			System.out.println("��"+(me==0? "����, ":
				(me==1)? "����, ":"��, "));
			System.out.println("��ǻ�ʹ� "+(computer==0? "���� ":
				(computer==1)? "���� ":"�� "));
			System.out.println("= ��ǻ�Ͱ� �̰��");
		}else if(me==computer){
			System.out.println("��"+(me==0? "����, ":
				(me==1)? "����, ":"��, "));
			System.out.println("��ǻ�ʹ� "+(computer==0? "���� ":
				(computer==1)? "���� ":"�� "));
			System.out.println("����");
		}else {
			System.out.println("�߸� �³�");
		}//if
	}//main
}//class
