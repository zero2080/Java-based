package com.tj.ex1list;
import java.util.ArrayList;
import java.util.Scanner;
// ȸ������(�̸�, ��ȭ��ȣ, �ּ�)
public class Ex07 {
	public static void main(String[] args) {
		ArrayList<Customer> cs = new ArrayList<Customer>();
		Scanner scanner = new Scanner(System.in);
		String input;
		while(true) {
			System.out.print("ȸ�������� �ұ��(Y/N)?");
			input = scanner.next();
			if(input.equalsIgnoreCase("n")) {
				break;
			}
			System.out.print("������ ȸ���̸���? ");
			String name = scanner.next();
			System.out.print("������ ȸ�� ������? ");
			String phone = scanner.next();
			System.out.print("������ ȸ�� �ּҴ�? ");
			scanner.nextLine(); // ���ۿ� �����ִ� '\n'�� ������
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
			System.out.println("������ ȸ���� �����ϴ�");
		}
	}//main
}//class








