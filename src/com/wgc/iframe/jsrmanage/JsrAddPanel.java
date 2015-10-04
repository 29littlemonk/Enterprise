package com.wgc.iframe.jsrmanage;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import com.wgc.dao.Dao;
import com.wgc.dao.model.JsrInfo;
import com.wgc.dao.model.SupplierInfo;
import com.wgc.iframe.suppliermanage.SupplierAddPanel;

import java.awt.Font;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JsrAddPanel extends JPanel {
	private JTextField nameField;
	private JTextField ageField;
	private JTextField phoneField;

	/**
	 * Create the panel.
	 */
	public JsrAddPanel() {
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel nameLabel = new JLabel("\u59D3\u540D");
		nameLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.insets = new Insets(5, 5, 5, 5);
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 0;
		add(nameLabel, gbc_nameLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.gridwidth = 2;
		gbc_nameField.insets = new Insets(5, 5, 5, 5);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 0;
		add(nameField, gbc_nameField);
		
		JLabel ageLabel = new JLabel("\u5E74\u9F84");
		ageLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		GridBagConstraints gbc_ageLabel = new GridBagConstraints();
		gbc_ageLabel.anchor = GridBagConstraints.EAST;
		gbc_ageLabel.insets = new Insets(5, 5, 5, 5);
		gbc_ageLabel.gridx = 0;
		gbc_ageLabel.gridy = 1;
		add(ageLabel, gbc_ageLabel);
		
		ageField = new JTextField();
		ageField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		ageField.setText("");
		GridBagConstraints gbc_ageField = new GridBagConstraints();
		gbc_ageField.gridwidth = 2;
		gbc_ageField.insets = new Insets(5, 5, 5, 5);
		gbc_ageField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ageField.gridx = 1;
		gbc_ageField.gridy = 1;
		add(ageField, gbc_ageField);
		
		JLabel sexLabel = new JLabel("\u6027\u522B");
		sexLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		GridBagConstraints gbc_sexLabel = new GridBagConstraints();
		gbc_sexLabel.insets = new Insets(5, 5, 5, 5);
		gbc_sexLabel.gridx = 0;
		gbc_sexLabel.gridy = 2;
		add(sexLabel, gbc_sexLabel);
		
		JRadioButton maleRadioButton = new JRadioButton("\u7537");
		maleRadioButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		GridBagConstraints gbc_maleRadioButton = new GridBagConstraints();
		gbc_maleRadioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_maleRadioButton.insets = new Insets(5, 5, 5, 5);
		gbc_maleRadioButton.gridx = 1;
		gbc_maleRadioButton.gridy = 2;
		add(maleRadioButton, gbc_maleRadioButton);
		
		JRadioButton femaleRadioButton = new JRadioButton("\u5973");
		femaleRadioButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		GridBagConstraints gbc_femaleRadioButton = new GridBagConstraints();
		gbc_femaleRadioButton.insets = new Insets(5, 5, 5, 5);
		gbc_femaleRadioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_femaleRadioButton.gridx = 2;
		gbc_femaleRadioButton.gridy = 2;
		add(femaleRadioButton, gbc_femaleRadioButton);
		
		ButtonGroup group = new ButtonGroup();
		group.add(maleRadioButton);
		group.add(femaleRadioButton);
		
		JLabel phoneLabel = new JLabel("\u7535\u8BDD");
		phoneLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
		gbc_phoneLabel.anchor = GridBagConstraints.EAST;
		gbc_phoneLabel.insets = new Insets(5, 5, 5, 5);
		gbc_phoneLabel.gridx = 0;
		gbc_phoneLabel.gridy = 3;
		add(phoneLabel, gbc_phoneLabel);
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		GridBagConstraints gbc_phoneField = new GridBagConstraints();
		gbc_phoneField.insets = new Insets(5, 5, 5, 5);
		gbc_phoneField.gridwidth = 2;
		gbc_phoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneField.gridx = 1;
		gbc_phoneField.gridy = 3;
		add(phoneField, gbc_phoneField);
		
		JButton addButton = new JButton("\u6DFB\u52A0");
		addButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.insets = new Insets(5, 5, 5, 5);
		gbc_addButton.gridx = 1;
		gbc_addButton.gridy = 4;
		add(addButton, gbc_addButton);
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		GridBagConstraints gbc_resetButton = new GridBagConstraints();
		gbc_resetButton.insets = new Insets(5, 5, 5, 5);
		gbc_resetButton.gridx = 2;
		gbc_resetButton.gridy = 4;
		add(resetButton, gbc_resetButton);
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(nameField.getText().equals("") || ageField.getText().equals("") ||  phoneField.getText().equals("")) {
					JOptionPane.showMessageDialog(JsrAddPanel.this, "«ÎÃÓ–¥»´≤ø–≈œ¢","æØ∏Ê",JOptionPane.WARNING_MESSAGE);
					return;
				}
				ResultSet result = Dao.getResultSet("select * from tb_jsr where name = '" + nameField.getText().trim() +"' " );
				try {
					if(result.next()) {
						JOptionPane.showMessageDialog(JsrAddPanel.this, "¥Àæ≠ ÷»À“—¥Ê‘⁄", "æØ∏Ê", JOptionPane.WARNING_MESSAGE);
						return;
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				JsrInfo jsr = new JsrInfo();
				jsr.setName(nameField.getText().trim());
				jsr.setAge(ageField.getText().trim());
				jsr.setPhone(phoneField.getText().trim());
				if(maleRadioButton.isSelected())
					jsr.setSex("ƒ–");
				else
					jsr.setSex("≈Æ");				
				if(Dao.addJsr(jsr)) {
					JOptionPane.showMessageDialog(JsrAddPanel.this, "ÃÌº”æ≠ ÷»À≥…π¶", "πßœ≤", JOptionPane.INFORMATION_MESSAGE);
					resetButton.doClick();
				}
				else
					JOptionPane.showMessageDialog(JsrAddPanel.this, "ÃÌº”æ≠ ÷»À ß∞‹", "æØ∏Ê", JOptionPane.WARNING_MESSAGE);
			}
		});
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nameField.setText("");
				ageField.setText("");
				phoneField.setText("");
				maleRadioButton.setSelected(false);
				femaleRadioButton.setSelected(false);
			}
		});
	}
}
