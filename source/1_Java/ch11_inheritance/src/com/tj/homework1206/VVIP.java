package com.tj.homework1206;

public class VVIP extends Customer{
	private String birth;
	public VVIP(String name, String tel, String birth) {
		super(name, tel);
		this.birth = birth;
	}
	public void sendMsg() {
		System.out.println(getName()+"¥‘ ±‚≥‰¿œ("+birth+")√‡«œµÂ∑¡ø‰ ¢æ");
	}
}
