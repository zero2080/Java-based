package com.tj.op;
// �����(����) ������ < <= > >=
public class Ex03 {
	public static void main(String[] args) {
		int n1=10, n2=25;
		boolean result = n1 < n2;
		// %s(���ڿ�) %d(����) %f(�Ǽ�) %c(����) %x(16����) %b(�Ҹ�)
		System.out.printf("%d %c %d = %b\t", n1, '<', n2, result);
		result = n1 > n2;
		System.out.printf("%d %c %d = %b\n", n1, '>', n2, result);
		result = n1 <= n2;
		System.out.printf("%d %s %d = %b\n", n1, "<=", n2, result);
		result = n1 >= n2;
		System.out.printf("%d %s %d = %b\n", n1, ">=", n2, result);
		// ����(==) �ٸ���(!=)
		System.out.println(n1==n2);
		System.out.println(n1!=n2);
	}
}
