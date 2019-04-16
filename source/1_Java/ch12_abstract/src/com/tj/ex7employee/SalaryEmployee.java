package com.tj.ex7employee;
//name, annalSalary, computePay(),computeIncentive()
// main���� ��ü ���� new SalaryEmployee("ȫ�浿",2400)
public class SalaryEmployee extends Employee{
	private int annalSalary;
	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}
	@Override
	public int computePay() {
		return annalSalary/14;
	}
	public int getAnnalSalary() {
		return annalSalary;
	}
}
