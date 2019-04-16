package com.tj.ex1try_catch;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j=1;
		do {
			try {
				System.out.print("ù��° ����?");
				i = sc.nextInt();
				break;
			}catch(Exception e) {
				System.out.println("ù��° ���� �Է��� ������ ��� ����~");
				sc.nextLine(); // ���۸� �����
			}
		}while(true);
		System.out.print("�ι�° ����?");
		try {
			j = sc.nextInt();
			System.out.println("i=" + i + ", j=" + j);
			System.out.println("i/j=" + (i/j) );
		}catch(InputMismatchException e) {
			System.out.println("�ι�° ���� �Է����� ������ 1�� �ʱ�ȭ");
		}catch(ArithmeticException e) {
			System.out.println("0���� ������ �н�~");
		}catch(Exception e) {
			System.out.println("��Ÿ ���ܴ� ���⼭ ���������� ó��"+e.getMessage());
		}
		System.out.println("i*j=" + (i*j) );
		System.out.println("i+j=" + (i+j) );
		System.out.println("i-j=" + (i-j) );
		System.out.println("DONE");
		sc.close();
	}
}
