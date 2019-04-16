package com.tj.ex6super;
public class ChildClass extends ParentClass {
	private String cStr="아들클래스";
	public ChildClass() {System.out.println("자식생성자");}
	@Override // 1.리턴타입과 매개변수가 같다 2.접근제한자의 범위가 같거나 넓다 
	          // 3.static method는 오버라이드 불가
			  // 4.final method는 오버라이드 불가
	public void getMamiName() {
		System.out.print("이쁜 아주 이쁜 ");
		super.getMamiName(); // this.
	}
	public String getcStr() {
		return cStr;
	}
	public void setcStr(String cStr) {
		this.cStr = cStr;
	}
}
