package com.webpage.DAO.cart;

import java.util.List;

import com.webpage.DAO.orderInfo.OrderInfoDTO;

public interface CartDAO {

	List<CartDTO> getCartAjax(String memberId);

	void setCartDAO(CartDTO cart);

	void deleteCart(String memberId, int itemId);

	void setDeleteAllCart(OrderInfoDTO orderInfo);

	boolean checkCart(CartDTO cart);

	void updateCartDAO(CartDTO cart);

}
