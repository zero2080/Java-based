package com.tj.condition;
import java.util.Scanner;
// ��, ��, �� ������ �Է¹޾� �� ���� ����̻����� �������� ���
public class Ex05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor, eng, mat; double avg;
		System.out.print("���������� ?");
		kor = sc.nextInt();
		System.out.print("���������� ?");
		eng = sc.nextInt();
		System.out.print("���������� ?");
		mat = sc.nextInt();
		avg = (kor+eng+mat) / 3.0 ;
		if(kor>=avg) {
			System.out.printf("��� ���(%.2f)�̻��Դϴ�", avg);
		}else {
			System.out.printf("��� ���(%.2f)�̸��Դϴ�", avg);
		}
		if(eng>=avg) {
			System.out.printf("��� ���(%.2f)�̻��Դϴ�", avg);
		}else {
			System.out.printf("��� ���(%.2f)�̸��Դϴ�", avg);
		}
		if(mat>=avg) {
			System.out.printf("������ ���(%.2f)�̻��Դϴ�", avg);
		}else {
			System.out.printf("������ ���(%.2f)�̸��Դϴ�", avg);
		}
	}
}
