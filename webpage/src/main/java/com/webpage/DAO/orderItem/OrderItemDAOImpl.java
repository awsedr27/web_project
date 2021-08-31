package com.webpage.DAO.orderItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webpage.DAO.orderInfo.OrderInfoDTO;
import com.webpage.DAO.review.ReviewDTO;

@Repository
public class OrderItemDAOImpl implements OrderItemDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void setOrderItem(OrderInfoDTO orderInfo, int orderId) {
		for(int i=0;i<orderInfo.getOrderItemList().size();i++) {
			orderInfo.getOrderItemList().get(i).setMemberId(orderInfo.getMemberId());
			orderInfo.getOrderItemList().get(i).setOrderId(orderId);
			sqlSession.insert("mapper.setOrderItem",orderInfo.getOrderItemList().get(i));
		}
		
		
	}

	@Override
	public List<OrderItemDTO> getOrderItem(int orderId) {
		List<OrderItemDTO> list=sqlSession.selectList("mapper.getOrderItem", orderId);
		return list;
	}

	@Override
	public String isPurchase(String memberId, int itemId) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("itemId", itemId);
		OrderItemDTO writeReviewBtn=sqlSession.selectOne("mapper.isPurchase", map);
		if(writeReviewBtn==null) {
			return "NotPurchase";
		}else {
			return "Purchase";
		}
		
	}

	

}
