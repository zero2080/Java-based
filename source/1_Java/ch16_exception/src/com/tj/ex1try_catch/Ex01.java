package com.tj.ex1try_catch;
import java.util.Scanner;
public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j;
		System.out.print("ù��° ����?");
		i = sc.nextInt();
		System.out.print("�ι�° ����?");
		j = sc.nextInt();
		System.out.println("i=" + i + ", j=" + j);
		System.out.println("i*j=" + (i*j) );
		try {
			System.out.println("i/j=" + (i/j) );
		}catch(ArithmeticException e) {
			System.out.println("0���� ������ �ʰ� ��ȸ�մϴ�");
			System.out.println(e.getMessage()); //������ ���ܸ޼���
			//e.printStackTrace(); // �ڼ��� ���� �޼���
		}
		System.out.println("i+j=" + (i+j) );
		System.out.println("i-j=" + (i-j) );
		System.out.println("DONE");
		sc.close();
	}
}
