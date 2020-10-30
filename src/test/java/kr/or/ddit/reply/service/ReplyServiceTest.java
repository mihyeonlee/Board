package kr.or.ddit.reply.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.reply.model.ReplyVo;

public class ReplyServiceTest {
	private ReplyServiceI replyService;
	private static final Logger logger = LoggerFactory.getLogger(ReplyServiceTest.class);

	@Before
	public void setup() {
		replyService = new ReplyService();
	}

	@Test
	public void getReplyListTest() {
		/*** Given ***/

		int post_seq = 45;
		/*** When ***/
		List<ReplyVo> replyList = replyService.getReply(post_seq);
		logger.debug("replyList:{}",replyList);
		/*** Then ***/
		assertEquals(1, replyList.size());
	}
	
	@Test
	public void insertReplyTest() {
		/*** Given ***/
		
		ReplyVo replyVo = new ReplyVo("잘햇어요", 54, "sally");
		/*** When ***/
		int cnt = replyService.insertReply(replyVo);
		logger.debug("replyVo:{}",replyVo);
		/*** Then ***/
		assertEquals(cnt,1 );
	}
	
	@Test
	public void deleteReplyTest() {
		/*** Given ***/
		int reply_seq = 4;
		/*** When ***/
		int cnt = replyService.deleteReply(reply_seq);
		/*** Then ***/
		assertEquals(cnt,1 );
	}
	
	
}
