package com.tj.ex7employee;
//name, annalSalary, computePay(),computeIncentive()
// main俊辑 按眉 积己 new SalaryEmployee("全辨悼",2400)
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
