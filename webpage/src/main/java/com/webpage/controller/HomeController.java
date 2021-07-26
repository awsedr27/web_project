package com.webpage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webpage.DAO.ItemDTO;
import com.webpage.service.ItemService;

@Controller
public class HomeController {
	
	@Autowired
	private ItemService itemSerivce;
	
	@RequestMapping("/index")
	public String itemController(Model model) {
		List<ItemDTO> itemList=itemSerivce.getItemService();
		model.addAttribute("itemList",itemList);
		
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/index/ajax")
	public List<ItemDTO> itemAjax(HttpServletRequest request){
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		List<ItemDTO> list=itemSerivce.getItemAjaxService(pageNum);
		return list;
		
	}
	



}
