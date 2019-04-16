package com.tj.ex04actor;
// 다형성 예제
public class ActorTestMain {
	public static void main(String[] args) {
		Actor park = new Actor("박보검");
		park.makePizza();
		park.makeSpaghetti();
		park.canCatchCriminal();
		park.canSearch();
		park.outFire();
		park.saveMan();
		Policeman parkPol = park;
		parkPol.canCatchCriminal();
		parkPol.canSearch();
		FireFighter parkF = park;
		parkF.outFire();
		parkF.saveMan();
		Chef parkChef = park;
		parkChef.makePizza();
		parkChef.makeSpaghetti();
	}
}
