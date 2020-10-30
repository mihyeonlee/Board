package kr.or.ddit.atchFile.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.atchfile.dao.AtchFileDao;
import kr.or.ddit.atchfile.dao.AtchFileDaoI;
import kr.or.ddit.atchfile.model.AtchFileVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.db.MybatisUtil;

public class atchFileDaoTest {
	
	private AtchFileDaoI atchFileDao;
	
	@Before
	public void setup() {
		atchFileDao = new AtchFileDao();
	}
	
	@Test
	public void insertFileTest() {
		/*** Given ***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		AtchFileVo atchFileVo = new AtchFileVo("경로경로", "mimi");
		atchFileVo.setPost_seq(5);
		/*** When ***/
		int fCnt = atchFileDao.insertFile(atchFileVo,sqlSession);
		
		sqlSession.close();
		/*** Then ***/
		assertEquals(1, fCnt);
	}
	
	@Test
	public void deleteFileTest() {
		/*** Given ***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		/*** When ***/
		int fCnt = atchFileDao.deleteFile(34, sqlSession);
		
		if(fCnt==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		/*** Then ***/
		assertEquals(1, fCnt);
	}
	
	

}
