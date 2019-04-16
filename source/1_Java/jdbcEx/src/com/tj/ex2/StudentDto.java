package com.tj.ex2;
public class StudentDto {
	private String sNo;
	private String sName;
	private int mNo;
	private int score;
	private String sExpel;
	private String mName;
	public StudentDto() {}
	public StudentDto(String sNo, String sName, int mNo, int score, 
												int sExpel, String mName) {
		this.sNo = sNo;
		this.sName = sName;
		this.mNo = mNo;
		this.score = score;
		if(sExpel==0) {
			this.sExpel = "학생";
		}else {
			this.sExpel = "제적자";
		}
		this.mName = mName;
	}
	@Override
	public String toString() {
		return "\t" + sNo + "\t" + sName + "\t" + mName + "(" +mNo+")\t"+ score 
				+ "\t"+ sExpel +"\n";
	}
	public void setsNo(String sNo) {this.sNo = sNo;	}
	public void setsName(String sName) {this.sName = sName;}
	public void setmNo(int mNo) {this.mNo = mNo;}
	public void setScore(int score) {this.score = score;}
	public void setsExpel(String sExpel) {this.sExpel = sExpel;}
	public void setmName(String mName) {this.mName = mName;}
}