package com.webpage.DAO;

import java.util.List;

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
	public List<ItemDTO> getItemAjax(int pageNum) {
		pageNum=pageNum*6;
		List<ItemDTO> listAjax=sqlSession.selectList("mapper.getAjaxItem",pageNum);

		return listAjax;
	}

}
