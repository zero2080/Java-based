package com.tj.loop;
import java.util.Scanner;
// 컴퓨터가 1~45 사이의 난수를 발생하고 범위를 줄여가면서 난수 맞추기
public class DoWhileEx04 {
	public static void main(String[] args) {
		int lotto = (int)(Math.random()*45)+1;
		int su;
		int min=1, max=45;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print(min+"부터"+max+"사이의 로또 번호 하나를 맞춰봐 : ");
			su = scanner.nextInt();
			if(su==lotto) {
				System.out.println("축하합니다. 맞췄습니다");
			}else if(su>lotto) {
				System.out.println(su+"보다 작은 수에서 다시 찾아봐");
				max = su-1;
			}else if(su<lotto) {
				System.out.println(su+"보다 큰 수에서 다시 찾아봐");
				min = su+1;
			}
		}while(su!=lotto);
	}
}
