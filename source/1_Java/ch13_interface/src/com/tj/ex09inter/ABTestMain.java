package com.tj.ex09inter;

public class ABTestMain {

	public static void main(String[] args) {
		User user = new User();
		A a = new A();
		B b = new B();
		user.aORb_use(a);
		System.out.println();
		user.aORb_use(b);
		user.aORb_use(new A());
		user.aORb_use(new B());
		I i = new I() {
			
			@Override
			public void method() {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
