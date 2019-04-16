package com.tj.ex16_1.dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tj.ex16_1.model.Dept;
@Repository // 이 클래스는 DAO클래스임을 알려주고 bean생성
public class DeptDaoImpl implements DeptDao {
	@Autowired
	private SqlSession sessionTemplate;
	@Override
	public List<Dept> deptList() {
		return sessionTemplate.selectList("deptList");
	}

}
