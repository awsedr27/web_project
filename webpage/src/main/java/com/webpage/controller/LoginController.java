package com.webpage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webpage.DAO.ItemDAO;
import com.webpage.DAO.ItemDTO;
import com.webpage.service.ItemService;

@RestController
public class LoginController{
	
	@Autowired
	private ItemService itemSerivce;
	
	@RequestMapping("/index/ajax2")
	public List<ItemDTO> itemController(Model model) {
		List<ItemDTO> itemList=itemSerivce.getItemService();
		return itemList;
	}


	}

	

