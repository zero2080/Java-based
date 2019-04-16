package com.tj.condition;
import java.util.Scanner;
// 입력받은 점수의 학점을 출력
public class Ex09 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		if(score<=100 && score>=90) {
			System.out.println("A학점");
		}else if(score<90 && score>=80) {
			System.out.println("B학점");
		}else if(score<80 && score>=70) {
			System.out.println("C학점");
		}else if(score<70 && score>=60) {
			System.out.println("D학점");
		}else if(score<60 && score>=0){
			System.out.println("F학점");
		}else {
			System.out.println("유효한 점수가 아닙니다");
		}
	}
}
