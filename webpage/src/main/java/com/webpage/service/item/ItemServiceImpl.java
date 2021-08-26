package com.webpage.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<ItemDTO> getCategoryItemAjaxService(int lastIdNum, String category) {
		List<ItemDTO> item = itemDAO.getCategoryItemAjax(lastIdNum,category);
		return item;
	}

	
	@Transactional
	@Override
	public List<ItemDTO> infinityPageService(String category, int categoryPage) {
		 
		int limitValue=(categoryPage-1)*6;
		
		if(category.equals("hotItem")) {
			int hotItemPageCount=(int) Math.ceil((itemDAO.getCountPage()/6.0));
			if(categoryPage<=hotItemPageCount) {
			    List<ItemDTO> list=itemDAO.getHotItem(limitValue);
			    return list;
			}else {
				return null;
			}
			
		}else if(category.equals("discountItem")) {
			int discountPageCount=(int) Math.ceil(itemDAO.getDiscountPageCount()/6.0);
			if(categoryPage<=discountPageCount) {
			    List<ItemDTO> list=itemDAO.getDiscountItem(limitValue);
			    return list;
			}else {
				return null;
			}
			
		} 
		else {
			int categoryPageCount=(int) Math.ceil((itemDAO.getCountPage()/6.0));
			if(categoryPage<=categoryPageCount) {
			    List<ItemDTO> list=itemDAO.getCategoryItemDAO(category,limitValue);
			    return list;
			}else {
				return null;
			}
			
		}
		
	}
	
	

}
