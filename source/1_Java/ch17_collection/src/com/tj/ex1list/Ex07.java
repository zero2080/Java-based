package com.tj.ex1list;
import java.util.ArrayList;
import java.util.Scanner;
// 회원정보(이름, 전화번호, 주소)
public class Ex07 {
	public static void main(String[] args) {
		ArrayList<Customer> cs = new ArrayList<Customer>();
		Scanner scanner = new Scanner(System.in);
		String input;
		while(true) {
			System.out.print("회원가입을 할까요(Y/N)?");
			input = scanner.next();
			if(input.equalsIgnoreCase("n")) {
				break;
			}
			System.out.print("가입할 회원이름은? ");
			String name = scanner.next();
			System.out.print("가입할 회원 전번은? ");
			String phone = scanner.next();
			System.out.print("가입할 회원 주소는? ");
			scanner.nextLine(); // 버퍼에 남아있는 '\n'을 버리기
			String address = scanner.nextLine();
			//Customer customer = new Customer(name, phone, address);
			//cs.add(customer);
			cs.add(new Customer(name, phone, address));
		}//while
		if(!cs.isEmpty()) {
			for(Customer c : cs) {
				System.out.println(c);
			}
		}else {
			System.out.println("가입한 회원이 없습니다");
		}
	}//main
}//class








