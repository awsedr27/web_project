package com.webpage.service.bbs;

import java.util.List;

import com.webpage.DAO.bbs.BbsDTO;

public interface BbsService {

	List<BbsDTO> getBbs(int pageNum);

	int getPageCnt();

	void setBbs(BbsDTO bbsDTO);

}
