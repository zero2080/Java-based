package com.tj.homework1206;

public class Main {
	public static void main(String[] args) {
		Customer customer = new Customer("ȫ�浿", "010-9999-9999");
		VVIP vvip = new VVIP("�պ���","010-8888-8888","10-10");
		customer.changeTel("010-1111-1111");
		try {
			customer.buy(-1000);
		} catch (Exception e) {
			System.out.println("���� �̻���");
		}
		vvip.changeTel("010-7777-7777");
		try {
			vvip.buy(10000);
		} catch (Exception e) {
			System.out.println("���� �̻���. �������� �����������");
		}
		System.out.println(customer.getName()+"���� ���� ���ž��� "+customer.getSum()+", ����Ʈ�� "+customer.getPoint());
		System.out.println(vvip.getName()+"���� ���� ���ž��� "+vvip.getSum()+", ����Ʈ�� "+vvip.getPoint());
		vvip.sendMsg();
	}
}
