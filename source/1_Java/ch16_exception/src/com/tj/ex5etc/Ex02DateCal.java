package com.tj.ex5etc;
import java.util.Date;
import java.util.Scanner;
public class Ex02DateCal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Date checkIn = new Date();            //2018.12.13�ݳ�
		Date checkOut = new Date(118, 10, 31);//2018.11.28����
		long day = (checkIn.getTime() - checkOut.getTime()) /(1000*60*60*24);
		if(day>14) {
			System.out.print((day-14)*100+"���� ��ü�Ḧ �����̳���(Y/N)?");
			String answer = sc.next();
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("�ݳ�ó���� �������� ���");
			}else if(answer.equalsIgnoreCase("n")) {
				System.out.println("��ü�� �����Ͻð� �ݳ�ó�� �ȵȴ��Ͻ�");
			}else {
				System.out.println("�Է��� ��ȿ���� �ʾƿ�");
			}
		}else {
			System.out.println("�ݳ�ó���� �������� ���");
		}
	}
}
