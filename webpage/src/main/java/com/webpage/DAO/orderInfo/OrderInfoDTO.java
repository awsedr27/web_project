package com.webpage.DAO.orderInfo;

import java.util.List;

import com.webpage.DAO.orderItem.OrderItemDTO;

public class OrderInfoDTO {
	private int orderId;
	private String memberId;
	private String orderName;
	private String orderLocation;
	private String orderRecipient;
	private String orderRequest;
	private List<OrderItemDTO> orderItemList;
	
	
	
	
	
	public List<OrderItemDTO> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItemDTO> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public String getOrderRequest() {
		return orderRequest;
	}
	public void setOrderRequest(String orderRequest) {
		this.orderRequest = orderRequest;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderLocation() {
		return orderLocation;
	}
	public void setOrderLocation(String orderLocation) {
		this.orderLocation = orderLocation;
	}
	public String getOrderRecipient() {
		return orderRecipient;
	}
	public void setOrderRecipient(String orderRecipient) {
		this.orderRecipient = orderRecipient;
	}
	
	
	
	

}
