package com.wgc;

import com.wgc.login.LoginDialog;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame{
	private DesktopPanel desktopPanel = null;
	private JPanel frameContentPanel = null;
	private ToolBar toolBar = null;
	
	public DesktopPanel getDesktopPanel(){
		if(desktopPanel == null) {
			desktopPanel = new DesktopPanel();
		}
		return desktopPanel;
	}
	public ToolBar getToolBar(){
		if(toolBar == null) {
			toolBar = new ToolBar();
			toolBar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return toolBar;
	}
	public JPanel getFrameContentPanel() {
		if(frameContentPanel == null) {
			frameContentPanel = new JPanel();
			frameContentPanel.setLayout(new BorderLayout());
			frameContentPanel.add(getDesktopPanel(), BorderLayout.CENTER);
			frameContentPanel.add(getToolBar(), BorderLayout.NORTH);
		}
		return frameContentPanel;
	}
	
	public void initialize() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(200, 100, 800, 600);
		this.setJMenuBar(new MenuBar());
		this.setContentPane(getFrameContentPanel());
		this.setTitle("铭泰企业进销存管理系统");
	}
	public MainFrame() {
		// TODO Auto-generated constructor stub
		super();
		initialize();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginDialog loginDialog = new LoginDialog();
	}

}
