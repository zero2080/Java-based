package com.tj.ex6hw1218;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainTestWriter {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Customer> customers = new ArrayList<Customer>();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(new Date());
		Writer writer = null;
		try {
			do {
				System.out.print("회원가입을 중단하시려면 N / 계속 하시려면 press any key : ");
				if(keyboard.readLine().equalsIgnoreCase("n")) break;
				System.out.print("회원이름은 ");
				String name = keyboard.readLine();
				System.out.print("회원전화번호는 ");
				String phone = keyboard.readLine();
				System.out.print("생일은(예시 : 08-08)");
				String birth = keyboard.readLine();
				if(birth.equals(todayStr)) {
					System.out.println("★ ★ ★ ★ ★ 생일 축하드려요 ★ ★ ★ ★ ★");
				}
				System.out.print("회원 주소는 ");
				String address = keyboard.readLine();
				customers.add(new Customer(name, phone, birth, address));
			}while(true);
		}catch (IOException e) {
			System.out.println("키보드 입력 예외 : "+e.getMessage());
		}
		try {
			writer = new FileWriter("src/com/tj/ex6hw1218/customer.txt");
			for(Customer customer : customers) {
				System.out.println(customer);
				writer.write(customer.toString()+"\r\n");
			}
			System.out.println(". . . . . 이하 "+customers.size()+"명 가입");
			writer.write(". . . . . 이하 "+customers.size()+"명 가입");
		} catch (FileNotFoundException e) {
			System.out.println("해당 폴더가 없다는 예외 : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IO예외"+e.getMessage());
		} finally {
			try {
				if(writer!=null) writer.close();
			}catch (IOException e) {System.out.println(e.getMessage());}
		}
	}
}
