package com.wgc.iframe;

import java.awt.Rectangle;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.wgc.iframe.clientmanage.ClientAddPanel;
import com.wgc.iframe.clientmanage.ClientAlterPanel;

public class ClientManage_IFrame extends JInternalFrame{
	private JTabbedPane tabPanel = null;
	private ClientAddPanel clientaddPanel = null;
	private ClientAlterPanel clientalterPanel = null;

	public ClientManage_IFrame() {
		// TODO Auto-generated constructor stub
		if (tabPanel == null) {
			tabPanel = new JTabbedPane();
			clientaddPanel = new ClientAddPanel();
			clientalterPanel = new ClientAlterPanel();
			tabPanel.add("添加客户", clientaddPanel);
			tabPanel.addTab("修改与删除客户", clientalterPanel);
		}

		getContentPane().add(tabPanel);
		tabPanel.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				clientalterPanel.initComboBox();
			}
		});
		this.setBounds(new Rectangle(0, 0, 460, 270));
		this.setIconifiable(true);
		this.setClosable(true);
		// this.setMaximizable(true);
		setVisible(true);
	}
}
