package com.webpage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webpage.DAO.item.ItemDTO;
import com.webpage.DAO.review.ReviewDTO;
import com.webpage.service.item.ItemService;
import com.webpage.service.review.ReviewService;

@Controller
public class ItemViewController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ReviewService reviewService;
	
	
	@RequestMapping("/itemView")
	public String itemViewController(Model model,@RequestParam(value="itemId",required = false) Integer itemId) {
		
		if(itemId==null) {
			
			
			return "redirect:/index";

		}else {
			
			
		ItemDTO itemView=itemService.getItemView(itemId);
		List<ReviewDTO> review=reviewService.getReview(itemId);
		model.addAttribute("itemView",itemView); 
		model.addAttribute("review",review); 
		
		return "itemView";
		}
	}

}
