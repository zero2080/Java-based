package com.tj.today;
// 2680�� 
public class Quiz06 {
	public static void main(String[] args) {
		int money = 2680;
		int[] coin = {500,100,50,10};
		for(int i=0 ; i<coin.length ; i++) {
			System.out.println(coin[i]+"�� ¥���� "+(money/coin[i])+"�� ");
			money = money % coin[i];
		}
	}
}
