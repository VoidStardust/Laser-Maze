package com.frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Page2 extends JPanel implements MouseListener, MouseMotionListener {
	private Image im;
	private HelpPanel helppanel;
	private JLabel label;
	private ImageIcon icon;
	
	public Page2(Image im, HelpPanel helppanel) {
		this.im = im;
		this.helppanel = helppanel;
		
		setLayout(null);
		initPage2();
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	private void initPage2(){
		icon = new ImageIcon("./img/left.jpg");
		label = new JLabel();
		label.setIcon(icon);
		label.setBounds(0, 210, icon.getIconWidth(), icon.getIconHeight());
		label.setVisible(false);
		add(label);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX(), y = arg0.getY();
		
		if(x < icon.getIconWidth() && y > 200 && y < 200 + icon.getIconHeight()) {
			label.setVisible(true);
		} else {
			label.setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX(), y = arg0.getY();
		
		if(x < icon.getIconWidth() && y > 200 && y < 200 + icon.getIconHeight()) {
			helppanel.card.previous(helppanel);
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
