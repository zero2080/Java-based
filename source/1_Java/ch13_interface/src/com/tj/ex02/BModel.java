package com.tj.ex02;
//b��ǰ : DMB�ۼ��Ű���, LTE, TV������ ž��,
public class BModel implements IAcor {
	private String model = "B��";
	@Override
	public void dmbReceive() {
		System.out.println(model+"�� DMB �ۼ��� ����");
	}
	@Override
	public void lte() {
		System.out.println(model+"�� LTE ��");
	}
	@Override
	public void tvremoteControl() {
		System.out.println(model+"�� TV������ ž��");
	}
}