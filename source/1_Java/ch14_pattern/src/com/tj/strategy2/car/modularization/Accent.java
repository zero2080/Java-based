package com.tj.strategy2.car.modularization;
import com.tj.strategy2.car.inter.EngineLow;
import com.tj.strategy2.car.inter.FuelDiesel;
import com.tj.strategy2.car.inter.Km20;
public class Accent extends Car{
	//
	public Accent() {
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
	}
	@Override
	public void shape() {
		System.out.print(getClass().getName()+ " ");
		super.shape();
	}
}
