package com.webpage.DAO.bbs;

import java.util.List;

public interface BbsDAO {

	List<BbsDTO> getBbs(int pageNum);

	int getPageCnt();

	void setBbs(BbsDTO bbsDTO);

}
