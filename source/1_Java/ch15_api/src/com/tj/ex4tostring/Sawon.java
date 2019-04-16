package com.tj.ex4tostring;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Sawon {
	private String num; //���
	private String name;//�̸�
	private String part;//�μ�
	private Date enterDate;//�Ի���
	//main�Լ����� Sawon sawon = new Sawon("a01","ȫ","�����");
	public Sawon(String num, String name, String part) {
		this.num = num; this.name = name; this.part = part;
		enterDate = new Date();
	}
	public void print() {
		System.out.print("num:"+num+",name:"+name+",part:"+part+", enterDate:");
		SimpleDateFormat sdf = new SimpleDateFormat("yy��MM��dd��(E)");
		System.out.println(sdf.format(enterDate));
	}
	public String infoString() {
		String result = "num:"+num+",name:"+name+",part:"+part+", enterDate:";
		SimpleDateFormat sdf = new SimpleDateFormat("yy��MM��dd��(E)");
		result = result + sdf.format(enterDate);
		return result;
	}
	@Override
	public String toString() {
		String result = "num:"+num+",name:"+name+",part:"+part+", enterDate:";
		SimpleDateFormat sdf = new SimpleDateFormat("yy��MM��dd��(E)");
		result = result + sdf.format(enterDate);
		return result;
	}
}










