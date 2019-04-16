package com.tj.condition;
import java.util.Scanner;
// 가위(0), 바위(1), 보자기(2)
public class Ex06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("가위(0), 바위(1), 보(2) 중 하나를 내세요?");
		int me = scanner.nextInt();
		if(me==0) {
			System.out.println("가위 냈네");
		}else if(me==1) {
			System.out.println("바위 냈네");
		}else if(me==2){
			System.out.println("보 냈네");
		}else {
			System.out.println("유효하지 않는 걸 냈네");
		}//if
	}//main
}//class
