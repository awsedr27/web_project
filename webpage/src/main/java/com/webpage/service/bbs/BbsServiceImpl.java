package com.webpage.service.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webpage.DAO.bbs.BbsDAO;
import com.webpage.DAO.bbs.BbsDTO;
@Service
public class BbsServiceImpl implements BbsService {
	
	@Autowired
	BbsDAO bbsDAO;

	@Override
	public List<BbsDTO> getBbs(int pageNum) {
		List<BbsDTO> list=bbsDAO.getBbs(pageNum);
		return list;
	}

	@Override
	public int getPageCnt() {
		int pageCnt=bbsDAO.getPageCnt();
		return pageCnt;
	}

	@Override
	public void setBbs(BbsDTO bbsDTO) {
		bbsDAO.setBbs(bbsDTO);
		
	}

	@Override
	public BbsDTO getBbsView(int bbs_id) {
		BbsDTO bbs=bbsDAO.getBbsView(bbs_id);
		return bbs;
	}

	@Override
	public void setBbsModify(String bbs_title, String bbs_contents,int bbs_id) {
		bbsDAO.setBbsModify(bbs_title,bbs_contents,bbs_id);
		
	}

	@Override
	public void deleteBbs(int bbs_id) {
		bbsDAO.deleteBbs(bbs_id);
		
	}

}
