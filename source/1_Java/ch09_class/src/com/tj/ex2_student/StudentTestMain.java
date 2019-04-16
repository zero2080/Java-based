package com.tj.ex2_student;
public class StudentTestMain {
	public static void main(String[] args) {
		Student[] students = {new Student("정우성", 90, 99, 99),
				new Student("김하늘", 80, 89, 89), 
				new Student("황정민", 70, 89, 89), 
				new Student("강동원", 99, 89, 89), 
				new Student("유아인", 86, 89, 89)};
		int[] arr = {10,20,30};
		// 배열의 선언과 초기화를 따로.
		int[] arr1 = new int[3];
		arr1[0]=10; arr1[1] = 20 ; arr1[2]=30;
		Student[] st = new Student[5];
		st[0] = new Student("정우성", 90, 99, 99);
		st[1] = new Student("김하늘", 80, 89, 89);
		st[2] = new Student("황정민", 70, 89, 89);
		st[3] = new Student("강동원", 99, 89, 89);
		st[4] = new Student("유아인", 86, 89, 89);		
		line('■', 50);
		System.out.println("      성 적 표");
		line('-', 50);
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		line('-',50);
		for(Student temp : students) {
			System.out.println(temp.infoString());
		}
		line('■', 50);
	}
	private static void line(char c, int cnt) {
		for(int i=1 ; i<=cnt ; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
}