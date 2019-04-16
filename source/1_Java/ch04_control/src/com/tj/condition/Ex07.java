package com.tj.condition;
// 0.0 <= Math.random() < 1
// 0.0 <= Math.random()*3 < 3
//난수(0,1,2중 임의의 수)발생 : (int)(Math.random()*3)
public class Ex07 {
	public static void main(String[] args) {
		int computer = (int)(Math.random()*3);
		if(computer==0) {
			System.out.println("컴퓨터는 가위냈네");
		}else if(computer==1) {
			System.out.println("컴퓨터는 바위냈네");
		}else if(computer==2){
			System.out.println("컴퓨터는 보자기 냈네");
		}
	}
}
