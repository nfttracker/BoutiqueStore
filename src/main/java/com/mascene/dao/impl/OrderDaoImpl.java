package com.mascene.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mascene.api.request.OrderRequest;
import com.mascene.api.request.ProductRequest;
import com.mascene.api.response.OrderResponse;
import com.mascene.api.response.ProductResponse;
import com.mascene.dao.OrderDao;
import com.mascene.entities.CustomerOrder;
import com.mascene.entities.OrderItem;
import com.mascene.entities.Product;
import com.mascene.repository.OrderRepository;
import com.mascene.repository.ProductRepository;
import com.mascene.services.ProductService;

/**
 * @author Raman.Ahuja
 * 
 *         Implementation for order data object layer
 *
 */
@Service
@Transactional
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ProductService productService;

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<OrderResponse> getAllOrders() {
		List<CustomerOrder> orders = (List<CustomerOrder>) orderRepository.findAll();
		List<OrderResponse> orderResponses = new ArrayList<>();
		if (orders != null) {
			for (CustomerOrder order : orders) {
				if (order != null) {
					OrderResponse orderResponse = new OrderResponse();
					BeanUtils.copyProperties(order, orderResponse);
					orderResponse.setApiResponseMessage("All order fetched successfully");
					orderResponse.setApiResponseStatus(Boolean.TRUE);
					orderResponses.add(orderResponse);
				}
			}
		}
		return orderResponses;
	}

	@Override
	public OrderResponse createOrder(OrderRequest orderRequest) {
		OrderResponse orderResponse = new OrderResponse();
		CustomerOrder order = new CustomerOrder();
		order.setOrderDate(new Date());
		BeanUtils.copyProperties(orderRequest, order);
		double orderTaxAmount = 0;
		double orderTotal = 0;
		double orderSubTotalBeforeTax = 0;
		System.out.println("before order item : " + order);
		for (OrderItem orderItem : order.getOrderItems()) {
			orderSubTotalBeforeTax += orderItem.getPriceAsPerQuantity() * orderItem.getProductQuantityPurchased();
			System.out.println(orderSubTotalBeforeTax);
			Optional<Product> productResponse = productRepository.findById(orderItem.getProductId());
			if (productResponse.isPresent())
				System.out.println(productResponse.toString());
			else {
				System.out.println("product missing");
			}
			productResponse.get().setProductQuantity(
					productResponse.get().getProductQuantity() - orderItem.getProductQuantityPurchased());
			System.out.println("product quantity set: " + productResponse);
			ProductRequest productRequest = new ProductRequest();
			BeanUtils.copyProperties(productResponse.get(), productRequest);
			System.out.println("copied to product request: " + productRequest);

			ProductResponse response = productService.updateProduct(productRequest,
					productResponse.get().getProductId());
			System.out.println("updated called");
			if (response == null) {
				orderResponse.setApiResponseMessage("Failure in Order creation");
				orderResponse.setApiResponseStatus(Boolean.FALSE);
				return orderResponse;
			}
		}
		orderTaxAmount = 0.13 * orderSubTotalBeforeTax;
		orderTotal = orderTaxAmount + orderSubTotalBeforeTax;
		order.setOrderSubTotalBeforeTax(orderSubTotalBeforeTax);
		order.setOrderTaxAmount(orderTaxAmount);
		order.setOrderTotal(orderTotal);
		System.out.println(order.toString());
		CustomerOrder orderSaved = orderRepository.save(order);
		if (orderSaved != null) {
			BeanUtils.copyProperties(orderSaved, orderResponse);
			orderResponse.setApiResponseMessage("Order created successfully");
			orderResponse.setApiResponseStatus(Boolean.TRUE);
		} else {
			orderResponse.setApiResponseMessage("Failure in Order creation");
			orderResponse.setApiResponseStatus(Boolean.FALSE);
		}
		return orderResponse;

	}

	@Override
	public OrderResponse updateOrder(OrderRequest orderRequest, long orderId) {
		Optional<CustomerOrder> order = orderRepository.findById(orderId);
		CustomerOrder orderFetched = order.get();
		BeanUtils.copyProperties(orderRequest, orderFetched);
		CustomerOrder orderUpdated = orderRepository.save(orderFetched);
		OrderResponse orderResponse = new OrderResponse();
		if (orderUpdated != null) {
			BeanUtils.copyProperties(orderUpdated, orderResponse);
			orderResponse.setApiResponseMessage("Order updated successfully");
			orderResponse.setApiResponseStatus(Boolean.TRUE);
		} else {
			orderResponse.setApiResponseMessage("Failure in Order updation");
			orderResponse.setApiResponseStatus(Boolean.FALSE);
		}
		return orderResponse;
	}

	@Override
	public OrderResponse deleteOrder(long orderId) {
		Optional<CustomerOrder> order = orderRepository.findById(orderId);
		OrderResponse orderResponse = new OrderResponse();
		if (order.get() != null) {
			BeanUtils.copyProperties(order, orderResponse);
			orderRepository.delete(order.get());
			orderResponse.setApiResponseMessage("Order Deleted Successfully");
			orderResponse.setApiResponseStatus(Boolean.TRUE);
		} else {
			orderResponse.setOrderId(orderId);
			orderResponse.setApiResponseMessage("Order doesn't exists with Order Id: " + orderId);
			orderResponse.setApiResponseStatus(Boolean.FALSE);
		}
		return orderResponse;
	}

}