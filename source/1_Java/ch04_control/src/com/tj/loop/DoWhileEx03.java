package com.tj.loop;
import java.util.Scanner;
// 컴퓨터가 1~45 사이의 난수를 발생하고 그 난수 알아맞추기
public class DoWhileEx03 {
	public static void main(String[] args) {
		int lotto = (int)(Math.random()*45)+1;
		int su;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("로또 번호 하나를 맞춰봐 : ");
			su = scanner.nextInt();
			if(su==lotto) {
				System.out.println("축하합니다. 맞췄습니다");
			}else if(su>lotto) {
				System.out.println(su+"보다 작은 수에서 다시 찾아봐");
			}else if(su<lotto) {
				System.out.println(su+"보다 큰 수에서 다시 찾아봐");
			}
		}while(su!=lotto);
	}
}
