package com.tj.homework1206;

public class Main {
	public static void main(String[] args) {
		Customer customer = new Customer("홍길동", "010-9999-9999");
		VVIP vvip = new VVIP("왕부자","010-8888-8888","10-10");
		customer.changeTel("010-1111-1111");
		try {
			customer.buy(-1000);
		} catch (Exception e) {
			System.out.println("때끼 이상해");
		}
		vvip.changeTel("010-7777-7777");
		try {
			vvip.buy(10000);
		} catch (Exception e) {
			System.out.println("때끼 이상해. 사장한테 쪽지보낼까보다");
		}
		System.out.println(customer.getName()+"님의 누적 구매액은 "+customer.getSum()+", 포인트는 "+customer.getPoint());
		System.out.println(vvip.getName()+"님의 누적 구매액은 "+vvip.getSum()+", 포인트는 "+vvip.getPoint());
		vvip.sendMsg();
	}
}
