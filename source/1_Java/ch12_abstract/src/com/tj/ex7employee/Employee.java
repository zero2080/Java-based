package com.tj.ex7employee;
//name, computePay(),computeIncentive()
// main���� SalaryEmployee kim = new SalaryEmployee("ȫ�浿",2400);
public abstract class Employee {
	private String name;
	public Employee() {}
	public Employee(String name) {
		this.name = name;
	}
	public abstract int computePay(); // ������ return�ϴ� �߻� �޼ҵ�
	public final int computeIncentive() {
		int temp = computePay();
		if(temp>2000000)
			return (int)((temp-2000000)*0.1);
		return 0;
	}
	public String getName() {return name;}
}
