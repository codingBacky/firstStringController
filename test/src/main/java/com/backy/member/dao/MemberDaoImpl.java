package com.backy.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.backy.member.domain.MemberVO;

public class MemberDaoImpl implements MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

		
		private RowMapper<MemberVO> mapper = new RowMapper<MemberVO>(){
			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				MemberVO vo = new MemberVO();
				vo.setDetailAddress(rs.getString("detailAddress"));	
				vo.setEmail(rs.getString("Email"));
				vo.setMemId(rs.getString("MemId"));
				vo.setMemName(rs.getString("MemName"));
				vo.setMemPwd(rs.getString("MemPwd"));
				vo.setPostCode(rs.getString("PostCode"));
				vo.setRegidate(rs.getString("Regidate"));
				
			return vo;
	}
	};


	
	@Override
	public int insertMember(MemberVO vo) {
		return jdbcTemplate.update("insert into members values(?,?,?,?,?,?,sysdate)", 
				vo.getMemId(), vo.getMemPwd(), vo.getMemName(), 
				vo.getEmail(), vo.getPostCode(), vo.getDetailAddress());
	}

	@Override
	public int deleteMember(String memId) {
		return jdbcTemplate.update("delete from members where memId = ?", memId);
	}

	@Override
	public int updateMember(MemberVO vo) {
		return jdbcTemplate.update("update members set memPwd =?, memName = ?, memEmail = ? where memId = ?", 
				vo.getMemPwd(), vo.getMemName(),vo.getEmail(),vo.getMemId());
	}
	
	@Override
	public int deleteAll() {
		return jdbcTemplate.update("delete from members");
	}

	@Override
	public MemberVO getMember(String memId) {
		return jdbcTemplate.queryForObject("select * from members where memId = ?"/* and mm = ? */, new Object[] {memId/*, "aa"*/}, mapper);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return jdbcTemplate.query("select * from members",/* ?에 들어갈 자료 ,*/ mapper);
	}

	
	@Override
	public int getCount() {
		return jdbcTemplate.queryForObject("select count(*) from members", Integer.class);
	}
	
//	public int getCount() { 
//		
//	}


}
