package com.webpage.controller;

import java.util.HashMap;
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
import com.webpage.service.member.MemberService;

@Controller
public class SignController {
	
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping(value="/signIn",method=RequestMethod.GET)
	public String signIn() {
		
		return "signIn";
		
	}
	
	@RequestMapping(value="/signIn",method=RequestMethod.POST)
	public String signIn(HttpServletRequest request,@RequestParam("userID") String memberId,@RequestParam("userPassword") int password) {
		
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
			return "signIn";
		}
		
		
		
		
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public String signUp() {
		
		return "signUp";
		
		
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String signUp(MemberDTO memberDTO) {
		
		
		memberService.setMember(memberDTO);
		return "redirect:/signIn";
		
		
	}
	
	@RequestMapping("/myInfo")
	public String myInfo(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		if(memberId==null) {
			return "signIn";
		}
		else {
			MemberDTO memberDTO=memberService.getMemberInfo(memberId);
			model.addAttribute("memberInfo", memberDTO);
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
	
	@RequestMapping("/myInfo/modify_action")
	public String myInfoModify_Action(HttpServletRequest request,MemberDTO memberDTO,@RequestParam(value = "mode",required = false) String mode,@RequestParam(value = "newPassword",required = false) Integer newPassword) {
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("memberId");
		if(userId==null) {
			return "signIn";
		}
		else {
			if(mode.equals("myInfo")) {
				memberService.setMyInfoModify(memberDTO);
				return "redirect:/index";
			}
			else if(mode.equals("modifyPassword")) {
				boolean checkPassword=memberService.checkPassword(userId,memberDTO.getMemberPassword());
				if(checkPassword) {
					
					memberService.setNewPassword(userId,newPassword);
					return "redirect:/myInfo"; 
				}
				else {
					return "redirect:/myInfo";	
				}
				
				
			}
			else {
				return "redirect:/myInfo";
			}
			
		}
		

	}
}
