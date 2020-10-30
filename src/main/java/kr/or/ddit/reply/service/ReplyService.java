package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoI;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyService implements ReplyServiceI {
	ReplyDaoI replyDao;
	public ReplyService() {
		replyDao = new ReplyDao();
	}
	@Override
	public List<ReplyVo> getReply(int post_seq) {
		return replyDao.getReply(post_seq);
	}
	@Override
	public int insertReply(ReplyVo replyVo) {
		return replyDao.insertReply(replyVo);
	}
	@Override
	public int deleteReply(int reply_seq) {
		return replyDao.deleteReply(reply_seq);
	}

}
