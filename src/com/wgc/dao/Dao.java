package com.wgc.dao;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.ObjectInputStream.GetField;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.wgc.dao.model.ClientInfo;
import com.wgc.dao.model.JsrInfo;
import com.wgc.dao.model.ProductInfo;
import com.wgc.dao.model.SupplierInfo;

public class Dao {
	private static String dbDriverName = "com.mysql.jdbc.Driver";
	private static String dbConnection = "jdbc:mysql://localhost:3306/enterprise";
	private static String username = "root";
	private static String password = "WA290029";
	private static Connection conn = null;
	static {
		if (conn == null) {
			try {
				Class.forName(dbDriverName);
				conn = DriverManager.getConnection(dbConnection, username,
						password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static boolean addSupplier(SupplierInfo supplier) {

		PreparedStatement pstat;
		int i = 0;
		try {
			pstat = conn
					.prepareStatement("insert into tb_supplier values(?,?,?,?,?,?,?,?)");
			pstat.setString(1, supplier.getId());
			pstat.setString(2, supplier.getFullname());
			pstat.setString(3, supplier.getAddress());
			pstat.setString(4, supplier.getContact());
			pstat.setString(5, supplier.getPhone());
			pstat.setString(6, supplier.getBank());
			pstat.setString(7, supplier.getEmail());
			pstat.setString(8, supplier.getShortname());
			i = pstat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i == 1)
			return true;
		else
			return false;

	}

	public static int deleteSupplier(String fullname) {
		int flag = 0;
		String sql = "delete from tb_supplier where name = '" + fullname + "'";
		Statement stat;
		try {
			stat = conn.createStatement();
			flag = stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static int updateSupplier(SupplierInfo supplier, String fullname) {
		int flag = 0;
		String id = "";
		ResultSet result = getResultSet("select id from tb_supplier where name = '"
				+ fullname + "'");
		try {
			result.next();
			id = result.getString(1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "update tb_supplier set name = ?,address = ?,contact = ?,phone = ?,bank = ?,email = ?,shortname = ? where id = '"
				+ id + "'";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, supplier.getFullname());
			pstat.setString(2, supplier.getAddress());
			pstat.setString(3, supplier.getContact());
			pstat.setString(4, supplier.getPhone());
			pstat.setString(5, supplier.getBank());
			pstat.setString(6, supplier.getEmail());
			pstat.setString(7, supplier.getShortname());
			flag = pstat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static List<String> getSupplierName() {
		ResultSet result = getResultSet("select name from tb_supplier");
		List<String> supplierName = new ArrayList<String>();
		try {
			while (result.next()) {
				supplierName.add(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return supplierName;
	}

	/*
	 * public static Map<String,String> getSupplierByName(String name) {
	 * Map<String, String> map = new HashMap<String, String>(); ResultSet result
	 * = getResultSet("select * from where name = '" + name +"' "); try {
	 * ResultSetMetaData meta = result.getMetaData(); while(result.next()) {
	 * for(int i=1; i <= meta.getColumnCount(); i++) {
	 * map.put(meta.getColumnName(i), result.getString(i)); } } } catch
	 * (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return map; }
	 */

	public static SupplierInfo getSupplierByName(String name) {
		SupplierInfo supplier = new SupplierInfo();
		ResultSet result = getResultSet("select * from tb_supplier where name = '"
				+ name + "' ");
		try {
			while (result.next()) {
				supplier.setFullname(result.getString("name"));
				supplier.setAddress(result.getString("address"));
				supplier.setContact(result.getString("contact"));
				supplier.setPhone(result.getString("phone"));
				supplier.setBank(result.getString("bank"));
				supplier.setEmail(result.getString("email"));
				supplier.setShortname(result.getString("shortname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return supplier;
	}

	public static boolean addProduct(ProductInfo product) {

		PreparedStatement pstat;
		int i = 0;
		try {
			pstat = conn
					.prepareStatement("insert into tb_productInfo values(?,?,?,?,?,?,?,?,?,?,?)");
			pstat.setString(1, product.getId());
			pstat.setString(2, product.getFullname());
			pstat.setString(3, product.getShortname());
			pstat.setString(4, product.getOriginplace());
			pstat.setString(5, product.getUnit());
			pstat.setString(6, product.getStandard());
			pstat.setString(7, product.getPac());
			pstat.setString(8, product.getLotnumber());
			pstat.setString(9, product.getApproval());
			pstat.setString(10, product.getMemo());
			pstat.setString(11, product.getSupplier());
			i = pstat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i == 1)
			return true;
		else
			return false;

	}

	public static int deleteProduct(String fullname) {
		int flag = 0;
		String sql = "delete from tb_productInfo where fullname = '" + fullname
				+ "'";
		Statement stat;
		try {
			stat = conn.createStatement();
			flag = stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static int updateProduct(ProductInfo product, String fullname) {
		int flag = 0;
		String id = "";
		ResultSet result = getResultSet("select id from tb_productInfo where fullname = '"
				+ fullname + "'");
		try {
			result.next();
			id = result.getString(1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "update tb_productInfo set fullname = ?, shortname= ?,originplace = ?,unit = ?,standard = ?,package = ?,lotnumber = ?,approval = ?,memo = ?,supplier=? where id = '"
				+ id + "'";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, product.getFullname());
			pstat.setString(2, product.getShortname());
			pstat.setString(3, product.getOriginplace());
			pstat.setString(4, product.getUnit());
			pstat.setString(5, product.getStandard());
			pstat.setString(6, product.getPac());
			pstat.setString(7, product.getLotnumber());
			pstat.setString(8, product.getApproval());
			pstat.setString(9, product.getMemo());
			pstat.setString(10, product.getSupplier());
			flag = pstat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static List<String> getProductName() {
		ResultSet result = getResultSet("select fullname from tb_productInfo");
		List<String> productName = new ArrayList<String>();
		try {
			while (result.next()) {
				productName.add(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productName;
	}

	/*
	 * public static Map<String,String> getSupplierByName(String name) {
	 * Map<String, String> map = new HashMap<String, String>(); ResultSet result
	 * = getResultSet("select * from where name = '" + name +"' "); try {
	 * ResultSetMetaData meta = result.getMetaData(); while(result.next()) {
	 * for(int i=1; i <= meta.getColumnCount(); i++) {
	 * map.put(meta.getColumnName(i), result.getString(i)); } } } catch
	 * (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return map; }
	 */

	public static ProductInfo getProductByName(String name) {
		ProductInfo product = new ProductInfo();
		ResultSet result = getResultSet("select * from tb_productInfo where fullname = '"
				+ name + "' ");
		try {
			while (result.next()) {
				product.setFullname(result.getString("fullname"));
				product.setApproval(result.getString("approval"));
				product.setLotnumber(result.getString("lotnumber"));
				product.setMemo(result.getString("memo"));
				product.setOriginplace(result.getString("originplace"));
				product.setPac(result.getString("package"));
				product.setShortname(result.getString("shortname"));
				product.setStandard(result.getString("standard"));
				product.setSupplier(result.getString("supplier"));
				product.setUnit(result.getString("unit"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	public static boolean addClient(ClientInfo client) {

		PreparedStatement pstat;
		int i = 0;
		try {
			pstat = conn
					.prepareStatement("insert into tb_client values(?,?,?,?,?,?,?,?)");
			pstat.setString(1, client.getId());
			pstat.setString(2, client.getFullname());
			pstat.setString(3, client.getAddress());
			pstat.setString(4, client.getContact());
			pstat.setString(5, client.getPhone());
			pstat.setString(6, client.getBank());
			pstat.setString(7, client.getEmail());
			pstat.setString(8, client.getShortname());
			i = pstat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i == 1)
			return true;
		else
			return false;
	}

	public static int deleteClient(String fullname) {
		int flag = 0;
		String sql = "delete from tb_client where name = '" + fullname + "'";
		Statement stat;
		try {
			stat = conn.createStatement();
			flag = stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static int updateClient(ClientInfo client, String fullname) {
		int flag = 0;
		String id = "";
		ResultSet result = getResultSet("select id from tb_client where name = '"
				+ fullname + "'");
		try {
			result.next();
			id = result.getString(1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "update tb_client set name = ?,address = ?,contact = ?,phone = ?,bank = ?,email = ?,shortname = ? where id = '"
				+ id + "'";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, client.getFullname());
			pstat.setString(2, client.getAddress());
			pstat.setString(3, client.getContact());
			pstat.setString(4, client.getPhone());
			pstat.setString(5, client.getBank());
			pstat.setString(6, client.getEmail());
			pstat.setString(7, client.getShortname());
			flag = pstat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static List<String> getClientName() {
		ResultSet result = getResultSet("select name from tb_client");
		List<String> clientName = new ArrayList<String>();
		try {
			while (result.next()) {
				clientName.add(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientName;
	}

	/*
	 * public static Map<String,String> getSupplierByName(String name) {
	 * Map<String, String> map = new HashMap<String, String>(); ResultSet result
	 * = getResultSet("select * from where name = '" + name +"' "); try {
	 * ResultSetMetaData meta = result.getMetaData(); while(result.next()) {
	 * for(int i=1; i <= meta.getColumnCount(); i++) {
	 * map.put(meta.getColumnName(i), result.getString(i)); } } } catch
	 * (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return map; }
	 */

	public static ClientInfo getClientByName(String name) {
		ClientInfo client = new ClientInfo();
		ResultSet result = getResultSet("select * from tb_client where name = '"
				+ name + "' ");
		try {
			while (result.next()) {
				client.setFullname(result.getString("name"));
				client.setAddress(result.getString("address"));
				client.setContact(result.getString("contact"));
				client.setPhone(result.getString("phone"));
				client.setBank(result.getString("bank"));
				client.setEmail(result.getString("email"));
				client.setShortname(result.getString("shortname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

	public static boolean addJsr(JsrInfo jsr) {

		PreparedStatement pstat;
		int i = 0;
		try {
			pstat = conn
					.prepareStatement("insert into tb_jsr(name,age,sex,phone) values(?,?,?,?)");
			pstat.setString(1, jsr.getName());
			pstat.setString(2, jsr.getAge());
			pstat.setString(3, jsr.getSex());
			pstat.setString(4, jsr.getPhone());
			i = pstat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i == 1)
			return true;
		else
			return false;
	}

	public static int updateJsr(JsrInfo jsr) {
		String sql = "update tb_jsr set age = ?,sex = ?,phone = ? where name = ?";
		int flag = 0;
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, jsr.getAge());
			pstat.setString(2, jsr.getSex());
			pstat.setString(3, jsr.getPhone());
			pstat.setString(4, jsr.getName());
			flag = pstat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static int updateJsrState(int status, String name) {
		String sql;
		if (status == 1)
			sql = "update tb_jsr set enable = enable-1 where name = '" + name
					+ "'";
		else
			sql = "update tb_jsr set enable = enable+1 where name = '" + name
					+ "'";
		int flag = 0;
		try {
			Statement stat = conn.createStatement();
			flag = stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static int deleteJsr(String name) {
		String sql = "delete from tb_jsr where name = '" + name + "'";
		int flag = 0;
		try {
			Statement stat = conn.createStatement();
			flag = stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static ResultSet getResultSet(String sql) {
		ResultSet result = null;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static boolean checkLogin(Component parentComponent,
			String username, String password) {
		ResultSet result = null;
		String sql = "select * from tb_userlist where name='" + username + "' ";// 双引号单引号双引号
		result = getResultSet(sql);
		try {
			if (!result.next()) {
				// System.out.println(sql);
				JOptionPane.showMessageDialog(parentComponent, "此用户不存在！");
				return false;
			} else {
				result = getResultSet("select * from tb_userlist where name='"
						+ username + "' and pass='" + password + "' ");
				if (!result.next()) {
					JOptionPane.showMessageDialog(parentComponent, "密码不正确！");
					return false;
				}
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
