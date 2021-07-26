package com.webpage.service;

import java.util.List;

import com.webpage.DAO.ItemDTO;

public interface ItemService {
	List<ItemDTO> getItemService();
	List<ItemDTO> getItemAjaxService(int pageNum);


}
