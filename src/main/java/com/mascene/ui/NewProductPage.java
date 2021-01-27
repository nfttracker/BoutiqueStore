package com.mascene.ui;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mascene.api.request.ProductRequest;
import com.mascene.api.response.ProductResponse;
import com.mascene.services.ProductService;
import com.mascene.utilities.BoutiqueStoreAppService;

/**
 *
 * @author Raman.Ahuja
 * 
 *         New Product Creation UI screen class
 */
@Service
public class NewProductPage extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	@Autowired
	BoutiqueStoreAppService boutiqueStoreAppService;

	@Autowired
	AdminPage adminPage;

	@Autowired
	ProductService productService;

	int editFlag = 1;

	public NewProductPage() {
		initComponents();
	}

	private void initComponents() {

		header = new java.awt.Label();
		addNewProductLabel = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel1 = new javax.swing.JLabel();
		productTitle = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		productColour = new javax.swing.JTextField();
		productBarcode = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		productQuantity = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		productPrice = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		description = new javax.swing.JTextArea();
		productDescription = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		reason = new javax.swing.JTextField();
		cancelButton = new javax.swing.JButton();
		saveButton = new javax.swing.JButton();
		jLabel7 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		header.setAlignment(java.awt.Label.CENTER);
		header.setBackground(new java.awt.Color(153, 153, 255));
		header.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		header.setText("MA Scene Inc.");

		addNewProductLabel.setBackground(new java.awt.Color(0, 51, 255));
		addNewProductLabel.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
		addNewProductLabel.setText("Add New Product");
		addNewProductLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		jLabel1.setFont(new java.awt.Font("Sylfaen", 2, 14)); // NOI18N
		jLabel1.setText("Product Title:");

		jLabel2.setFont(new java.awt.Font("Sylfaen", 2, 14)); // NOI18N
		jLabel2.setText("Product Colour:");

		jLabel3.setFont(new java.awt.Font("Sylfaen", 2, 14)); // NOI18N
		jLabel3.setText("Barcode:");

		jLabel4.setFont(new java.awt.Font("Sylfaen", 2, 14)); // NOI18N
		jLabel4.setText("Quantity:");

		jLabel5.setFont(new java.awt.Font("Sylfaen", 2, 14)); // NOI18N
		jLabel5.setText("Price:");

		description.setColumns(20);
		description.setRows(5);
		jScrollPane1.setViewportView(description);

		reason.setEnabled(Boolean.FALSE);
		reason.setText("NA");

		productDescription.setFont(new java.awt.Font("Sylfaen", 2, 14)); // NOI18N
		productDescription.setText("Description:");

		jLabel6.setFont(new java.awt.Font("Sylfaen", 2, 14)); // NOI18N
		jLabel6.setText("Reason for Unavailability:");

		cancelButton.setFont(new java.awt.Font("Sylfaen", 2, 14)); // NOI18N
		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		saveButton.setFont(new java.awt.Font("Sylfaen", 2, 14)); // NOI18N
		saveButton.setText("Save");
		saveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveButtonActionPerformed(evt);
			}
		});

		jLabel7.setText("$");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(jSeparator1)
				.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(addNewProductLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(saveButton)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(cancelButton).addGap(8, 8, 8))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2)
										.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel1).addComponent(jLabel4).addComponent(jLabel5)
										.addComponent(productDescription)).addGap(2, 2, 2).addComponent(jLabel7)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(productBarcode)
												.addComponent(productColour, javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(productTitle, javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(productPrice,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE, 56,
																Short.MAX_VALUE)
														.addComponent(productQuantity,
																javax.swing.GroupLayout.Alignment.LEADING))
												.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284,
														Short.MAX_VALUE))
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup().addComponent(jLabel6).addGap(18, 18, 18)
										.addComponent(reason)))
								.addContainerGap()))));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(addNewProductLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(saveButton))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18,
										Short.MAX_VALUE)
								.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1).addComponent(
																productTitle, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel2).addComponent(productColour,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(productBarcode,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(productQuantity, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel4))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel5)
										.addComponent(productPrice, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel7))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGap(21, 21, 21)
												.addComponent(productDescription))
										.addGroup(layout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37,
										Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(jLabel6,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(reason, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(21, 21, 21)));

		pack();
		this.setResizable(Boolean.FALSE);
	}

	private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (productTitle.getText().equals("") || productBarcode.getText().equals("")
				|| productColour.getText().equals("") || description.equals("") || productPrice.getText().equals("")
				|| productQuantity.getText().equals("") || reason.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Properly fill the product details properly");
		} else {
			try {
				ProductRequest productRequest = new ProductRequest();
				productRequest.setProductBarcode(Long.parseLong(productBarcode.getText()));
				productRequest.setProductColour(productColour.getText());
				productRequest.setProductDescription(description.getText());
				productRequest.setProductPrice(Float.parseFloat(productPrice.getText()));
				productRequest.setProductQuantity(Long.parseLong(productQuantity.getText()));
				productRequest.setProductSizes(null);
				productRequest.setProductTitle(productTitle.getText());
				productRequest.setReasonForUnavailability(reason.getText());
				if (editFlag == 0) {
					productService.updateProduct(productRequest,
							BoutiqueStoreAppService.productResponse.getProductId());
					editFlag = 1;
					BoutiqueStoreAppService.productResponse = new ProductResponse();
					JOptionPane.showMessageDialog(null, "Product updated successfully");
				} else {
					productService.createProduct(productRequest);
					JOptionPane.showMessageDialog(null, "Product saved successfully");
				}
				boutiqueStoreAppService.loadProductsFromDB();
				dispose();
				adminPage.extracted();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Some issue with the product data filled, please check once again");
				dispose();
			}
		}

	}

	public void displayProductInEditMode() {
		editFlag = 0;
		ProductResponse productResponse = BoutiqueStoreAppService.productResponse;
		if (productResponse.getProductBarcode() != null) {
			productBarcode.setText(productResponse.getProductBarcode() + "");
			productBarcode.setEnabled(Boolean.FALSE);
			productColour.setText(productResponse.getProductColour());
			description.setText(productResponse.getProductDescription());
			productPrice.setText(productResponse.getProductPrice() + "");
			productQuantity.setText(productResponse.getProductQuantity() + "");
			productTitle.setText(productResponse.getProductTitle());
			reason.setText(productResponse.getReasonForUnavailability());
		}
	}

	public void clearFields() {
		productBarcode.setText("");
		productBarcode.setEnabled(Boolean.TRUE);
		productColour.setText("");
		description.setText("");
		productPrice.setText("");
		productQuantity.setText("");
		productTitle.setText("");
		reason.setText("NA");
	}

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
		ProductResponse productResponse = new ProductResponse();
	}

	// Variables declaration
	private javax.swing.JLabel addNewProductLabel;
	private javax.swing.JButton cancelButton;
	private java.awt.Label header;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTextArea description;
	private javax.swing.JTextField reason;
	private javax.swing.JTextField productBarcode;
	private javax.swing.JTextField productColour;
	private javax.swing.JLabel productDescription;
	private javax.swing.JTextField productPrice;
	private javax.swing.JTextField productQuantity;
	private javax.swing.JTextField productTitle;
	private javax.swing.JButton saveButton;
	// End of variables declaration
}
