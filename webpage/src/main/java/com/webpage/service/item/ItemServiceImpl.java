package com.webpage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webpage.DAO.ItemDAO;
import com.webpage.DAO.ItemDTO;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDAO itemDAO;
	
	
	@Override
	public List<ItemDTO> getItemService() {
		
		List<ItemDTO> item=itemDAO.getItemDAO();
		
		return item;
	}


	@Override
	public List<ItemDTO> getItemAjaxService(int pageNum) {
		List<ItemDTO> itemAjax=itemDAO.getItemAjax(pageNum);
		return itemAjax;
	}

}
