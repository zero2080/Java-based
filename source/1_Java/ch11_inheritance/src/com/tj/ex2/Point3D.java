package com.tj.ex2;
//3������ǥ (x,y,z)
public class Point3D extends Point{
	private int z;
	public int getZ() {return z;}
	public void setZ(int z) {this.z = z;}
	// x,y,z ��ǥ�� ����ϴ� �Լ�
	public String infoString() {
		String result = "3������ǥ ("+getX()+", "+getY()+","+z+")";
		return result;
	}
}
