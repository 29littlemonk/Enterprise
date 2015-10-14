package com.wgc.iframe;

import javax.swing.JInternalFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableCell;

import com.wgc.MainFrame;
import com.wgc.dao.Dao;
import com.wgc.dao.model.ProductInfo;
import com.wgc.dao.model.RuKuDetailInfo;
import com.wgc.dao.model.RukuMainInfo;

public class JinHuoDan_IFrame extends JInternalFrame {
	private JLabel jinhuopiaohaoLabel = new JLabel("进货票号");
	private JLabel gongyingshangLabel = new JLabel("供应商");
	private JLabel lianxirenLabel = new JLabel("联系人");
	private JLabel jiesuanfangshiLabel = new JLabel("结算方式");
	private JLabel jinhuoshijianLabel = new JLabel("进货时间");
	private JLabel jingshourenLabel = new JLabel("经手人");
	private JLabel pinzhongshuliangLabel = new JLabel("品种数量");
	private JLabel huopinzongshuLabel = new JLabel("货品总数");
	private JLabel hejijineLabel = new JLabel("合计金额");
	private JLabel yanshoujielunLabel = new JLabel("验收结论");
	private JLabel caozuoyuanLabel = new JLabel("操作员");

	private JComboBox<String> gongyingshangCombo = null;
	private JComboBox<String> jiesuanfangshiCombo = null;
	private JComboBox<String> jingshourenCombo = null;
	private JComboBox<String> productNameCombo = null;

	private JTextField jinhuopiaohaoField = null;
	private JTextField lianxirenField = null;
	private JTextField jinhuoshijianField = null;
	private JTextField pinzhongshuliangField = null;
	private JTextField huopinzongshuField = null;
	private JTextField hejijineField = null;
	private JTextField yanshoujielunField = null;
	private JTextField caozuoyuanField = null;

	private JButton addButton = null;
	private JButton rukuButton = null;

	private JPanel topPanel = null;
	private JPanel bottomPanel = null;
	private JScrollPane middlePanel = null;
	private JPanel contentPanel = null;

	private DefaultTableModel tablemodel = null;
	private JTable table = null;

	public JPanel getTopPanel() {
		topPanel = new JPanel();
		topPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 0;
		// constraint.weightx = 10;
		constraint.insets = new Insets(0, 0, 0, 5);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint1 = new GridBagConstraints();
		constraint1.gridx = 1;
		constraint1.gridy = 0;
		constraint1.weightx = 20;
		constraint1.insets = new Insets(0, 5, 0, 5);
		constraint1.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint2 = new GridBagConstraints();
		constraint2.gridx = 2;
		constraint2.gridy = 0;
		// constraint2.weightx = 10;
		constraint2.insets = new Insets(0, 5, 0, 5);
		constraint2.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint3 = new GridBagConstraints();
		constraint3.gridx = 3;
		constraint3.gridy = 0;
		constraint3.weightx = 30;
		constraint3.insets = new Insets(0, 5, 0, 5);
		constraint3.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint4 = new GridBagConstraints();
		constraint4.gridx = 4;
		constraint4.gridy = 0;
		// constraint4.weightx = 10;
		constraint4.insets = new Insets(0, 5, 0, 5);
		constraint4.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint5 = new GridBagConstraints();
		constraint5.gridx = 5;
		constraint5.gridy = 0;
		constraint5.weightx = 20;
		constraint5.insets = new Insets(0, 5, 0, 0);
		constraint5.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint6 = new GridBagConstraints();
		constraint6.gridx = 0;
		constraint6.gridy = 1;
		// constraint6.weightx = 10;
		constraint6.insets = new Insets(0, 0, 0, 5);
		constraint6.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint7 = new GridBagConstraints();
		constraint7.gridx = 1;
		constraint7.gridy = 1;
		constraint7.weightx = 20;
		constraint7.insets = new Insets(0, 5, 0, 5);
		constraint7.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint8 = new GridBagConstraints();
		constraint8.gridx = 2;
		constraint8.gridy = 1;
		// constraint8.weightx = 10;
		constraint8.insets = new Insets(0, 5, 0, 5);
		constraint8.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint9 = new GridBagConstraints();
		constraint9.gridx = 3;
		constraint9.gridy = 1;
		constraint9.weightx = 30;
		constraint9.insets = new Insets(0, 5, 0, 5);
		constraint9.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint10 = new GridBagConstraints();
		constraint10.gridx = 4;
		constraint10.gridy = 1;
		// constraint10.weightx = 10;
		constraint10.insets = new Insets(0, 5, 0, 5);
		constraint10.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint11 = new GridBagConstraints();
		constraint11.gridx = 5;
		constraint11.gridy = 1;
		constraint11.weightx = 20;
		constraint11.insets = new Insets(0, 5, 0, 0);
		constraint11.fill = GridBagConstraints.HORIZONTAL;

		topPanel.add(jinhuopiaohaoLabel, constraint);
		topPanel.add(getJinHuoPiaoHaoField(), constraint1);
		topPanel.add(gongyingshangLabel, constraint2);
		topPanel.add(getGongYingShanCombo(), constraint3);
		topPanel.add(lianxirenLabel, constraint4);
		topPanel.add(getLianXiRenField(), constraint5);
		topPanel.add(jiesuanfangshiLabel, constraint6);
		topPanel.add(getJieSuanFangShiCombo(), constraint7);
		topPanel.add(jinhuoshijianLabel, constraint8);
		topPanel.add(getJinHuoShiJianField(), constraint9);
		topPanel.add(jingshourenLabel, constraint10);
		topPanel.add(getJingShouRenCombo(), constraint11);

		gongyingshangCombo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				lianxirenField.setText(Dao.getContact(gongyingshangCombo
						.getSelectedItem().toString()));
			}
		});
		return topPanel;
	}

	public JScrollPane getMiddlePanel() {
		middlePanel = new JScrollPane();
		String[] columnNames = { "商品名称", "商品编号", "产地", "单位", "规格", "包装", "单价",
				"数量", "批号", "批准文号" };
		tablemodel = new DefaultTableModel();
		tablemodel.setColumnIdentifiers(columnNames);
		table = new JTable(tablemodel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 否则不会出现滚动面板
		table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		table.setRowHeight(20);
		TableColumn column = table.getColumnModel().getColumn(0);
		DefaultCellEditor editor = new DefaultCellEditor(getProductName());
		column.setCellEditor(editor);
		middlePanel.setViewportView(table);
		table.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				if(evt.getPropertyName().equals("tableCellEditor")) {
					computeInfo();
				}
			}
		});
		return middlePanel;
	}

	public JPanel getBottomPanel() {
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 0;
		// constraint.weightx = 10;
		constraint.insets = new Insets(0, 0, 0, 5);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint1 = new GridBagConstraints();
		constraint1.gridx = 1;
		constraint1.gridy = 0;
		constraint1.weightx = 1.0;
		constraint1.insets = new Insets(0, 5, 0, 5);
		constraint1.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint2 = new GridBagConstraints();
		constraint2.gridx = 2;
		constraint2.gridy = 0;
		// constraint2.weightx = 10;
		constraint2.insets = new Insets(0, 5, 0, 5);
		constraint2.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint3 = new GridBagConstraints();
		constraint3.gridx = 3;
		constraint3.gridy = 0;
		constraint3.weightx = 1.0;
		constraint3.insets = new Insets(0, 5, 0, 5);
		constraint3.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint4 = new GridBagConstraints();
		constraint4.gridx = 4;
		constraint4.gridy = 0;
		// constraint4.weightx = 10;
		constraint4.insets = new Insets(0, 5, 0, 5);
		constraint4.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint5 = new GridBagConstraints();
		constraint5.gridx = 5;
		constraint5.gridy = 0;
		constraint5.weightx = 1.0;
		constraint5.insets = new Insets(0, 5, 0, 0);
		constraint5.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint6 = new GridBagConstraints();
		constraint6.gridx = 0;
		constraint6.gridy = 1;
		// constraint6.weightx = 10;
		constraint6.insets = new Insets(0, 0, 0, 5);
		constraint6.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint7 = new GridBagConstraints();
		constraint7.gridx = 1;
		constraint7.gridy = 1;
		constraint7.weightx = 1.0;
		constraint7.insets = new Insets(0, 5, 0, 5);
		constraint7.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint8 = new GridBagConstraints();
		constraint8.gridx = 2;
		constraint8.gridy = 1;
		// constraint8.weightx = 10;
		constraint8.insets = new Insets(0, 5, 0, 5);
		constraint8.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint9 = new GridBagConstraints();
		constraint9.gridx = 3;
		constraint9.gridy = 1;
		constraint9.weightx = 1.0;
		constraint9.insets = new Insets(0, 5, 0, 5);
		constraint9.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint10 = new GridBagConstraints();
		constraint10.gridx = 4;
		constraint10.gridy = 1;
		constraint10.weightx = 1.0;
		constraint10.insets = new Insets(0, 5, 0, 5);
		constraint10.gridwidth = 2;
		constraint10.fill = GridBagConstraints.HORIZONTAL;
		JPanel jp = new JPanel();
		jp.add(getAddButton());
		jp.add(getRukuButton());

		bottomPanel.add(pinzhongshuliangLabel, constraint);
		bottomPanel.add(getPinZhongShuLiangField(), constraint1);
		bottomPanel.add(huopinzongshuLabel, constraint2);
		bottomPanel.add(getHuoPinZongShuField(), constraint3);
		bottomPanel.add(hejijineLabel, constraint4);
		bottomPanel.add(getHeJiJinEField(), constraint5);
		bottomPanel.add(yanshoujielunLabel, constraint6);
		bottomPanel.add(getYanShouJieLunField(), constraint7);
		bottomPanel.add(caozuoyuanLabel, constraint8);
		bottomPanel.add(getCaoZuoYuanField(), constraint9);
		bottomPanel.add(jp, constraint10);

		return bottomPanel;
	}

	public JTextField getJinHuoPiaoHaoField() {
		if (jinhuopiaohaoField == null) {
			jinhuopiaohaoField = new JTextField();
			jinhuopiaohaoField.setEditable(false);
		}
		return jinhuopiaohaoField;
	}

	public JComboBox<String> getGongYingShanCombo() {
		if (gongyingshangCombo == null) {
			gongyingshangCombo = new JComboBox<String>();
			List<String> supplierName = Dao.getSupplierName();
			Iterator<String> ite = supplierName.iterator();
			while (ite.hasNext()) {
				gongyingshangCombo.addItem(ite.next());
			}
		}
		return gongyingshangCombo;
	}

	public JTextField getLianXiRenField() {
		if (lianxirenField == null) {
			lianxirenField = new JTextField();
			lianxirenField.setText(Dao.getContact(gongyingshangCombo
					.getSelectedItem().toString()));
			lianxirenField.setEditable(false);
		}
		return lianxirenField;
	}

	public JComboBox<String> getJieSuanFangShiCombo() {
		if (jiesuanfangshiCombo == null) {
			jiesuanfangshiCombo = new JComboBox<String>();
			jiesuanfangshiCombo.addItem("现金结算");
			jiesuanfangshiCombo.addItem("支票结算");
			jiesuanfangshiCombo.addItem("刷卡结算");
		}
		return jiesuanfangshiCombo;
	}

	public JTextField getJinHuoShiJianField() {
		if (jinhuoshijianField == null) {
			jinhuoshijianField = new JTextField();
		}
		return jinhuoshijianField;
	}

	public JComboBox<String> getJingShouRenCombo() {
		if (jingshourenCombo == null) {
			jingshourenCombo = new JComboBox<String>();
			List<String> jsrName = Dao.getJsrName();
			Iterator<String> ite = jsrName.iterator();
			while (ite.hasNext()) {
				jingshourenCombo.addItem(ite.next());
			}
		}
		return jingshourenCombo;
	}

	public JTextField getPinZhongShuLiangField() {
		if (pinzhongshuliangField == null) {
			pinzhongshuliangField = new JTextField();
			pinzhongshuliangField.setEditable(false);
		}
		return pinzhongshuliangField;
	}

	public JTextField getHuoPinZongShuField() {
		if (huopinzongshuField == null) {
			huopinzongshuField = new JTextField();
			huopinzongshuField.setEditable(false);
		}
		return huopinzongshuField;
	}

	public JTextField getHeJiJinEField() {
		if (hejijineField == null) {
			hejijineField = new JTextField();
			hejijineField.setEditable(false);
		}
		return hejijineField;
	}

	public JTextField getYanShouJieLunField() {
		if (yanshoujielunField == null) {
			yanshoujielunField = new JTextField();
		}
		return yanshoujielunField;
	}

	public JTextField getCaoZuoYuanField() {
		if (caozuoyuanField == null) {
			caozuoyuanField = new JTextField();
			caozuoyuanField.setText(MainFrame.getUserLabel().getText());
			caozuoyuanField.setEditable(false);
		}
		return caozuoyuanField;
	}

	public JButton getAddButton() {
		if (addButton == null) {
			addButton = new JButton();
			addButton.setText("添加");
			addButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Date date = new Date();
					jinhuoshijianField.setText(String.format("%tF", date));
					jinhuopiaohaoField.setText(Dao.getRukuMainMaxId());
					stopCellEdit();
					for (int i = 0; i < table.getRowCount(); i++) {
						if (table.getValueAt(i, 0) == null)
							return;
					}
					tablemodel.addRow(new Vector<String>());
				}
			});
		}
		return addButton;
	}

	public JButton getRukuButton() {
		if (rukuButton == null) {
			rukuButton = new JButton();
			rukuButton.setText("入库");
			rukuButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					stopCellEdit();
					if(yanshoujielunField.getText().equals("")) {
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "请填写验收结论", "抱歉", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					RukuMainInfo rukumain = new RukuMainInfo();
					rukumain.setId(jinhuopiaohaoField.getText().trim());
					rukumain.setConclusion(yanshoujielunField.getText().trim());
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date date =format.parse(jinhuoshijianField.getText().trim());
						rukumain.setDate(date);
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					rukumain.setJsr(jingshourenCombo.getSelectedItem().toString().trim());
					rukumain.setOperator(caozuoyuanField.getText().trim());
					rukumain.setPayment(jiesuanfangshiCombo.getSelectedItem().toString().trim());
					rukumain.setProductnum(Integer.parseInt(pinzhongshuliangField.getText().trim()));
					rukumain.setSummoney(Double.parseDouble(hejijineField.getText().trim()));
					rukumain.setSuppliername(gongyingshangCombo.getSelectedItem().toString().trim());
					Set<RuKuDetailInfo> set = rukumain.getDetail();
					int row = table.getRowCount();
					for(int i=0 ;i<row;i++) {
						RuKuDetailInfo detail = new RuKuDetailInfo();
						detail.setRkID(rukumain.getId());
						detail.setProductID(table.getValueAt(i, 1).toString());
						detail.setPrice(Double.parseDouble(table.getValueAt(i, 6).toString()));
						detail.setCount(Integer.parseInt(table.getValueAt(i, 7).toString()));
						set.add(detail);
					}
					if(Dao.Ruku(rukumain) == true){
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "所有入库操作成功", "恭喜", JOptionPane.INFORMATION_MESSAGE);
						huopinzongshuField.setText("");
						hejijineField.setText("");
						pinzhongshuliangField.setText("");
						yanshoujielunField.setText("");
					}else {
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "入库操作不成功", "抱歉", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
		}
		return rukuButton;
	}

	public JinHuoDan_IFrame() {
		super();
		initialize();
	}

	public JPanel getContentPanel() {
		if (contentPanel == null) {
			contentPanel = new JPanel();
			contentPanel.setLayout(new BorderLayout());
			contentPanel.add(getTopPanel(), BorderLayout.NORTH);
			contentPanel.add(getBottomPanel(), BorderLayout.SOUTH);
			contentPanel.add(getMiddlePanel(), BorderLayout.CENTER);
		}
		return contentPanel;
	}

	public JComboBox<String> getProductName() {
		if (productNameCombo == null) {
			productNameCombo = new JComboBox<String>();
			// 每次给下拉框施加动作时，都会重新初始化该下拉框。
			productNameCombo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					productNameCombo.removeAllItems();
					List<String> product = Dao
							.getProductNameBySupplierName(gongyingshangCombo
									.getSelectedItem().toString());
					productNameCombo.addItem("");
					Iterator ite = product.iterator();
					while (ite.hasNext()) {
						productNameCombo.addItem(ite.next().toString());
					}
				}
			});
			productNameCombo.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					if (productNameCombo.getItemCount() == 0)
						return;
					if (productNameCombo.getSelectedItem() != null
							&& productNameCombo.getSelectedItem().toString() != "") {
						updateTable();
					}
				}
			});

		}
		return productNameCombo;
	}

	public void stopCellEdit() {
		CellEditor editor = table.getCellEditor();
		if (editor != null) {
			editor.stopCellEditing();
		}
	}

	public void updateTable() {
		ProductInfo product = Dao.getProductByName(productNameCombo
				.getSelectedItem().toString());

		// System.out.println(productNameCombo.getSelectedItem().toString());
		int row = table.getSelectedRow();
		if (row >= 0 && product != null) {
			table.setValueAt(product.getId(), row, 1);
			table.setValueAt(product.getOriginplace(), row, 2);
			table.setValueAt(product.getUnit(), row, 3);
			table.setValueAt(product.getStandard(), row, 4);
			table.setValueAt(product.getPac(), row, 5);
			table.setValueAt("0", row, 6);
			table.setValueAt("0", row, 7);
			table.setValueAt(product.getLotnumber(), row, 8);
			table.setValueAt(product.getApproval(), row, 9);
			table.editCellAt(row, 6);
		}
	}

	public void computeInfo() {
		int row = table.getRowCount();
		int count = 0;
		double money = 0.0;
		if(table.getValueAt(row-1, 0) ==null || table.getValueAt(row-1, 0).toString() == ""){
			row--;
		}
		for (int i = 1; i <= row; i++) {
			int c7 = Integer.parseInt(table.getValueAt(i-1, 7).toString());
			double c6 = Double.parseDouble(table.getValueAt(i-1, 6).toString());
			count += c7;
			money += c6 * c7;
		}
		pinzhongshuliangField.setText(row + "");
		huopinzongshuField.setText(count + "");
		hejijineField.setText(money + "");
	}

	public void initialize() {
		setSize(500, 300);
		setVisible(true);
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setContentPane(getContentPanel());
	}
}
