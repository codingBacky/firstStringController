package com.backy.member.dao;

import com.backy.member.domain.BoardVO;

public interface BoardDao {

	int add(BoardVO data1);

	int delAll();

	int getCount();

}
