package com.mum.edu.ea.webstore.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CARD_DETAILS")
public class CardDetails implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "CARD_TYPE")
	private String cardType;

	@Column(name = "EXP_MONTH_YEAR")
	private String expMonthYear;

	@Column(name = "CARD_NO")
	private String cardNo;

	@Column(name = "CVC")
	private String cvc;

	@Column(name = "AVAILABLE_BALANCE")
	private long availableBalance;

	@Column(name = "LIMIT_AMOUNT")
	private long limit;

	@Column(name = "ENABLED")
	private boolean enabled;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
