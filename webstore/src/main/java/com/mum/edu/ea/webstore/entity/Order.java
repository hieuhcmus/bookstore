package com.mum.edu.ea.webstore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long orderId;

	@Temporal(TemporalType.DATE)
	@Column(name = "ORDERED_AT")
	private Date orderedAt = new Date();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID")
	private List<OrderLine> orderLine = new ArrayList<OrderLine>();

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	@Temporal(TemporalType.DATE)
	private Date createdAt = new Date();

	@Temporal(TemporalType.DATE)
	private Date updatedAt = new Date();

	@OneToOne
	@JoinColumn(name = "PERSON_ID")
	private Person person;

	@Column(name = "TOTAL_PRICE")
	private double totalPrice;

	public Order(Long orderId, Date orderedAt, List<OrderLine> orderLine, OrderStatus orderStatus, Date createdAt,
	             Date updatedAt) {
		super();
		this.orderId = orderId;
		this.orderedAt = orderedAt;
		this.orderLine = orderLine;
		this.orderStatus = orderStatus;
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
				+ orderStatus + ", customer=" + "createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
