package com.tj.condition;
// 0.0 <= Math.random() < 1
// 0.0 <= Math.random()*3 < 3
//����(0,1,2�� ������ ��)�߻� : (int)(Math.random()*3)
public class Ex07 {
	public static void main(String[] args) {
		int computer = (int)(Math.random()*3);
		if(computer==0) {
			System.out.println("��ǻ�ʹ� �����³�");
		}else if(computer==1) {
			System.out.println("��ǻ�ʹ� �����³�");
		}else if(computer==2){
			System.out.println("��ǻ�ʹ� ���ڱ� �³�");
		}
	}
}
