package com.backy.member.dao;

import java.util.List;

import com.backy.member.domain.MemberVO;

public interface MemberDao {
	int insertMember(MemberVO vo);
	int deleteMember(String memId);
	int updateMember(MemberVO vo);
	int deleteAll();//delete from members;
	int getCount();//select count(*) cnt from members;
	MemberVO getMember(String memId);
	List<MemberVO> getAllMember();	
}
