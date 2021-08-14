package com.webpage.service.cart;

import java.util.List;

import com.webpage.DAO.cart.CartDTO;

public interface CartService {

	 public List<CartDTO> getCartAjaxService(String memberId);

	public void setCartService(CartDTO cart);

	public void deleteCart(String memberId, int itemId);

}
