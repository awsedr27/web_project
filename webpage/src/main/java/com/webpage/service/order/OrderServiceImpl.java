package com.webpage.service.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webpage.DAO.cart.CartDAO;
import com.webpage.DAO.cart.CartDTO;
import com.webpage.DAO.item.ItemDAO;
import com.webpage.DAO.item.ItemDTO;
import com.webpage.DAO.orderInfo.OrderInfoDAO;
import com.webpage.DAO.orderInfo.OrderInfoDTO;
import com.webpage.DAO.orderItem.OrderItemDAO;
import com.webpage.DAO.orderItem.OrderItemDTO;
import com.webpage.DAO.payment.PaymentDAO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderInfoDAO orderInfoDAO;
	
	@Autowired
	OrderItemDAO orderItemDAO;
	
	@Autowired
	ItemDAO itemDAO;
	
	@Autowired
	PaymentDAO paymentDAO;

	@Override
	public List<CartDTO> readCartService(String memberId) {
		List<CartDTO> list=cartDAO.getCartAjax(memberId);
		return list;
	}

	@Transactional
	@Override
	public void setOrder(String memberId,OrderInfoDTO orderInfo) {
		   orderInfo.setMemberId(memberId);
		   List<CartDTO> list=paymentDAO.getPayment(memberId);
		   
		   List<OrderItemDTO> listOrder=new ArrayList<OrderItemDTO>();
		for(int i=0;i<list.size();i++) {
			OrderItemDTO orderItemDTO= new OrderItemDTO();
			orderItemDTO.setItemId(list.get(i).getItemId());
			orderItemDTO.setItemName(list.get(i).getItemName());
			orderItemDTO.setItemPrice(list.get(i).getItemPrice());
			orderItemDTO.setDiscountNum(list.get(i).getDiscountNum());
			orderItemDTO.setDiscount(list.get(i).isDiscount());
			orderItemDTO.setQuantity(list.get(i).getQuantity());
			orderItemDTO.setMemberId(list.get(i).getMemberId());
			
			listOrder.add(i,orderItemDTO);
			
		}
		
		orderInfo.setOrderItemList(listOrder);
		int orderId=orderInfoDAO.setOrderInfo(orderInfo);
		orderItemDAO.setOrderItem(orderInfo,orderId);
		itemDAO.setRemainder(orderInfo);
		cartDAO.setDeleteAllCart(orderInfo);
		paymentDAO.deletePayment(memberId);

	}

	@Transactional
	@Override
	public List<CartDTO> readCartOrderService(String memberId) {
		
		List<CartDTO> list=cartDAO.getCartAjax(memberId);
		if(list.isEmpty()) {
			return null;
		}else {
			paymentDAO.deletePayment(memberId);
			paymentDAO.setPayment(list);
			return list;
		}
	}

	@Override
	public void deleteOrderService(int orderId, String memberId) {
		orderInfoDAO.deleteOrder(orderId,memberId);
		
	}

}
