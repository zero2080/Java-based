package com.tj.ex2;
public class CustomerDto {
	private String ctel;	//����ȭ
	private String cname;	//���̸�
	private int cpoint;		//����Ʈ
	private int camount;	//�������ž�
	private String levelname;//������
	private int levelup;	//������ ������ ���� �� ��  
	public CustomerDto() { }
	public CustomerDto(String ctel, String cname, int cpoint, int camount, String levelname, int levelup) {
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
		this.camount = camount;
		this.levelname = levelname;
		this.levelup = levelup;
	}
	@Override
	public String toString() {
		String temp = ctel + "\t" + cname + "\t" + cpoint + "\t" 
				+ camount + "\t" + levelname + "\t" + levelup+"\n";
		return temp;
	}
	public void setCtel(String ctel) {this.ctel = ctel;}
	public void setCname(String cname) {this.cname = cname;}
	public void setCpoint(int cpoint) {this.cpoint = cpoint;}
	public void setCamount(int camount) {this.camount = camount;}
	public void setLevelname(String levelname) {this.levelname = levelname;}
	public void setLevelup(int levelup) {this.levelup = levelup;}
}
