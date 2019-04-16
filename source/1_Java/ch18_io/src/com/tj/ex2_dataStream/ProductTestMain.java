package com.tj.ex2_dataStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class ProductTestMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		InputStream      fis = null;
		DataInputStream  dis = null;
		OutputStream     fos = null;
		DataOutputStream dos = null;
		File file = new File("txtFile/productData.dat");
		ArrayList<Product> products = new ArrayList<Product>();
		String name;
		int price, ps;
		//1�ܰ�
		try {
			fos = new FileOutputStream(file, true);
			dos = new DataOutputStream(fos);
			do {
				System.out.print("����Է��� �����÷��� x, ��� �Է��Ͻ÷��� press any key");
				if(scanner.next().equalsIgnoreCase("x")) break;
				System.out.print("��� ��ǰ���� ?");
				dos.writeUTF(scanner.next());
				System.out.print("��� ��ǰ������? ");
				dos.writeInt(scanner.nextInt());
				System.out.print("��� ��ǰ �����? ");
				dos.writeInt(scanner.nextInt());
			}while(true);
		}catch (FileNotFoundException e) {
			System.out.println("���� �� ã�� : "+e.getMessage());
		}catch (IOException e) {
			System.out.println("IO ���� : "+e.getMessage());
		}finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		scanner.close();
		// 2�ܰ�
		try {
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			while(true) {
				name  = dis.readUTF();
				price = dis.readInt();
				ps    = dis.readInt();
				products.add(new Product(name, price, ps));
			}
		}catch (FileNotFoundException e) {
			System.out.println("���� �� ã�� : "+e.getMessage());
		}catch (IOException e) {
			System.out.println("�̻� 2�ܰ� ��. ArrayList�� ���� ���� ����");
		}finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		//3�ܰ�
		System.out.println("��ǰ��\t����\t�����");
		for(Product product : products)
			System.out.println(product);
	}
}







