package com.webpage.DAO.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<CartDTO> getCartAjax(String memberId) {
		List<CartDTO> listAjax=sqlSession.selectList("mapper.getAjaxCart",memberId);

		return listAjax;
	}

	@Override
	public void setCartDAO(CartDTO cart) {
		sqlSession.insert("mapper.setCart", cart);
		
	}

}
