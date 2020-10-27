package kr.or.ddit.post.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.page.model.PageVo;
import kr.or.ddit.post.model.PostVo;

public class PostDaoTest {

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
	public void getPostPageTest() {
		/*** Given ***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		PageVo pageVo = new PageVo(1, 10, 5,"Q&A게시판");
		/*** When ***/
		List<PostVo> postList = postDao.getPostPage(sqlSession, pageVo);

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
		assertEquals(21, totalCnt);
	}

}
