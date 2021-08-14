package com.webpage.service.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webpage.DAO.cart.CartDAO;
import com.webpage.DAO.cart.CartDTO;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartDAO cartDAO;

	@Override
	public List<CartDTO> getCartAjaxService(String memberId) {
		
		List<CartDTO> list=cartDAO.getCartAjax(memberId);
		
		return list;
	}

	@Override
	public void setCartService(CartDTO cart) {
		cartDAO.setCartDAO(cart);
		
	}

	@Override
	public void deleteCart(String memberId, int itemId) {
		cartDAO.deleteCart(memberId,itemId);
		
	}

}
