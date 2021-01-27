package com.mascene.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mascene.utilities.BoutiqueStoreAppService;

/**
 *
 * @author Raman.Ahuja
 * 
 *         App login UI screen class
 */
@Component
public class AppLoginPage extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	BoutiqueStoreAppService boutiqueStoreAppService;

	@Autowired
	StorePage storePage;

	@Autowired
	AdminPage adminPage;

	public AppLoginPage() {
		initComponents();
	}

	private void initComponents() {

		header = new java.awt.Label();
		seperator = new javax.swing.JSeparator();
		username = new javax.swing.JLabel();
		password = new javax.swing.JLabel();
		usernameText = new javax.swing.JTextField();
		passwordText = new javax.swing.JPasswordField();
		loginButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		header.setAlignment(java.awt.Label.CENTER);
		header.setBackground(new java.awt.Color(153, 153, 255));
		header.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		header.setText("MA Scene Inc.");

		username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		username.setText("Username:");

		password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		password.setText("Password:");

		loginButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		loginButton.setText("Login");
		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(36, 36, 36)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addComponent(password).addGap(18, 18, 18))
								.addGroup(layout.createSequentialGroup().addComponent(username).addGap(16, 16, 16)))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(usernameText, javax.swing.GroupLayout.DEFAULT_SIZE, 159,
												Short.MAX_VALUE)
										.addComponent(passwordText))))
				.addContainerGap(123, Short.MAX_VALUE))
				.addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(seperator, javax.swing.GroupLayout.Alignment.TRAILING));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(37, 37, 37).addComponent(username))
								.addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(password).addComponent(passwordText,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(28, 28, 28).addComponent(loginButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
						.addComponent(seperator, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(55, 55, 55)));

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setBounds(0, 0, screenSize.width, screenSize.height - 100);
		this.setResizable(Boolean.FALSE);
	}

	private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
		@SuppressWarnings("deprecation")
		String empRole = boutiqueStoreAppService.authenticateUser(usernameText.getText(), passwordText.getText());
		if (empRole.equals("")) {
			JOptionPane.showMessageDialog(null, "Username/Password is incorrect...");
		} else {
			this.setVisible(Boolean.FALSE);
			dispose();
			storePage.extracted();
			storePage.hideAdminButton();
			storePage.setVisible(Boolean.TRUE);
		}
	}

	// Variables declaration
	private java.awt.Label header;
	private javax.swing.JButton loginButton;
	private javax.swing.JLabel password;
	private javax.swing.JPasswordField passwordText;
	private javax.swing.JSeparator seperator;
	private javax.swing.JLabel username;
	private javax.swing.JTextField usernameText;
	// End of variables declaration
}
