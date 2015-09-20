package com.wgc.dao;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.ObjectInputStream.GetField;
import java.sql.*;
import java.util.Optional;

import javax.swing.JOptionPane;

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
		String sql = "select * from tb_userlist where name='" + username
				+ "' ";// 双引号单引号双引号
		result = getResultSet(sql);
		try {
			if (!result.next()) {
				//System.out.println(sql);
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
