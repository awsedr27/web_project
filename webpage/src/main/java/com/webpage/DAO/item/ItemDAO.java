package com.webpage.DAO.item;

import java.util.List;

public interface ItemDAO {
	
	public List<ItemDTO> getItemDAO();
	public List<ItemDTO> getItemAjax(int pageNum);
	public ItemDTO getItemView(int itemId);
	public List<ItemDTO> getCategoryItemDAO(String category);
	public List<ItemDTO> getCategoryItemAjax(int lastIdNum, String category);

}
