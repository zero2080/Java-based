package com.tj.condition;
public class Ex01 {
	public static void main(String[] args) {
		int seoulLunchPrice = 4000;
		if(seoulLunchPrice>=7000) {
			System.out.println("���� ���ɰ� ��γ׿�");
		}else if(seoulLunchPrice>=6000){
			System.out.println("���� ���ɰ� �ɱ� �� ����������");
		}else if(seoulLunchPrice>=5000){
			System.out.println("����");
		}else {
			System.out.println("�Ĵ� ���� ���ϴ°� �ƴϾ�");
		}
		System.out.println("DONE");
	}//main
}//class
