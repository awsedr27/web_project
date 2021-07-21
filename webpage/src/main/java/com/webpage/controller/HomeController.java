package com.webpage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webpage.DAO.ItemDAO;
import com.webpage.DAO.ItemDTO;

@Controller
public class HomeController {
	
	@Autowired
	ItemDAO itemDAO;
	
	@RequestMapping("/index")
	public String itemController(Model model) {
		List<ItemDTO> itemList=itemDAO.getTime();
		model.addAttribute("itemList",itemList);
		
		return "index";
	}

}
