package com.tj.loop;
import java.util.Scanner;
// Ư�� ������ ���
public class ForEx07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("����ϰ��� �ϴ� ������ �ܼ��� ?");
		int dansu = sc.nextInt();
		for(int i=1 ; i<=9 ; i++) {
			System.out.println(dansu+"*"+i+"="+(dansu*i));
		}
	}
}
