package com.tj.ex7employee;
// ������2��� ��������3���� ���޸� ���
public class TestMain {
	public static void main(String[] args) {
		Employee[] sawon = {new SalaryEmployee("ȫ�浿", 24000000),
				new SalaryEmployee("������", 70000000),
				new HourlyEmployee("�����", 160, 10000),
				new HourlyEmployee("���߱�", 150, 20000),
				new HourlyEmployee("�����", 170, 15000)};
		for(Employee s : sawon) {
			System.out.println("* * * * * ���� ���� * * * * *");
			System.out.println("��  �� : "+s.getName());
			System.out.println("��  �� : "+s.computePay());
			int tempIncentive = s.computeIncentive();
			if(tempIncentive>0) {
				System.out.println("�󿩱� : "+s.computeIncentive());
			}//if
			System.out.println("* * * �� �� �� �� �� �� �� * * *");
			System.out.println();
		}//for
	}//main
}//class
