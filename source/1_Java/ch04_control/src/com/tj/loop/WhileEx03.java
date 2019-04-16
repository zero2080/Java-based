package com.tj.loop;
import java.util.Scanner;
/* 컴퓨터와 가위바위보 게임을 무한반복하는 게임을 작성하시오.
  (단, 가위대신 0, 바위대신 1, 보대신 2, 종료를 원하면 -1을 입력합니다) */
public class WhileEx03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int me, computer;
		while(true) {
			System.out.println("가위(0), 바위(1), 보(2) 중 하나 선택(단, 종료는-1) : ");
			me = sc.nextInt();
			if(me==-1) break;
			computer = (int)(Math.random()*3);
			if(me>2 || me<0) {
				System.out.println("제대로 내");
			}else if((me +2 )%3 == computer) { // me가 이길 경우
				printResult(me, computer);
				System.out.println("me가 이겼다");
			}else if((me+1)%3 == computer ) {// computer가 이길 경우
				printResult(me, computer);
				System.out.println("computer가 이겼다");
			}else if(me==computer) {//비길 경우 
				printResult(me, computer);
				System.out.println("비겼다");
			}//if
		}//while
	}//main
	private static void printResult(int me, int computer) {
		System.out.println("나는 "+(me==0? "가위": me==1? "바위":"보"));
		System.out.println("컴은 "+(computer==0? "가위": computer==1? "바위":"보"));
	}//printResult
}







