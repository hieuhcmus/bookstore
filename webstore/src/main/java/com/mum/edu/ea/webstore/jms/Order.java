package com.mum.edu.ea.webstore.jms;

import java.io.Serializable;

/**
 * The temporary class, will be deleted later.
 */
public class Order implements Serializable {
	private String name;
	private String description;
	private double price;
	private int quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
