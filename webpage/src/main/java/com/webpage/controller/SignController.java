package com.webpage.controller;

import java.util.HashMap;
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

import com.webpage.DAO.member.MemberDTO;
import com.webpage.DAO.orderInfo.OrderInfoDTO;
import com.webpage.DAO.orderItem.OrderItemDTO;
import com.webpage.service.member.MemberService;

@Controller
public class SignController {
	
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping(value="/signIn",method=RequestMethod.GET)
	public String signIn(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		if(memberId==null) {
			return "signIn";
		}else {
			return "redirect:/index";
		}
		
	}
	
	@RequestMapping(value="/signIn",method=RequestMethod.POST)
	public String signIn(Model model,HttpServletRequest request,@RequestParam("userID") String memberId,@RequestParam("userPassword") int password) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("memberPassword", password);
		HttpSession session=request.getSession();
		
		boolean signIn=memberService.getMember(map);
		if(signIn==true) {
			session.setAttribute("memberId", memberId);
			return "redirect:/index";
			
		}
		else {
			model.addAttribute("url", "signIn");
			model.addAttribute("msg", "로그인 실패");
			return "/redirect";
		}
		
		
		
		
	}
	
	@RequestMapping("/signOut")
	public String signOut(Model model,HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		model.addAttribute("url", "index");
		model.addAttribute("msg", "로그아웃 하셨습니다");
		return "/redirect";
		

	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public String signUp(Model model,HttpServletRequest request) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		if(memberId==null) {
			return "signUp";
		}else {
			model.addAttribute("url", "index");
			model.addAttribute("msg", "이미 로그인하셨습니다");
			return "/redirect";
			
		}
		
		
		
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String signUp(Model model,MemberDTO memberDTO) {
		
		try {
		memberService.setMember(memberDTO);
		model.addAttribute("url", "signIn");
		model.addAttribute("msg", "회원가입 성공!");
		return "/redirect";
		}
		catch(Exception e){
			model.addAttribute("url", "signIn");
			model.addAttribute("msg", "회원가입 실패");
			return "/redirect";
		}
		
	}
	
	@RequestMapping("/myInfo")
	public String myInfo(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		if(memberId==null) {
			return "redirect:/signIn";
		}
		else {
			MemberDTO memberDTO=memberService.getMemberInfo(memberId);
			List<OrderInfoDTO> orderItemList=memberService.getMemberOrderService(memberId);
			model.addAttribute("memberInfo", memberDTO);
			model.addAttribute("memberInfoOrder", orderItemList);
			
			return "myInfo";
		}

	}
	
	@RequestMapping("/myInfo/modify")
	public String myInfoModify(HttpServletRequest request,Model model,@RequestParam(value = "mode" ,required = false) String mode) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		if(memberId==null) {
			return "redirect:/signIn";
		}
		else {
			if(mode.equals("modifyPassword")) {
				MemberDTO memberDTO=memberService.getMemberInfo(memberId);
				model.addAttribute("memberInfo", memberDTO);
				model.addAttribute("mode", mode);
				return "myInfoModify";
			}
			else if(mode.equals("myInfo")){
				MemberDTO memberDTO=memberService.getMemberInfo(memberId);
				model.addAttribute("memberInfo", memberDTO);
				model.addAttribute("mode", mode);
				return "myInfoModify";
				
			}else {
				return "redirect:/myInfo";
			}
			
		}

	}
	
	@RequestMapping(value="/myInfo/modify_action",method = RequestMethod.POST)
	public String myInfoModify_Action(Model model,HttpServletRequest request,MemberDTO memberDTO,@RequestParam(value = "mode",required = false) String mode,@RequestParam(value = "newPassword",required = false) Integer newPassword) {
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("memberId");
		if(userId==null) {
			return "redirect:/signIn";
		}
		else {
			if(mode.equals("myInfo")) {
				
				memberService.setMyInfoModify(memberDTO);
				model.addAttribute("url", "index");
				model.addAttribute("msg", "회원정보 수정 완료");
				return "/redirect";
			}
			else if(mode.equals("modifyPassword")) {
				boolean checkPassword=memberService.checkPassword(userId,memberDTO.getMemberPassword());
				if(checkPassword) {
					
					memberService.setNewPassword(userId,newPassword);
					model.addAttribute("url", "myInfo");
					model.addAttribute("msg", "비밀번호 변경하셨습니다");
					return "/redirect";
					
				}
				else {
					model.addAttribute("url", "myInfo");
					model.addAttribute("msg", "정확한 비밀번호를 입력하세요");
					return "/redirect";
						
				}
				
				
			}
			else {
				return "redirect:/myInfo";
			}
			
		}
		

	}
}
