package com.webpage.DAO.cart;

import java.util.List;

public interface CartDAO {

	List<CartDTO> getCartAjax(String memberId);

	void setCartDAO(CartDTO cart);

	void deleteCart(String memberId, int itemId);

}
