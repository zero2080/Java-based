package com.tj.condition;
// 컴퓨터가 발생한 난수 점수와 학점 출력
public class Ex11 {
	public static void main(String[] args) {
		//0 <= Math.random()*101 < 101
		int score = (int)(Math.random()*101);
		char grade;
		switch(score/10) {
			case 9:grade = 'A';break;
			case 8:grade = 'B';break;
			case 7:grade = 'C';break;
			case 6:grade = 'D';break;
			default: 
				grade = 'F';break;
		}
		System.out.println("난수 점수는 "+score+", 학점은 "+grade);
	}
}
