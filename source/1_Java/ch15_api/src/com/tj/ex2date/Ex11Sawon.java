package com.tj.ex2date;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Ex11Sawon {
	private String sabun;
	private String name;
	private String part;
	private Date enterDate;
	public Ex11Sawon(String sabun, String name, String part) {
		this.sabun = sabun;
		this.name  = name;
		this.part  = part;
		enterDate = new Date();
	}
	public String infoString() {
		String result = "���:"+sabun+", �̸�:"+name+", �μ�:"+part;
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		result += ", �Ի���:"+sdf.format(enterDate);
		return result;
	}
}
