package com.webpage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webpage.DAO.cart.CartDTO;
import com.webpage.DAO.orderInfo.OrderInfoDTO;
import com.webpage.service.order.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/order")
	public String order(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		if(memberId==null) {
			return "redirect:/signIn";
		}else {
			List<CartDTO> list=orderService.readCartService(memberId);
			model.addAttribute("cartList", list);
			return "order";
			
		}
		
	}
	
	@RequestMapping("/cart/order")
	public String cartOrder(HttpServletRequest request,OrderInfoDTO orderInfo,Model model) {
        HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		if(memberId==null) {
			return "redirect:/signIn";

		}
		else{
			orderInfo.setMemberId(memberId);
			List<CartDTO> list=orderService.readCartOrderService(orderInfo);
			model.addAttribute("cartList", list);
			return "order";
		}
		
		
	
		
	}
	
	@RequestMapping("/cart/order/payment")
	public String orderPay(@ModelAttribute OrderInfoDTO orderInfo,HttpServletRequest request) {
		HttpSession session=request.getSession();
		
		String memberId=(String) session.getAttribute("memberId");
		if(memberId==null) {
			return "redirect:/signIn";
		}else {
			orderInfo.setMemberId(memberId);
			orderService.setOrder(orderInfo);
			
			return "redirect:/index";
			
		}
		
		
	}

}
