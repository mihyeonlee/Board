package kr.or.ddit.post.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.page.model.PageVo;
import kr.or.ddit.post.model.PostVo;

public class PostServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(PostServiceTest.class);
	
	private PostServiceI postService;
	
	@Before
	public void setup() {
		postService = new PostService();
	}
	
	@Test
	public void getPostListTest() {
		/***Given***/

		int board_seq = 5;
		/***When***/
		List<PostVo> postList = postService.getPostList(board_seq);
		/***Then***/
		assertEquals(1, postList.size());
	}
	
	@Test
	public void getPostPageTest() {
		/***Given***/
		PageVo pageVo = new PageVo(1, 10, 6,"Q&A게시판");
		/***When***/
		Map<String, Object> map = postService.getPostPage(pageVo);
		List<PostVo> postList = (List<PostVo>) map.get("postList");
		
		int pages = (int) map.get("pages");
		
		logger.debug("postList:{}",postList);
		logger.debug("pages:{}",pages);
		/***Then***/
		assertEquals(3, postList.size());
		assertEquals(1, pages);
	}
	
	
	
	

}
