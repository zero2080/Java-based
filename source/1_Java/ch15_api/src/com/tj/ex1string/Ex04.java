package com.tj.ex1string;
import java.util.Scanner;
/*  1. ��ȣ(031-234-5678)�Է� �ϸ� (sc.next())
	"�Է��� ��ȭ��ȣ : 031-234-5678
	¦����° ���ڿ�  : 0 1 2 6 5 7
	���ڸ� ���ٷ�    : 8765-432-130
	��ȭ��ȣ ���ڸ���: 031
	��ȭ��ȣ ���ڸ���: 5678"�� sysout
  2. x�� �Է��ϸ� ���α׷� ��*/
public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tel;
		while(true) {
			System.out.print("��ȭ��ȣ�� (��, ���Ḧ ���ϸ� X) ");
			tel = sc.next();
			if(tel.equalsIgnoreCase("x")) break;
			System.out.println("�Է��� ��ȭ��ȣ : "+tel);
			System.out.print("¦����° ���ڿ� : ");
			for(int idx=0 ; idx<tel.length() ; idx++) {
				System.out.print(idx%2==0? tel.charAt(idx): " ");
				/*if(idx%2==0) {
					System.out.print(tel.charAt(idx));
				}else {
					System.out.print(" ");
				}*/
			}
			System.out.print("\n���ڸ� ���ٷ�   : ");
			for(int idx=tel.length()-1 ; idx>=0 ; idx--) {
				System.out.print(tel.charAt(idx));
			}// 02-712-1234 010-9999-9999 010-435-8888
			int idx = tel.indexOf("-");//��ȭ��ȣ ���ڸ�
			String preTel = tel.substring(0, idx);
			int lastIdx = tel.lastIndexOf("-");//��ȭ��ȣ ���ڸ�
			String postTel = tel.substring(lastIdx+1);
			System.out.println("\n��ȭ��ȣ ���ڸ� : "+preTel);
			System.out.println("��ȭ��ȣ ���ڸ� : "+postTel);			
		}//while
	}//main
}//class








