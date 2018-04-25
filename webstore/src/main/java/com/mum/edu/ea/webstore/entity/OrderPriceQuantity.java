package com.mum.edu.ea.webstore.entity;

public class OrderPriceQuantity {
	
	private Order order;
	private int totalQuantities;
	private int totalItems;
	private double totalPrice;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getTotalQuantities() {
		return totalQuantities;
	}
	public void setTotalQuantities(int totalQuantities) {
		this.totalQuantities = totalQuantities;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public OrderPriceQuantity(Order order, int totalQuantities, int totalItems, double totalPrice) {
		super();
		this.order = order;
		this.totalQuantities = totalQuantities;
		this.totalItems = totalItems;
		this.totalPrice = totalPrice;
	}
	public OrderPriceQuantity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
