package com.tj.ex7construct;
public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person("�ƺ���","�׶���");
		papa.intro();
		Person mom = new Person("������","������");
		mom.intro();
		Baby baby = new Baby();
		baby.setName("�Ʊ��1");
		baby.setCharacter("�Ϳ���");
		baby.intro();
		Baby baby2 = new Baby("�Ʊ��2","�� �Ϳ���");
		baby2.intro();
		baby2.cry();
	}
}




