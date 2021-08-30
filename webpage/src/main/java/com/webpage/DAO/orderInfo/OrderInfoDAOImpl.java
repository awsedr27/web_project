package com.webpage.DAO.orderInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


	@Override
	public List<OrderInfoDTO> getMemberOrderDAO(String memberId) {
		List<OrderInfoDTO> list=sqlSession.selectList("mapper.getMemberOrder", memberId);
		return list;
	}


	@Override
	public void deleteOrder(int orderId, String memberId) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("orderId", orderId);
		map.put("memberId", memberId);
		
		
		sqlSession.delete("mapper.deleteOrder", map);
		
	}

}
