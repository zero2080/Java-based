package com.tj.ex02store;
public class Store3 extends HeadQuarterStore{
	private String name="3ȣ��";
	@Override
	public void kimchi() {
		System.out.println("��ġ� 6,000��");
	}
	@Override
	public void bude() {
		System.out.println("�δ�� 7,000��");
	}
	@Override
	public void bibib() {
		System.out.println("����� 6,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹 5,000��");
	}
	@Override
	public void gonggibib() {
		System.out.println("����� 1,000��");
	}
	@Override
	public String getName() {
		return name;
	}

}
