package com.webpage.DAO.orderInfo;

import java.util.List;

public interface OrderInfoDAO {

	int setOrderInfo(OrderInfoDTO orderInfo);

	List<OrderInfoDTO> getMemberOrderDAO(String memberId);

	void deleteOrder(int orderId, String memberId);

}
