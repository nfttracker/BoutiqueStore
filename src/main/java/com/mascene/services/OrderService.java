package com.mascene.services;

import java.util.List;

import com.mascene.api.request.OrderRequest;
import com.mascene.api.response.OrderResponse;

/**
 * @author Raman.Ahuja
 * 
 *         Order Entity Service Interface for database CRUD layer interaction
 *
 */
public interface OrderService {

	public List<OrderResponse> getOrders();

	public OrderResponse createOrder(OrderRequest orderRequest);

	public OrderResponse deleteOrder(long orderId);

	public OrderResponse updateOrder(OrderRequest orderRequest, long orderId);

}
