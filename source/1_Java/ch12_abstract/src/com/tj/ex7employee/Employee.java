package com.tj.ex7employee;
//name, computePay(),computeIncentive()
// main에서 SalaryEmployee kim = new SalaryEmployee("홍길동",2400);
public abstract class Employee {
	private String name;
	public Employee() {}
	public Employee(String name) {
		this.name = name;
	}
	public abstract int computePay(); // 월급을 return하는 추상 메소드
	public final int computeIncentive() {
		int temp = computePay();
		if(temp>2000000)
			return (int)((temp-2000000)*0.1);
		return 0;
	}
	public String getName() {return name;}
}
