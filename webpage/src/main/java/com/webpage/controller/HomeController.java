package com.webpage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webpage.DAO.item.ItemDTO;
import com.webpage.service.item.ItemService;

@Controller
public class HomeController {
	
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping("/index")
	public String itemController(Model model) {
		List<ItemDTO> itemList=itemService.getItemService();
		model.addAttribute("itemList",itemList);
		
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/index/ajax")
	public List<ItemDTO> itemAjax(@RequestParam("lastIdNum") int lastIdNum){
		List<ItemDTO> list=itemService.getItemAjaxService(lastIdNum);
		return list;
		
	}
	



}
