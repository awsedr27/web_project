package com.webpage.DAO.item;

import java.util.List;

import com.webpage.DAO.orderInfo.OrderInfoDTO;

public interface ItemDAO {
	
	public List<ItemDTO> getItemDAO();
	public List<ItemDTO> getItemAjax(int pageNum);
	public ItemDTO getItemView(int itemId);
	public List<ItemDTO> getCategoryItemDAO(String category,int categoryPage);
	public List<ItemDTO> getCategoryItemAjax(int lastIdNum, String category);
	public void setRemainder(OrderInfoDTO orderInfo);
	public List<ItemDTO> getHotItem(int categoryPage);
	public List<ItemDTO> getDiscountItem(int categoryPage);
	public int getCountPage();
	public int getDiscountPageCount();

}
