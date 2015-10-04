package com.wgc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.wgc.iframe.ClientManage_IFrame;
import com.wgc.iframe.JinHuoDan_IFrame;
import com.wgc.iframe.JsrManage_IFrame;
import com.wgc.iframe.ProductManage_IFrame;
import com.wgc.iframe.SupplierManage_IFrame;
import com.wgc.iframe.suppliermanage.SupplierAddPanel;

public class MenuBar extends JMenuBar {
	private JMenu jinhuo_Menu = null;
	private JMenuItem jinhuoItem = null;
	private JMenuItem jinhuo_tuihuoItem = null;
	private JMenu xiaoshou_Menu = null;
	private JMenuItem xiaoshouItem = null;
	private JMenuItem xiaoshou_tuihuoItem = null;
	private JMenu kucun_Menu = null;
	private JMenuItem kucunItem = null;
	private JMenuItem priceadjustmentItem = null;
	private JMenu informationQuery_Menu = null;
	private JMenuItem salesQueryItem = null;
	private JMenuItem productQueryItem = null;
	private JMenuItem salesRankItem = null;
	private JMenu basicData_Menu = null;
	private JMenuItem productDataManagementItem = null;
	private JMenuItem customerDataManagementItem = null;
	private JMenuItem supplierDataManagementItem = null;
	private JMenuItem jingShourenSettingItem = null;
	private JMenu systemMaintenance_Menu = null;
	private JMenuItem databaseBackupItem = null;
	private JMenuItem passwordModificationItem = null;
	private JMenuItem systemExitItem = null;
	private JMenu window_Menu = null;
	private JMenuItem windowStackItem = null;
	private JMenuItem closeAllItem = null;
	private JMenuItem minAllItem = null;
	private JMenuItem restorationAllItem = null;
	private JMenu help_Menu = null;
	private JMenuItem aboutItem = null;
	private JMenuItem contactTechSupportItem = null;
	private JMenuItem visitTechWebsiteItem = null;
	
	private JDesktopPane desktopPanel = null;
	private JLabel stateLabel = null;
	private Map<JMenuItem,JInternalFrame> iFrames = null;

	private int iFrameX,iFrameY;
	public JMenu getJinhuo_Menu() {
		if (jinhuo_Menu == null) {
			jinhuo_Menu = new JMenu();
			jinhuo_Menu.setText("进货管理(J)");
			jinhuo_Menu.setMnemonic(KeyEvent.VK_J);
			jinhuo_Menu.add(getJinhuoItem());
			// jinhuo_Menu.addSeparator();
			jinhuo_Menu.add(getJinhuo_tuihuoItem());
		}
		return jinhuo_Menu;
	}

	public JMenuItem getJinhuoItem() {
		if (jinhuoItem == null) {
			jinhuoItem = new JMenuItem();
			jinhuoItem.setText("进货单");
			jinhuoItem.setIcon(new ImageIcon(this.getClass().getResource(
					"/image/icon/jinhuodan.png")));
			jinhuoItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					createJInternalFrame(jinhuoItem, JinHuoDan_IFrame.class);
				}
			});
		}
		return jinhuoItem;
	}

	public JMenuItem getJinhuo_tuihuoItem() {
		if (jinhuo_tuihuoItem == null) {
			jinhuo_tuihuoItem = new JMenuItem();
			jinhuo_tuihuoItem.setText("进货退货");
			jinhuo_tuihuoItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/jinhuo_tuihuo.png")));
			jinhuo_tuihuoItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return jinhuo_tuihuoItem;
	}

	public JMenu getXiaoshou_Menu() {
		if (xiaoshou_Menu == null) {
			xiaoshou_Menu = new JMenu();
			xiaoshou_Menu.setText("销售管理(X)");
			xiaoshou_Menu.setMnemonic(KeyEvent.VK_X);
			xiaoshou_Menu.add(getXiaoshouItem());
			xiaoshou_Menu.add(getXiaoshou_tuihuoItem());
		}
		return xiaoshou_Menu;
	}

	public JMenuItem getXiaoshouItem() {
		if (xiaoshouItem == null) {
			xiaoshouItem = new JMenuItem();
			xiaoshouItem.setText("销售单");
			xiaoshouItem.setIcon(new ImageIcon(this.getClass().getResource(
					"/image/icon/xiaoshoudan.png")));
			xiaoshouItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return xiaoshouItem;
	}

	public JMenuItem getXiaoshou_tuihuoItem() {
		if (xiaoshou_tuihuoItem == null) {
			xiaoshou_tuihuoItem = new JMenuItem();
			xiaoshou_tuihuoItem.setText("销售退货");
			xiaoshou_tuihuoItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/xiaoshou_tuihuo.png")));
			xiaoshou_tuihuoItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return xiaoshou_tuihuoItem;
	}

	public JMenu getKucun_Menu() {
		if (kucun_Menu == null) {
			kucun_Menu = new JMenu();
			kucun_Menu.setText("库存管理(K)");
			kucun_Menu.setMnemonic(KeyEvent.VK_K);
			kucun_Menu.add(getKucunItem());
			kucun_Menu.add(getPriceadjustmentItem());
		}
		return kucun_Menu;
	}

	public JMenuItem getKucunItem() {
		if (kucunItem == null) {
			kucunItem = new JMenuItem();
			kucunItem.setText("库存盘点");
			kucunItem.setIcon(new ImageIcon(this.getClass().getResource(
					"/image/icon/kucun_pandian.png")));
			kucunItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return kucunItem;
	}

	public JMenuItem getPriceadjustmentItem() {
		if (priceadjustmentItem == null) {
			priceadjustmentItem = new JMenuItem();
			priceadjustmentItem.setText("价格调整");
			priceadjustmentItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/jiage_tiaozheng.png")));
			priceadjustmentItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return priceadjustmentItem;
	}

	public JMenu getInformationQuery_Menu() {
		if (informationQuery_Menu == null) {
			informationQuery_Menu = new JMenu();
			informationQuery_Menu.setText("信息查询(C)");
			informationQuery_Menu.setMnemonic(KeyEvent.VK_C);
			informationQuery_Menu.add(getSalesQueryItem());
			informationQuery_Menu.add(getProductQueryItem());
			informationQuery_Menu.add(getSalesRankItem());
		}
		return informationQuery_Menu;
	}

	public JMenuItem getSalesQueryItem() {
		if (salesQueryItem == null) {
			salesQueryItem = new JMenuItem();
			salesQueryItem.setText("销售查询");
			salesQueryItem.setIcon(new ImageIcon(this.getClass().getResource(
					"/image/icon/xiaoshou_chaxun.png")));
			salesQueryItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return salesQueryItem;
	}

	public JMenuItem getProductQueryItem() {
		if (productQueryItem == null) {
			productQueryItem = new JMenuItem();
			productQueryItem.setText("商品查询");
			productQueryItem.setIcon(new ImageIcon(this.getClass().getResource(
					"/image/icon/shangpin_chaxun.png")));
			productQueryItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return productQueryItem;
	}

	public JMenuItem getSalesRankItem() {
		if (salesRankItem == null) {
			salesRankItem = new JMenuItem();
			salesRankItem.setText("销售排行");
			salesRankItem.setIcon(new ImageIcon(this.getClass().getResource(
					"/image/icon/xiaoshou_paihang.png")));
			salesRankItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return salesRankItem;
	}

	public JMenu getBasicData_Menu() {
		if (basicData_Menu == null) {
			basicData_Menu = new JMenu();
			basicData_Menu.setText("基本资料(B)");
			basicData_Menu.setMnemonic(KeyEvent.VK_B);
			basicData_Menu.add(getProductDataManagementItem());
			basicData_Menu.add(getCustomerDataManagementItem());
			basicData_Menu.add(getSupplierDataManagementItem());
			basicData_Menu.add(getJingShouRenSettingItem());
		}
		return basicData_Menu;
	}

	public JMenuItem getProductDataManagementItem() {
		if (productDataManagementItem == null) {
			productDataManagementItem = new JMenuItem();
			productDataManagementItem.setText("商品资料管理");
			productDataManagementItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/shangpin_guanli.png")));
			productDataManagementItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					createJInternalFrame(productDataManagementItem, ProductManage_IFrame.class);
				}
			});
		}
		return productDataManagementItem;
	}

	public JMenuItem getCustomerDataManagementItem() {
		if (customerDataManagementItem == null) {
			customerDataManagementItem = new JMenuItem();
			customerDataManagementItem.setText("客户资料管理");
			customerDataManagementItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/kehu_guanli.png")));
			customerDataManagementItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					createJInternalFrame(customerDataManagementItem, ClientManage_IFrame.class);
				}
			});
		}
		return customerDataManagementItem;
	}

	public JMenuItem getSupplierDataManagementItem() {
		if (supplierDataManagementItem == null) {
			supplierDataManagementItem = new JMenuItem();
			supplierDataManagementItem.setText("供应商资料管理");
			supplierDataManagementItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/gys_guanli.png")));
			supplierDataManagementItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					createJInternalFrame(supplierDataManagementItem, SupplierManage_IFrame.class);
				}
			});
		}
		return supplierDataManagementItem;
	}

	public JMenuItem getJingShouRenSettingItem() {
		if (jingShourenSettingItem == null) {
			jingShourenSettingItem = new JMenuItem();
			jingShourenSettingItem.setText("经手人设置");
			jingShourenSettingItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/jsr_shezhi.png")));
			jingShourenSettingItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					createJInternalFrame(jingShourenSettingItem, JsrManage_IFrame.class);
				}
			});
		}
		return jingShourenSettingItem;
	}

	public JMenu getSystemMaintanence_Menu() {
		if (systemMaintenance_Menu == null) {
			systemMaintenance_Menu = new JMenu();
			systemMaintenance_Menu.setText("系统维护(S)");
			systemMaintenance_Menu.setMnemonic(KeyEvent.VK_S);
			systemMaintenance_Menu.add(getDatabaseBackupItem());
			systemMaintenance_Menu.add(getPasswordModificationItem());
			systemMaintenance_Menu.add(getSystemExitItem());
		}
		return systemMaintenance_Menu;
	}

	public JMenuItem getDatabaseBackupItem() {
		if (databaseBackupItem == null) {
			databaseBackupItem = new JMenuItem();
			databaseBackupItem.setText("数据库备份与恢复");
			databaseBackupItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/shujuku_beifen_huifu.png")));
			databaseBackupItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return databaseBackupItem;
	}

	public JMenuItem getPasswordModificationItem() {
		if (passwordModificationItem == null) {
			passwordModificationItem = new JMenuItem();
			passwordModificationItem.setText("修改密码");
			passwordModificationItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/mima_xiugai.png")));
			passwordModificationItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return passwordModificationItem;
	}

	public JMenuItem getSystemExitItem() {
		if (systemExitItem == null) {
			systemExitItem = new JMenuItem();
			systemExitItem.setText("退出系统");
			systemExitItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/tuichu_xitong.png")));
			systemExitItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return systemExitItem;
	}

	public JMenu getWindowMenu() {
		if (window_Menu == null) {
			window_Menu = new JMenu();
			window_Menu.setText("窗口(W)");
			window_Menu.setMnemonic(KeyEvent.VK_W);
			window_Menu.add(getWindowStackItem());
			window_Menu.add(getCloseAllItem());
			window_Menu.add(getMinAllItem());
			window_Menu.add(getRestorationAllItem());
		}
		return window_Menu;
	}

	public JMenuItem getWindowStackItem() {
		if (windowStackItem == null) {
			windowStackItem = new JMenuItem();
			windowStackItem.setText("窗口层叠");
			windowStackItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/chuangkou_pingpu.png")));
			windowStackItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return windowStackItem;
	}

	public JMenuItem getCloseAllItem() {
		if (closeAllItem == null) {
			closeAllItem = new JMenuItem();
			closeAllItem.setText("全部关闭");
			closeAllItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/quanbu_guanbi.png")));
			closeAllItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return closeAllItem;
	}

	public JMenuItem getMinAllItem() {
		if (minAllItem == null) {
			minAllItem = new JMenuItem();
			minAllItem.setText("全部最小化");
			minAllItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/quanbu_zuixiaohua.png")));
			minAllItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return minAllItem;
	}
	public JMenuItem getRestorationAllItem() {
		if (restorationAllItem == null) {
			restorationAllItem = new JMenuItem();
			restorationAllItem.setText("全部还原");
			restorationAllItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/quanbu_huanyuan.png")));
			restorationAllItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return restorationAllItem;
	}
	
	public JMenu getHelpMenu() {
		if (help_Menu == null) {
			help_Menu = new JMenu();
			help_Menu.setText("帮助(H)");
			help_Menu.setMnemonic(KeyEvent.VK_H);
			help_Menu.add(getHelpMenu());
			help_Menu.add(getAboutItem());
			help_Menu.add(getContactTechSupportItem());
			help_Menu.add(getVisitTechWebsiteItem());
		}
		return help_Menu;
	}

	public JMenuItem getAboutItem() {
		if (aboutItem == null) {
			aboutItem = new JMenuItem();
			aboutItem.setText("关于");
			aboutItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/guanyu.png")));
			aboutItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return aboutItem;
	}

	public JMenuItem getContactTechSupportItem() {
		if (contactTechSupportItem == null) {
			contactTechSupportItem = new JMenuItem();
			contactTechSupportItem.setText("联系技术支持");
			contactTechSupportItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/jishu_zhichi.png")));
			contactTechSupportItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return contactTechSupportItem;
	}

	public JMenuItem getVisitTechWebsiteItem() {
		if (visitTechWebsiteItem == null) {
			visitTechWebsiteItem = new JMenuItem();
			visitTechWebsiteItem.setText("访问技术网站");
			visitTechWebsiteItem.setIcon(new ImageIcon(this.getClass()
					.getResource("/image/icon/jishu_wangzhan.png")));
			visitTechWebsiteItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		return visitTechWebsiteItem;
	}
	public void initialize() {
		this.setSize(600, 24);
		add(getJinhuo_Menu());
		add(getXiaoshou_Menu());
		add(getKucun_Menu());
		add(getInformationQuery_Menu());
		add(getBasicData_Menu());
		add(getSystemMaintanence_Menu());
		add(getWindowMenu());
		add(getHelpMenu());
	}

	public JInternalFrame createJInternalFrame(JMenuItem item, Class cla) {
		Constructor cons = cla.getConstructors()[0];
		JInternalFrame iFrame = iFrames.get(item);
		if(iFrame == null || iFrame.isClosed()) {
			try {
				iFrame = (JInternalFrame) cons.newInstance(new Object[] {});
				iFrames.put(item, iFrame);
				iFrame.setTitle(item.getText());
				iFrame.setLocation(iFrameX, iFrameY);
				iFrame.setFrameIcon(item.getIcon());
				iFrame.setVisible(true);
				iFrame.setSelected(true);
				stateLabel.setText(iFrame.getTitle());
				desktopPanel.add(iFrame);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return iFrame;
	}
	public MenuBar(JDesktopPane desktopPanel, JLabel stateLabel) {
		super();
		iFrames = new HashMap<JMenuItem, JInternalFrame>();
		this.desktopPanel = desktopPanel;
		this.stateLabel = stateLabel;
		initialize();
	}
}
