package com.tj.strategy2.car.modularization;
import com.tj.strategy2.car.inter.IEngine;
import com.tj.strategy2.car.inter.IFuel;
import com.tj.strategy2.car.inter.IKm;
public class Car {
	private IEngine engine;
	private IKm     km;
	private IFuel   fuel;
	public void drive() {
		System.out.println("����̺긦 �� �� �ֽ��ϴ�");
	}
	public void shape() {
		System.out.println("�ڵ����� door, sheet, handle�� �����ǿ�");
	}
	public void isEngine() {
		engine.engine();
	}
	public void isKm() {
		km.kmPerLiter();
	}
	public void isFuel() {
		fuel.fuel();
	}
	public void setEngine(IEngine engine) {this.engine = engine;}
	public void setKm(IKm km) {	this.km = km;	}
	public void setFuel(IFuel fuel) {this.fuel = fuel;	}
}
