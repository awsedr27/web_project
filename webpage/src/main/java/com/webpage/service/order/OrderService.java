package com.webpage.service.order;

import java.util.List;

import com.webpage.DAO.cart.CartDTO;
import com.webpage.DAO.orderInfo.OrderInfoDTO;

public interface OrderService {

	List<CartDTO> readCartService(String memberId);

	void setOrder(OrderInfoDTO orderInfo);

	List<CartDTO> readCartOrderService(OrderInfoDTO orderInfo);

}
