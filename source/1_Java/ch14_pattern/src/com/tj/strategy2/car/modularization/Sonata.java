package com.tj.strategy2.car.modularization;
import com.tj.strategy2.car.inter.EngineMid;
import com.tj.strategy2.car.inter.FuelGasoline;
import com.tj.strategy2.car.inter.Km15;
public class Sonata extends Car {
	public Sonata() {
		setEngine(new EngineMid());
		setKm(new Km15());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.print(getClass().getName()+" ");
		super.shape();
	}
}