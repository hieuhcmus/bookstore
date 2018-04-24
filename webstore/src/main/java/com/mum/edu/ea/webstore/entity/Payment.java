package com.mum.edu.ea.webstore.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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

	//@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address BILL_ADDRESS_ID;

	//@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address SHIP_ADDRESS_ID;

	//ID, BILL_ADDRESS_ID, SHIP_ADDRESS_ID, CARD_TYPE, CARD_NO, EXP_MONTH_YEAR, CVC, AVAILABLE_BALANCE, LIMIT

	@Column(name = "AVAILABLE_BALANCE")
	private long AVAILABLE_BALANCE;

	@Column(name = "LIMIT")
	private long LIMIT;

	@Column(name = "CVC")
	private String CVC;

	@Column(name = "EXP_MONTH_YEAR")
	private String EXP_MONTH_YEAR;

	@Column(name = "CARD_NO")
	private String CARD_NO;

	@Column(name = "CARD_TYPE")
	private String CARD_TYPE;

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

	public Address getBILL_ADDRESS_ID() {
		return BILL_ADDRESS_ID;
	}

	public void setBILL_ADDRESS_ID(Address BILL_ADDRESS_ID) {
		this.BILL_ADDRESS_ID = BILL_ADDRESS_ID;
	}

	public Address getSHIP_ADDRESS_ID() {
		return SHIP_ADDRESS_ID;
	}

	public void setSHIP_ADDRESS_ID(Address SHIP_ADDRESS_ID) {
		this.SHIP_ADDRESS_ID = SHIP_ADDRESS_ID;
	}

	public long getAVAILABLE_BALANCE() {
		return AVAILABLE_BALANCE;
	}

	public void setAVAILABLE_BALANCE(long AVAILABLE_BALANCE) {
		this.AVAILABLE_BALANCE = AVAILABLE_BALANCE;
	}

	public long getLIMIT() {
		return LIMIT;
	}

	public void setLIMIT(long LIMIT) {
		this.LIMIT = LIMIT;
	}

	public String getCVC() {
		return CVC;
	}

	public void setCVC(String CVC) {
		this.CVC = CVC;
	}

	public String getEXP_MONTH_YEAR() {
		return EXP_MONTH_YEAR;
	}

	public void setEXP_MONTH_YEAR(String EXP_MONTH_YEAR) {
		this.EXP_MONTH_YEAR = EXP_MONTH_YEAR;
	}

	public String getCARD_NO() {
		return CARD_NO;
	}

	public void setCARD_NO(String CARD_NO) {
		this.CARD_NO = CARD_NO;
	}

	public String getCARD_TYPE() {
		return CARD_TYPE;
	}

	public void setCARD_TYPE(String CARD_TYPE) {
		this.CARD_TYPE = CARD_TYPE;
	}

	@Override
	public String toString() {
		return "Payment{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", BILL_ADDRESS_ID=" + BILL_ADDRESS_ID +
				", SHIP_ADDRESS_ID=" + SHIP_ADDRESS_ID +
				", AVAILABLE_BALANCE=" + AVAILABLE_BALANCE +
				", LIMIT=" + LIMIT +
				", CVC='" + CVC + '\'' +
				", EXP_MONTH_YEAR='" + EXP_MONTH_YEAR + '\'' +
				", CARD_NO='" + CARD_NO + '\'' +
				", CARD_TYPE='" + CARD_TYPE + '\'' +
				'}';
	}
}
