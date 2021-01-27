package com.mascene.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mascene.api.response.ProductResponse;
import com.mascene.entities.User;
import com.mascene.services.ProductService;
import com.mascene.utilities.BoutiqueStoreAppService;

/**
 *
 * @author Raman.Ahuja
 * 
 *         Admin UI screen class
 */
@Component
public class AdminPage extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	EditReasonPage editReasonPage;

	@Autowired
	NewProductPage newProduct;

	@Autowired
	AppLoginPage appLoginPage;

	@Autowired
	StorePage storePage;

	@Autowired
	ProductService productService;

	@Autowired
	BoutiqueStoreAppService boutiqueStoreAppService;

	public AdminPage() {
		initComponents();
	}

	private void initComponents() {

		loggedUsername = new javax.swing.JLabel();
		header = new java.awt.Label();
		date = new javax.swing.JLabel();
		addNewProduct = new javax.swing.JButton();
		logout = new javax.swing.JButton();
		store = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jPanel2 = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		loggedUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		loggedUsername.setText("Store Backend Admin Personnel Login");

		header.setAlignment(java.awt.Label.CENTER);
		header.setBackground(new java.awt.Color(153, 153, 255));
		header.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		header.setText("MA Scene Inc.");

		date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		date.setText("Date");

		addNewProduct.setBackground(new java.awt.Color(102, 102, 255));
		addNewProduct.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		addNewProduct.setText("Add New Product");
		addNewProduct.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addNewProductActionPerformed(evt);
			}
		});

		logout.setBackground(new java.awt.Color(0, 0, 255));
		logout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		logout.setText("Logout");
		logout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logoutActionPerformed(evt);
			}
		});

		store.setBackground(new java.awt.Color(51, 51, 255));
		store.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		store.setText("Store");
		store.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				storeActionPerformed(evt);
			}
		});

		jPanel2.setLayout(new GridBagLayout());
		jPanel2.setBackground(Color.darkGray);
		jPanel2.setSize(300, 300);

		jScrollPane1.setViewportView(jPanel2);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1)
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(loggedUsername, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(addNewProduct))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(store, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(loggedUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(date))
						.addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(addNewProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
						.addComponent(store, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jScrollPane1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setBounds(0, 0, screenSize.width, screenSize.height - 100);
		this.setResizable(Boolean.FALSE);
	}

	private void addNewProductActionPerformed(java.awt.event.ActionEvent evt) {
		BoutiqueStoreAppService.productResponse = new ProductResponse();
		newProduct.clearFields();
		newProduct.setVisible(Boolean.TRUE);
	}

	private void logoutActionPerformed(java.awt.event.ActionEvent evt) {
		BoutiqueStoreAppService.loggedInUser = new User();
		BoutiqueStoreAppService.products.clear();
		BoutiqueStoreAppService.productsInCartWithQuantity.clear();
		dispose();
		appLoginPage.setVisible(Boolean.TRUE);
	}

	public void displayAdminUsernameInfo() {
		date.setText("Today's Date: " + new SimpleDateFormat("MMMM dd, YYYY").format(new Date()));
		loggedUsername.setText(
				"Store Backend - Sales Personnel Login (" + BoutiqueStoreAppService.loggedInUser.getUserName() + ")");
	}

	private void storeActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
		boutiqueStoreAppService.loadProductsFromDB();
		BoutiqueStoreAppService.productsInCartWithQuantity = new HashMap<ProductResponse, Integer>();
		storePage.extracted();
		storePage.setVisible(Boolean.TRUE);
	}

	public void extracted() {
		jPanel2.removeAll();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		int productNumber = 1;
		if (BoutiqueStoreAppService.products != null && BoutiqueStoreAppService.products.size() > 0) {
			for (ProductResponse productResponse : BoutiqueStoreAppService.products) {
				addProduct(jPanel2, gbc, productResponse, productNumber);
				++gbc.gridy;
				++productNumber;
			}
		}
	}

	// Variables declaration
	private javax.swing.JButton addNewProduct;
	private javax.swing.JLabel date;
	private java.awt.Label header;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel loggedUsername;
	private javax.swing.JButton logout;
	private javax.swing.JButton store;
	// End of variables declaration

	private void addProduct(JPanel panel, GridBagConstraints gbc, ProductResponse productResponse, int productNumber) {

		JPanel mainPanel = new JPanel(new FlowLayout());
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.setBackground(Color.WHITE);
		panel.add(mainPanel, gbc);

		JPanel serialNumberPanel = new JPanel();
		serialNumberPanel.setPreferredSize(new Dimension(30, 100));
		serialNumberPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.add(serialNumberPanel);

		JLabel serialNumberLabel = new JLabel(productNumber + "");
		serialNumberPanel.add(serialNumberLabel);

		JPanel titleColourPanel = new JPanel();
		titleColourPanel.setPreferredSize(new Dimension(150, 100));
		titleColourPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.add(titleColourPanel);
		titleColourPanel.setLayout(new BoxLayout(titleColourPanel, BoxLayout.Y_AXIS));

		JLabel titleLabel = new JLabel("Title : " + productResponse.getProductTitle());
		titleColourPanel.add(titleLabel);

		JLabel colorLabel = new JLabel("Color : " + productResponse.getProductColour());
		titleColourPanel.add(colorLabel);

		JPanel barcodeQuantityPanel = new JPanel();
		barcodeQuantityPanel.setPreferredSize(new Dimension(300, 100));
		barcodeQuantityPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.add(barcodeQuantityPanel);
		barcodeQuantityPanel.setLayout(new BoxLayout(barcodeQuantityPanel, BoxLayout.Y_AXIS));

		JLabel barcodeLabel = new JLabel("Barcode number : " + productResponse.getProductBarcode());
		barcodeQuantityPanel.add(barcodeLabel);

		JLabel productQuantityLabel = new JLabel("Quantity : " + productResponse.getProductQuantity());
		barcodeQuantityPanel.add(productQuantityLabel);

		JLabel priceLabel = new JLabel("Price : $" + productResponse.getProductPrice());
		barcodeQuantityPanel.add(priceLabel);

		JPanel descriptionReasonPanel = new JPanel();
		descriptionReasonPanel.setPreferredSize(new Dimension(350, 100));
		descriptionReasonPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.add(descriptionReasonPanel);
		descriptionReasonPanel.setLayout(new BoxLayout(descriptionReasonPanel, BoxLayout.Y_AXIS));

		JLabel descriptionLabel = new JLabel("Description : " + productResponse.getProductDescription());
		descriptionReasonPanel.add(descriptionLabel);

		JLabel reasonLabel = new JLabel("Reason unavailable : " + productResponse.getReasonForUnavailability());
		descriptionReasonPanel.add(reasonLabel);

		JButton editReasonButton = new JButton("Edit");
		descriptionReasonPanel.add(editReasonButton);

		editReasonButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BoutiqueStoreAppService.productResponse = productResponse;
				editReasonPage.setVisible(Boolean.TRUE);
			}
		});

		JButton editButton = new JButton("Edit");
		JButton deleteButton = new JButton("Delete");

		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BoutiqueStoreAppService.productResponse = productResponse;
				newProduct.displayProductInEditMode();
				newProduct.setVisible(Boolean.TRUE);
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productService.deleteProduct(productResponse.getProductId());
				JOptionPane.showMessageDialog(null, "Product Deleted Successfully");
				boutiqueStoreAppService.loadProductsFromDB();
				extracted();
			}
		});

		mainPanel.add(editButton);
		mainPanel.add(deleteButton);

	}
}
