package com.tj.ex4tostring;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Sawon {
	private String num; //사번
	private String name;//이름
	private String part;//부서
	private Date enterDate;//입사일
	//main함수에서 Sawon sawon = new Sawon("a01","홍","전산실");
	public Sawon(String num, String name, String part) {
		this.num = num; this.name = name; this.part = part;
		enterDate = new Date();
	}
	public void print() {
		System.out.print("num:"+num+",name:"+name+",part:"+part+", enterDate:");
		SimpleDateFormat sdf = new SimpleDateFormat("yy년MM월dd일(E)");
		System.out.println(sdf.format(enterDate));
	}
	public String infoString() {
		String result = "num:"+num+",name:"+name+",part:"+part+", enterDate:";
		SimpleDateFormat sdf = new SimpleDateFormat("yy년MM월dd일(E)");
		result = result + sdf.format(enterDate);
		return result;
	}
	@Override
	public String toString() {
		String result = "num:"+num+",name:"+name+",part:"+part+", enterDate:";
		SimpleDateFormat sdf = new SimpleDateFormat("yy년MM월dd일(E)");
		result = result + sdf.format(enterDate);
		return result;
	}
}










