package com.mascene.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mascene.api.request.OrderRequest;
import com.mascene.api.response.OrderResponse;
import com.mascene.api.response.ProductResponse;
import com.mascene.entities.User;
import com.mascene.repository.UserRepository;
import com.mascene.services.OrderService;
import com.mascene.services.ProductService;

/**
 *
 * @author Raman.Ahuja
 * 
 *         Boutique Store Utility service to provide helper functionality to UI
 *         pages.
 */
@Service
public class BoutiqueStoreAppService {

	@Autowired
	ProductService productService;

	@Autowired
	OrderService orderService;

	@Autowired
	UserRepository userRepository;

	public static List<ProductResponse> products;
	public static List<OrderResponse> orders;
	public static OrderRequest orderRequest;
	public static User loggedInUser = new User();
	public static ProductResponse productResponse = new ProductResponse();

	public static Map<ProductResponse, Integer> productsInCartWithQuantity = new HashMap<ProductResponse, Integer>();

	@SuppressWarnings("deprecation")
	public String authenticateUser(String username, String password) {
		if (!(StringUtils.isEmpty(username) || StringUtils.isEmpty(password))) {
			Optional<User> user = userRepository.findUserByUserName(username);
			if (user != null && user.isPresent()) {

				if (user.get().getPassword().equals(password)) {
					loggedInUser = user.get();
					loadProductsFromDB();
					return user.get().getEmployeeRole();
				}
			}
		}
		return "";
	}

	public void loadProductsFromDB() {
		products = productService.getProducts();
	}

	public void loadOrdersFromDB() {
		orders = orderService.getOrders();
	}

	public void addProductToCart(ProductResponse productResponse) {
		if (productsInCartWithQuantity.get(productResponse) != null) {
			productsInCartWithQuantity.put(productResponse, productsInCartWithQuantity.get(productResponse) + 1);
		} else {
			productsInCartWithQuantity.put(productResponse, 1);
		}
	}

}
