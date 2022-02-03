package com.webpage.service.order;

import java.util.List;

import com.webpage.DAO.cart.CartDTO;
import com.webpage.DAO.orderInfo.OrderInfoDTO;

public interface OrderService {

	List<CartDTO> readCartService(String memberId, CartDTO cart);

	

	List<CartDTO> readCartOrderService(String memberId);

	void deleteOrderService(int orderId, String memberId);

	void setOrder(String memberId,OrderInfoDTO orderInfo);

}
