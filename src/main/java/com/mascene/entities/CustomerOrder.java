package com.mascene.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.mascene.api.response.Response;

/**
 * @author Raman.Ahuja
 * 
 *         Customer Order Entity
 *
 */
@Entity
public class CustomerOrder extends Response {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;

	@Column(nullable = false)
	private Date orderDate;

	@Column(nullable = false)
	private double orderTaxAmount;

	@Column(nullable = false)
	private double orderTotal;

	@Column(nullable = false)
	private double orderSubTotalBeforeTax;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private List<OrderItem> orderItems;

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderTaxAmount=" + orderTaxAmount
				+ ", orderTotal=" + orderTotal + ", orderSubTotal=" + orderSubTotalBeforeTax + ", products="
				+ orderItems + "]";
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderTaxAmount() {
		return orderTaxAmount;
	}

	public void setOrderTaxAmount(double orderTaxAmount) {
		this.orderTaxAmount = orderTaxAmount;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public double getOrderSubTotalBeforeTax() {
		return orderSubTotalBeforeTax;
	}

	public void setOrderSubTotalBeforeTax(double orderSubTotalBeforeTax) {
		this.orderSubTotalBeforeTax = orderSubTotalBeforeTax;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
