package com.tj.ex6super;
public class ChildClass extends ParentClass {
	private String cStr="�Ƶ�Ŭ����";
	public ChildClass() {System.out.println("�ڽĻ�����");}
	@Override // 1.����Ÿ�԰� �Ű������� ���� 2.������������ ������ ���ų� �д� 
	          // 3.static method�� �������̵� �Ұ�
			  // 4.final method�� �������̵� �Ұ�
	public void getMamiName() {
		System.out.print("�̻� ���� �̻� ");
		super.getMamiName(); // this.
	}
	public String getcStr() {
		return cStr;
	}
	public void setcStr(String cStr) {
		this.cStr = cStr;
	}
}
