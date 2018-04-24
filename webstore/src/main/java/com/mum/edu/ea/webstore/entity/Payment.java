package com.mum.edu.ea.webstore.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PAYMENT")
public class Payment implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BILLING_ADDRESS_ID")
	private Address billingAddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SHIPPING_ADDRESS_ID")
	private Address shippingAddress;

	@Column(name = "AVAILABLE_BALANCE")
	private long availableBalance;

	@Column(name = "LIMIT_AMOUNT")
	private long limit;

	@Column(name = "CVC")
	private String cvc;

	@Column(name = "EXP_MONTH_YEAR")
	private String expMonthYear;

	@Column(name = "CARD_NO")
	private String cardNo;

	@Column(name = "CARD_TYPE")
	private String cardType;

	@Column(name = "ENABLED")
	private boolean enabled;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Payment{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", billingAddress=" + billingAddress +
				", shippingAddress=" + shippingAddress +
				", AVAILABLE_BALANCE=" + availableBalance +
				", LIMIT=" + limit +
				", CVC='" + cvc + '\'' +
				", EXP_MONTH_YEAR='" + expMonthYear + '\'' +
				", CARD_NO='" + cardNo + '\'' +
				", CARD_TYPE='" + cardType + '\'' +
				'}';
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public long getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(long availableBalance) {
		this.availableBalance = availableBalance;
	}

	public long getLimit() {
		return limit;
	}

	public void setLimit(long limit) {
		this.limit = limit;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getExpMonthYear() {
		return expMonthYear;
	}

	public void setExpMonthYear(String expMonthYear) {
		this.expMonthYear = expMonthYear;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
