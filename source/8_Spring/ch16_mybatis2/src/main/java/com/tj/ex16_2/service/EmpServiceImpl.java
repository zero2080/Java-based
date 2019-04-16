package com.tj.ex16_2.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tj.ex16_2.dao.DeptDao;
import com.tj.ex16_2.dao.EmpDao;
import com.tj.ex16_2.model.Dept;
import com.tj.ex16_2.model.Emp;
import com.tj.ex16_2.model.EmpDept;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao empDao;
	@Autowired
	private DeptDao deptDao;
	@Override
	public List<Dept> deptList() {
		return deptDao.deptList();
	}
	@Override
	public List<Emp> empList(String pageNum) {
		Paging paging = new Paging(empDao.total(), pageNum, 10, 10);
		Emp emp = new Emp();
		emp.setStartRow(paging.getStartRow());
		emp.setEndRow(paging.getEndRow());
		return empDao.empList(emp);
	}
	@Override
	public int total() {
		return empDao.total();
	}
	@Override
	public Emp detail(int empno) {
		return empDao.detail(empno);
	}
	@Override
	public List<Emp> managerList() {
		return empDao.managerList();
	}
	@Override
	public int insert(Emp emp) {
		return empDao.insert(emp);
	}
	@Override
	public int update(Emp emp) {
		return empDao.update(emp);
	}
	@Override
	public int delete(int empno) {
		return empDao.delete(empno);
	}
	@Override
	public List<EmpDept> empDeptList(EmpDept empDept) {
		return empDao.empDeptList(empDept);
	}
	@Override
	public void insert50() {
		Emp emp = new Emp();
		for(int i=9000 ; i<9050 ; i++) {
			emp.setEmpno(i);
			emp.setEname("길동"+i);
			if(i%2==0) {
				emp.setJob("개발");
				emp.setMgr(7499);
			}else {
				emp.setJob("행정");
				emp.setMgr(7566);
			}
			emp.setHiredate("19-04-02");
			emp.setSal(i);
			emp.setComm(i/10);
			emp.setDeptno(40);
			int result = empDao.insert(emp);
			System.out.println(result==1? i+"등록 성공":i+"등록 실패");
		}
	}
}









