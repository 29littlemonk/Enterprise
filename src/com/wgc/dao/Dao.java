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
