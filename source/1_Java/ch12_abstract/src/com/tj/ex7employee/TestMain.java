package com.tj.ex7employee;
// 정규직2명과 비정규직3명의 월급명세 출력
public class TestMain {
	public static void main(String[] args) {
		Employee[] sawon = {new SalaryEmployee("홍길동", 24000000),
				new SalaryEmployee("강동원", 70000000),
				new HourlyEmployee("김고은", 160, 10000),
				new HourlyEmployee("송중기", 150, 20000),
				new HourlyEmployee("김길자", 170, 15000)};
		for(Employee s : sawon) {
			System.out.println("* * * * * 월급 명세서 * * * * *");
			System.out.println("성  함 : "+s.getName());
			System.out.println("월  급 : "+s.computePay());
			int tempIncentive = s.computeIncentive();
			if(tempIncentive>0) {
				System.out.println("상여금 : "+s.computeIncentive());
			}//if
			System.out.println("* * * 수 고 하 셨 습 니 다 * * *");
			System.out.println();
		}//for
	}//main
}//class
