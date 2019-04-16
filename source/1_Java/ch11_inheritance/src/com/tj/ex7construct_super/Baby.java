package com.tj.ex7construct_super;
public class Baby extends Person {
	public Baby() {
		super("","");
		System.out.println("�Ű����� ���� Baby ������");
	}
	public Baby(String name, String character) {
		// super.xxx : superŬ������ xxx
		// super()   : superŬ������ ������. �ݵ�� ù���ο�.
		// ������ �ϸ������� Person()
		super(name, character); //Person(name, character)
		System.out.println("�Ű����� �ִ� Baby ������");
	}
	@Override
	public void intro() {
		System.out.println(getName()+"�� �Ʊ�� �� ����");
	}
	public void cry() {
		System.out.println("��������");
	}
}
