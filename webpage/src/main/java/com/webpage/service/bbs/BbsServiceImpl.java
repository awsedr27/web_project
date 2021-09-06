package com.webpage.service.bbs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String,Object> getPagingService(int pageNum) {
		Map<String,Object> map=new HashMap<String,Object>();
		int pageCnt=bbsDAO.getPageCnt();
		
		int pageRangeFirst=0;
		int pageRangeLast=0;
		boolean nextRange;
		if(pageCnt==0) {
			pageCnt++;
		}
		if(pageNum%5==0) {
			--pageNum;
			 pageRangeFirst= (5*((int)Math.floor(pageNum/5.0)))+1;
			 ++pageNum;
			 pageRangeLast=pageRangeFirst+4;
			
		}else {
			 pageRangeFirst= (5*((int)Math.floor(pageNum/5.0)))+1;
			 pageRangeLast=pageRangeFirst+4;
		}
		
		if(pageRangeLast<pageCnt) {
			nextRange=true;
			
		}else {
			nextRange=false;
		}
		
		map.put("pageCnt", pageCnt);
		map.put("pageRangeLast", pageRangeLast);
		map.put("pageRangeFirst", pageRangeFirst);
		map.put("nextRange", nextRange);

		return map;
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
