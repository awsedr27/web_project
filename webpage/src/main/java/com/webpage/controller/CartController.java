package com.webpage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webpage.DAO.cart.CartDTO;
import com.webpage.DAO.item.ItemDAO;
import com.webpage.DAO.item.ItemDTO;
import com.webpage.service.cart.CartService;
import com.webpage.service.item.ItemService;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	ItemService itemService;
	
	
	@RequestMapping("/cart")
	public String cart(HttpServletRequest request,Model model){
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		List<CartDTO> list=cartService.getCartAjaxService(memberId);
		model.addAttribute("cartList", list);
		
		return "cart";
		}
	
	@ResponseBody
	@RequestMapping("/cart/ajaxDel")
	public void cartDel(HttpServletRequest request,@RequestParam("itemId") int itemId) {
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		cartService.deleteCart(memberId,itemId);
	}
	
	
	
	@ResponseBody
	@RequestMapping("/cart/ajax")
	public List<CartDTO> cartOut(HttpServletRequest request){
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		List<CartDTO> list=cartService.getCartAjaxService(memberId);
		return list;
		
	}
	
	
	@RequestMapping("/cartPut")
	public String cartPut(@RequestParam("itemId") int itemId,HttpServletRequest request){
		HttpSession session=request.getSession();
		String memberId=(String) session.getAttribute("memberId");
		ItemDTO item=itemService.getItemView(itemId);
		CartDTO cart = new CartDTO();
		cart.setMemberId(memberId);
		cart.setItemId(itemId);
		cart.setItemUrl(item.getItemUrl());
		cart.setItemName(item.getItemName());
		cart.setItemPrice(item.getItemPrice());
		cart.setDiscountNum(item.getDiscountNum());
		cart.setDiscount(item.isDiscount());
		cart.setPopularity(item.getPopularity());
		cart.setCategory(item.getCategory());
		
		cartService.setCartService(cart);
		
		return "redirect:/index";
		
	}
	
	
}
