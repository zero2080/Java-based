package com.tj.ex;
import java.util.Scanner;
// 배열을 이용하여 학생들(영희, 철수, 길동, 영수, 말자)의 키를 입력받고 평균치를 구해보자
public class Ex06 {
	public static void main(String[] args) {
		String[] arrName = {"영희","철수","길동","영수","말자"};
		int[]    arrHeight = new int[arrName.length];
		Scanner scanner = new Scanner(System.in);
		int totHeight = 0;
		for(int idx=0 ; idx<arrName.length ; idx++) {
			System.out.print(arrName[idx]+"의 키는? ");
			arrHeight[idx] = scanner.nextInt();
		}
		scanner.close();
		for(int idx=0 ; idx<arrHeight.length ; idx++) {
			totHeight += arrHeight[idx];
		}
		System.out.println("평균키는 "+totHeight/arrHeight.length);
	}
}








