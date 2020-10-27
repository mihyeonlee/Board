package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoI;
import kr.or.ddit.user.model.UserVo;

public class UserServiceTest {
	UserDaoI userDao;
	
	@Before
	public void setup() {
		userDao = new UserDao();
	}
	

	@Test
	public void getUserTest() {
		/***Given***/
		String user_id = "brown"; 
		
		/***When***/
		UserVo userVo = userDao.getUser(user_id);

		/***Then***/
		assertEquals(userVo.getUser_id(), user_id);
	}

}
