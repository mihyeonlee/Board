package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.atchfile.model.AtchFileVo;
import kr.or.ddit.page.model.PageVo;
import kr.or.ddit.post.model.PostVo;

public interface PostServiceI {
	//전체 게시글
	List<PostVo> getPostList(int board_seq);
	/**
	 * 페이지 처리된 게시글리스트
	* PostServiceI.java
	*
	* @author PC-03
	* @version 1.0
	* @see
	* @return pageList, pages(게시글 수)
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
	Map<String, Object> getPostPage(PageVo pageVo);
	
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
	int insertPost(Map<String, Object> insertMap);
	
	
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
	 * 해당게시글 첨부파일 가져오기
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
	List<AtchFileVo> getFile(int post_seq);
	/**
	 * 게시글 삭제
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
	int deletePost(int post_seq);
	/**
	 * 답글등록
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
	int insertAnswer(Map<String, Object> insertMap);
	/**
	 * 게시글 수정
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
	int updatePost(Map<String, Object> updateMap);

}
