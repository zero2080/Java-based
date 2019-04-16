package com.tj.ex7employee;
// name, hoursWorked, moneyPerHour, computePay(),computeIncentive()
// main¿¡¼­ new HourlyEmployee("È«±æµ¿", 160, 8000);
public class HourlyEmployee extends Employee {
	private int hoursWorked;
	private int moneyPerHour;
	public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
	}
	public int getHoursWorked() {
		return hoursWorked;
	}
	public int getMoneyPerHour() {
		return moneyPerHour;
	}
	@Override
	public int computePay() {
		return hoursWorked*moneyPerHour;
	}
}
