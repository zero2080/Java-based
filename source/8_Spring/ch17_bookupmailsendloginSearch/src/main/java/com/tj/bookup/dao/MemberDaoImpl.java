package com.tj.bookup.dao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tj.bookup.model.Member;
@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	@Override
	public Member getMember(String mid) {
		return sessionTemplate.selectOne("getMember", mid);
	}
	@Override
	public int idConfirm(String mid) {
		return sessionTemplate.selectOne("idConfirm", mid);
	}
	@Override
	public int joinMember(Member member) {
		return sessionTemplate.insert("joinMember", member);
	}

	@Override
	public int modifyMember(Member member) {
		return sessionTemplate.update("modifyMember", member);
	}
}
