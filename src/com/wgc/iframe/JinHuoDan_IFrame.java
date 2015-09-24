package com.wgc.iframe;

import javax.swing.JInternalFrame;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

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
		//constraint.weightx = 10;
		constraint.insets = new Insets(0, 5, 0, 5);
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
		//constraint2.weightx = 10;
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
		//constraint4.weightx = 10;
		constraint4.insets = new Insets(0, 5, 0, 5);
		constraint4.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint5 = new GridBagConstraints();
		constraint5.gridx = 5;
		constraint5.gridy = 0;
		constraint5.weightx = 20;
		constraint5.insets = new Insets(0, 5, 0, 5);
		constraint5.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint6 = new GridBagConstraints();
		constraint6.gridx = 0;
		constraint6.gridy = 1;
		//constraint6.weightx = 10;
		constraint6.insets = new Insets(0, 5, 0, 5);
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
		//constraint8.weightx = 10;
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
		//constraint10.weightx = 10;
		constraint10.insets = new Insets(0, 5, 0, 5);
		constraint10.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint11 = new GridBagConstraints();
		constraint11.gridx = 5;
		constraint11.gridy = 1;
		constraint11.weightx = 20;
		constraint11.insets = new Insets(0, 5, 0, 5);
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
		
		return topPanel;
	}
	public JScrollPane getMiddlePanel() {
		middlePanel = new JScrollPane();
		String[] columnNames = { "商品名称", "商品编号", "产地", "单位", "规格", "包装",
				"单价", "数量", "批号", "批准文号"};
		tablemodel = new DefaultTableModel();
		tablemodel.setColumnIdentifiers(columnNames);
		table = new JTable(tablemodel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//否则不会出现滚动面板
		table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		middlePanel.setViewportView(table);
		return middlePanel;
	}
	
	
	public JPanel getBottomPanel() {
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 0;
		//constraint.weightx = 10;
		constraint.insets = new Insets(0, 5, 0, 5);
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
		//constraint2.weightx = 10;
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
		//constraint4.weightx = 10;
		constraint4.insets = new Insets(0, 5, 0, 5);
		constraint4.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint5 = new GridBagConstraints();
		constraint5.gridx = 5;
		constraint5.gridy = 0;
		constraint5.weightx = 1.0;
		constraint5.insets = new Insets(0, 5, 0, 5);
		constraint5.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints constraint6 = new GridBagConstraints();
		constraint6.gridx = 0;
		constraint6.gridy = 1;
		//constraint6.weightx = 10;
		constraint6.insets = new Insets(0, 5, 0, 5);
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
		//constraint8.weightx = 10;
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
		if(jinhuopiaohaoField == null) {
			jinhuopiaohaoField = new JTextField();
		}
		return jinhuopiaohaoField;
	}
	public JComboBox<String> getGongYingShanCombo() {
		if(gongyingshangCombo == null) {
			gongyingshangCombo = new JComboBox<String>();
		}
		return gongyingshangCombo;
	}
	public JTextField getLianXiRenField() {
		if(lianxirenField == null) {
			lianxirenField = new JTextField();
		}
		return lianxirenField;
	}
	public JComboBox<String> getJieSuanFangShiCombo() {
		if(jiesuanfangshiCombo == null) {
			jiesuanfangshiCombo = new JComboBox<String>();
		}
		return jiesuanfangshiCombo;
	}
	public JTextField getJinHuoShiJianField() {
		if(jinhuoshijianField == null) {
			jinhuoshijianField = new JTextField();
		}
		return jinhuoshijianField;
	}
	public JComboBox<String> getJingShouRenCombo() {
		if(jingshourenCombo == null) {
			jingshourenCombo = new JComboBox<String>();
		}
		return jingshourenCombo;
	}
	public JTextField getPinZhongShuLiangField() {
		if(pinzhongshuliangField == null) {
			pinzhongshuliangField = new JTextField();
		}
		return pinzhongshuliangField;
	}
	public JTextField getHuoPinZongShuField() {
		if(huopinzongshuField == null) {
			huopinzongshuField = new JTextField();
		}
		return huopinzongshuField;
	}
	public JTextField getHeJiJinEField() {
		if(hejijineField == null) {
			hejijineField = new JTextField();
		}
		return hejijineField;
	}
	public JTextField getYanShouJieLunField() {
		if(yanshoujielunField == null) {
			yanshoujielunField = new JTextField();
		}
		return yanshoujielunField;
	}
	public JTextField getCaoZuoYuanField() {
		if(caozuoyuanField == null) {
			caozuoyuanField = new JTextField();
		}
		return caozuoyuanField;
	}
	public JButton getAddButton() {
		if(addButton == null) {
			addButton = new JButton();
			addButton.setText("添加");
		}
		return addButton;
	}
	public JButton getRukuButton() {
		if(rukuButton == null) {
			rukuButton = new JButton();
			rukuButton.setText("入库");
		}
		return rukuButton;
	}
	
	public JinHuoDan_IFrame() {
		super();
		initialize();
	}

	public JPanel getContentPanel() {
		if(contentPanel == null) {
			contentPanel = new JPanel();
			contentPanel.setLayout(new BorderLayout());
			contentPanel.add(getTopPanel(), BorderLayout.NORTH);
			contentPanel.add(getBottomPanel(), BorderLayout.SOUTH);
			contentPanel.add(getMiddlePanel(), BorderLayout.CENTER);
		}
		return contentPanel;
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
