package com.mum.edu.ea.inventory.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ORDER_QUEUE")
public class OrderQueue implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "NAME")
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
