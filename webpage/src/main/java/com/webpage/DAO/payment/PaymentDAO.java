package com.webpage.DAO.payment;

import java.util.List;

import com.webpage.DAO.cart.CartDTO;

public interface PaymentDAO {

	void setPayment(List<CartDTO> list);
	List<CartDTO> getPayment(String memberId);
	void deletePayment(String memberId);

}
