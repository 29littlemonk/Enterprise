package com.wgc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;

public class ToolBar extends JToolBar{
	
	private MenuBar menubar;
	public JButton createToolButton(final JMenuItem item) {
		JButton button = new JButton();
		button.setText(item.getText());
		button.setToolTipText(item.getText());
		button.setIcon(item.getIcon());
		button.setFocusable(false);
		button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				item.doClick();
			}
		});
		return button;
	}
	public void initialize() {
		this.setFloatable(false);
		this.setSize(600, 24);
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		add(createToolButton(menubar.getJinhuoItem()));
		add(createToolButton(menubar.getXiaoshouItem()));
		add(createToolButton(menubar.getKucunItem()));
		add(createToolButton(menubar.getPriceadjustmentItem()));
		add(createToolButton(menubar.getProductQueryItem()));
		add(createToolButton(menubar.getProductDataManagementItem()));
		add(createToolButton(menubar.getCustomerDataManagementItem()));
		add(createToolButton(menubar.getSupplierDataManagementItem()));
		add(createToolButton(menubar.getSystemExitItem()));
	}
	public ToolBar(MenuBar menubar) {
		// TODO Auto-generated constructor stub
		this.menubar = menubar;
		initialize();
	}
}

