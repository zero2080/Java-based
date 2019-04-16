package com.tj.today;
// 2680원 
public class Quiz06 {
	public static void main(String[] args) {
		int money = 2680;
		int[] coin = {500,100,50,10};
		for(int i=0 ; i<coin.length ; i++) {
			System.out.println(coin[i]+"원 짜리는 "+(money/coin[i])+"개 ");
			money = money % coin[i];
		}
	}
}
