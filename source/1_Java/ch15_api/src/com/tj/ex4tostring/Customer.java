package com.tj.ex4tostring;

public class Customer {
	private String phone;
	private String name;
	private int sum;	// �����ݾ�
	private int point;	// ����Ʈ
	public Customer(String phone, String name) {
		this.phone = phone;
		this.name = name;
		point = 1000;
	}
	// sysout(customer) => ȫ�浿(9999)�� ����Ʈ : 6000
	@Override
	public String toString() {
		String result = name +"("
				+ phone.substring(phone.lastIndexOf('-')+1)
				+") �� ����Ʈ :" + point;		
		return result;
	}
}











