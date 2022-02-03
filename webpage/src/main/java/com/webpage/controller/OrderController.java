package com.webpage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webpage.DAO.cart.CartDTO;
import com.webpage.DAO.orderInfo.OrderInfoDTO;
import com.webpage.service.order.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/order",method = RequestMethod.POST)
	public String order(HttpServletRequest request,Model model,CartDTO cart) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		
		if(memberId==null) {
			return "redirect:/signIn";
		}else {
			List<CartDTO> list=orderService.readCartService(memberId,cart);
			if(list==null) {
				model.addAttribute("cartEmpty", true);
				return "order";
			}else {
				model.addAttribute("cartEmpty", false);
				model.addAttribute("cartList", list);
				return "order";	
			}
			
			
		}
		
	}
	
	@RequestMapping(value="/cart/order",method = RequestMethod.POST)
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
					model.addAttribute("cartEmpty", false);
					model.addAttribute("cartList", list);
					return "order";	
				}
				
				
			}
			
		}
		
		
	
		
	
	
	@RequestMapping(value="/cart/order/payment",method = RequestMethod.POST)
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
	@RequestMapping(value="/myInfo/orderDelete",method = RequestMethod.POST)
	public void myInfoOrderDelete(HttpServletRequest request,@RequestParam("orderId") int orderId) {
        HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		if(memberId==null) {
			
		}else {
			orderService.deleteOrderService(orderId,memberId);
		}
		
	}

}
