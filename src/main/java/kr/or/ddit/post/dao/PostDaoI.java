package kr.or.ddit.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.atchfile.model.AtchFileVo;
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
	 * @param sqlSession 
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
	int insertPost(PostVo postVo, SqlSession sqlSession);
	
	
	
	/**
	 * post_seq로 post정보가져오기
	* PostServiceI.java
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
	PostVo getPost(int post_seq);
	/**
	 * 해당게시글의 첨부파일 가져오기
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
	List<AtchFileVo> getFile(int post_seq);
	
	/**
	 * 게시글삭제
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
	int deletePost(int post_seq);
	/**
	 * 답글등록
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
	int insertAnswer(PostVo postVo,SqlSession sqlSession);
	/**
	 * 게시글수정
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
	int updatePost(PostVo postVo,SqlSession sqlSession);

}
