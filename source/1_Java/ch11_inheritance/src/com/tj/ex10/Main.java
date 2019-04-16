package com.tj.ex10;

public class Main {
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal rabbit = new Rabbit();
		Animal[] animal = {dog, rabbit};
		for(Animal a : animal) {
			a.running();
			a.stop();
		}
	}
}
