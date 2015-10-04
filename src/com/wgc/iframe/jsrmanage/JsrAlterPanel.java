package com.wgc.iframe.jsrmanage;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JTable;

import java.awt.Font;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import com.wgc.dao.Dao;
import com.wgc.dao.model.JsrInfo;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class JsrAlterPanel extends JPanel {
	private JTable table;
	private DefaultTableModel dftm;
	private JScrollPane js;

	/**
	 * Create the panel.
	 */
	public JsrAlterPanel() {
		setLayout(new BorderLayout(0, 0));

		dftm = new DefaultTableModel(new Object[][] {}, new String[] {
				"\u59D3\u540D", "\u5E74\u9F84", "\u6027\u522B", "\u7535\u8BDD",
				"\u72B6\u6001" });
		table = new JTable(dftm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFont(new Font("楷体", Font.PLAIN, 14));
		js = new JScrollPane();
		js.setViewportView(table);
		add(js, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		JButton stateButton = new JButton("\u542F\u7528/\u7981\u7528");
		stateButton.setFont(new Font("楷体", Font.PLAIN, 14));
		panel.add(stateButton);

		JButton deleteButton = new JButton("\u5220\u9664");
		deleteButton.setFont(new Font("楷体", Font.PLAIN, 14));
		panel.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (table.getSelectedRow() != -1) {
					int confirm = JOptionPane.showConfirmDialog(
							JsrAlterPanel.this, "确定一定以及肯定要删除吗");
					if (confirm == JOptionPane.YES_OPTION) {
						if (Dao.deleteJsr(table
								.getValueAt(table.getSelectedRow(), 0)
								.toString().trim()) == 1) {
							JOptionPane.showMessageDialog(JsrAlterPanel.this,
									"删除成功", "祝贺", JOptionPane.WARNING_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(JsrAlterPanel.this,
									"删除失败", "不行", JOptionPane.WARNING_MESSAGE);
						}
					}
					initTable();
				}
			}
		});
		dftm.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if (e.getType() == TableModelEvent.UPDATE) {
					int row = table.getSelectedRow();
					JsrInfo jsr = new JsrInfo();
					jsr.setName(table.getValueAt(row, 0).toString());
					jsr.setAge(table.getValueAt(row, 1).toString());
					jsr.setSex(table.getValueAt(row, 2).toString());
					jsr.setPhone(table.getValueAt(row, 3).toString());
					if (Dao.updateJsr(jsr) == 1) {
						JOptionPane.showMessageDialog(JsrAlterPanel.this,
								"修改成功", "祝贺", JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(JsrAlterPanel.this,
								"修改失败", "不行", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		stateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (row != -1) {
					int status = table.getValueAt(row, 4).toString()
							.equals("启用") ? 1 : 0;
					if (Dao.updateJsrState(status, table.getValueAt(row, 0)
							.toString()) == 1) {
						JOptionPane.showMessageDialog(JsrAlterPanel.this,
								"状态修改成功", "祝贺", JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(JsrAlterPanel.this,
								"状态修改失败", "不行", JOptionPane.WARNING_MESSAGE);
					}
					initTable();
				}
			}
		});
	}

	public void initTable() {
		dftm.setRowCount(0);
		ResultSet result = Dao.getResultSet("select * from tb_jsr");
		String[] data = new String[5];
		try {
			while (result.next()) {
				data[0] = result.getString("name");
				data[1] = result.getString("age");
				data[2] = result.getString("sex");
				data[3] = result.getString("phone");
				data[4] = result.getString("enable").equals("1") ? "启用" : "禁用";
				dftm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
