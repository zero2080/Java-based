package com.tj.ex4etc;
import java.util.Stack;
public class ExStack {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>(); 
		stack.push("�̰�����");
		stack.push("���ѹα�");
		stack.push("ź�ڴϾ�");
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
