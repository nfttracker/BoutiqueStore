package com.mascene.api.request;

import java.util.List;

import com.mascene.entities.OrderItem;

/**
 * @author Raman.Ahuja
 *
 *         Class to make a reqyest to the api for order CRUD operations
 *
 */
public class OrderRequest {

	private List<OrderItem> orderItems;

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "OrderRequest [orderItems=" + orderItems + "]";
	}

}
