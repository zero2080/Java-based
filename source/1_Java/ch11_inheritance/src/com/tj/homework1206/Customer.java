package com.tj.homework1206;
public class Customer {
	private String name;
	private String tel;
	private int sum;
	private int point;
	public Customer() {}
	public Customer(String name, String tel) {
		this.name = name;
		this.tel = tel;
		//sum = 0; 안해도 0으로 초기화 되지
		point = 1000;
		System.out.println("회원가입 감사합니다. 감사의 마음으로 1000 포인트 드립니다.");
	}
	public void changeTel(String tel) {
		System.out.println(name+"님의 "+this.tel+" 연락처가 변경될 예정입니다");
		this.tel = tel;
		System.out.println(tel+"로 변경되었습니다");
	}
	public void buy(int amount) throws Exception { // customer.buy(10000)
		if(amount>=0) {
			sum += amount;
			int tempPoint = (int)(amount*0.1);
			point += tempPoint;
			System.out.print(name+"님 구매 감사합니다. 본 구매 포인트 :"+tempPoint);
			System.out.println(" 총 누적 포인트 : "+point);
		}else {
//			System.out.println("이런 이상하네");
			throw new Exception("음수값이 구매금액이라니 수상해");
		}
	}
	public String getName() {return name;}
	public String getTel() {return tel;}
	public int getSum() {return sum;}
	public int getPoint() {return point;}
}
