package com.tj.ex06toy;

public class ToyTestMain {
	public static void main(String[] args) {
		IToy[] toys = {new PoohToyClass(), 
				new MazingerToyClass(), 
				new AirPlaneToyClass()};
		for(IToy toy : toys) {
			System.out.println(toy.getClass().getName());
		}
	}
}
