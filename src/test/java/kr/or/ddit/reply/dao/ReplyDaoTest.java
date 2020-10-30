package kr.or.ddit.reply.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.reply.model.ReplyVo;

public class ReplyDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(ReplyDaoTest.class);
	private ReplyDaoI replyDao;

	@Before
	public void setup() {
		replyDao = new ReplyDao();
	}

	@Test
	public void getReplyListTest() {
		/*** Given ***/

		int post_seq = 45;
		/*** When ***/
		List<ReplyVo> replyList = replyDao.getReply(post_seq);
		logger.debug("replyList:{}",replyList);
		/*** Then ***/
		assertEquals(1, replyList.size());
	}
	
	@Test
	public void insertReplyTest() {
		/*** Given ***/
		
		ReplyVo replyVo = new ReplyVo("잘햇어요", 54, "sally");
		/*** When ***/
		int cnt = replyDao.insertReply(replyVo);
		logger.debug("replyVo:{}",replyVo);
		/*** Then ***/
		assertEquals(cnt,1 );
	}
	
	@Test
	public void deleteReplyTest() {
		/*** Given ***/
		int reply_seq = 5;
		/*** When ***/
		int cnt = replyDao.deleteReply(reply_seq);
		/*** Then ***/
		assertEquals(cnt,1 );
	}
	
	
}
