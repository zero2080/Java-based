package com.tj.ex4etc;
import java.util.Stack;
public class ExStack {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>(); 
		stack.push("½Ì°¡Æ÷¸£");
		stack.push("´ëÇÑ¹Î±¹");
		stack.push("ÅºÀÚ´Ï¾Æ");
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
