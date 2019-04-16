package com.tj.homework;

public class EnvInfo {
	private String ipNum;
	private String portNum;
	private String userId;
	private String userPw;
	public void setIpNum(String ipNum) {
		this.ipNum = ipNum;
	}
	public void setPortNum(String portNum) {
		this.portNum = portNum;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	@Override
	public String toString() {
		return " ipNum =" + ipNum + "\n portNum=" + portNum 
				+ "\n userId=" + userId + "\n userPw=" + userPw;
	}
}
