package com.webpage.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webpage.DAO.item.ItemDAO;
import com.webpage.DAO.item.ItemDTO;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDAO itemDAO;

	@Override
	public List<ItemDTO> getItemService() {

		List<ItemDTO> item = itemDAO.getItemDAO();

		return item;
	}

	@Override
	public List<ItemDTO> getItemAjaxService(int pageNum) {
		List<ItemDTO> itemAjax = itemDAO.getItemAjax(pageNum);
		return itemAjax;
	}

	@Override
	public ItemDTO getItemView(int itemId) {
		ItemDTO item = itemDAO.getItemView(itemId);
		return item;
	}

	@Override
	public List<ItemDTO> getCategory(String category) {

		List<ItemDTO> item = itemDAO.getCategoryItemDAO(category);

		return item;
	}

	@Override
	public List<ItemDTO> getCategoryItemAjaxService(int lastIdNum, String category) {
		List<ItemDTO> item = itemDAO.getCategoryItemAjax(lastIdNum,category);
		return item;
	}

	@Override
	public List<ItemDTO> getHotItem() {
		List<ItemDTO> item = itemDAO.getHotItem();
		return item;
	}

	@Override
	public List<ItemDTO> getDiscountItem() {
		List<ItemDTO> item = itemDAO.getDiscountItem();
		return item;
	}

}
