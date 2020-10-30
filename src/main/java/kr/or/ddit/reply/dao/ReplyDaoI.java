package kr.or.ddit.reply.dao;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

public interface ReplyDaoI {

	List<ReplyVo> getReply(int post_seq);
	/**
	 * 댓글작성
	* ReplyDaoI.java
	*
	* @author PC-03
	* @version 1.0
	* @see
	*
	* <pre>
	* << 개정이력(Modification Information) >>
	*
	* 수정자 수정내용
	* ------ ------------------------
	* PC-03 최초 생성
	*
	* </pre>
	 */
	int insertReply(ReplyVo replyVo);
	/**
	 * 댓글삭제
	* ReplyDaoI.java
	*
	* @author PC-03
	* @version 1.0
	* @see
	*
	* <pre>
	* << 개정이력(Modification Information) >>
	*
	* 수정자 수정내용
	* ------ ------------------------
	* PC-03 최초 생성
	*
	* </pre>
	 */
	int deleteReply(int reply_seq);

}
