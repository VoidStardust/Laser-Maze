package com.frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ModeOption extends JPanel implements MouseListener, MouseMotionListener {
	private Image im;
	private MainPanel mainpanel;
	private ModePanel modepanel;
	private JLabel label[];
	private ImageIcon icon[];
	
	public ModeOption(Image im, MainPanel mainpanel, ModePanel modepanel) {
		this.im = im;
		this.mainpanel = mainpanel;
		this.modepanel = modepanel;
		
		setLayout(null);
		setOpaque(true);
		initOption();
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	private void initOption() {
		label = new JLabel[3];
		icon = new ImageIcon[3];
		
		for(int i = 0; i < 3; i++) {
			icon[i] = new ImageIcon("./img/m" + (i + 1) + ".jpg");
			label[i] = new JLabel();
			label[i].setIcon(icon[i]);
			label[i].setVisible(false);
			add(label[i]);
		}
		
		label[0].setBounds(0, 40, icon[0].getIconWidth(), icon[0].getIconHeight());
		label[1].setBounds(0, 100, icon[1].getIconWidth(), icon[1].getIconHeight());
		label[2].setBounds(0, 160, icon[2].getIconWidth(), icon[2].getIconHeight());
		
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
		
		if(x < icon[0].getIconWidth() && y > 40 && y < 90) {
			label[0].setVisible(true);
		} else {
			label[0].setVisible(false);
		}

		if(x < icon[1].getIconWidth() && y > 100 && y < 150) {
			label[1].setVisible(true);
		} else {
			label[1].setVisible(false);
		}
		
		if(x < icon[2].getIconWidth() && y > 160 && y < 210) {
			label[2].setVisible(true);
		} else {
			label[2].setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX(), y = arg0.getY();
		
		if(x < icon[0].getIconWidth() && y > 40 && y < 90) {
			
		}
		
		if(x < icon[1].getIconWidth() && y > 100 && y < 150) {
			
		} 
		
		if(x < icon[2].getIconWidth() && y > 160 && y < 210) {
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
