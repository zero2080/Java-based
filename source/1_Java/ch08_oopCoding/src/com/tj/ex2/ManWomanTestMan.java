package com.tj.ex2;
import com.tj.ex2_man.*;//com.tj.ex2_man 패키지의 모든 클래스를 import
import com.tj.ex2_man.woman.Woman;
/* ★ com.tj.ex2_man 패키지에는 Man 클래스만 있음
 *    Woman 클래스는 다른 패키지임(com.tj.ex2_man.woman)
*/
public class ManWomanTestMan {
	public static void main(String[] args) {
		Man man1 = new Man();
		man1.setHeight(170); man1.setWeight(60);
		Man man2 = new Man(31);
		man2.setHeight(170); man2.setWeight(60);
		Man man3 = new Man(31,180, 70, "010-9999-9999");
		if(man1.equals(man2)) {
			System.out.println("man1과 man2는 같은 객체");
		}else {
			System.out.println("man1과 man2는 다른 객체");
		}
		double bmi = man1.calculateBMI();
		if(bmi>30) {
			System.out.println("man1 건강한 다이어트 추천해요");
		}else {
			System.out.println("man1 잘 사네요. 쭉 잘 사세요");
		}
		System.out.println("man2 : "+man2.state());
		System.out.println("man3 : "+man3.state());
		Woman woman = new Woman();
	}
}













