package com.webpage.DAO.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public void deleteCart(String memberId, int itemId) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("itemId", itemId);
		
		sqlSession.delete("mapper.deleteCart",map);
		
	}

}
