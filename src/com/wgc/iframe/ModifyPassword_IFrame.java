package com.wgc.iframe;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JPasswordField;

import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.wgc.MainFrame;
import com.wgc.dao.Dao;

public class ModifyPassword_IFrame extends JInternalFrame {
	private JPasswordField originalField;
	private JPasswordField currentField;
	private JPasswordField ConfirmField;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ModifyPassword frame = new
	 * ModifyPassword(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public ModifyPassword_IFrame() {
		setBounds(100, 100, 300, 200);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel originalLabel = new JLabel("\u539F\u5BC6\u7801");
		originalLabel.setFont(new Font("楷体", Font.PLAIN, 14));
		GridBagConstraints gbc_originalLabel = new GridBagConstraints();
		gbc_originalLabel.insets = new Insets(10, 5, 10, 5);
		gbc_originalLabel.anchor = GridBagConstraints.EAST;
		gbc_originalLabel.gridx = 0;
		gbc_originalLabel.gridy = 0;
		panel.add(originalLabel, gbc_originalLabel);

		originalField = new JPasswordField();
		originalField.setFont(new Font("楷体", Font.PLAIN, 14));
		GridBagConstraints gbc_originalField = new GridBagConstraints();
		gbc_originalField.gridwidth = 3;
		gbc_originalField.insets = new Insets(10, 5, 10, 10);
		gbc_originalField.fill = GridBagConstraints.HORIZONTAL;
		gbc_originalField.gridx = 1;
		gbc_originalField.gridy = 0;
		panel.add(originalField, gbc_originalField);

		JLabel currentLabel = new JLabel("\u65B0\u5BC6\u7801");
		currentLabel.setFont(new Font("楷体", Font.PLAIN, 14));
		GridBagConstraints gbc_currentLabel = new GridBagConstraints();
		gbc_currentLabel.anchor = GridBagConstraints.EAST;
		gbc_currentLabel.insets = new Insets(10, 5, 10, 5);
		gbc_currentLabel.gridx = 0;
		gbc_currentLabel.gridy = 1;
		panel.add(currentLabel, gbc_currentLabel);

		currentField = new JPasswordField();
		currentField.setFont(new Font("楷体", Font.PLAIN, 14));
		GridBagConstraints gbc_currentField = new GridBagConstraints();
		gbc_currentField.gridwidth = 3;
		gbc_currentField.insets = new Insets(10, 5, 10, 10);
		gbc_currentField.fill = GridBagConstraints.HORIZONTAL;
		gbc_currentField.gridx = 1;
		gbc_currentField.gridy = 1;
		panel.add(currentField, gbc_currentField);

		JLabel confirmLabel = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		confirmLabel.setFont(new Font("楷体", Font.PLAIN, 14));
		GridBagConstraints gbc_confirmLabel = new GridBagConstraints();
		gbc_confirmLabel.anchor = GridBagConstraints.EAST;
		gbc_confirmLabel.insets = new Insets(10, 5, 10, 5);
		gbc_confirmLabel.gridx = 0;
		gbc_confirmLabel.gridy = 2;
		panel.add(confirmLabel, gbc_confirmLabel);

		ConfirmField = new JPasswordField();
		ConfirmField.setFont(new Font("楷体", Font.PLAIN, 14));
		GridBagConstraints gbc_ConfirmField = new GridBagConstraints();
		gbc_ConfirmField.gridwidth = 3;
		gbc_ConfirmField.insets = new Insets(10, 5, 10, 10);
		gbc_ConfirmField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ConfirmField.gridx = 1;
		gbc_ConfirmField.gridy = 2;
		panel.add(ConfirmField, gbc_ConfirmField);

		JButton updateButton = new JButton("\u4FEE\u6539\u5BC6\u7801");
		updateButton.setFont(new Font("楷体", Font.PLAIN, 14));
		GridBagConstraints gbc_updateButton = new GridBagConstraints();
		gbc_updateButton.insets = new Insets(10, 0, 10, 5);
		gbc_updateButton.gridx = 1;
		gbc_updateButton.gridy = 3;
		panel.add(updateButton, gbc_updateButton);

		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.setFont(new Font("楷体", Font.PLAIN, 14));
		GridBagConstraints gbc_resetButton = new GridBagConstraints();
		gbc_resetButton.insets = new Insets(10, 5, 10, 5);
		gbc_resetButton.gridx = 2;
		gbc_resetButton.gridy = 3;
		panel.add(resetButton, gbc_resetButton);
		this.setIconifiable(true);
		this.setClosable(true);

		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (Dao.checkOriginalPassword(MainFrame.getUserLabel()
						.getText(), new String(originalField.getPassword()))) {
					if (new String(currentField.getPassword()).equals(
							new String(ConfirmField.getPassword()))) {
						if (Dao.updatePassword(MainFrame.getUserLabel()
								.getText(),
								new String(currentField.getPassword())) == 1) {
							JOptionPane.showMessageDialog(ModifyPassword_IFrame.this,
									"密码修改成功", "恭喜",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane
									.showMessageDialog(ModifyPassword_IFrame.this,
											"密码修改失败", "抱歉",
											JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(ModifyPassword_IFrame.this,
								"两次输入密码不一致", "抱歉", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(ModifyPassword_IFrame.this,
							"原密码不正确", "抱歉", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				originalField.setText("");
				currentField.setText("");
				ConfirmField.setText("");
			}
		});
	}

}
