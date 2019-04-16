package com.tj.ex3;

public class ServerInfo {
	private String ipNum;
	private String portNum;
	public void setIpNum(String ipNum) {
		this.ipNum = ipNum;
	}
	public void setPortNum(String portNum) {
		this.portNum = portNum;
	}
	@Override
	public String toString() {
		return "[ipNum=" + ipNum + ", portNum=" + portNum + "]";
	}
}
