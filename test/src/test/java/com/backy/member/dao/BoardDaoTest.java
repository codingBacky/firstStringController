package com.backy.member.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backy.member.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/bean.xml")
public class BoardDaoTest {
	@Autowired
	private ApplicationContext context;
	@Autowired
	private BoardDao dao;
	
	private BoardVO data1, data2, data3, data4;
	
	@Before
	public void setData() {
		data1 = new BoardVO(1, "test Title1","test contents1", "backy");
		data2 = new BoardVO(2, "test Title2","test contents2", "backy2");
		data3 = new BoardVO(3, "test Title3","test contents3", "backy3");
		
	}
	
	@Test
	public void objInjection() {
		
		assertNotNull(dao);
	}
	@Test
	public void addTest() {
		dao.delAll();
		assertEquals(dao.getCount(),0);
		int result = dao.add(data1);
		assertEquals(result, 1);
		assertEquals(dao.getCount(),1);
		result = dao.add(data2);
		assertEquals(result, 1);
		assertEquals(dao.getCount(), 2);
		result = dao.add(data3);
		assertEquals(result, 1);
		assertEquals( dao.getCount(), 3);
	}
	
	
}
