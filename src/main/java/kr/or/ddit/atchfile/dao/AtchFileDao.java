package kr.or.ddit.atchfile.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.atchfile.model.AtchFileVo;
import kr.or.ddit.db.MybatisUtil;

public class AtchFileDao implements AtchFileDaoI {

	@Override
	public int insertFile(AtchFileVo atchFileVo,SqlSession sqlSession) {

		int fCnt = 0;
		try {
			fCnt = sqlSession.insert("atchFile.insertFile",atchFileVo);
		} catch (Exception e) {
			
		}
		
		return fCnt;
	}

	@Override
	public int deleteFile(int atch_file_seq,SqlSession sqlSession) {
		int cnt = 0;
		cnt = sqlSession.delete("atchFile.deleteFile",atch_file_seq);
		
		return cnt;
	}

	@Override
	public AtchFileVo getFile(int atch_file_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		AtchFileVo atchFileVo = sqlSession.selectOne("atchFile.getFile",atch_file_seq);
		
		sqlSession.close();
		return atchFileVo;
	}

	
}
