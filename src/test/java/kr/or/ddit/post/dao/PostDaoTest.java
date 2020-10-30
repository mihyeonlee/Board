package kr.or.ddit.post.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.atchfile.model.AtchFileVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.page.model.PageVo;
import kr.or.ddit.post.model.PostVo;

public class PostDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(PostDaoTest.class);
	private PostDaoI postDao;

	@Before
	public void setup() {
		postDao = new PostDao();
	}

	@Test
	public void getPostListTest() {
		/*** Given ***/

		int board_seq = 5;
		/*** When ***/
		List<PostVo> postList = postDao.getPostList(board_seq);
		/*** Then ***/
		assertEquals(21, postList.size());
	}
	
	@Test
	public void getPostTest() {
		/*** Given ***/
		
		int post_seq = 54;
		/*** When ***/
		PostVo postVo = postDao.getPost(post_seq);
		/*** Then ***/
		assertEquals(postVo.getPost_seq(),post_seq);
	}
	@Test
	public void deletePostTest() {
		/*** Given ***/
		
		int post_seq = 3;
		/*** When ***/
		int cnt = postDao.deletePost(post_seq);
		/*** Then ***/
		assertEquals(cnt,1);
	}
	
	@Test
	public void getFileListTest() {
		/*** Given ***/
		
		int post_seq = 54;
		/*** When ***/
		List<AtchFileVo> fileList = postDao.getFile(post_seq);
		/*** Then ***/
		assertEquals(fileList.size(),2);
	}
	

	@Test
	public void getPostPageTest() {
		/*** Given ***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		PageVo pageVo = new PageVo(1, 10, 5,"Q&A게시판");
		/*** When ***/
		List<PostVo> postList = postDao.getPostPage(sqlSession, pageVo);
		sqlSession.close();
		/*** Then ***/
		assertEquals(10, postList.size());
	}

	@Test
	public void getPageTotalCntTest() {
		/*** Given ***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int board_seq = 5;
		/*** When ***/
		int totalCnt = postDao.getPostTotalCnt(sqlSession, board_seq);
		/*** Then ***/
		sqlSession.close();
		assertEquals(21, totalCnt);
	}
	
	@Test
	public void insertPostTest() {
		/*** Given ***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		PostVo postVo = new PostVo("금일 6시에 서버운영이 종료됩니다^^ 탈퇴하세여 제발", "잘들어갔나요", "Y", 5, "brown",null);
		/*** When ***/
		int pCnt = postDao.insertPost(postVo,sqlSession);
		logger.debug("셀렉트키 받아오기!! :{}",postVo.getPost_seq());
		if(pCnt==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		/*** Then ***/
		assertEquals(1, pCnt);
	}
	@Test
	public void updatePostTest() {
		/*** Given ***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		PostVo postVo = new PostVo();
		postVo.setPost_title("얄리얄리얄라셩");
		postVo.setPost_content("얄라리얄라");
		postVo.setPost_seq(59);
		/*** When ***/
		int pCnt = postDao.updatePost(postVo,sqlSession);
		logger.debug("셀렉트키 받아오기!! :{}",postVo.getPost_seq());
		
		/*** Then ***/
		assertEquals(1, pCnt);
	}
	@Test
	public void insertAnswerTest() {
		/*** Given ***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		PostVo postVo = new PostVo("빠바바바밤", "잘들어갔나요", "Y", 5, "brown","56"); 
		postVo.setPost_gn(56);
		/*** When ***/
		int pCnt = postDao.insertAnswer(postVo,sqlSession);
		logger.debug("셀렉트키 받아오기!! :{}",postVo.getPost_seq());
		if(pCnt==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		/*** Then ***/
		assertEquals(1, pCnt);
	}
	
	
}
