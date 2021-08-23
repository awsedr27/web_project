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
	public BbsDTO getBbsView(int bbsId) {
		BbsDTO bbs=bbsDAO.getBbsView(bbsId);
		return bbs;
	}

	@Override
	public void setBbsModify(String bbsTitle, String bbsContents,int bbsId) {
		bbsDAO.setBbsModify(bbsTitle,bbsContents,bbsId);
		
	}

	@Override
	public void deleteBbs(int bbsId) {
		bbsDAO.deleteBbs(bbsId);
		
	}

}
