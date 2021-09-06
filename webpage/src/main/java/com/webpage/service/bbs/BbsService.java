package com.webpage.service.bbs;

import java.util.List;
import java.util.Map;

import com.webpage.DAO.bbs.BbsDTO;

public interface BbsService {

	List<BbsDTO> getBbs(int pageNum);

	Map<String, Object> getPagingService(int pageNum);

	void setBbs(BbsDTO bbsDTO);

	BbsDTO getBbsView(int bbsId);

	void setBbsModify(String bbsTitle, String bbsContents, int bbsId);

	void deleteBbs(int bbsId);

}
