package kr.or.ddit.post.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.atchfile.model.AtchFileVo;
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
	public void getPostTest() {
		/*** Given ***/
		
		int post_seq = 45;
		/*** When ***/
		PostVo postVo = postService.getPost(post_seq);
		logger.debug("postVo:{}",postVo.getPost_content());
		/*** Then ***/
		assertEquals(postVo.getPost_seq(),post_seq);
	}
	
	@Test
	public void getFileListTest() {
		/*** Given ***/
		
		int post_seq = 54;
		/*** When ***/
		List<AtchFileVo> fileList = postService.getFile(post_seq);
		logger.debug("fileList:{}",fileList);
		/*** Then ***/
		assertEquals(fileList.size(),2);
	}
	
	
	@Test
	public void deletePostTest() {
		/*** Given ***/
		
		int post_seq = 4;
		/*** When ***/
		int cnt = postService.deletePost(post_seq);
		/*** Then ***/
		assertEquals(cnt,1);
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
	
	@Test
	public void insertPostTest() {
		/*** Given ***/
		
		Map<String, Object> map = new HashMap<String, Object>();
		PostVo postVo = new PostVo("귀신아", "물러가라", "Y", 5, "brown",null);
		map.put("postVo", postVo);
		
		List<AtchFileVo> fileList = new ArrayList<AtchFileVo>();
		AtchFileVo atchFileVo = new AtchFileVo("df", "파일이름");
		AtchFileVo atchFileVo2 = new AtchFileVo("12", "파일이름");
		AtchFileVo atchFileVo3 = new AtchFileVo("23", "파일이름");
		fileList.add(atchFileVo);
		fileList.add(atchFileVo2);
		fileList.add(atchFileVo3);
		map.put("fileList", fileList);
		
		/*** When ***/
		int pCnt = postService.insertPost(map);
		postVo = (PostVo) map.get("postVo");
		
		logger.debug("셀렉트키 받아오기!! :{}",postVo.getPost_seq());
		
		/*** Then ***/
		assertEquals(1, pCnt);
	}
	@Test
	public void updatePostTest() {
/*** Given ***/
		
		Map<String, Object> map = new HashMap<String, Object>();
		PostVo postVo = new PostVo();
		postVo.setPost_title("바꿔");
		postVo.setPost_content("바꿔바꿔");
		postVo.setPost_seq(76);
		map.put("postVo", postVo);
		
		List<AtchFileVo> fileList = new ArrayList<AtchFileVo>();
		AtchFileVo atchFileVo = new AtchFileVo("df", "파일이름");
		AtchFileVo atchFileVo2 = new AtchFileVo("12", "파일이름");
		AtchFileVo atchFileVo3 = new AtchFileVo("23", "파일이름");
		atchFileVo.setPost_seq(76);
		atchFileVo2.setPost_seq(76);
		atchFileVo3.setPost_seq(76);
		fileList.add(atchFileVo);
		fileList.add(atchFileVo2);
		fileList.add(atchFileVo3);
		map.put("fileList", fileList);
		
		int[] file_seq = new int[5];
		file_seq[0] = 35;
		map.put("file_seq", file_seq);
		/*** When ***/
		int pCnt = postService.updatePost(map);
		/*** Then ***/
		assertEquals(1, pCnt);
	}
	
	@Test
	public void insertAnswerTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		PostVo postVo = new PostVo("귀신아", "물러가라", "Y", 5, "brown","72");
		map.put("postVo", postVo);
		
		List<AtchFileVo> fileList = new ArrayList<AtchFileVo>();
		AtchFileVo atchFileVo = new AtchFileVo("df", "파일이름");
		AtchFileVo atchFileVo2 = new AtchFileVo("12", "파일이름");
		AtchFileVo atchFileVo3 = new AtchFileVo("23", "파일이름");
		fileList.add(atchFileVo);
		fileList.add(atchFileVo2);
		fileList.add(atchFileVo3);
		map.put("fileList", fileList);
		
		/*** When ***/
		int pCnt = postService.insertAnswer(map);
		postVo = (PostVo) map.get("postVo");
		
		logger.debug("셀렉트키 받아오기!! :{}",postVo.getPost_seq());
		/*** Then ***/
		assertEquals(1, pCnt);
	}
	
	
	
	
	

}
