package com.wgc.login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import com.wgc.MainFrame;
import com.wgc.dao.Dao;

public class LoginDialog extends JFrame {
	private MainFrame mainFrame;
	public LoginDialog(){
		try {
			UIManager.setLookAndFeel(UIManager
					.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LoginPanel loginPanel = new LoginPanel();
		loginPanel.setLayout(null);//important
		
		JLabel username = new JLabel("用户名：");
		username.setBounds(new Rectangle(90, 42, 60, 20));
		JLabel password = new JLabel("密  码：");
		password.setBounds(new Rectangle(91, 65, 60, 20));
		JTextField tfUsername = new JTextField();
		tfUsername.setBounds(150, 42, 100, 20);
		JPasswordField pfPassword = new JPasswordField();
		pfPassword.setBounds(150, 65, 100, 20);
	
		JButton login = new JButton("登录");
		login.setBounds(90, 100, 60, 25);
		login.setBackground(new Color(0x1c8382));
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Dao.checkLogin(LoginDialog.this, tfUsername.getText(), new String(pfPassword.getPassword()))){
					mainFrame  = new MainFrame();
					mainFrame.setVisible(true);
					MainFrame.getUserLabel().setText(tfUsername.getText());
					setVisible(false);
				}
				//System.out.println(pfPassword.getPassword().toString());
			}
		});
		pfPassword.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyChar() == '\n')
					login.doClick();
			}
		});
		JButton exit = new JButton("退出");
		exit.setBounds(190, 100, 60, 25);
		exit.setBackground(new Color(0x1c8382));
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		loginPanel.add(username,null);
		loginPanel.add(tfUsername,null);
		loginPanel.add(password,null);
		loginPanel.add(pfPassword,null);
		loginPanel.add(login);
		loginPanel.add(exit);
		loginPanel.setBackground(new Color(0xd7dcc6));
		
		
		Container c = this.getContentPane();
		c.add(loginPanel);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(500, 300, 300, 200);
		this.setTitle("登录系统");
		this.setVisible(true);
	}
}
