package com.wgc.dao;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.ObjectInputStream.GetField;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Date;
import java.util.Set;

import javax.swing.JOptionPane;

import com.wgc.dao.model.*;

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

	public static String getContact(String supplierName) {
		String contact = "";
		ResultSet result = getResultSet("select contact from tb_supplier where name = '"+supplierName+"' ");
		try {
			while(result.next()) {
				contact = result.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contact;
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
	
	public static List<String> getProductNameBySupplierName(String supplierName) {
		ResultSet result = getResultSet("select fullname from tb_productInfo where supplier ='"+supplierName+"'");
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
				product.setId(result.getString("id"));
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
	
	public static ProductInfo getProductById(String id) {
		ProductInfo product = new ProductInfo();
		ResultSet result = getResultSet("select * from tb_productInfo where id = '"
				+ id + "' ");
		try {
			while (result.next()) {
				product.setId(result.getString("id"));
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
	//获得经手人
	public static List<String> getJsrName() {
		ResultSet result = getResultSet("select name from tb_jsr where enable = 1");
		List<String> jsrName = new ArrayList<String>();
		try {
			while (result.next()) {
				jsrName.add(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsrName;
	}
	
	public static String getRukuMainMaxId() {
		String max = "";
		String baseId = "";
		ResultSet result = getResultSet("select max(id) from tb_ruku_main");
		try {
			if(result.next()) {
				max = result.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		baseId = max == null ? "000" : max.substring(max.length()-3);
		max = "RK";
		Date date = new Date();
		max += String.format("%tF", date).replace("-","");
		max += String.format("%03d", Integer.parseInt(baseId) + 1);
		return max;
	}
	
	public static boolean Ruku(RukuMainInfo rukumain) {
		String sql = "insert into tb_ruku_main values(?,?,?,?,?,?,?,?,?)";
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, rukumain.getId());
			pstat.setInt(2, rukumain.getProductnum());
			pstat.setDouble(3, rukumain.getSummoney());
			pstat.setString(4, rukumain.getConclusion());
			pstat.setString(5, rukumain.getSuppliername());
			pstat.setDate(6,new java.sql.Date(rukumain.getDate().getTime()));
			pstat.setString(7, rukumain.getOperator());
			pstat.setString(8, rukumain.getJsr());
			pstat.setString(9, rukumain.getPayment());
			if(pstat.executeUpdate() == 0)
				return false;
			Set<RuKuDetailInfo> set = rukumain.getDetail();
			Iterator ite = set.iterator();
			while(ite.hasNext()) {
				RuKuDetailInfo detail = new RuKuDetailInfo();
				detail = (RuKuDetailInfo)ite.next();
				sql = "insert into tb_ruku_detail(rkID,productID,price,count) values(?,?,?,?)";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, detail.getRkID());
				pstat.setString(2, detail.getProductID());
				pstat.setDouble(3, detail.getPrice());
				pstat.setInt(4, detail.getCount());
				if(pstat.executeUpdate() == 0)
					return false;
				sql = "select * from tb_kucun where productID = '"+detail.getProductID()+"' ";
				Statement stat = conn.createStatement();
				ResultSet result = getResultSet(sql);
				if(result.next()) {
					sql = "update tb_kucun set count = count + '"+detail.getCount()+"' where productID = '"+detail.getProductID()+"'";
					if(stat.executeUpdate(sql) == 0)
						return false;	
				}
				else {
					ProductInfo product = getProductById(detail.getProductID());
					sql = "insert into tb_kucun(productID,productName,productUnit,count,originalPlace) values(?,?,?,?,?)";
					pstat = conn.prepareStatement(sql);
					pstat.setString(1, detail.getProductID());
					pstat.setString(2, product.getFullname());
					pstat.setString(3, product.getUnit());
					pstat.setInt(4, detail.getCount());
					pstat.setString(5, product.getOriginplace());
					if(pstat.executeUpdate() == 0)
						return false;
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
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

	public static int updatePassword(String username, String password) {
		int flag = 0;
		String sql = "update tb_userlist set pass = '" + password
				+ "'where name='" + username + "' ";
		try {
			Statement stat = conn.createStatement();
			flag = stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean checkOriginalPassword(String username, String password) {
		String sql = "select pass from tb_userlist where name='" + username
				+ "' ";
		ResultSet result = getResultSet(sql);
		try {
			if (result.next()) {
				if (result.getString(1).equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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
