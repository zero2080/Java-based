package com.tj.ex09.dto;

public class Member {
	private String id;
	private String pw;
	public Member() {}
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	@Override
	public String toString() {
		return "아이디는 " + id + ", 비밀번호는 " + pw;
	}
}
