package com.tj.ex4tostring;

public class Goods {
	private String goodsCode;
	private String goodsName;
	private int goodsPrice;
	private int stockNum;
	public Goods(String goodsCode, String goodsName,
			int goodsPrice, int stockNum) {
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.stockNum = stockNum;
	}
	//main���� sysout(goods) => �����(a01) : 1000�� - ���10��
	@Override
	public String toString() {
		String result = goodsName+"("+goodsCode+") : "+goodsPrice;
		result += "�� - ��� "+stockNum+"��";
		return result;
	}
}













