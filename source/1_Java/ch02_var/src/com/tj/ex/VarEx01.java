package com.tj.ex;

public class VarEx01 {
	public static void main(String[] args) {
		// JVM�� �����ϴ� ���α׷� ���� �κ�
		// ������Ÿ�� ������ = �ʱⰪ
		int age = 23;		// ������ ����
		String name = "����"; // ���ڿ� ����
		System.out.println("�ȳ��ϼ���? "+age+"�� "+name+"�Դϴ�");
		System.out.println("�ȳ��ϼ���? "+age+"�� "+name+"�Դϴ�");
		System.out.println("�ȳ��ϼ���? "+age+"�� "+name+"�Դϴ�");
		System.out.println("�ȳ��ϼ���? "+age+"�� "+name+"�Դϴ�");
		System.out.println("�ȳ��ϼ���? "+age+"�� "+name+"�Դϴ�");
		age = 47;
		name = "�嵿��";
		System.out.println("�ȳ��ϼ���? "+age+"�� "+name+"�Դϴ�");
		System.out.println("�ȳ��ϼ���? "+age+"�� "+name+"�Դϴ�");
		// JVM�� ������ ������ ���α׷� �� �κ�
	}
}