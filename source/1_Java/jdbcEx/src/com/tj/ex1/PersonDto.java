package com.tj.ex1;
public class PersonDto {
	private int rank;
	private String nameid;
	private String jname;
	private int kor;
	private int eng;
	private int mat;
	private int sum;
	public PersonDto(int rank, String nameid, String jname, int kor, int eng, int mat, int sum) {
		this.rank = rank;
		this.nameid = nameid;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = sum;
	}
	@Override
	public String toString() {
		String result = rank+"µî\t"+nameid+"\t"+jname+"\t"+
				kor+"\t"+eng+"\t"+mat+"\t"+sum;
		return result;
	}
}









