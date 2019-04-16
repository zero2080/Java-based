package com.tj.ex02store;
public class Store2 extends HeadQuarterStore {
	private String name = "2È£Á¡";
	@Override
	public void kimchi() {System.out.println("±èÄ¡Âî°³ 6,000¿ø");}
	@Override
	public void bude() {System.out.println("ºÎ´ëÂî°³ 6,000¿ø");}
	@Override
	public void bibib() {System.out.println("ºñºö¹ä 5,000¿ø");	}
	@Override
	public void sunde() {System.out.println("¼ø´ë±¹ 6,000¿ø");	}
	@Override
	public void gonggibib() {System.out.println("°ø±â¹ä ¹«·á");}
	@Override
	public String getName() {
		return name;
	}
}
