package eShop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import eShop.model.user.Customer;
import eShop.model.user.Supplier;

@Entity
public class PaymentRecord {
	
	@Id@GeneratedValue
	private Integer id;
	private LocalDate paymentDate;
	private Double amount;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billInfo_id")
	private BillingInfo billInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;
	
	@OneToMany
	@JoinColumn(name="fk_book")
	private List<Book> books;
	
	
	
	public PaymentRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentRecord(Customer customer, Supplier supplier, LocalDate paymentDate, BillingInfo billInfo,
			List<Book> books, Order order, Double amount) {
		super();
		this.customer = customer;
		this.supplier = supplier;
		this.paymentDate = paymentDate;
		this.billInfo = billInfo;
		this.books = books;
		this.order = order;
		this.amount = amount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public BillingInfo getBillInfo() {
		return billInfo;
	}
	public void setBillInfo(BillingInfo billInfo) {
		this.billInfo = billInfo;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "PaymentRecord [id=" + id + ", customer=" + customer + ", supplier=" + supplier + ", paymentDate="
				+ paymentDate + ", billInfo=" + billInfo + ", books=" + books + ", order=" + order + ", amount="
				+ amount + "]";
	}
	
	

}