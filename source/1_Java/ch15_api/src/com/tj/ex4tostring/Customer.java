package com.tj.ex4tostring;

public class Customer {
	private String phone;
	private String name;
	private int sum;	// 누적금액
	private int point;	// 포인트
	public Customer(String phone, String name) {
		this.phone = phone;
		this.name = name;
		point = 1000;
	}
	// sysout(customer) => 홍길동(9999)님 포인트 : 6000
	@Override
	public String toString() {
		String result = name +"("
				+ phone.substring(phone.lastIndexOf('-')+1)
				+") 님 포인트 :" + point;		
		return result;
	}
}











