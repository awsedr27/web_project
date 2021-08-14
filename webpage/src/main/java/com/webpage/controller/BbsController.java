package com.webpage.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webpage.DAO.bbs.BbsDTO;
import com.webpage.service.bbs.BbsService;

@Controller
public class BbsController {
	
	@Autowired
	BbsService bbsService;
	
	@RequestMapping("/bbs")
	public String bbs(Model model,@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum) {
		
		List<BbsDTO>list=bbsService.getBbs(pageNum);
		int pageCnt=bbsService.getPageCnt();
		if(pageCnt==0) {
			pageCnt++;
		}
		int pageRange= (5*((int)Math.floor(pageCnt/5)))+1;
		
		
		
		model.addAttribute("bbsPageCnt", pageCnt);
		model.addAttribute("bbsPageRange", pageRange);
		model.addAttribute("bbsList", list);
		
		return "bbs";
		
	}
	
	@RequestMapping("/write")
	public String bbsWrite() {
		return "write";
		
	}
	
	@RequestMapping("bbs/put")
	public String bbsPut(HttpServletRequest request,@RequestParam("bbs_title") String bbs_title,@RequestParam("bbs_contents") String bbs_contents) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
	
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String dateString=dateFormat.format(new java.util.Date());
		Date bbs_time=java.sql.Date.valueOf(dateString);
		BbsDTO bbsDTO=new BbsDTO();
		bbsDTO.setMemberId(memberId);
		bbsDTO.setBbs_title(bbs_title);
		bbsDTO.setBbs_contents(bbs_contents);
		bbsDTO.setBbs_time(bbs_time);
		
		bbsService.setBbs(bbsDTO);
		return "redirect:/bbs";
		
	}

}
