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

	@Override
	public List<CartDTO> readCartService(String memberId) {
		List<CartDTO> list=cartDAO.getCartAjax(memberId);
		return list;
	}

	@Transactional
	@Override
	public void setOrder(OrderInfoDTO orderInfo) {
		
		int orderId=orderInfoDAO.setOrderInfo(orderInfo);
		orderItemDAO.setOrderItem(orderInfo,orderId);
		itemDAO.setRemainder(orderInfo);
		cartDAO.setDeleteAllCart(orderInfo);
		

	}

	@Transactional
	@Override
	public List<CartDTO> readCartOrderService(OrderInfoDTO orderInfo) {
		try {
			CartDTO cart=new CartDTO();
			List<CartDTO> list=new ArrayList<CartDTO>();
			for(int i=0;i<orderInfo.getOrderItemList().size();i++) {
				cart.setItemId(orderInfo.getOrderItemList().get(i).getItemId());
				cart.setMemberId(orderInfo.getMemberId());
				boolean check=cartDAO.checkCart(cart);
				if(check) {
					ItemDTO itemDTO=itemDAO.getItemView(cart.getItemId());
					cart.setItemUrl(itemDTO.getItemUrl());
					cart.setItemName(itemDTO.getItemName());
					cart.setItemPrice(itemDTO.getItemPrice());
					cart.setDiscount(itemDTO.isDiscount());
					cart.setDiscountNum(itemDTO.getDiscountNum());
					cart.setPopularity(itemDTO.getPopularity());
					cart.setCategory(itemDTO.getCategory());
					cart.setQuantity(orderInfo.getOrderItemList().get(i).getQuantity());
					
				}else {
					cart.setQuantity(orderInfo.getOrderItemList().get(i).getQuantity());
					cartDAO.updateCartDAO(cart);
					cart=cartDAO.getCartItem(orderInfo.getMemberId(),orderInfo.getOrderItemList().get(i).getItemId());
				}
				list.add(i, cart);
			}
			
			
			return list;
			
		}catch(Exception e){
			
			
			return null;
		}
		
	}

	@Override
	public void deleteOrderService(int orderId, String memberId) {
		orderInfoDAO.deleteOrder(orderId,memberId);
		
	}

}
