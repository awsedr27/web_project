package com.webpage.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

}
