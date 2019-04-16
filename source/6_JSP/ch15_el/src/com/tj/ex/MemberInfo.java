package com.tj.ex;
// el표기법이나 bean태그 사용시 : 매개변수 없는 생성, setters&getters
public class MemberInfo {
	private String name;
	private String id;
	private String pw;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}
