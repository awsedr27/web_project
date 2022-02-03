package com.webpage.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webpage.DAO.bbs.BbsDTO;
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
	public String itemViewController(HttpServletRequest request,Model model,@RequestParam(value="itemId",required = false) Integer itemId) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		
		
		if(itemId==null) {
			return "redirect:/index";

		}else {
		if(memberId==null) {
			ItemDTO itemView=itemService.getItemView(itemId);
			String writeReviewBtn="NotLogIn";
			model.addAttribute("itemView",itemView); 
			model.addAttribute("writeBtnExist",writeReviewBtn); 
			
			return "itemView";
			
		}else {
			
			
			ItemDTO itemView=itemService.getItemView(itemId);

			String writeReviewBtn=reviewService.getWriteReviewBtn(memberId,itemView.getItemId());
			model.addAttribute("itemView",itemView); 
			model.addAttribute("writeBtnExist",writeReviewBtn); 
			
			return "itemView";
			
			
		}
			
	   
		
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/review",method = RequestMethod.POST)
	public List<ReviewDTO> Review(@RequestParam("itemId") int itemId,@RequestParam(value = "reviewPageNum",defaultValue = "1") int reviewPageNum) {
			List<ReviewDTO> review=reviewService.getReview(itemId,reviewPageNum);
			
			return review;
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/writeReview",method=RequestMethod.POST)
	public void writeReview(HttpServletRequest request,ReviewDTO review) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		
		if(memberId==null) {
			
		}else {
			reviewService.setReview(review,memberId);
			
		}
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/reviewPaging",method=RequestMethod.POST)
	public Map<String,Object> reviewPaging(@RequestParam(value = "reviewPageNum",defaultValue = "1") int reviewPageNum,@RequestParam(value = "itemId",required = false) Integer itemId) {
		
			
		
            Map<String,Object> pageMap=reviewService.getPagingService(reviewPageNum,itemId);
			
			
			return pageMap;
		
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/reviewContentsView",method=RequestMethod.POST)
	public ReviewDTO reviewContentsView(@RequestParam("itemId") int itemId,@RequestParam("memberId") String memberId) {
		
		ReviewDTO reviewContents=reviewService.getReviewContentsViewService(memberId,itemId);
		
		
		return reviewContents;
   
}
	
	@ResponseBody
	@RequestMapping(value = "/deleteReview",method=RequestMethod.POST)
	public void deleteReview(HttpServletRequest request,@RequestParam("itemId") int itemId) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		if(memberId==null) {
			
		}else {
			reviewService.deleteReviewService(itemId,memberId);
			
			
		}
		
		
	}

}
