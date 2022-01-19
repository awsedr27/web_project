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
import org.springframework.web.bind.annotation.ResponseBody;

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
			if(list.isEmpty()) {
				model.addAttribute("cartEmpty", true);
				return "order";
			}else {
				model.addAttribute("cartList", list);
				return "order";
			}
			
			
		}
		
	}
	
	@RequestMapping("/cart/order")
	public String cartOrder(HttpServletRequest request,Model model) {
        HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		if(memberId==null) {
			return "redirect:/signIn";

		}
		else{ 
				
				List<CartDTO> list=orderService.readCartOrderService(memberId);
				if(list==null) {
					model.addAttribute("cartEmpty", true);
					return "order";
				}else {
					
					model.addAttribute("cartList", list);
					return "order";	
				}
				
				
			}
			
		}
		
		
	
		
	
	
	@RequestMapping("/cart/order/payment")
	public String orderPay(HttpServletRequest request,OrderInfoDTO orderInfo) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		
		if(memberId==null) {
			return "redirect:/signIn";
		}else {
			
			orderService.setOrder(memberId,orderInfo);
			
			return "redirect:/index";
			
		}
		
		
	}
	
	@ResponseBody
	@RequestMapping("/myInfo/orderDelete")
	public void myInfoOrderDelete(HttpServletRequest request,@RequestParam("orderId") int orderId) {
        HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		if(memberId==null) {
			
		}else {
			orderService.deleteOrderService(orderId,memberId);
		}
		
	}

}
