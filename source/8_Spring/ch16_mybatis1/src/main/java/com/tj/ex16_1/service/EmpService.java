package com.tj.ex16_1.service;
import java.util.List;
import com.tj.ex16_1.model.Dept;
import com.tj.ex16_1.model.Emp;
public interface EmpService {
	public List<Emp> empList(Emp emp);
	public List<Dept> deptList();
}
