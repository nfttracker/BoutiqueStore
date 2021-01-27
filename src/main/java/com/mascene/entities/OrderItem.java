package com.mascene.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

/**
 * @author Raman.Ahuja
 * 
 *         Order Item Entity
 *
 */
@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderItemId;

	@NotNull
	private Long productId;

	@Column(nullable = false)
	private long productQuantityPurchased;

	@Column(nullable = false)
	private double priceAsPerQuantity;

	public long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public long getProductQuantityPurchased() {
		return productQuantityPurchased;
	}

	public void setProductQuantityPurchased(long productQuantityPurchased) {
		this.productQuantityPurchased = productQuantityPurchased;
	}

	public double getPriceAsPerQuantity() {
		return priceAsPerQuantity;
	}

	public void setPriceAsPerQuantity(double priceAsPerQuantity) {
		this.priceAsPerQuantity = priceAsPerQuantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", productId=" + productId + ", productQuantityPurchased="
				+ productQuantityPurchased + ", priceAsPerQuantity=" + priceAsPerQuantity + "]";
	}

}
