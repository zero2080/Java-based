package com.tj.ex02store;
public class Store2 extends HeadQuarterStore {
	private String name = "2ȣ��";
	@Override
	public void kimchi() {System.out.println("��ġ� 6,000��");}
	@Override
	public void bude() {System.out.println("�δ�� 6,000��");}
	@Override
	public void bibib() {System.out.println("����� 5,000��");	}
	@Override
	public void sunde() {System.out.println("���뱹 6,000��");	}
	@Override
	public void gonggibib() {System.out.println("����� ����");}
	@Override
	public String getName() {
		return name;
	}
}
