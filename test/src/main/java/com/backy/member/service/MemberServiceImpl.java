package com.backy.member.service;

import java.util.List;

import com.backy.member.dao.MemberDao;
import com.backy.member.domain.MemberVO;

//@Service
public class MemberServiceImpl implements MemberService {
	//@Autowired
	MemberDao dao;

	public void setDao(MemberDao dao) {
		
		//필요에 따라서 선행작업이 이루어진다. 유효성 검사 ,,,
		this.dao = dao;
	}

	@Override
	public int save(MemberVO vo) {
		//필요에 따라서 선행작업이 이루어진다. 
		return dao.insertMember(vo);
	}

	@Override
	public int del(String memId) {
		//필요에 따라서 선행작업이 이루어진다. 
		return dao.deleteMember(memId);
	}

	@Override
	public int upd(MemberVO vo) {
		//필요에 따라서 선행작업이 이루어진다. 
		return dao.updateMember(vo);
	}

	@Override
	public List<MemberVO> listAll() {
		//필요에 따라서 선행작업이 이루어진다. 지우고 추가하거나,,,
		return dao.getAllMember();
	}
	
}
