package com.tj.ex16_1.dao;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tj.ex16_1.model.Emp;
@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	@Override
	public List<Emp> empList(Emp emp) {
		return sessionTemplate.selectList("empList", emp);
	}
}
