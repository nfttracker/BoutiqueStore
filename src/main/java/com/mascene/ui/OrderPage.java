package com.mascene.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mascene.api.request.OrderRequest;
import com.mascene.api.response.OrderResponse;
import com.mascene.api.response.ProductResponse;
import com.mascene.entities.OrderItem;
import com.mascene.entities.Product;
import com.mascene.repository.ProductRepository;
import com.mascene.services.OrderService;
import com.mascene.utilities.BoutiqueStoreAppService;

/**
 *
 * @author Raman.Ahuja
 * 
 *         Order UI screen class
 */
@Service
public class OrderPage extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	StorePage storePage;

	@Autowired
	BoutiqueStoreAppService boutiqueStoreAppService;

	private OrderRequest orderRequest;

	private double cartTotal = 0;

	@Autowired
	OrderService orderService;

	public OrderPage() {
		initComponents();
	}

	private void initComponents() {
		orderPanel = new javax.swing.JPanel();
		header = new java.awt.Label();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		orderTable = new javax.swing.JPanel();
		remove = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();
		completePurchase = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		/*
		 * javax.swing.GroupLayout orderPanelLayout = new
		 * javax.swing.GroupLayout(orderPanel); orderPanel.setLayout(orderPanelLayout);
		 * orderPanelLayout.setHorizontalGroup(orderPanelLayout
		 * .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0,
		 * Short.MAX_VALUE)); orderPanelLayout.setVerticalGroup(orderPanelLayout
		 * .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
		 * 103, Short.MAX_VALUE));
		 */

		orderPanel.setLayout(new GridBagLayout());

		header.setAlignment(java.awt.Label.CENTER);
		header.setBackground(new java.awt.Color(153, 153, 255));
		header.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		header.setText("MA Scene Inc.");

		jLabel1.setText("Current Order(s):");

		jScrollPane1.setViewportView(orderTable);

		remove.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
		remove.setText("Remove");
		remove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BoutiqueStoreAppService.productsInCartWithQuantity = new HashMap<ProductResponse, Integer>();
				System.out.println(BoutiqueStoreAppService.productsInCartWithQuantity.size());
				orderTable.setVisible(Boolean.FALSE);
				removeCartOrderFromTable();
				cartTotal = 0;
			}
		});

		cancelButton.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cartTotal = 0;
				removeCartOrderFromTable();
				dispose();
				boutiqueStoreAppService.loadProductsFromDB();
				boutiqueStoreAppService.loadOrdersFromDB();
				BoutiqueStoreAppService.productsInCartWithQuantity = new HashMap<ProductResponse, Integer>();
				storePage.extracted();
				storePage.setVisible(Boolean.TRUE);
			}
		});

		completePurchase.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
		completePurchase.setText("Complete Purchase");
		completePurchase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderRequest req = getOrderRequestFromCart();
				OrderResponse orderResponse = orderService.createOrder(req);
				if (orderResponse != null && orderResponse.isApiResponseStatus()) {
					boutiqueStoreAppService.loadProductsFromDB();
					boutiqueStoreAppService.loadOrdersFromDB();
					BoutiqueStoreAppService.productsInCartWithQuantity = new HashMap<ProductResponse, Integer>();
					JOptionPane.showMessageDialog(null, "Products Ordered successfully..");
					cartTotal = 0;
					removeCartOrderFromTable();
					dispose();
					storePage.extracted();
					storePage.setVisible(Boolean.TRUE);
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jScrollPane1)
										.addGroup(layout.createSequentialGroup()
												.addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(162, 162, 162).addComponent(completePurchase,
														javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
								.addContainerGap())))
				.addComponent(orderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(orderPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(completePurchase, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(19, 19, 19)));

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setBounds(0, 0, screenSize.width, screenSize.height - 50);
		this.setResizable(Boolean.FALSE);
	}

	private JDialog createOrderHistoryDialog(OrderResponse orders) {

		final JDialog myDialog = new JDialog(null, "Order History", Dialog.ModalityType.DOCUMENT_MODAL);
		myDialog.setBounds(100, 100, 300, 200);
		myDialog.setSize(new Dimension(600, 500));
		Container dialogContainer = myDialog.getContentPane();
		dialogContainer.setLayout(new BorderLayout());
		dialogContainer.add(getOrderHistoryPannel(orders), BorderLayout.CENTER);
		return myDialog;
	}

	private JPanel getOrderHistoryPannel(OrderResponse order) {
		JPanel mainOrderHistoryPanel = new JPanel();
		GridBagLayout gridPanel = new GridBagLayout();
		gridPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gridPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		mainOrderHistoryPanel.setLayout(gridPanel);

		JLabel orderHistoryLabel = new JLabel("Order history");
		orderHistoryLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gridCons = new GridBagConstraints();
		gridCons.gridwidth = 2;
		gridCons.insets = new Insets(0, 0, 5, 5);
		gridCons.gridx = 0;
		gridCons.gridy = 0;
		mainOrderHistoryPanel.add(orderHistoryLabel, gridCons);

		String date = new SimpleDateFormat("MMMM dd, yyyy 'at' hh:mm a").format(order.getOrderDate());

		JLabel orderDateLabel = new JLabel("Order at : " + date);
		GridBagConstraints orderGridCons = new GridBagConstraints();
		orderGridCons.anchor = GridBagConstraints.WEST;
		orderGridCons.insets = new Insets(0, 0, 5, 5);
		orderGridCons.gridx = 1;
		orderGridCons.gridy = 1;
		mainOrderHistoryPanel.add(orderDateLabel, orderGridCons);

		String column[] = { "No.", "Product name", "Quantity", "Sub total", "Tax", "Total" };
		Object[][] data = getTableData(order);
		JTable table = new JTable(data, column);
		JScrollPane myScrollPane = new JScrollPane(table);

		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 3;
		mainOrderHistoryPanel.add(myScrollPane, gbc_table);

		JLabel totalLabel = new JLabel("Grand total : " + order.getOrderTotal());
		GridBagConstraints gbc_totalLabel = new GridBagConstraints();
		gbc_totalLabel.anchor = GridBagConstraints.WEST;
		gbc_totalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_totalLabel.gridx = 1;
		gbc_totalLabel.gridy = 4;
		mainOrderHistoryPanel.add(totalLabel, gbc_totalLabel);

		return mainOrderHistoryPanel;
	}

	private Object[][] getTableData(OrderResponse orderResp) {
		Object data[][] = new Object[orderResp.getOrderItems().size()][6];
		AtomicInteger index = new AtomicInteger(0);
		orderResp.getOrderItems().forEach(orderItem -> {
			int i = index.getAndIncrement();
			List<String> row = new ArrayList<>();
			row.add((i + 1) + "");
			double price = orderItem.getProductQuantityPurchased() * orderItem.getPriceAsPerQuantity();
			double taxAmount = orderItem.getProductQuantityPurchased() * orderItem.getPriceAsPerQuantity() * 0.13;
			Optional<Product> product = productRepository.findById(orderItem.getProductId());
			System.out.println(orderItem.toString());
			row.add(product.get().getProductTitle());
			row.add(orderItem.getProductQuantityPurchased() + "");
			row.add(price + "");
			row.add(taxAmount + "");
			row.add(price + taxAmount + "");
			data[i] = row.toArray();
		});
		return data;
	}

	public void displayCartOrderInTable() {
		String column[] = { "No.", "Product Title & Colour", "Total" };
		Object[][] data = getTableDataForOrderInCart();
		JTable table = new JTable(data, column);
		table.setSize(table.getWidth() + 50, table.getHeight());
		// table.setRowHeight(table.getRowHeight() + 80);
		orderTableDataScrollPane = new JScrollPane(table);
		orderTable.setLayout(new GridBagLayout());
		orderTable.add(orderTableDataScrollPane);
		gradTotalLabel = new JLabel("Grand Total: $" + new DecimalFormat("0.00").format(cartTotal));
		orderTable.add(gradTotalLabel);
		orderTable.setVisible(Boolean.TRUE);
	}

	public void removeCartOrderFromTable() {
		orderTable.remove(orderTableDataScrollPane);
		orderTable.remove(gradTotalLabel);
	}

	private Object[][] getTableDataForOrderInCart() {
		Object data[][] = new Object[BoutiqueStoreAppService.productsInCartWithQuantity.size()][3];
		int i = 0;
		for (Entry<ProductResponse, Integer> productInCart : BoutiqueStoreAppService.productsInCartWithQuantity
				.entrySet()) {
			List<String> row = new ArrayList<>();
			row.add(i + 1 + "");
			float productTotalBeforeTax = productInCart.getKey().getProductPrice() * productInCart.getValue();
			float productTax = (float) (0.13 * productTotalBeforeTax);
			float productTotalPay = productTax + productTotalBeforeTax;
			row.add("Item: " + productInCart.getKey().getProductTitle() + ", BarCode Number: "
					+ productInCart.getKey().getProductBarcode());
			row.add("Price: $" + productTotalBeforeTax + ", Tax: $" + productTax + ", Total: $" + productTotalPay);
			System.out.println(" Item: " + productInCart.getKey().getProductTitle() + " BarCode Number: "
					+ productInCart.getKey().getProductBarcode() + "Price: $" + productTotalBeforeTax + " Tax: $"
					+ productTax + " Total: $" + productTotalPay);
			cartTotal += productTotalPay;
			data[i] = row.toArray();
			++i;
		}
		return data;
	}

	private OrderRequest getOrderRequestFromCart() {
		orderRequest = new OrderRequest();
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for (Entry<ProductResponse, Integer> productInCart : BoutiqueStoreAppService.productsInCartWithQuantity
				.entrySet()) {
			OrderItem orderItemTemp = new OrderItem();
			orderItemTemp.setPriceAsPerQuantity(productInCart.getKey().getProductPrice());
			orderItemTemp.setProductQuantityPurchased(productInCart.getValue());
			orderItemTemp.setProductId(productInCart.getKey().getProductId());
			orderItems.add(orderItemTemp);
		}
		orderRequest.setOrderItems(orderItems);
		return orderRequest;
	}

	public void displayOrderInPanel() {
		System.out.println(BoutiqueStoreAppService.orders);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		int orderSerialNumber = 1;
		orderHistory = new JLabel("Order History:");
		orderPanel.add(orderHistory, gbc);
		gbc.gridy = 1;
		for (OrderResponse orderResponse : BoutiqueStoreAppService.orders) {
			addOrder(orderPanel, gbc, orderResponse, orderSerialNumber);
			++gbc.gridy;
			++orderSerialNumber;
		}
	}

	// Variables declaration
	private javax.swing.JButton remove;
	private javax.swing.JButton cancelButton;
	private javax.swing.JButton completePurchase;
	private java.awt.Label header;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel orderPanel;
	private javax.swing.JPanel orderTable;
	private JScrollPane orderTableDataScrollPane;
	private JLabel gradTotalLabel;
	private JLabel orderHistory;
	// End of variables declaration

	private void addOrder(JPanel panel, GridBagConstraints gbc, OrderResponse orderResponse, int orderNumber) {
		JPanel mainPanel = new JPanel(new FlowLayout());
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.setBackground(Color.WHITE);
		panel.add(mainPanel, gbc);

		JPanel serialNumberPanel = new JPanel();
		mainPanel.add(serialNumberPanel);

		JLabel serialNumberLabel = new JLabel(orderNumber + "");
		serialNumberPanel.add(serialNumberLabel);

		JPanel orderDatePanel = new JPanel();
		mainPanel.add(orderDatePanel);
		orderDatePanel.setLayout(new BoxLayout(orderDatePanel, BoxLayout.Y_AXIS));

		JLabel orderDate = new JLabel(orderResponse.getOrderDate() + "");
		orderDatePanel.add(orderDate);

		JButton viewOrderButton = new JButton("View");

		viewOrderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createOrderHistoryDialog(orderResponse).setVisible(Boolean.TRUE);
			}
		});
		mainPanel.add(viewOrderButton);

	}

}
