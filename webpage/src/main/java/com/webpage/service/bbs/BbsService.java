package com.webpage.service.bbs;

import java.util.List;

import com.webpage.DAO.bbs.BbsDTO;

public interface BbsService {

	List<BbsDTO> getBbs(int pageNum);

	int getPageCnt();

	void setBbs(BbsDTO bbsDTO);

	BbsDTO getBbsView(int bbsId);

	void setBbsModify(String bbsTitle, String bbsContents, int bbsId);

	void deleteBbs(int bbsId);

}
