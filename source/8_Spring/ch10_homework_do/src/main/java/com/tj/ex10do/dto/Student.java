package com.tj.ex10do.dto;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	public void calculate() {
		tot = kor + eng + mat;
		avg = tot/3.0;
		//avg = Math.round(tot/3.0*100)/100.0;
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getKor() {return kor;}
	public void setKor(int kor) {this.kor = kor;}
	public int getEng() {return eng;}
	public void setEng(int eng) {this.eng = eng;}
	public int getMat() {return mat;}
	public void setMat(int mat) {this.mat = mat;}
	public int getTot() {return tot;}
	public void setTot(int tot) {this.tot = tot;}
	public double getAvg() {return avg;}
	public void setAvg(double avg) {this.avg = avg;}
	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot=" + tot + ", avg="
				+ avg + "]";
	}
}
