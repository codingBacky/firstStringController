package com.backy.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.backy.member.domain.BoardVO;

import lombok.Setter;

//@repository 빈으로 등록할게
public class BoardDaoImpl implements BoardDao{
	@Setter
	JdbcTemplate jdbcTemplate;
	
	RowMapper<BoardVO> mapper = new RowMapper<BoardVO>() {
		
		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO vo = new BoardVO();
			vo.setBoardNo(rs.getLong("boardNo"));
			vo.setContents(rs.getNString("contents"));
			vo.setTitle(rs.getNString("title"));
			vo.setWriter(rs.getNString("writer"));
			vo.setWriteDate(rs.getNString("writeDate"));
			return null;
		}
	};

	@Override
	public int add(BoardVO data1) {

		return jdbcTemplate.update("insert into boards values(?,?,?,?,sysdate)", 
				data1.getBoardNo(), data1.getTitle(), data1.getContents(), data1.getWriter());
	}

	@Override
	public int delAll() {
		
		return jdbcTemplate.update("delete from boards");
	}

	@Override
	public int getCount() {
		
		return jdbcTemplate.queryForObject("select count(*) from boards", Integer.class);
	}  
}
