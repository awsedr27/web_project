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
	public String category(Model model,@RequestParam(value="category",required = false) String category,@RequestParam(value="categoryPage",defaultValue = "1") int categoryPage) {
	
		
		if(category==null) {
			
			return "redirect:/index";
		}
		else {
			
			List<ItemDTO> list=itemService.infinityPageService(category,categoryPage);
			if(list==null) {
				return "redirect:/index";

			}else {
                model.addAttribute("itemList", list);
				
				return "index";
				
			}
			
				
			}
		
		}
	@ResponseBody
	@RequestMapping("/category/ajax")
	public List<ItemDTO> categoryAjax(@RequestParam("category") String category,@RequestParam("categoryPage") int categoryPage){
		List<ItemDTO> list=itemService.infinityPageService(category, categoryPage);
		
			return list;
		
		
		
		
	}
	
	
	
	
	

}
