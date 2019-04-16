package com.tj.ex7construct_super;
public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person("¾Æºü°õ","¶×¶×ÇØ");
		papa.intro();
		Person mom = new Person("¾ö¸¶°õ","³¯¾ÀÇØ");
		mom.intro();
		Baby baby = new Baby();
		baby.setName("¾Æ±â°õ1");
		baby.setCharacter("±Í¿©¿ö");
		baby.intro();
		Baby baby2 = new Baby("¾Æ±â°õ2","³Ñ ±Í¿©¿ö");
		baby2.intro();
		baby2.cry();
		Person p = new Person("¾Æºü°õ", "¶×¶×ÇØ");
		if(p.equals(papa)) {
			System.out.println("°°Àº ¾Æºü³×. ÀÌ¸§¸¸ ´Ù¸£³×");
		}
	}
}




