package com.tj.ex2;
//3차원좌표 (x,y,z)
public class Point3D extends Point{
	private int z;
	public int getZ() {return z;}
	public void setZ(int z) {this.z = z;}
	// x,y,z 좌표값 출력하는 함수
	public String infoString() {
		String result = "3차원좌표 ("+getX()+", "+getY()+","+z+")";
		return result;
	}
}
