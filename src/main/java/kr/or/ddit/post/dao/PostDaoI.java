package kr.or.ddit.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.page.model.PageVo;
import kr.or.ddit.post.model.PostVo;

public interface PostDaoI {

	List<PostVo> getPostList(int board_seq);
	/**
	 * 게시글 개수
	* PostDaoI.java
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
	int getPostTotalCnt(SqlSession sqlSession, int board_seq);
	/**
	 * 페이징처리해서 게시글 가져오기
	* PostDaoI.java
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
	List<PostVo> getPostPage(SqlSession sqlSession, PageVo pageVo);
	/**
	 * 게시글 등록
	* PostDaoI.java
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
	int insertPost(PostVo postVo);

}
