package com.wgc.login;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;

public class LoginPanel extends JPanel{		
		Image img;
		public LoginPanel() {
			super();
			URL url = this.getClass().getResource("/image/login.jpg");
			img = Toolkit.getDefaultToolkit().getImage(url);
		}
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this);
		}
		
}
