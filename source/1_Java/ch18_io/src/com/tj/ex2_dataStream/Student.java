package com.tj.ex2_dataStream;
//"¿Ã¡ÿºÆ"(name) / 95.9(score) / 2(hak)
public class Student {
	private String name;
	private double score;
	private int hak;
	public Student() { }
	public Student(String name, double score, int hak) {
		this.name = name;
		this.score = score;
		this.hak = hak;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", hak=" + hak + "]";
	}
	public String getName() {return name;}
	public double getScore() {return score;}
	public int getHak() {return hak;}
}
