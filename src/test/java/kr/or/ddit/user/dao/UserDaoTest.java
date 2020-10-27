package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserDaoTest {
	UserServiceI userService;
	@Before
	public void setup() {
		userService = new UserService();
	}
	

	@Test
	public void getUserTest() {
		/***Given***/
		String user_id = "brown"; 
		
		/***When***/
		UserVo userVo = userService.getUser(user_id);

		/***Then***/
		assertEquals(userVo.getUser_id(), user_id);
	}

}
