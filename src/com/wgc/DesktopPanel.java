package com.wgc;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class DesktopPanel extends JDesktopPane{

	private final Image backImg;
	public DesktopPanel() {
		// TODO Auto-generated constructor stub
		URL url = this.getClass().getResource("/image/back.jpg");
		backImg = new ImageIcon(url).getImage();
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		//super.paintComponent(g);
		g.drawImage(backImg, 0, 0,this.getWidth(),this.getHeight(),this);
	}
}
