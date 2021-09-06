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

import com.webpage.DAO.bbs.BbsDTO;
import com.webpage.service.bbs.BbsService;

@Controller
public class BbsController {
	
	@Autowired
	BbsService bbsService;
	
	@RequestMapping("/bbs")
	public String bbs(Model model,@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum) {
		
		List<BbsDTO>list=bbsService.getBbs(pageNum);
		Map<String,Object> pageMap=bbsService.getPagingService(pageNum);
		model.addAttribute("pageRangeLast", pageMap.get("pageRangeLast"));
		model.addAttribute("pageRangeFirst", pageMap.get("pageRangeFirst"));
		model.addAttribute("nextRange", pageMap.get("nextRange"));
		model.addAttribute("pageCnt", pageMap.get("pageCnt"));
		
		model.addAttribute("bbsList", list);
		
		
		return "bbs";
		
	}
	
	@RequestMapping("/bbs/write")
	public String bbsWrite(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		if(memberId==null) {
			return "redirect:/signIn";
		}else {
		return "bbsWrite";
		}
	}
	
	@RequestMapping(value = "/bbs/put" ,method = RequestMethod.POST)
	public String bbsPut(HttpServletRequest request,@RequestParam("bbsTitle") String bbsTitle,@RequestParam("bbsContents") String bbsContents) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		if(memberId==null) {
			return "redirect:/signIn";
		}else {
			if (bbsContents.length() < 101) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = dateFormat.format(new java.util.Date());
				Date bbsTime = java.sql.Date.valueOf(dateString);
				BbsDTO bbsDTO = new BbsDTO();
				bbsDTO.setMemberId(memberId);
				bbsDTO.setBbsTitle(bbsTitle);
				bbsDTO.setBbsContents(bbsContents);
				bbsDTO.setBbsTime(bbsTime);

				bbsService.setBbs(bbsDTO);

				return "redirect:/bbs";
			}else {
				return "redirect:/bbs";	
			}
			
		}
		
		
	}
	
	@RequestMapping("bbs/view")
	public String bbsView(Model model,@RequestParam("bbsId") int bbsId) {
		BbsDTO bbs = bbsService.getBbsView(bbsId);
		model.addAttribute("bbsView", bbs);
		
		return "bbsView";
	}
	
	@RequestMapping("bbs/modify")
	public String bbsModify(HttpServletRequest request,Model model,@RequestParam("bbsId") int bbsId) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		BbsDTO bbs = bbsService.getBbsView(bbsId);
		if(bbs.getMemberId().equals(memberId)) {
			model.addAttribute("bbs", bbs);
			
			return "bbsModify";
		}else {
			
			model.addAttribute("modify", false);
			return "bbsModify";
		}
		
	}
	@ResponseBody
	@RequestMapping(value = "/bbs/modify_action",method = RequestMethod.POST)
	public String bbsModify_Action(HttpServletRequest request,@RequestParam("bbsId") int bbsId, @RequestParam("bbsTitle") String bbsTitle,
			@RequestParam("bbsContents") String bbs_contents,@RequestParam("memberId") String memberId) {
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("memberId");
		if(userId.equals(memberId)) {
			if(bbs_contents.length()<101) {
				bbsService.setBbsModify(bbsTitle,bbs_contents,bbsId);
				return "<script>alert('수정완료');location.href='/bbs'</script>";	
			}
			else {
				return "<script>alert('수정실패, 글자수제한을 넘었습니다.');location.href='/bbs'</script>";
			}
			
		}else {
			return "<script>alert('글쓴이가 아닙니다');location.href='/bbs'</script>";
			
		}
		

	}
	@ResponseBody
	@RequestMapping("bbs/delete")
	public String bbsDelete(HttpServletRequest request,@RequestParam("bbsId") int bbsId,@RequestParam("memberId") String memberId) {
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("memberId");
		
		if(userId.equals(memberId)) {
			bbsService.deleteBbs(bbsId);
			
			return "<script>alert('삭제완료');location.href='/bbs'</script>";
		}
		else {
			return "<script>alert('글쓴이가 아닙니다');location.href='/bbs'</script>";
		}


		
		
	}
	

}
