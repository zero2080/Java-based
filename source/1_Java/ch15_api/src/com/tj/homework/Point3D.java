package com.tj.homework;

public class Point3D implements Cloneable{
	private int x;
	private int y;
	private int z;
	public Point3D() {
		//x=0; y=0; z=0;
	}
	public Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public String toString() {
		return "ÁÂÇ¥°ª ["+x+", "+y+", "+z+"]";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Point3D) {
			boolean xEqual = x==((Point3D)obj).x;
			boolean yEqual = y==((Point3D)obj).y;
			boolean zEqual = z==((Point3D)obj).z;
			return xEqual && yEqual && zEqual;
		}
		return false;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
