package com.webpage.DAO.bbs;

import java.util.List;

public interface BbsDAO {

	List<BbsDTO> getBbs(int pageNum);

	int getPageCnt();

	void setBbs(BbsDTO bbsDTO);

	BbsDTO getBbsView(int bbs_id);

	void setBbsModify(String bbs_title, String bbs_contents, int bbs_id);

	void deleteBbs(int bbs_id);

}
