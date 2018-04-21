package com.mum.edu.ea.webstore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Order implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long orderId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ORDERED AT")
	private Date orderedAt;
	
	@OneToMany
	@JoinColumn(name = "ORDER_ID")
	private List<OrderLine> orderLine = new ArrayList<OrderLine>();
	
	@Enumerated
	private OrderStatus orderStatus;
	
	
	private Person customer;
	
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@Temporal(TemporalType.DATE)
	private Date updatedAt;

	public Order(Long orderId, Date orderedAt, List<OrderLine> orderLine, OrderStatus orderStatus, Person customer,
			Date createdAt, Date updatedAt) {
		super();
		this.orderId = orderId;
		this.orderedAt = orderedAt;
		this.orderLine = orderLine;
		this.orderStatus = orderStatus;
		this.customer = customer;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getOrderedAt() {
		return orderedAt;
	}

	public void setOrderedAt(Date orderedAt) {
		this.orderedAt = orderedAt;
	}

	public List<OrderLine> getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Person getCustomer() {
		return customer;
	}

	public void setCustomer(Person customer) {
		this.customer = customer;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderedAt=" + orderedAt + ", orderLine=" + orderLine + ", orderStatus="
				+ orderStatus + ", customer=" + customer + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}
	
	
	
}