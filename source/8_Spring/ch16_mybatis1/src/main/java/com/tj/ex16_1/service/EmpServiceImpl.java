package com.tj.ex16_1.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.ex16_1.dao.DeptDao;
import com.tj.ex16_1.dao.DeptDaoImpl;
import com.tj.ex16_1.dao.EmpDao;
import com.tj.ex16_1.model.Dept;
import com.tj.ex16_1.model.Emp;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao eDao;
	@Autowired
	private DeptDao dDao;
	@Override
	public List<Emp> empList(Emp emp) {
		if(emp.getEname()==null)
			emp.setEname("");
		if(emp.getJob()==null)
			emp.setJob("");
		return eDao.empList(emp);
	}
	@Override
	public List<Dept> deptList() {
		return dDao.deptList();
	}

}
