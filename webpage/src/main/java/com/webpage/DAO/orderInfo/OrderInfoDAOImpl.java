package com.webpage.DAO.orderInfo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderInfoDAOImpl implements OrderInfoDAO {
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public int setOrderInfo(OrderInfoDTO orderInfo) {
		sqlSession.insert("mapper.setOrderInfo", orderInfo);
		int orderId=sqlSession.selectOne("mapper.getOrderId");
		return orderId;
	}

}
