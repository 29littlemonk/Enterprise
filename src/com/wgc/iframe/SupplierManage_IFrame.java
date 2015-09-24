package com.wgc.iframe;

import java.awt.Rectangle;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;

import com.wgc.iframe.suppliermanage.SupplierAddPanel;
import com.wgc.iframe.suppliermanage.SupplierAlterPanel;

public class SupplierManage_IFrame extends JInternalFrame{
	private JTabbedPane tabPanel = null;
	private SupplierAddPanel supplieraddPanel = null;
	private SupplierAlterPanel supplieralterPanel = null;
	public SupplierManage_IFrame() {
		// TODO Auto-generated constructor stub
		if(tabPanel == null) {
			tabPanel = new JTabbedPane();
			supplieraddPanel = new SupplierAddPanel();
			supplieralterPanel = new SupplierAlterPanel();
			tabPanel.add("添加供应商",supplieraddPanel);
			tabPanel.addTab("修改与删除供应商", supplieralterPanel);
		}
		getContentPane().add(tabPanel);
		this.setBounds(new Rectangle(0, 0, 450, 270));
		this.setIconifiable(true);
		this.setClosable(true);
		//this.setMaximizable(true);
		setVisible(true);
	}
	
}
