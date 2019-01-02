package com.frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class AboutPanel extends JPanel implements MouseListener, MouseMotionListener {
	Image im;
	MainPanel mainpanel;
	JLabel label;
	ImageIcon icon;
	
	public AboutPanel(Image im, MainPanel mainpanel) {
		this.im = im;
		this.mainpanel = mainpanel;
		
		setLayout(null);
		initAbout();
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	private void initAbout() {
		icon = new ImageIcon("./img/return2.jpg");
		label = new JLabel();
		label.setIcon(icon);
		label.setBounds(900 - icon.getIconWidth(), 0, icon.getIconWidth(), icon.getIconHeight());
		label.setVisible(false);
		add(label);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX(), y = arg0.getY();
		
		if(x > 900 - icon.getIconWidth() && y < icon.getIconHeight()) {
			label.setVisible(true);
		} else {
			label.setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX(), y = arg0.getY();
		
		if(x > 900 - icon.getIconWidth() && y < icon.getIconHeight()) {
			mainpanel.card.first(mainpanel);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


