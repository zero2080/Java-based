package com.tj.loop;
// 2~9�ܱ��� ���
public class ForEx08 {
	public static void main(String[] args) {
		for(int i=1 ; i<=9 ; i++) {
			for(int dansu=2 ; dansu<=9 ; dansu++) {
				System.out.print(dansu+"*"+i+"="+(dansu*i)+"\t");
			}
			System.out.println();//����
		}//for-i
	}//main
}//class
