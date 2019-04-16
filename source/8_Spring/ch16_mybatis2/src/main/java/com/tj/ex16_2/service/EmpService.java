package com.tj.ex16_2.service;
import java.util.List;
import com.tj.ex16_2.model.Dept;
import com.tj.ex16_2.model.Emp;
import com.tj.ex16_2.model.EmpDept;
public interface EmpService {
	public List<Dept> deptList();     //deptDao
	public List<Emp> empList(String pageNum);//이하는 empDao에서
	public int total();
	public Emp detail(int empno);
	public List<Emp> managerList();
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	public List<EmpDept> empDeptList(EmpDept empDept);
	public void insert50();
}
