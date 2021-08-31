package com.webpage.DAO.orderItem;

import java.util.List;

import com.webpage.DAO.orderInfo.OrderInfoDTO;

public interface OrderItemDAO {

	void setOrderItem(OrderInfoDTO orderInfo, int orderId);
	List<OrderItemDTO> getOrderItem(int orderId);
	String isPurchase(String memberId, int itemId);


}
