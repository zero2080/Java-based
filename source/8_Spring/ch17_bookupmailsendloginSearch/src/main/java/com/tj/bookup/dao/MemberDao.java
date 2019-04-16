package com.tj.bookup.dao;
import com.tj.bookup.model.Member;
public interface MemberDao {
	public Member getMember(String mid);
	public int idConfirm(String mid);
	public int joinMember(Member member);
	public int modifyMember(Member member);
}
