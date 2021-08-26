package com.webpage.DAO.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webpage.DAO.orderInfo.OrderInfoDTO;

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

	@Override
	public void setDeleteAllCart(OrderInfoDTO orderInfo) {
		String memberId=orderInfo.getMemberId();
		sqlSession.delete("mapper.deleteAllCart",memberId);
		
	}

	@Override
	public boolean checkCart(CartDTO cart) {
		CartDTO checkCart=sqlSession.selectOne("mapper.checkCart",cart);
		if(checkCart==null) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public void updateCartDAO(CartDTO cart) {
		sqlSession.update("mapper.updateCart",cart);
		
	}

	@Override
	public CartDTO getCartItem(String memberId, int itemId) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("itemId", itemId);
		CartDTO cartDTO=sqlSession.selectOne("mapper.getCartItem",map);

		return cartDTO;
	}

}
