package kr.or.ddit.atchfile.service;

import kr.or.ddit.atchfile.dao.AtchFileDao;
import kr.or.ddit.atchfile.dao.AtchFileDaoI;
import kr.or.ddit.atchfile.model.AtchFileVo;

public class AtchFileService implements AtchFileServiceI {
	private AtchFileDaoI atchFileDao;
	
	public AtchFileService() {
		atchFileDao = new AtchFileDao();
	}
	@Override
	public AtchFileVo getFile(int atch_file_seq) {
		return atchFileDao.getFile(atch_file_seq);
	}

}
