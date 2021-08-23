package com.webpage.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webpage.DAO.cart.CartDAO;
import com.webpage.DAO.cart.CartDTO;
import com.webpage.DAO.orderInfo.OrderInfoDAO;
import com.webpage.DAO.orderInfo.OrderInfoDTO;
import com.webpage.DAO.orderItem.OrderItemDAO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderInfoDAO orderInfoDAO;
	
	@Autowired
	OrderItemDAO orderItemDAO;

	@Override
	public List<CartDTO> readCartOrderService(String memberId) {
		List<CartDTO> list=cartDAO.getCartAjax(memberId);
		return list;
	}

	@Transactional
	@Override
	public void setOrder(OrderInfoDTO orderInfo) {
		
		int orderId=orderInfoDAO.setOrderInfo(orderInfo);
		orderItemDAO.setOrderItem(orderInfo,orderId);
	
	
		
		
	}

}
