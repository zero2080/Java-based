package com.tj.homework1205;
public class Main {
	public static void main(String[] args) {
		Person st1 = new Student("A01","������","JAVA��");
		Person st2 = new Student("A02","ȫ�浿","C++");
		Person sf1 = new Gangsa("S01","���浿","�������");
		Person sf2 = new Gangsa("S02","���ѵ�","���������");
		Person ga1 = new Staff("G01","�̱浿","��ü����");
		Person[] p = {st1, st2, sf1, sf2, ga1};
		for(Person pp : p)
			pp.print();
	}
}
