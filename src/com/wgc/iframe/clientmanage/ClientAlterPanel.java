package com.wgc.iframe.clientmanage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wgc.dao.Dao;
import com.wgc.dao.model.ClientInfo;
import com.wgc.dao.model.SupplierInfo;
import com.wgc.iframe.suppliermanage.SupplierAlterPanel;

public class ClientAlterPanel extends JPanel {

	private JTextField fullnameField;
	private JTextField addressField;
	private JTextField contactField;
	private JTextField telField;
	private JTextField bankField;
	private JTextField emailField;
	private JTextField shortField;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public ClientAlterPanel() {
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		JLabel fullnameLabel = new JLabel("客户全称");
		fullnameLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_fullnameLabel = new GridBagConstraints();
		gbc_fullnameLabel.anchor = GridBagConstraints.EAST;
		gbc_fullnameLabel.insets = new Insets(0, 5, 5, 5);
		gbc_fullnameLabel.gridx = 0;
		gbc_fullnameLabel.gridy = 0;
		gbc_fullnameLabel.gridwidth = 1;
		//gbc_fullnameLabel.ipady = 10;
		add(fullnameLabel, gbc_fullnameLabel);
		
		fullnameField = new JTextField();
		fullnameField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_fullnameField = new GridBagConstraints();
		gbc_fullnameField.gridwidth = 3;
		gbc_fullnameField.insets = new Insets(0, 5, 5, 5);
		gbc_fullnameField.fill = GridBagConstraints.BOTH;
		gbc_fullnameField.gridx = 1;
		gbc_fullnameField.gridy = 0;
		gbc_fullnameField.ipadx = 310;
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
		
		JLabel supplierLabel = new JLabel("请选择客户");
		supplierLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_supplierLabel = new GridBagConstraints();
		gbc_supplierLabel.anchor = GridBagConstraints.EAST;
		gbc_supplierLabel.insets = new Insets(5, 5, 5, 5);
		gbc_supplierLabel.gridx = 0;
		gbc_supplierLabel.gridy = 4;
		add(supplierLabel, gbc_supplierLabel);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(5, 5, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		add(comboBox, gbc_comboBox);
		
		JLabel shortLabel = new JLabel("客户简称");
		shortLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_shortLabel = new GridBagConstraints();
		gbc_shortLabel.anchor = GridBagConstraints.EAST;
		gbc_shortLabel.insets = new Insets(5, 5, 5, 5);
		gbc_shortLabel.gridx = 0;
		gbc_shortLabel.gridy = 5;
		add(shortLabel, gbc_shortLabel);
		
		shortField = new JTextField();
		shortField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_shortField = new GridBagConstraints();
		gbc_shortField.insets = new Insets(5, 5, 5, 5);
		gbc_shortField.fill = GridBagConstraints.HORIZONTAL;
		gbc_shortField.gridx = 1;
		gbc_shortField.gridy = 5;
		add(shortField, gbc_shortField);
		
		JButton alterButton = new JButton("\u4FEE\u6539");
		alterButton.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_alterButton = new GridBagConstraints();
		gbc_alterButton.insets = new Insets(5, 5, 5, 5);
		gbc_alterButton.gridx = 2;
		gbc_alterButton.gridy = 5;
		add(alterButton, gbc_alterButton);
		
		JButton deleteButton = new JButton("\u5220\u9664");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.insets = new Insets(5, 5, 5, 5);
		gbc_deleteButton.gridx = 3;
		gbc_deleteButton.gridy = 5;
		add(deleteButton, gbc_deleteButton);		
		
		
		initComboBox();
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				setClientByName();
			}
		});
		//setSupplierByName();//要放在各個field後面，否則field沒初始化，無法為field設置text。
		alterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateClient();
			}
		});
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				deleteClient();
			}
		});
	}
	public void initComboBox() {
		comboBox.removeAllItems();
		List<String> clientName = Dao.getClientName();
		Iterator<String> ite = clientName.iterator();
		while(ite.hasNext()) {
			comboBox.addItem(ite.next());
		}
		setClientByName();
	}
	public void setClientByName() {
		if(comboBox.getItemCount() == 0)
			return;//相當於當全部移除item時，讓item的監聽器不再執行以下操作，否則會出現異常
		ClientInfo client = Dao.getClientByName(comboBox.getSelectedItem().toString()); 
		fullnameField.setText(client.getFullname());
		addressField.setText(client.getAddress());
		contactField.setText(client.getContact());
		telField.setText(client.getPhone());
		bankField.setText(client.getBank());
		emailField.setText(client.getEmail());
		shortField.setText(client.getShortname());
	}
	public void updateClient() {
		ClientInfo client = new ClientInfo();
		client.setFullname(fullnameField.getText().trim());
		client.setAddress(addressField.getText().trim());
		client.setContact(contactField.getText().trim());
		client.setPhone(telField.getText().trim());
		client.setBank(bankField.getText().trim());
		client.setEmail(emailField.getText().trim());
		client.setShortname(shortField.getText().trim());
		if(Dao.updateClient(client, comboBox.getSelectedItem().toString()) == 1){
			JOptionPane.showMessageDialog(ClientAlterPanel.this, "修改成功", "消息", JOptionPane.INFORMATION_MESSAGE);
			initComboBox();
		}else {
			JOptionPane.showMessageDialog(ClientAlterPanel.this, "修改失败", "消息", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void deleteClient() {
		int confirm = JOptionPane.showConfirmDialog(this, "真的要删除吗？");
		if(confirm == JOptionPane.YES_OPTION) {
			if(Dao.deleteClient(comboBox.getSelectedItem().toString()) == 1) {
				JOptionPane.showMessageDialog(this, "删除成功");
			}
			else
				JOptionPane.showMessageDialog(this, "删除失败");
			initComboBox();
		}
	}

}
