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
	//main에서 sysout(goods) => 새우깡(a01) : 1000원 - 재고10개
	@Override
	public String toString() {
		String result = goodsName+"("+goodsCode+") : "+goodsPrice;
		result += "원 - 재고 "+stockNum+"개";
		return result;
	}
}













