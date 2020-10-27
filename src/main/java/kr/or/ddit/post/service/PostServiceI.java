package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

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
	int insertPost(PostVo postVo);

}
