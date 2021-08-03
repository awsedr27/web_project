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
public class CategoryController {
	
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping("/category")
	public String category(Model model,@RequestParam(value="category",required = false) String category) {
	
		if(category==null) {
			
			return "redirect:/index";
		}
		else {
		List<ItemDTO> itemList=itemService.getCategory(category);
		model.addAttribute("itemList",itemList);
		
		return "index";
		}
	}
	
	
	@ResponseBody
	@RequestMapping("/category/ajax")
	public List<ItemDTO> itemAjax(@RequestParam("category") String category,@RequestParam("lastIdNum") int lastIdNum){
		List<ItemDTO> list=itemService.getCategoryItemAjaxService(lastIdNum,category);
		return list;
		
	}

}
