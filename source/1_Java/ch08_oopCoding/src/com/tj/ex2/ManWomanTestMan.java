package com.tj.ex2;
import com.tj.ex2_man.*;//com.tj.ex2_man ��Ű���� ��� Ŭ������ import
import com.tj.ex2_man.woman.Woman;
/* �� com.tj.ex2_man ��Ű������ Man Ŭ������ ����
 *    Woman Ŭ������ �ٸ� ��Ű����(com.tj.ex2_man.woman)
*/
public class ManWomanTestMan {
	public static void main(String[] args) {
		Man man1 = new Man();
		man1.setHeight(170); man1.setWeight(60);
		Man man2 = new Man(31);
		man2.setHeight(170); man2.setWeight(60);
		Man man3 = new Man(31,180, 70, "010-9999-9999");
		if(man1.equals(man2)) {
			System.out.println("man1�� man2�� ���� ��ü");
		}else {
			System.out.println("man1�� man2�� �ٸ� ��ü");
		}
		double bmi = man1.calculateBMI();
		if(bmi>30) {
			System.out.println("man1 �ǰ��� ���̾�Ʈ ��õ�ؿ�");
		}else {
			System.out.println("man1 �� ��׿�. �� �� �缼��");
		}
		System.out.println("man2 : "+man2.state());
		System.out.println("man3 : "+man3.state());
		Woman woman = new Woman();
	}
}













