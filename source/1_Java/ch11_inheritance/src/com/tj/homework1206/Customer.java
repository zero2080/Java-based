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
		//sum = 0; ���ص� 0���� �ʱ�ȭ ����
		point = 1000;
		System.out.println("ȸ������ �����մϴ�. ������ �������� 1000 ����Ʈ �帳�ϴ�.");
	}
	public void changeTel(String tel) {
		System.out.println(name+"���� "+this.tel+" ����ó�� ����� �����Դϴ�");
		this.tel = tel;
		System.out.println(tel+"�� ����Ǿ����ϴ�");
	}
	public void buy(int amount) throws Exception { // customer.buy(10000)
		if(amount>=0) {
			sum += amount;
			int tempPoint = (int)(amount*0.1);
			point += tempPoint;
			System.out.print(name+"�� ���� �����մϴ�. �� ���� ����Ʈ :"+tempPoint);
			System.out.println(" �� ���� ����Ʈ : "+point);
		}else {
//			System.out.println("�̷� �̻��ϳ�");
			throw new Exception("�������� ���űݾ��̶�� ������");
		}
	}
	public String getName() {return name;}
	public String getTel() {return tel;}
	public int getSum() {return sum;}
	public int getPoint() {return point;}
}
