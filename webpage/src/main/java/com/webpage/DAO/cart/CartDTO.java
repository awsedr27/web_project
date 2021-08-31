package com.webpage.DAO.cart;

import java.util.List;

public class CartDTO {
	private String memberId;
	private int itemId;
	private int itemPrice;
	private String itemName;
	private String itemUrl;
	private boolean discount;
	private int discountNum;
	private int popularity;
	private String category;
	private int quantity;
	private boolean purchase;
	
	
	public boolean isPurchase() {
		return purchase;
	}
	public void setPurchase(boolean purchase) {
		this.purchase = purchase;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemUrl() {
		return itemUrl;
	}
	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}
	public boolean isDiscount() {
		return discount;
	}
	public void setDiscount(boolean discount) {
		this.discount = discount;
	}
	public int getDiscountNum() {
		return discountNum;
	}
	public void setDiscountNum(int discountNum) {
		this.discountNum = discountNum;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
}
