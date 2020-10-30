package kr.or.ddit.post.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.atchfile.model.AtchFileVo;
import kr.or.ddit.atchfile.service.AtchFileService;
import kr.or.ddit.atchfile.service.AtchFileServiceI;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profileDownload")
public class ProfileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AtchFileServiceI atchFileService;
	private static final Logger logger = LoggerFactory.getLogger(ProfileDownloadServlet.class);

	@Override
	public void init() throws ServletException {
		atchFileService = new AtchFileService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		// 사용자 아이디 파라미터 확인
		int atch_file_seq = Integer.parseInt(request.getParameter("atch_file_seq"));
		
		// db에서 사용자 filename 확인
		AtchFileVo atchFileVo = atchFileService.getFile(atch_file_seq);
		logger.debug("파일:{}",atchFileVo);
		
		// 경로 확인 후 파일 입출력을 통해 응답생성
		// 파일 읽기
		// 응답 생성
		// response content-type 설정
		response.setHeader("Content-Disposition","attachment; filename=\"" + atchFileVo.getFile_name());
		response.setContentType("application/octet-stream"); 
//		image/png
//		image/gif
//		image/jpg
//		response.addHeader(name, value); 이것도 사용가능
		
		if(atchFileVo.getFile_path()!=null) {
			FileInputStream fis = new FileInputStream(atchFileVo.getFile_path());// 파일 경로 읽기
			ServletOutputStream sos = response.getOutputStream();
			
			byte[] buffer = new byte[512];
			
			while (fis.read(buffer) != -1) {
				sos.write(buffer);
			}
			fis.close();
			sos.flush();
			sos.close();
		}


	}

}
