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
import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;

@MultipartConfig
@WebServlet("/postUpdate")
public class PostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostServlet.class);
	private PostServiceI postService;
	private ReplyServiceI replyService;

	@Override
	public void init() throws ServletException {
		postService = new PostService();
		replyService = new ReplyService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostVo postVo = postService.getPost(Integer.parseInt(request.getParameter("post_seq")));
		logger.debug("postVo:{}", postVo);

		List<AtchFileVo> fileList = postService.getFile(Integer.parseInt(request.getParameter("post_seq")));
		List<ReplyVo> replyList = replyService.getReply(Integer.parseInt(request.getParameter("post_seq")));

		request.setAttribute("postVo", postVo);
		request.setAttribute("fileList", fileList);
		request.setAttribute("replyList", replyList);
		logger.debug("fileList:{}", fileList);
		// jsp
		request.getRequestDispatcher(request.getContextPath() + "post/postUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String, Object> updateMap = new HashMap<String, Object>();

		// update post
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		int post_seq = Integer.parseInt(request.getParameter("post_seq"));

		int pcnt = 0;
		PostVo postVo = new PostVo();
		postVo.setPost_title(post_title);
		postVo.setPost_content(post_content);
		postVo.setPost_seq(post_seq);
		logger.debug("postVo:{}",postVo);
		updateMap.put("postVo", postVo);
		
		//updateFile
		List<AtchFileVo> fileList = new ArrayList<AtchFileVo>();
		String fstr = request.getParameter("fileListSize");
		int fileListSize = Integer.parseInt(fstr);
		logger.debug("fileListSize:{}",fileListSize);
		for (int i = 1; i < 6-fileListSize; i++) {
			
			Part profile = request.getPart("realFilename" + i);
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
				atchFileVo.setPost_seq(post_seq);
				fileList.add(atchFileVo);	
				logger.debug("fileList:{}",fileList);
				}
		}
		int insertFileRe = fileList.size();
		updateMap.put("insertFileRe", insertFileRe);
		updateMap.put("fileList", fileList);

		// 기존 파일 삭제하기
		int[] file_seq = new int[5];
		String str_seq =  null;
		for (int i = 1; i < 6; i++) {
			str_seq = request.getParameter("deleteFile"+i+"");
			logger.debug("str_seq:{}",str_seq);
			file_seq[i-1] = str_seq == null ? 0 : Integer.parseInt(str_seq);
		}
		updateMap.put("file_seq", file_seq);
		
		//결과
		int uCnt = postService.updatePost(updateMap);
		
		if (uCnt == 1) {
			response.sendRedirect(request.getContextPath() + "/post?post_seq="+post_seq);
		} else {
			doGet(request, response);
		}


	}

}
