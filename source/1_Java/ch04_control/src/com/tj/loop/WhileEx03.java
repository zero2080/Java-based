package com.tj.loop;
import java.util.Scanner;
/* ��ǻ�Ϳ� ���������� ������ ���ѹݺ��ϴ� ������ �ۼ��Ͻÿ�.
  (��, ������� 0, ������� 1, ����� 2, ���Ḧ ���ϸ� -1�� �Է��մϴ�) */
public class WhileEx03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int me, computer;
		while(true) {
			System.out.println("����(0), ����(1), ��(2) �� �ϳ� ����(��, �����-1) : ");
			me = sc.nextInt();
			if(me==-1) break;
			computer = (int)(Math.random()*3);
			if(me>2 || me<0) {
				System.out.println("����� ��");
			}else if((me +2 )%3 == computer) { // me�� �̱� ���
				printResult(me, computer);
				System.out.println("me�� �̰��");
			}else if((me+1)%3 == computer ) {// computer�� �̱� ���
				printResult(me, computer);
				System.out.println("computer�� �̰��");
			}else if(me==computer) {//��� ��� 
				printResult(me, computer);
				System.out.println("����");
			}//if
		}//while
	}//main
	private static void printResult(int me, int computer) {
		System.out.println("���� "+(me==0? "����": me==1? "����":"��"));
		System.out.println("���� "+(computer==0? "����": computer==1? "����":"��"));
	}//printResult
}







