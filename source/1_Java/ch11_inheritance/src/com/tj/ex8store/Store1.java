package com.tj.ex8store;
/*���� ��ħ       : ��ġ�-5,000  �δ��-6,000  �����-6,000 ���뱹-5,000  �����-1,000��
���ð��� ����1ȣ��: ��ġ�-4,500  �δ��-5,000  �����-6,000 ���뱹-���Ⱦ�    �����-1,000��*/
public class Store1 extends HeadQuarterStore{
	@Override
	public void kimchi() {
		System.out.println("��ġ� 4,500��");
	}
	@Override
	public void bude() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹�� �� �Ⱦƿ�");
	}
}
