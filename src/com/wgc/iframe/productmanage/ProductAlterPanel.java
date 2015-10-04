package com.wgc.iframe.productmanage;

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
import com.wgc.dao.model.ProductInfo;
import com.wgc.dao.model.SupplierInfo;
import com.wgc.iframe.suppliermanage.SupplierAlterPanel;

public class ProductAlterPanel extends JPanel {
	
	private JTextField fullnameField;
	private JTextField originplaceField;
	private JTextField shortnameField;
	private JTextField unitField;
	private JTextField standardField;
	private JTextField packageField;
	private JTextField approvalField;
	private JTextField lotnumberField;
	private JTextField memoField;
	private JComboBox<String> supplierComboBox;
	private JComboBox<String> productComboBox;
	/**
	 * Create the panel.
	 */
	public ProductAlterPanel() {
		super();
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		//gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		//gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		//gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel fullnameLabel = new JLabel("\u5546\u54C1\u540D\u79F0");
		fullnameLabel.setForeground(Color.BLACK);
		fullnameLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_fullnameLabel = new GridBagConstraints();
		gbc_fullnameLabel.insets = new Insets(5, 5, 5, 5);
		gbc_fullnameLabel.anchor = GridBagConstraints.EAST;
		gbc_fullnameLabel.gridx = 0;
		gbc_fullnameLabel.gridy = 0;
		add(fullnameLabel, gbc_fullnameLabel);
		
		fullnameField = new JTextField();
		fullnameField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_fullnameField = new GridBagConstraints();
		gbc_fullnameField.gridwidth = 3;
		gbc_fullnameField.insets = new Insets(5, 5, 5, 5);
		gbc_fullnameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fullnameField.gridx = 1;
		gbc_fullnameField.gridy = 0;
		gbc_fullnameField.ipadx = 300;
		add(fullnameField, gbc_fullnameField);
		
		JLabel originplaceLabel = new JLabel("\u4EA7\u5730");
		originplaceLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_originplaceLabel = new GridBagConstraints();
		gbc_originplaceLabel.anchor = GridBagConstraints.EAST;
		gbc_originplaceLabel.insets = new Insets(5, 5, 5, 5);
		gbc_originplaceLabel.gridx = 0;
		gbc_originplaceLabel.gridy = 1;
		add(originplaceLabel, gbc_originplaceLabel);
		
		originplaceField = new JTextField();
		originplaceField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_originplaceField = new GridBagConstraints();
		gbc_originplaceField.gridwidth = 3;
		gbc_originplaceField.insets = new Insets(5, 5, 5, 5);
		gbc_originplaceField.fill = GridBagConstraints.HORIZONTAL;
		gbc_originplaceField.gridx = 1;
		gbc_originplaceField.gridy = 1;
		add(originplaceField, gbc_originplaceField);
		
		JLabel shortnameLabel = new JLabel("\u5546\u54C1\u7B80\u79F0");
		shortnameLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_shortnameLabel = new GridBagConstraints();
		gbc_shortnameLabel.anchor = GridBagConstraints.EAST;
		gbc_shortnameLabel.insets = new Insets(5, 5, 5, 5);
		gbc_shortnameLabel.gridx = 0;
		gbc_shortnameLabel.gridy = 2;
		add(shortnameLabel, gbc_shortnameLabel);
		
		shortnameField = new JTextField();
		shortnameField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_shortnameField = new GridBagConstraints();
		gbc_shortnameField.insets = new Insets(5, 5, 5, 5);
		gbc_shortnameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_shortnameField.gridx = 1;
		gbc_shortnameField.gridy = 2;
		gbc_shortnameField.ipadx = 70;
		add(shortnameField, gbc_shortnameField);
		
		JLabel unitLabel = new JLabel("\u5355\u4F4D");
		unitLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_unitLabel = new GridBagConstraints();
		gbc_unitLabel.anchor = GridBagConstraints.EAST;
		gbc_unitLabel.insets = new Insets(5, 5, 5, 5);
		gbc_unitLabel.gridx = 2;
		gbc_unitLabel.gridy = 2;
		add(unitLabel, gbc_unitLabel);
		
		unitField = new JTextField();
		unitField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_unitField = new GridBagConstraints();
		gbc_unitField.insets = new Insets(5, 5, 5, 5);
		gbc_unitField.fill = GridBagConstraints.HORIZONTAL;
		gbc_unitField.gridx = 3;
		gbc_unitField.gridy = 2;
		add(unitField, gbc_unitField);
		
		JLabel standardLabel = new JLabel("\u89C4\u683C");
		standardLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_standardLabel = new GridBagConstraints();
		gbc_standardLabel.anchor = GridBagConstraints.EAST;
		gbc_standardLabel.insets = new Insets(5, 5, 5, 5);
		gbc_standardLabel.gridx = 0;
		gbc_standardLabel.gridy = 3;
		add(standardLabel, gbc_standardLabel);
		
		standardField = new JTextField();
		standardField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_standardField = new GridBagConstraints();
		gbc_standardField.insets = new Insets(5, 5, 5, 5);
		gbc_standardField.fill = GridBagConstraints.HORIZONTAL;
		gbc_standardField.gridx = 1;
		gbc_standardField.gridy = 3;
		add(standardField, gbc_standardField);
		
		JLabel packageLabel = new JLabel("\u5305\u88C5");
		packageLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_packageLabel = new GridBagConstraints();
		gbc_packageLabel.anchor = GridBagConstraints.EAST;
		gbc_packageLabel.insets = new Insets(5, 5, 5, 5);
		gbc_packageLabel.gridx = 2;
		gbc_packageLabel.gridy = 3;
		add(packageLabel, gbc_packageLabel);
		
		packageField = new JTextField();
		packageField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_packageField = new GridBagConstraints();
		gbc_packageField.insets = new Insets(5, 5, 5, 0);
		gbc_packageField.fill = GridBagConstraints.HORIZONTAL;
		gbc_packageField.gridx = 3;
		gbc_packageField.gridy = 3;
		add(packageField, gbc_packageField);
		
		JLabel approvalLabel = new JLabel("\u6279\u51C6\u6587\u53F7");
		approvalLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_approvalLabel = new GridBagConstraints();
		gbc_approvalLabel.anchor = GridBagConstraints.EAST;
		gbc_approvalLabel.insets = new Insets(5, 5, 5, 5);
		gbc_approvalLabel.gridx = 0;
		gbc_approvalLabel.gridy = 4;
		add(approvalLabel, gbc_approvalLabel);
		
		approvalField = new JTextField();
		approvalField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_approvalField = new GridBagConstraints();
		gbc_approvalField.insets = new Insets(5, 5, 5, 5);
		gbc_approvalField.fill = GridBagConstraints.HORIZONTAL;
		gbc_approvalField.gridx = 1;
		gbc_approvalField.gridy = 4;
		add(approvalField, gbc_approvalField);
		
		JLabel lotnumberLabel = new JLabel("\u6279\u53F7");
		lotnumberLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_lotnumberLabel = new GridBagConstraints();
		gbc_lotnumberLabel.anchor = GridBagConstraints.EAST;
		gbc_lotnumberLabel.insets = new Insets(5, 5, 5, 5);
		gbc_lotnumberLabel.gridx = 2;
		gbc_lotnumberLabel.gridy = 4;
		add(lotnumberLabel, gbc_lotnumberLabel);
		
		lotnumberField = new JTextField();
		lotnumberField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_lotnumberField = new GridBagConstraints();
		gbc_lotnumberField.insets = new Insets(5, 5, 5, 5);
		gbc_lotnumberField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lotnumberField.gridx = 3;
		gbc_lotnumberField.gridy = 4;
		add(lotnumberField, gbc_lotnumberField);
		
		JLabel memoLabel = new JLabel("\u5907\u6CE8");
		memoLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_memoLabel = new GridBagConstraints();
		gbc_memoLabel.anchor = GridBagConstraints.EAST;
		gbc_memoLabel.insets = new Insets(5, 5, 5, 5);
		gbc_memoLabel.gridx = 0;
		gbc_memoLabel.gridy = 5;
		add(memoLabel, gbc_memoLabel);
		
		memoField = new JTextField();
		memoField.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_memoField = new GridBagConstraints();
		gbc_memoField.gridwidth = 3;
		gbc_memoField.insets = new Insets(5, 5, 5, 5);
		gbc_memoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_memoField.gridx = 1;
		gbc_memoField.gridy = 5;
		add(memoField, gbc_memoField);
		
		JLabel supplierLabel = new JLabel("\u4F9B\u5E94\u5546");
		supplierLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_supplierLabel = new GridBagConstraints();
		gbc_supplierLabel.anchor = GridBagConstraints.EAST;
		gbc_supplierLabel.insets = new Insets(5, 5, 5, 5);
		gbc_supplierLabel.gridx = 0;
		gbc_supplierLabel.gridy = 6;
		add(supplierLabel, gbc_supplierLabel);
		
		supplierComboBox = new JComboBox<String>();
		supplierComboBox.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_supplierComboBox = new GridBagConstraints();
		gbc_supplierComboBox.gridwidth = 3;
		gbc_supplierComboBox.insets = new Insets(5, 5, 5, 5);
		gbc_supplierComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_supplierComboBox.gridx = 1;
		gbc_supplierComboBox.gridy = 6;
		add(supplierComboBox, gbc_supplierComboBox);
		
		JLabel productLabel = new JLabel("\u9009\u62E9\u5546\u54C1");
		productLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_productLabel = new GridBagConstraints();
		gbc_productLabel.anchor = GridBagConstraints.EAST;
		gbc_productLabel.insets = new Insets(5, 5, 5, 5);
		gbc_productLabel.gridx = 0;
		gbc_productLabel.gridy = 7;
		add(productLabel, gbc_productLabel);
		
		productComboBox = new JComboBox<String>();
		productComboBox.setFont(new Font("宋体", Font.PLAIN, 14) );
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(5, 5, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 7;
		add(productComboBox, gbc_comboBox);
		
		JButton alterButton = new JButton("\u4FEE\u6539");
		alterButton.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_alterButton = new GridBagConstraints();
		gbc_alterButton.insets = new Insets(5, 5, 5, 5);
		gbc_alterButton.gridx = 2;
		gbc_alterButton.gridy = 7;
		add(alterButton, gbc_alterButton);
		
		JButton deleteButton = new JButton("\u5220\u9664");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.insets = new Insets(5, 5, 5, 5);
		gbc_deleteButton.gridx = 3;
		gbc_deleteButton.gridy = 7;
		add(deleteButton, gbc_deleteButton);
		
		initSupplierComboBox();
		
		productComboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				setProductByName();
			}
		});
		alterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				updateProduct();
			}
		});
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteProduct();
			}
		});

	}
	public void initProductComboBox() {
		productComboBox.removeAllItems();
		List<String> productName = Dao.getProductName();
		Iterator<String> ite = productName.iterator();
		while(ite.hasNext()) {
			productComboBox.addItem(ite.next());
		}
		setProductByName();
	}
	public void setProductByName() {
		if(productComboBox.getItemCount() == 0)
			return;//相當於當全部移除item時，讓item的監聽器不再執行以下操作，否則會出現異常
		ProductInfo product = Dao.getProductByName(productComboBox.getSelectedItem().toString()); 
		fullnameField.setText(product.getFullname());
		originplaceField.setText(product.getOriginplace());
		shortnameField.setText(product.getShortname());
		unitField.setText(product.getUnit());
		standardField.setText(product.getStandard());
		packageField.setText(product.getPac());
		lotnumberField.setText(product.getLotnumber());
		approvalField.setText(product.getApproval());
		memoField.setText(product.getMemo());
		supplierComboBox.setSelectedItem(product.getSupplier());
	}
	public void updateProduct() {
		ProductInfo product = new ProductInfo();
		product.setFullname(fullnameField.getText().trim());
		product.setApproval(approvalField.getText().trim());
		product.setLotnumber(lotnumberField.getText().trim());
		product.setMemo(memoField.getText().trim());
		product.setOriginplace(originplaceField.getText().trim());
		product.setPac(packageField.getText().trim());
		product.setShortname(shortnameField.getText().trim());
		product.setStandard(standardField.getText().trim());
		product.setSupplier(supplierComboBox.getSelectedItem().toString());
		product.setUnit(unitField.getText().trim());
	
		if(Dao.updateProduct(product, productComboBox.getSelectedItem().toString()) == 1){
			JOptionPane.showMessageDialog(ProductAlterPanel.this, "修改成功", "消息", JOptionPane.INFORMATION_MESSAGE);
			initProductComboBox();
		}else {
			JOptionPane.showMessageDialog(ProductAlterPanel.this, "修改失败", "消息", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void deleteProduct() {
		int confirm = JOptionPane.showConfirmDialog(this, "真的要删除吗？");
		if(confirm == JOptionPane.YES_OPTION) {
			if(Dao.deleteProduct(productComboBox.getSelectedItem().toString()) == 1) {
				JOptionPane.showMessageDialog(this, "删除成功");
			}
			else
				JOptionPane.showMessageDialog(this, "删除失败");
			initProductComboBox();
		}
	}
	public void initSupplierComboBox() {
		//supplierComboBox.removeAllItems();
		List<String> supplierName = Dao.getSupplierName();
		Iterator<String> ite = supplierName.iterator();
		while(ite.hasNext()) {
			supplierComboBox.addItem(ite.next());
		}
	}

}
