package com.tj.ex3selectWhere_varchar;
//���, �̸�, sal, comm, �μ���ȣ, �μ���
public class Emp {
	private int empno;
	private String ename;
	private int sal;
	private int comm;
	private int deptno;
	private String dname;
	public Emp() {}
	public Emp(int empno, String ename, int sal, int comm, int deptno, String dname) {
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
		this.dname = dname;
	}
	@Override
	public String toString() {
		String result = empno+"\t"+ename+"\t"+sal+"\t"+comm+"\t"+deptno+"\t"+dname;
		return result;
	}
}















