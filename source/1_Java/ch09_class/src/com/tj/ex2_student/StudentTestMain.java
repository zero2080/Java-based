package com.tj.ex2_student;
public class StudentTestMain {
	public static void main(String[] args) {
		Student[] students = {new Student("���켺", 90, 99, 99),
				new Student("���ϴ�", 80, 89, 89), 
				new Student("Ȳ����", 70, 89, 89), 
				new Student("������", 99, 89, 89), 
				new Student("������", 86, 89, 89)};
		int[] arr = {10,20,30};
		// �迭�� ����� �ʱ�ȭ�� ����.
		int[] arr1 = new int[3];
		arr1[0]=10; arr1[1] = 20 ; arr1[2]=30;
		Student[] st = new Student[5];
		st[0] = new Student("���켺", 90, 99, 99);
		st[1] = new Student("���ϴ�", 80, 89, 89);
		st[2] = new Student("Ȳ����", 70, 89, 89);
		st[3] = new Student("������", 99, 89, 89);
		st[4] = new Student("������", 86, 89, 89);		
		line('��', 50);
		System.out.println("      �� �� ǥ");
		line('-', 50);
		System.out.println("�̸�\t����\t����\t����\t����\t���");
		line('-',50);
		for(Student temp : students) {
			System.out.println(temp.infoString());
		}
		line('��', 50);
	}
	private static void line(char c, int cnt) {
		for(int i=1 ; i<=cnt ; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
}