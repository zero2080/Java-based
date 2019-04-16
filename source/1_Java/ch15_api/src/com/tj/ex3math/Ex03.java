package com.tj.ex3math;
import java.util.Random;
public class Ex03 {
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("int형 전체범위 난수 : "+random.nextInt());
		System.out.println("0~100까지의 정수 난수 :"+random.nextInt(101));
		System.out.println("0~20까지의 정수 난수 : "+random.nextInt(21));
		System.out.println("1~45까지의 정수 난수 : "+(random.nextInt(45)+1));
		System.out.println("float형 난수(0~1보다 작은) : "+random.nextFloat());
		System.out.println("double형 난수(0~1보다 작은): "+random.nextDouble());
		System.out.println("long형 난수 : "+random.nextLong());
		System.out.println("boolean형 난수 "+random.nextBoolean());
		// 로또번호 6개를 뽑아 배열방에 넣는다.
		byte[] lotto = new byte[6];  // x % 45 -44~44
		/*random.nextBytes(lotto); // -128~127까지의 byte형 난수를 배열방에 다 넣어
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
