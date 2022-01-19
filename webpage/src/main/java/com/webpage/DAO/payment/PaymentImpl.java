package com.webpage.DAO.payment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webpage.DAO.cart.CartDTO;

@Repository
public class PaymentImpl implements PaymentDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void setPayment(List<CartDTO> list) {
		for(int i=0;i<list.size();i++) {
			sqlSession.insert("mapper.setPayment", list.get(i));

		}
		
		
	}

	@Override
	public List<CartDTO> getPayment(String memberId) {
		List<CartDTO> list=sqlSession.selectList("mapper.getPayment", memberId);
		
		return list;
	}

	@Override
	public void deletePayment(String memberId) {
		sqlSession.delete("mapper.deletePayment", memberId)	;	
	}

}
