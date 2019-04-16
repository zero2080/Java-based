package com.tj.condition;
import java.util.Scanner;
// 입력받은 점수의 학점을 출력
public class Ex09Switch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("점수는 ");
		int score = scanner.nextInt();
		int tempScore = (score==100)? score-1 : score;
		switch(tempScore/10) {
			case 9 : System.out.println("A학점");break;
			case 8 : System.out.println("B학점");break;
			case 7 : System.out.println("C학점");break;
			case 6 : System.out.println("D학점");break;
			case 5 : case 4: case 3: case 2: case 1: case 0:
				System.out.println("F학점");break;
			default: System.out.println("유효한 점수가 아닙니다");
		}
	}
}
