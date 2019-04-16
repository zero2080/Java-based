package com.tj.ex02store;
public class Store3 extends HeadQuarterStore{
	private String name="3È£Á¡";
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ 6,000¿ø");
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ 7,000¿ø");
	}
	@Override
	public void bibib() {
		System.out.println("ºñºö¹ä 6,000¿ø");
	}
	@Override
	public void sunde() {
		System.out.println("¼ø´ë±¹ 5,000¿ø");
	}
	@Override
	public void gonggibib() {
		System.out.println("°ø±â¹ä 1,000¿ø");
	}
	@Override
	public String getName() {
		return name;
	}

}
