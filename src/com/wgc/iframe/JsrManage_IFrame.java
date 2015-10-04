package com.wgc.iframe;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.wgc.iframe.jsrmanage.JsrAddPanel;
import com.wgc.iframe.jsrmanage.JsrAlterPanel;

public class JsrManage_IFrame extends JInternalFrame{
	private JTabbedPane tab;
	private JsrAddPanel jsrAddPanel;
	private JsrAlterPanel jsrAlterPanel;
	public JsrManage_IFrame() {
		// TODO Auto-generated constructor stub
		tab = new JTabbedPane();
		jsrAddPanel = new JsrAddPanel();
		jsrAlterPanel = new JsrAlterPanel();
		tab.addTab("添加经手人", jsrAddPanel);
		tab.addTab("设置经手人", jsrAlterPanel);
		getContentPane().add(tab);
		tab.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				jsrAlterPanel.initTable();
			}
		});
		this.setIconifiable(true);
		this.setClosable(true);
		this.setBounds(0, 0, 350, 250);
		this.setVisible(true);
	}
}
