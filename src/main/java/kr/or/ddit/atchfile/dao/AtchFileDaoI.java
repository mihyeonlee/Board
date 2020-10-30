package kr.or.ddit.atchfile.dao;


import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.atchfile.model.AtchFileVo;

public interface AtchFileDaoI {
	/**
	 * 파일등록
	* AtchFileDaoI.java
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
	int insertFile(AtchFileVo atchFileVo, SqlSession sqlSession);
	
	/**
	 * 파일 삭제
	* AtchFileDaoI.java
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
	int deleteFile(int atch_file_seq,SqlSession sqlSession);

	AtchFileVo getFile(int atch_file_seq);
	
	
}
