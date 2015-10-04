package com.wgc.iframe;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.wgc.iframe.productmanage.ProductAddPanel;
import com.wgc.iframe.productmanage.ProductAlterPanel;

public class ProductManage_IFrame extends JInternalFrame{
	JTabbedPane tab = null;
	ProductAddPanel productAddPanel = null;
	ProductAlterPanel productAlterPanel = null;
	public ProductManage_IFrame() {
		super();
		tab = new JTabbedPane();
		productAddPanel = new ProductAddPanel();
		productAlterPanel = new ProductAlterPanel();
		tab.addTab("添加商品", productAddPanel);
		tab.addTab("修改和删除商品", productAlterPanel);
		getContentPane().add(tab);
		addInternalFrameListener(new InternalFrameAdapter() {

			@Override
			public void internalFrameActivated(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				super.internalFrameActivated(arg0);
				productAddPanel.initSupplierComboBox();
			}
			
		});
		tab.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				productAlterPanel.initProductComboBox();
			}
		});
		this.setIconifiable(true);
		this.setClosable(true);
		this.setBounds(0, 0, 470,320);
		this.setVisible(true);
		
	}
	
	
}
