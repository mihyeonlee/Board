package kr.or.ddit.post.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.atchfile.model.AtchFileVo;
import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceI;

@MultipartConfig
@WebServlet("/postRegist")
public class PostRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostRegistServlet.class);
	private PostServiceI postService;

	@Override
	public void init() throws ServletException {
		postService = new PostService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String board_name = request.getParameter("board_name");
		request.setAttribute("board_name", board_name);
		request.getRequestDispatcher(request.getContextPath() + "/post/postRegist.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Map<String, Object> insertMap = new HashMap<String, Object>();
		
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		String post_yn = request.getParameter("post_yn");
		String user_id = request.getParameter("user_id");
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		String post_p_seq = request.getParameter("post_p_seq");

		logger.debug("parameter : {},{},{},{},{},{},{}", post_title, post_content, post_yn, user_id, board_seq,
				post_p_seq);

		// 게시글 정보 등록
		PostVo postVo = new PostVo(post_title, post_content, post_yn, board_seq, user_id, post_p_seq);
		insertMap.put("postVo", postVo);
		
		
		
		// file 정보 등록
		List<AtchFileVo> fileList = new ArrayList<AtchFileVo>();
		for (int i = 1; i < 6; i++) {
			Part profile = request.getPart("realFilename"+i);
			logger.debug("file : {}", profile.getHeader("Content-Disposition"));

			String realfilename = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
			String file_name = UUID.randomUUID().toString();

			String extension = FileUploadUtil.getExtension(realfilename);
			String file_path = "";
			logger.debug("realfilename ,filename : {},{}", realfilename, file_name);

			if (profile.getSize() > 0) {
				file_path = "D:\\profile\\" + file_name + "." + extension;
				profile.write(file_path);
				// 파일 정보 등록
				AtchFileVo atchFileVo = new AtchFileVo(file_path, realfilename);
				fileList.add(atchFileVo);
			}
		}
		insertMap.put("fileList", fileList);
		insertMap.put("fileListSize", fileList.size());
		
		//서비스 호출
		int pCnt = postService.insertPost(insertMap);
		postVo = (PostVo) insertMap.get("postVo");
		int post_seq = postVo.getPost_seq();
		logger.debug("게시글 번호는=========> :{}",post_seq);
		// 1건이 입력되었을 때 : 정상
		// 1건이 아닐때 : 비정상
		if (pCnt == 1) {
			response.sendRedirect(request.getContextPath() + "/post?post_seq="+post_seq);
		} else {
			doGet(request, response);
		}
	}

}
