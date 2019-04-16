package com.tj.strategy2.car.modularization;
import com.tj.strategy2.car.inter.EngineHigh;
import com.tj.strategy2.car.inter.FuelGasoline;
import com.tj.strategy2.car.inter.Km10;
public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.print(getClass().getName()+ " ");
		super.shape();
	}
}
