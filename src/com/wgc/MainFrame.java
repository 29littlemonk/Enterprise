package com.wgc;

import com.wgc.login.LoginDialog;

import java.awt.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
	private DesktopPanel desktopPanel = null;
	private JPanel frameContentPanel = null;
	private ToolBar toolBar = null;
	private JLabel stateLabel = null;
	private static JLabel userLabel = null;
	private JLabel dateLabel = null;
	private JLabel companyLabel = null;
	private JPanel statePanel = null;
	private MenuBar menuBar = null;

	public DesktopPanel getDesktopPanel() {
		if (desktopPanel == null) {
			desktopPanel = new DesktopPanel();
		}
		return desktopPanel;
	}

	public ToolBar getToolBar() {
		if (toolBar == null) {
			toolBar = new ToolBar(getFrameMenuBar());
			toolBar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return toolBar;
	}

	public MenuBar getFrameMenuBar() {
		if (menuBar == null) {
			menuBar = new MenuBar(getDesktopPanel(), getStateLabel());
		}
		return menuBar;
	}

	public JPanel getStatePanel() {
		companyLabel = new JLabel("大广泉村有限公司");
		dateLabel = new JLabel();
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					Date date = new Date();
					dateLabel.setText(String.format("%tc", date));
				}
			}
		});
		t.start();
		statePanel = new JPanel();
		statePanel.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
		statePanel.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.weightx = 1.0;
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.insets = new Insets(0, 5, 0, 5);
		GridBagConstraints constraint1 = new GridBagConstraints();
		constraint1.gridx = 1;
		constraint1.gridy = 0;
		constraint1.weighty = 1.0;
		constraint1.fill = GridBagConstraints.VERTICAL;
		constraint1.insets = new Insets(0, 5, 0, 5);
		GridBagConstraints constraint2 = new GridBagConstraints();
		constraint2.gridx = 2;
		constraint2.gridy = 0;
		constraint2.fill = GridBagConstraints.NONE;
		constraint2.insets = new Insets(0, 5, 0, 5);
		GridBagConstraints constraint3 = new GridBagConstraints();
		constraint3.gridx = 3;
		constraint3.gridy = 0;
		constraint3.weighty = 1.0;
		constraint3.fill = GridBagConstraints.VERTICAL;
		constraint3.insets = new Insets(0, 5, 0, 5);
		GridBagConstraints constraint4 = new GridBagConstraints();
		constraint4.gridx = 4;
		constraint4.gridy = 0;
		constraint4.fill = GridBagConstraints.NONE;
		constraint4.insets = new Insets(0, 5, 0, 5);
		GridBagConstraints constraint5 = new GridBagConstraints();
		constraint5.gridx = 5;
		constraint5.gridy = 0;
		constraint5.weighty = 1.0;
		constraint5.fill = GridBagConstraints.VERTICAL;
		constraint5.insets = new Insets(0, 5, 0, 5);
		GridBagConstraints constraint6 = new GridBagConstraints();
		constraint6.gridx = 6;
		constraint6.gridy = 0;
		constraint6.fill = GridBagConstraints.NONE;
		constraint6.insets = new Insets(0, 5, 0, 5);
		statePanel.add(getStateLabel(), constraint);
		statePanel.add(getJsperator(), constraint1);
		statePanel.add(getUserLabel(), constraint2);
		statePanel.add(getJsperator(), constraint3);
		statePanel.add(dateLabel, constraint4);
		statePanel.add(getJsperator(), constraint5);
		statePanel.add(companyLabel, constraint6);

		// statePanel.setLayout(new GridLayout(1, 4));
		// statePanel.add(getStateLabel());
		// statePanel.add(getUserLabel());
		// statePanel.add(dateLabel);
		// statePanel.add(companyLabel);
		// SpringLayout spring = new SpringLayout();
		// statePanel.setLayout(spring);
		// statePanel.add(companyLabel);
		// spring.putConstraint(SpringLayout.EAST, companyLabel, -5,
		// SpringLayout.EAST, this.getContentPane());
		// spring.putConstraint(SpringLayout.SOUTH, companyLabel, -5,
		// SpringLayout.SOUTH, this.getContentPane());
		// statePanel.add(dateLabel);
		// statePanel.add(getUserLabel());
		// statePanel.add(getStateLabel());
		//
		// spring.putConstraint(SpringLayout.EAST, dateLabel, -5,
		// SpringLayout.EAST, companyLabel);
		// spring.putConstraint(SpringLayout.EAST, getUserLabel(), -5,
		// SpringLayout.EAST, dateLabel);
		// spring.putConstraint(SpringLayout.EAST, getStateLabel(), -5,
		// SpringLayout.EAST, getUserLabel());
		return statePanel;
	}

	public JSeparator getJsperator() {
		JSeparator js = new JSeparator();
		js.setOrientation(JSeparator.VERTICAL);
		return js;
	}

	public static JLabel getUserLabel() {
		if (userLabel == null) {
			userLabel = new JLabel("root");
		}
		return userLabel;
	}

	public JLabel getStateLabel() {
		if (stateLabel == null) {
			stateLabel = new JLabel("当前没有选择窗体");
		}
		return stateLabel;
	}

	public JPanel getFrameContentPanel() {
		if (frameContentPanel == null) {
			frameContentPanel = new JPanel();
			frameContentPanel.setLayout(new BorderLayout());
			frameContentPanel.add(getDesktopPanel(), BorderLayout.CENTER);
			frameContentPanel.add(getToolBar(), BorderLayout.NORTH);
			frameContentPanel.add(getStatePanel(), BorderLayout.SOUTH);
		}
		return frameContentPanel;
	}

	public void initialize() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(200, 100, 800, 600);
		this.setJMenuBar(getFrameMenuBar());
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
