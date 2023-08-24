package com.backy.member.service;

import java.util.List;

import com.backy.member.domain.MemberVO;

public interface MemberService {
	int save(MemberVO vo);
	int del(String memId);
	int upd(MemberVO vo);
	List<MemberVO> listAll();
}
