package com.tj.ex04actor;
// ������ ����
public class ActorTestMain {
	public static void main(String[] args) {
		Actor park = new Actor("�ں���");
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
