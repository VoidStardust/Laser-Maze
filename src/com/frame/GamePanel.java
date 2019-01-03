package com.frame;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

class GamePanel extends JPanel {
	Image im;
	
	public GamePanel(Image im) {
		this.im = im;
		
		setLayout(null);
		setOpaque(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
	}
}
