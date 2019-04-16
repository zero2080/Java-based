package com.tj.ex10form.dto;
public class MemberInfo {
	private String name;
	private String id;
	private String pw;
	private int age;
	private String email;
	private String address;
	public MemberInfo() { }
	public MemberInfo(String name, String id, String pw, int age, String email, String address) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.email = email;
		this.address = address;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {return name;}
	public String getId() {return id;}
	public String getPw() {return pw;}
	public int getAge() {return age;}
	public String getEmail() {return email;	}
	public String getAddress() {return address;}
	@Override
	public String toString() {
		return "MemberInfo [name=" + name + ", id=" + id + ", pw=" + pw + ", age=" + age + ", email=" + email
				+ ", address=" + address + "]";
	}
}
