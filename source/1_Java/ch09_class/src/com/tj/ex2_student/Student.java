package com.tj.ex2_student;
//�̸�	����	����	����	����	���
public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	// main���� Student jung = new Student("���켺",90,90,99);
	public Student() {} //����Ʈ ������
	public Student(String name, int kor, int eng, int mat) { // ������ �Լ��� �����ε�
		this.name = name; this.kor = kor; this.eng = eng; this.mat = mat;
		tot = kor+eng+mat;
		avg = tot/3.0;
	}
	// main���� System.out.println(jung.infoString());
	public String infoString() { // "���켺   90   90  90  270  90.0"
		//String result = name +"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+avg;
		return String.format("%s\t%d\t%d\t%d\t%d\t%5.1f", 
				name, kor, eng, mat, tot, avg);
	}
	// main���� jung.print();
	public void print() {
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%5.1f\n", 
				name, kor, eng, mat, tot, avg);
	}
	public void setName(String name) {this.name = name;}
	public void setKor(int kor) {this.kor = kor;}
	public void setEng(int eng) {this.eng = eng;}
	public void setMat(int mat) {this.mat = mat;}
	public void setTot(int tot) {this.tot = tot;}
	public void setAvg(double avg) {this.avg = avg;}
}













