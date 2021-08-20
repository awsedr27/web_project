package com.webpage.service.bbs;

import java.util.List;

import com.webpage.DAO.bbs.BbsDTO;

public interface BbsService {

	List<BbsDTO> getBbs(int pageNum);

	int getPageCnt();

	void setBbs(BbsDTO bbsDTO);

	BbsDTO getBbsView(int bbs_id);

	void setBbsModify(String bbs_title, String bbs_contents, int bbs_id);

	void deleteBbs(int bbs_id);

}
