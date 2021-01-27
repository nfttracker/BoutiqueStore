package com.mascene.services.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mascene.api.request.OrderRequest;
import com.mascene.api.response.OrderResponse;
import com.mascene.dao.OrderDao;
import com.mascene.services.OrderService;

/**
 * @author Raman.Ahuja
 * 
 *         Order Entity Service implementation for database CRUD layer
 *         interaction
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;

	@Override
	public List<OrderResponse> getOrders() {
		return orderDao.getAllOrders();
	}

	@Override
	public OrderResponse createOrder(OrderRequest orderRequest) {
		OrderResponse orderResponse = null;
		if (orderRequest.getOrderItems() != null && orderRequest.getOrderItems().size() > 0) {
			orderResponse = orderDao.createOrder(orderRequest);
			if (orderResponse != null) {
				return orderResponse;
			}
		}
		orderResponse = new OrderResponse();
		BeanUtils.copyProperties(orderRequest, orderResponse);
		orderResponse.setApiResponseMessage("Failure in Order creation");
		orderResponse.setApiResponseStatus(Boolean.FALSE);
		return orderResponse;
	}

	@Override
	public OrderResponse updateOrder(OrderRequest orderRequest, long orderId) {
		OrderResponse orderResponse = orderDao.updateOrder(orderRequest, orderId);
		if (orderResponse != null) {
			BeanUtils.copyProperties(orderResponse, orderResponse);
		} else {
			orderResponse = new OrderResponse();
			BeanUtils.copyProperties(orderRequest, orderResponse);
			orderResponse.setApiResponseMessage("Failure in Order updation");
			orderResponse.setApiResponseStatus(Boolean.FALSE);
		}
		return orderResponse;
	}

	@Override
	public OrderResponse deleteOrder(long orderId) {
		OrderResponse orderResponse = orderDao.deleteOrder(orderId);
		if (orderResponse != null) {
			BeanUtils.copyProperties(orderResponse, orderResponse);
		} else {
			orderResponse = new OrderResponse();
			orderResponse.setOrderId(orderId);
			orderResponse.setApiResponseMessage("Order doesn't exists with Order Id: " + orderId);
			orderResponse.setApiResponseStatus(Boolean.FALSE);
		}
		return orderResponse;
	}

}
