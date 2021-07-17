package com.webpage.DAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ItemDAO {

	@Autowired
	private DataSource dataSource;
}
