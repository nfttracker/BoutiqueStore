package com.mascene.ui;

import javax.swing.JOptionPane;

import org.springframework.beans.BeanUtils;
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
 *         Edit Reason UI screen class
 */
@Service
public class EditReasonPage extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	@Autowired
	AdminPage adminPage;

	@Autowired
	ProductService productService;

	@Autowired
	BoutiqueStoreAppService boutiqueStoreAppService;

	public EditReasonPage() {
		initComponents();
	}

	private void initComponents() {

		header = new java.awt.Label();
		jScrollPane1 = new javax.swing.JScrollPane();
		reasonTextArea = new javax.swing.JTextArea();
		jLabel1 = new javax.swing.JLabel();
		submitReasonButton = new javax.swing.JButton();
		cancelReasonButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		header.setAlignment(java.awt.Label.CENTER);
		header.setBackground(new java.awt.Color(153, 153, 255));
		header.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		header.setText("MA Scene Inc.");

		reasonTextArea.setColumns(20);
		reasonTextArea.setRows(5);
		jScrollPane1.setViewportView(reasonTextArea);

		jLabel1.setText("Enter the reason for unavailability:");

		submitReasonButton.setText("Submit");
		submitReasonButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitReasonButtonActionPerformed(evt);
			}
		});

		cancelReasonButton.setText("Cancel");
		cancelReasonButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelReasonButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1)
								.addGroup(layout.createSequentialGroup().addComponent(jLabel1).addGap(0, 0,
										Short.MAX_VALUE)))
						.addContainerGap())
				.addGroup(layout.createSequentialGroup().addGap(36, 36, 36)
						.addComponent(submitReasonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(30, 30, 30)
						.addComponent(cancelReasonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(8, 8, 8).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(submitReasonButton).addComponent(cancelReasonButton))
						.addGap(0, 11, Short.MAX_VALUE)));

		pack();
		this.setResizable(Boolean.FALSE);
	}

	private void submitReasonButtonActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			if (reasonTextArea.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please provide the reason before submiting");
			} else {
				ProductRequest productRequest = new ProductRequest();
				BeanUtils.copyProperties(BoutiqueStoreAppService.productResponse, productRequest);
				productRequest.setProductQuantity(0L);
				productRequest.setReasonForUnavailability(reasonTextArea.getText());
				productService.updateProduct(productRequest, BoutiqueStoreAppService.productResponse.getProductId());
				BoutiqueStoreAppService.productResponse = new ProductResponse();
				JOptionPane.showMessageDialog(null, "Reason updated successfully");
				boutiqueStoreAppService.loadProductsFromDB();
				dispose();
				adminPage.extracted();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Some issue with the product reason updation, please check once again");
			dispose();
		}
	}

	private void cancelReasonButtonActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
	}

	// Variables declaration
	private javax.swing.JButton cancelReasonButton;
	private java.awt.Label header;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea reasonTextArea;
	private javax.swing.JButton submitReasonButton;
	// End of variables declaration
}
