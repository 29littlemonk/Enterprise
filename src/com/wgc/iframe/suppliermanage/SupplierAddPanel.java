package com.wgc.iframe.suppliermanage;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class SupplierAddPanel extends JPanel {
	private JTextField fullnameField;
	private JTextField addressField;
	private JTextField contactField;
	private JTextField phoneField;
	private JTextField telField;
	private JTextField bankField;
	private JTextField emailField;
	private JTextField shortField;

	/**
	 * Create the panel.
	 */
	public SupplierAddPanel() {
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		//gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		setLayout(gridBagLayout);
		
		JLabel fullnameLabel = new JLabel("\u4F9B\u5E94\u5546\u5168\u79F0");
		fullnameLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_fullnameLabel = new GridBagConstraints();
		gbc_fullnameLabel.anchor = GridBagConstraints.EAST;
		gbc_fullnameLabel.insets = new Insets(5, 5, 5, 5);
		gbc_fullnameLabel.gridx = 0;
		gbc_fullnameLabel.gridy = 0;
		gbc_fullnameLabel.gridwidth = 1;
		//gbc_fullnameLabel.ipady = 10;
		add(fullnameLabel, gbc_fullnameLabel);
		
		fullnameField = new JTextField();
		fullnameField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_fullnameField = new GridBagConstraints();
		gbc_fullnameField.gridwidth = 3;
		gbc_fullnameField.insets = new Insets(5, 5, 5, 5);
		gbc_fullnameField.fill = GridBagConstraints.BOTH;
		gbc_fullnameField.gridx = 1;
		gbc_fullnameField.gridy = 0;
		gbc_fullnameField.ipadx = 300;
		//gbc_fullnameField.ipady = 8;
		add(fullnameField, gbc_fullnameField);
		
		JLabel addressLabel = new JLabel("\u5730\u5740");
		addressLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_addressLabel = new GridBagConstraints();
		gbc_addressLabel.anchor = GridBagConstraints.EAST;
		gbc_addressLabel.insets = new Insets(5, 5, 5, 5);
		gbc_addressLabel.gridx = 0;
		gbc_addressLabel.gridy = 1;
		gbc_fullnameLabel.gridwidth = 1;
		add(addressLabel, gbc_addressLabel);
		
		addressField = new JTextField();
		addressField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_addressField = new GridBagConstraints();
		gbc_addressField.gridwidth = 3;
		gbc_addressField.insets = new Insets(5, 5, 5, 5);
		gbc_addressField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addressField.gridx = 1;
		gbc_addressField.gridy = 1;
		add(addressField, gbc_addressField);
	
		JLabel contactLabel = new JLabel("\u8054\u7CFB\u4EBA");
		contactLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_contactLabel = new GridBagConstraints();
		gbc_contactLabel.anchor = GridBagConstraints.EAST;
		gbc_contactLabel.insets = new Insets(5, 5, 5, 5);
		gbc_contactLabel.gridx = 0;
		gbc_contactLabel.gridy = 2;
		add(contactLabel, gbc_contactLabel);
		
		contactField = new JTextField();
		contactField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_contactField = new GridBagConstraints();
		gbc_contactField.insets = new Insets(5, 5, 5, 5);
		gbc_contactField.fill = GridBagConstraints.HORIZONTAL;
		gbc_contactField.gridx = 1;
		gbc_contactField.gridy = 2;
		gbc_contactField.ipadx = 100;
		add(contactField, gbc_contactField);
		
		JLabel phoneLabel = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		phoneLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
		gbc_phoneLabel.anchor = GridBagConstraints.EAST;
		gbc_phoneLabel.insets = new Insets(5, 5, 5, 5);
		gbc_phoneLabel.gridx = 2;
		gbc_phoneLabel.gridy = 2;
		add(phoneLabel, gbc_phoneLabel);
		
		telField = new JTextField();
		telField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_telField = new GridBagConstraints();
		gbc_telField.insets = new Insets(5, 5, 5, 5);
		gbc_telField.fill = GridBagConstraints.HORIZONTAL;
		gbc_telField.gridx = 3;
		gbc_telField.gridy = 2;
		add(telField, gbc_telField);
		
		JLabel bankLabel = new JLabel("\u5F00\u6237\u94F6\u884C");
		bankLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_bankLabel = new GridBagConstraints();
		gbc_bankLabel.anchor = GridBagConstraints.EAST;
		gbc_bankLabel.insets = new Insets(5, 5, 5, 5);
		gbc_bankLabel.gridx = 0;
		gbc_bankLabel.gridy = 3;
		add(bankLabel, gbc_bankLabel);
		
		bankField = new JTextField();
		bankField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_bankField = new GridBagConstraints();
		gbc_bankField.insets = new Insets(5, 5, 5, 5);
		gbc_bankField.fill = GridBagConstraints.HORIZONTAL;
		gbc_bankField.gridx = 1;
		gbc_bankField.gridy = 3;
		add(bankField, gbc_bankField);
		
		JLabel emailLabel = new JLabel("\u90AE\u7BB1");
		emailLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.EAST;
		gbc_emailLabel.insets = new Insets(5, 5, 5, 5);
		gbc_emailLabel.gridx = 2;
		gbc_emailLabel.gridy = 3;
		add(emailLabel, gbc_emailLabel);
		
		emailField = new JTextField();
		emailField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(5, 5, 5, 5);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 3;
		gbc_emailField.gridy = 3;
		add(emailField, gbc_emailField);
		
		JLabel shortLabel = new JLabel("\u4F9B\u5E94\u5546\u7B80\u79F0");
		shortLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_shortLabel = new GridBagConstraints();
		gbc_shortLabel.anchor = GridBagConstraints.EAST;
		gbc_shortLabel.insets = new Insets(5, 5, 5, 5);
		gbc_shortLabel.gridx = 0;
		gbc_shortLabel.gridy = 4;
		add(shortLabel, gbc_shortLabel);
		
		shortField = new JTextField();
		shortField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_shortField = new GridBagConstraints();
		gbc_shortField.insets = new Insets(5, 5, 5, 5);
		gbc_shortField.fill = GridBagConstraints.HORIZONTAL;
		gbc_shortField.gridx = 1;
		gbc_shortField.gridy = 4;
		add(shortField, gbc_shortField);
		
		JButton addButton = new JButton("\u6DFB\u52A0");
		addButton.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.insets = new Insets(5, 5, 5, 5);
		gbc_addButton.gridx = 2;
		gbc_addButton.gridy = 4;
		add(addButton, gbc_addButton);
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_resetButton = new GridBagConstraints();
		gbc_resetButton.insets = new Insets(5, 5, 5, 5);
		gbc_resetButton.gridx = 3;
		gbc_resetButton.gridy = 4;
		add(resetButton, gbc_resetButton);
	}

}
