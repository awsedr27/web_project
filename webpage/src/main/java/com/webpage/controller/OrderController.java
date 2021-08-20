package com.webpage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webpage.DAO.cart.CartDTO;
import com.webpage.service.cart.CartService;

@Controller
public class OrderController {
	
	
	@Autowired
	CartService cartService;
	
	@RequestMapping("/cart/order")
	public String order(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		List<CartDTO> list=cartService.getCartAjaxService(memberId);
		model.addAttribute("cartList", list);

		return "order";
	}

}
