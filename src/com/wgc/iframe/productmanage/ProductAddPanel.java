package com.wgc.iframe.productmanage;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.wgc.dao.Dao;
import com.wgc.dao.model.SupplierInfo;
import com.wgc.dao.model.ProductInfo;
import com.wgc.iframe.suppliermanage.SupplierAddPanel;

import java.awt.Font;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class ProductAddPanel extends JPanel {
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
	/**
	 * Create the panel.
	 */
	public ProductAddPanel() {
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
		gbc_unitField.insets = new Insets(5, 5, 5,5);
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
		gbc_packageField.insets = new Insets(5, 5, 5, 5);
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
		gbc_supplierComboBox.insets = new Insets(5, 5, 5, 5);
		gbc_supplierComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_supplierComboBox.gridx = 1;
		gbc_supplierComboBox.gridy = 6;
		add(supplierComboBox, gbc_supplierComboBox);
		
		JButton addButton = new JButton("\u6DFB\u52A0");
		addButton.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.insets = new Insets(5, 0, 5, 0);
		gbc_addButton.gridx = 2;
		gbc_addButton.gridy = 6;
		add(addButton, gbc_addButton);
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_resetButton = new GridBagConstraints();
		gbc_resetButton.insets = new Insets(5, 5, 5, 5);
		gbc_resetButton.gridx = 3;
		gbc_resetButton.gridy = 6;
		add(resetButton, gbc_resetButton);
		
addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(fullnameField.getText().equals("") || originplaceField.getText().equals("") ||  unitField.getText().equals("") || standardField.getText().equals("")
						|| packageField.getText().equals("") || lotnumberField.getText().equals("") || shortnameField.getText().equals("") || approvalField.getText().equals("") 
						|| memoField.getText().equals("") || supplierComboBox.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(ProductAddPanel.this, "请填写全部信息","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				ResultSet result = Dao.getResultSet("select * from tb_productInfo where fullname = '" + fullnameField.getText().trim() +"' " );
				try {
					if(result.next()) {
						JOptionPane.showMessageDialog(ProductAddPanel.this, "此商品已存在", "警告", JOptionPane.WARNING_MESSAGE);
						return;
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String sid = null;
				result = Dao.getResultSet("select max(id) from tb_productInfo ");//max可以的对字符串排序
				
				try {
					//System.out.println(result.next());
					if(result != null && result.next()) {
						sid = "sp" + (Integer.parseInt(result.getString(1).substring(2)) + 1);
					}else
						sid = "sp1001";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ProductInfo product = new ProductInfo();
				product.setId(sid);
				product.setFullname(fullnameField.getText().trim());
				product.setShortname(shortnameField.getText().trim());
				product.setOriginplace(originplaceField.getText().trim());
				product.setUnit(unitField.getText().trim());
				product.setStandard(standardField.getText().trim());
				product.setPac(packageField.getText().trim());
				product.setLotnumber(lotnumberField.getText().trim());
				product.setApproval(approvalField.getText().trim());
				product.setMemo(memoField.getText().trim());
				product.setSupplier(supplierComboBox.getSelectedItem().toString());
				
				if(Dao.addProduct(product)) {
					JOptionPane.showMessageDialog(ProductAddPanel.this, "添加商品成功", "消息", JOptionPane.INFORMATION_MESSAGE);
					resetButton.doClick();
				}
				else
					JOptionPane.showMessageDialog(ProductAddPanel.this, "添加商品失败", "消息", JOptionPane.WARNING_MESSAGE);
			}
		});
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fullnameField.setText("");
				originplaceField.setText("");
				shortnameField.setText("");
				unitField.setText("");
				standardField.setText("");
				packageField.setText("");
				lotnumberField.setText("");
				approvalField.setText("");
				memoField.setText("");
			}
		});
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
