package com.webpage.DAO;

import java.util.List;

public interface ItemDAO {
	
	public List<ItemDTO> getItemDAO();
	public List<ItemDTO> getItemAjax(int pageNum);
	

}
