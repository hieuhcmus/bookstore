package com.mum.edu.ea.webstore.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderLine implements Serializable{
	
	@Id
	@GeneratedValue
	private Long orderLineId;
	
	@OneToOne
	@JoinColumn(name = "ORDERLINE ID")
	private Product product;
	
	private int quantity;
	
}
