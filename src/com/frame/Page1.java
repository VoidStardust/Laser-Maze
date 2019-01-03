package com.frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Page1 extends JPanel implements MouseListener, MouseMotionListener {
	private Image im;
	private MainPanel mainpanel;
	private HelpPanel helppanel; 
	private JLabel label1, label2;
	private ImageIcon icon1, icon2;
	
	public Page1(Image im, MainPanel mainpanel, HelpPanel helppanel) {
		this.im = im;
		this.mainpanel = mainpanel;
		this.helppanel = helppanel;
		
		initPage1();
		setLayout(null);
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
	}
	
	void initPage1(){
		icon1 = new ImageIcon("./img/x5.jpg");
		label1 = new JLabel();
		label1.setIcon(icon1);
		label1.setBounds(0, 0, icon1.getIconWidth(), icon1.getIconHeight());
		label1.setVisible(false);
		add(label1);
		
		icon2 = new ImageIcon("./img/right.jpg");
		label2 = new JLabel();
		label2.setIcon(icon2);
		label2.setBounds(880 - icon2.getIconWidth(), 240, icon2.getIconWidth(), icon2.getIconHeight());
		label2.setVisible(false);
		add(label2);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX(), y = arg0.getY();
		
		if(x < icon1.getIconWidth() && y < icon1.getIconHeight()) {
			label1.setVisible(true);
		} else {
			label1.setVisible(false);
		}
		
		if(x > 880 - icon2.getIconWidth() && y > 240 && y < 330) {
			label2.setVisible(true);
		} else {
			label2.setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX(), y = arg0.getY();
		
		if(x < icon1.getIconWidth() && y < icon1.getIconHeight()) {
			mainpanel.card.first(mainpanel);
		}
		
		if(x > 880 - icon2.getIconWidth() && y > 240 && y < 330) {
			helppanel.card.next(helppanel);
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
