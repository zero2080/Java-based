package com.tj.ex3math;
import java.util.Random;
public class Ex03 {
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("int�� ��ü���� ���� : "+random.nextInt());
		System.out.println("0~100������ ���� ���� :"+random.nextInt(101));
		System.out.println("0~20������ ���� ���� : "+random.nextInt(21));
		System.out.println("1~45������ ���� ���� : "+(random.nextInt(45)+1));
		System.out.println("float�� ����(0~1���� ����) : "+random.nextFloat());
		System.out.println("double�� ����(0~1���� ����): "+random.nextDouble());
		System.out.println("long�� ���� : "+random.nextLong());
		System.out.println("boolean�� ���� "+random.nextBoolean());
		// �ζǹ�ȣ 6���� �̾� �迭�濡 �ִ´�.
		byte[] lotto = new byte[6];  // x % 45 -44~44
		/*random.nextBytes(lotto); // -128~127������ byte�� ������ �迭�濡 �� �־�
		for(int i=0 ; i<lotto.length ; i++) {
			lotto[i] = (byte)(Math.abs(lotto[i]%45)+1);
		}*/
		for(int i=0 ; i<lotto.length ; i++) {
			byte temp, j;
			do {
				temp = (byte) (random.nextInt(45)+1);
				for(j=0 ; j<i ; j++) {
					if(lotto[j]==temp) {
						break;
					}
				}
				if(i==j) {
					lotto[i]=temp;
				}
			}while(i!=j);
		}
		for(byte l : lotto) {
			System.out.print(l+"   ");
		}
	}
}
