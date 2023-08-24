package com.backy.member.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backy.member.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/bean.xml")
//@RunWith(SpringJUnit4ClassRunner.class)@ContextConfiguration여기까지spring test 사용하는데 필수로 써줘야함 (설정정보를 이용하겠다)
public class MemberDaoTest {
	@Autowired
	private ApplicationContext context; //filed -> 객체가 생성되면 기본 값을 갖는다. context = null; ApplicationContext 타입이 있으면 알아서 context 생성해서 넣어줘
	
	@Autowired
	private MemberDao dao;
	private MemberVO mem1, mem2, mem3;
	
	
	@Test
	@Ignore
	public void contextTest() {
		assertNotNull(context);
	}
	
	@Before
	public void dataSetup() {
		mem1 = new MemberVO("backy", "backy1", "hyeony", "backy@aaa.com", "12345", "suwon", null);
		mem2 = new MemberVO("back", "back1", "JJung", "back@aaa.com", "23456", "home", null);
		mem3 = new MemberVO("jung", "jung12", "junge", "jung@aaa.com", "34567", "school", null);
	}
	@Test
	public void addNget() {
		dao.deleteAll();
		assertEquals(dao.getCount(), 0);
		int result = dao.insertMember(mem1);
		assertEquals(result, 1);
		assertEquals(dao.getCount(), 1);
		result = dao.insertMember(mem2);
		assertEquals(result, 1);
		assertEquals(dao.getCount(), 2);
		result = dao.insertMember(mem3);
		assertEquals(result, 1);
		assertEquals(dao.getCount(), 3);
		//정확하게 해당 컬럼에 입력이 되었는지를 테스트 해야 한다.
		MemberVO getVO = dao.getMember(mem1.getMemId());
		objEquals(getVO, mem1);
		getVO = dao.getMember(mem2.getMemId());
		objEquals(getVO, mem2);
		getVO = dao.getMember(mem3.getMemId());
		objEquals(getVO, mem3);
	}
	private void objEquals(MemberVO mem1, MemberVO getVO) {
		assertEquals(getVO.getDetailAddress(), mem1.getDetailAddress());
		assertEquals(getVO.getEmail(), mem1.getEmail());
		assertEquals(getVO.getMemName(), mem1.getMemName());
		assertEquals(getVO.getMemPwd(), mem1.getMemPwd());
		assertEquals(getVO.getPostCode(), mem1.getPostCode());
	}
}	
