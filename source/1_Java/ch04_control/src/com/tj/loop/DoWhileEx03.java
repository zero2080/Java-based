package com.tj.loop;
import java.util.Scanner;
// ��ǻ�Ͱ� 1~45 ������ ������ �߻��ϰ� �� ���� �˾Ƹ��߱�
public class DoWhileEx03 {
	public static void main(String[] args) {
		int lotto = (int)(Math.random()*45)+1;
		int su;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("�ζ� ��ȣ �ϳ��� ����� : ");
			su = scanner.nextInt();
			if(su==lotto) {
				System.out.println("�����մϴ�. ������ϴ�");
			}else if(su>lotto) {
				System.out.println(su+"���� ���� ������ �ٽ� ã�ƺ�");
			}else if(su<lotto) {
				System.out.println(su+"���� ū ������ �ٽ� ã�ƺ�");
			}
		}while(su!=lotto);
	}
}
