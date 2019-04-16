package com.tj.ex.dto;

public class ProductDto {
	private int pNo;
	private String pName;
	private int pStock;
	public ProductDto(int pNo, String pName, int pStock) {
		this.pNo = pNo;
		this.pName = pName;
		this.pStock = pStock;
	}
	public int getpNo() {
		return pNo;
	}
	public String getpName() {
		return pName;
	}
	public int getpStock() {
		return pStock;
	}
	@Override
	public String toString() {
		return "ProductDto [pNo=" + pNo + ", pName=" + pName + ", pStock=" + pStock + "]";
	}
}
