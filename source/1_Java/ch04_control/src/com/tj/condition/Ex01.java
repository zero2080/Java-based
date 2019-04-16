package com.tj.condition;
public class Ex01 {
	public static void main(String[] args) {
		int seoulLunchPrice = 4000;
		if(seoulLunchPrice>=7000) {
			System.out.println("서울 점심값 비싸네요");
		}else if(seoulLunchPrice>=6000){
			System.out.println("서울 점심값 쪼금 더 저렴했으면");
		}else if(seoulLunchPrice>=5000){
			System.out.println("좋네");
		}else {
			System.out.println("식당 주인 망하는거 아니야");
		}
		System.out.println("DONE");
	}//main
}//class
