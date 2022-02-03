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
import com.webpage.DAO.review.ReviewDAO;

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
	
	@Autowired
	ReviewDAO reviewDAO;

	@Transactional
	@Override
	public List<CartDTO> readCartService(String memberId,CartDTO cartDTO) {
		ItemDTO item=itemDAO.getItemView(cartDTO.getItemId());
		cartDTO.setMemberId(memberId);
		cartDTO.setItemPrice(item.getItemPrice());
		cartDTO.setItemName(item.getItemName());
		cartDTO.setItemUrl(item.getItemUrl());
		cartDTO.setDiscount(item.isDiscount());
		cartDTO.setDiscountNum(item.getDiscountNum());
		cartDTO.setPopularity(item.getPopularity());
		cartDTO.setCategory(item.getCategory());
		List<CartDTO> list =new ArrayList<CartDTO>();
		list.add(0,cartDTO);
		
		paymentDAO.deletePayment(memberId);
		paymentDAO.setPayment(list);
		
		if(list.isEmpty()) {
			return null;
		}else {
			return list;
		}
		
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

	@Transactional
	@Override
	public void deleteOrderService(int orderId, String memberId) {
		List<OrderItemDTO> list=orderItemDAO.getOrderItem(orderId,memberId);
		for(int i=0;i<list.size();i++) {
			
			int rating=reviewDAO.getReviewContentsView(memberId, list.get(i).getItemId()).getRating();
			int popularity=itemDAO.getPopularity(list.get(i).getItemId());
			if(popularity-rating>0) {
				popularity=popularity-rating;
				itemDAO.setPopularity(popularity, list.get(i).getItemId());
			}else {
				itemDAO.setPopularity(0, list.get(i).getItemId());
			}
			
			
			reviewDAO.deleteReviewDAO(list.get(i).getItemId(), memberId);
			
		}
		
		
		orderInfoDAO.deleteOrder(orderId,memberId);
		
	}

}
