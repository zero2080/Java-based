package com.tj.condition;
import java.util.Scanner;
/*(me +2 )%3 == computer일 경우, me가 이김
(me+1)%3 == computer 일 경우, computer가 이김*/
public class Ex08 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("가위(0), 바위(1), 보(2) 중 하나 선택?");
		int me = scanner.nextInt();  // 정수
		int computer = (int)(Math.random()*3); // 0,1,2
		if((me+2)%3 == computer) {
			System.out.println("난"+(me==0? "가위, ":
									(me==1)? "바위, ":"보, "));
			System.out.println("컴퓨터는 "+(computer==0? "가위 ":
				(computer==1)? "바위 ":"보 "));
			System.out.println("= 내가 이겼다");
		}else if((me+1)%3 == computer) {
			System.out.println("난"+(me==0? "가위, ":
				(me==1)? "바위, ":"보, "));
			System.out.println("컴퓨터는 "+(computer==0? "가위 ":
				(computer==1)? "바위 ":"보 "));
			System.out.println("= 컴퓨터가 이겼다");
		}else if(me==computer){
			System.out.println("난"+(me==0? "가위, ":
				(me==1)? "바위, ":"보, "));
			System.out.println("컴퓨터는 "+(computer==0? "가위 ":
				(computer==1)? "바위 ":"보 "));
			System.out.println("비겼다");
		}else {
			System.out.println("잘못 냈네");
		}//if
	}//main
}//class
