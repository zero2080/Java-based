package com.tj.ex6car;
//HighGradeCar c1 = new HighGradeCar("레드", "일반타이어", 2000, "파워핸들");
public class CarTestMain {
	public static void main(String[] args) {
		/*Car car1 = new HighGradeCar(CarSpecs.COLOR_BLACK, 
				CarSpecs.TIRE_WIDE, CarSpecs.DISPLACEMENT_2400, 
				CarSpecs.HANDLE_POWER);
		Car car2 = new LowGradeCar(CarSpecs.COLOR_RED, CarSpecs.TIRE_NORMAL, 
				CarSpecs.DISPLACEMENT_1000, CarSpecs.HANDLE_POWER);
		Car[] car = {car1, car2};*/
		Car[] car = {new HighGradeCar(CarSpecs.COLOR_BLACK, 
				CarSpecs.TIRE_WIDE, CarSpecs.DISPLACEMENT_2400, 
				CarSpecs.HANDLE_POWER),
				new LowGradeCar(CarSpecs.COLOR_RED, CarSpecs.TIRE_NORMAL, 
						CarSpecs.DISPLACEMENT_1000, CarSpecs.HANDLE_POWER)};
		for(Car c : car) {
			c.getSpec();
		}
	}
}



