package com.webpage.DAO.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ItemDTO> getItemDAO() {
		List<ItemDTO> listDAO=sqlSession.selectList("mapper.getLimitItem");
		return listDAO;
		
	

}

	@Override
	public List<ItemDTO> getItemAjax(int lastIdNum) {
		
		List<ItemDTO> listAjax=sqlSession.selectList("mapper.getAjaxItem",lastIdNum);

		return listAjax;
	}

	@Override
	public ItemDTO getItemView(int itemId) {
	
		ItemDTO item=sqlSession.selectOne("mapper.getItemView", itemId);
		return item;
	}

	@Override
	public List<ItemDTO> getCategoryItemDAO(String category) {
		
		List<ItemDTO> listDAO=sqlSession.selectList("mapper.getCategoryItem",category);
		return listDAO;
	}

	@Override
	public List<ItemDTO> getCategoryItemAjax(int lastIdNum, String category) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("lastIdNum", lastIdNum);
		map.put("category", category);
		
		List<ItemDTO> listDAO=sqlSession.selectList("mapper.getCategoryAjaxItem",map);
		return listDAO;
	}

}
