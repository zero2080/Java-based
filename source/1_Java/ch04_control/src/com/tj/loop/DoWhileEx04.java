package com.tj.loop;
import java.util.Scanner;
// ��ǻ�Ͱ� 1~45 ������ ������ �߻��ϰ� ������ �ٿ����鼭 ���� ���߱�
public class DoWhileEx04 {
	public static void main(String[] args) {
		int lotto = (int)(Math.random()*45)+1;
		int su;
		int min=1, max=45;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print(min+"����"+max+"������ �ζ� ��ȣ �ϳ��� ����� : ");
			su = scanner.nextInt();
			if(su==lotto) {
				System.out.println("�����մϴ�. ������ϴ�");
			}else if(su>lotto) {
				System.out.println(su+"���� ���� ������ �ٽ� ã�ƺ�");
				max = su-1;
			}else if(su<lotto) {
				System.out.println(su+"���� ū ������ �ٽ� ã�ƺ�");
				min = su+1;
			}
		}while(su!=lotto);
	}
}
