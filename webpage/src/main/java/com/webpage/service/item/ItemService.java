package com.webpage.service.item;

import java.util.List;

import com.webpage.DAO.item.ItemDTO;

public interface ItemService {
	List<ItemDTO> getItemService();
	List<ItemDTO> getItemAjaxService(int pageNum);
	ItemDTO getItemView(int itemId);
	List<ItemDTO> getCategoryItemAjaxService(int lastIdNum, String category);
	List<ItemDTO> infinityPageService(String category, int categoryPage);


}
