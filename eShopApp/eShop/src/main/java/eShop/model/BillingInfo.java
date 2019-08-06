package eShop.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import eShop.model.user.Address;

@Entity
public class BillingInfo {
	@Id@GeneratedValue
	private Integer id;
	private Integer cardNumber;
	private String holderFullName;
	private LocalDate expireDate;
	private Integer securityDigits;
	
	@OneToOne //uni
	@JoinColumn(name="bill_address_id")  //FK
	private Address billingAddress;
	
	public BillingInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillingInfo(Integer cardNumber, String holderFullName, LocalDate expireDate, Integer securityDigits,
			Address billingAddress) {
		super();
		this.cardNumber = cardNumber;
		this.holderFullName = holderFullName;
		this.expireDate = expireDate;
		this.securityDigits = securityDigits;
		this.billingAddress = billingAddress;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getHolderFullName() {
		return holderFullName;
	}
	public void setHolderFullName(String holderFullName) {
		this.holderFullName = holderFullName;
	}
	public LocalDate getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}
	public Integer getSecurityDigits() {
		return securityDigits;
	}
	public void setSecurityDigits(Integer securityDigits) {
		this.securityDigits = securityDigits;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	@Override
	public String toString() {
		return "BillingInfo [id=" + id + ", cardNumber=" + cardNumber + ", holderFullName=" + holderFullName
				+ ", expireDate=" + expireDate + ", securityDigits=" + securityDigits + ", billingAddress="
				+ billingAddress + "]";
	}
	
	

}