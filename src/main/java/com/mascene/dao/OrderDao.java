package com.mascene.dao;

import java.util.List;

import com.mascene.api.request.OrderRequest;
import com.mascene.api.response.OrderResponse;

/**
 * @author Raman.Ahuja
 * 
 *         Interface for order Data object layer
 *
 */
public interface OrderDao {

	public List<OrderResponse> getAllOrders();

	public OrderResponse createOrder(OrderRequest orderRequest);

	public OrderResponse deleteOrder(long orderId);

	public OrderResponse updateOrder(OrderRequest orderRequest, long orderId);

}
