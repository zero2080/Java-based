package com.tj.method1;

public class Family {
	private String papaName;
	private String mamiName;
	private String sisterName;
	private String brotherName;
	public Family(String papaName, String mamiName) {
		this.papaName = papaName;
		this.mamiName = mamiName;
	}
	public void setSisterName(String sisterName) {
		this.sisterName = sisterName;
	}
	public void setBrotherName(String brotherName) {
		this.brotherName = brotherName;
	}
	@Override
	public String toString() {
		return "아빠=" + papaName + ", 엄마=" + mamiName 
				+ ", 딸=" + sisterName
				+ ", 아들=" + brotherName;
	}
}
