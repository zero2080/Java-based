package com.tj.ex1list;
//name, phone, address
public class Customer {
	private String name;
	private String phone;
	private String address;
	public Customer() {}
	public Customer(String name, String phone, String address) {
		this.name = name; this.phone= phone; this.address = address;
	}
	public void setName(String name) {this.name = name;}
	public void setPhone(String phone) {this.phone = phone;}
	public void setAddress(String address) {this.address = address;}
	@Override
	public String toString() {
		return name + "   "+phone+"   "+address;
	}
}
