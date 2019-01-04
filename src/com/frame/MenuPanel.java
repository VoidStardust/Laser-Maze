package com.frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class MenuPanel extends JPanel implements MouseListener, MouseMotionListener {
	private Image im;
	private MainPanel mainpanel;
	private ImageIcon icon[];
	private JLabel label[];

	public MenuPanel(Image im, MainPanel mainpanel) {
		this.im = im;
		this.mainpanel = mainpanel;
		
		setLayout(null);
		setOpaque(true);
		
		initMenu();
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	private void initMenu() {
		label = new JLabel[5];
		icon = new ImageIcon[5];
		
		for(int i = 0; i < 5; i++) {
			icon[i] = new ImageIcon("./img/menu"+ (i + 1) + ".jpg");
			label[i] = new JLabel();
			label[i].setIcon(icon[i]);
			label[i].setVisible(false);
			add(label[i]);
		}
		
		label[0].setBounds(127, 219, icon[0].getIconWidth(), icon[0].getIconHeight());
		label[1].setBounds(273, 291, icon[1].getIconWidth(), icon[1].getIconHeight());
		label[2].setBounds(386, 233, icon[2].getIconWidth(), icon[2].getIconHeight());
		label[3].setBounds(525, 280, icon[3].getIconWidth(), icon[3].getIconHeight());
		label[4].setBounds(632, 220, icon[4].getIconWidth(), icon[4].getIconHeight());
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
		
		if(x > 125 && x < 115 + icon[0].getIconWidth() && y > 217 && y < 217 + icon[0].getIconHeight()) {
			label[0].setVisible(true);
		} else {
			label[0].setVisible(false);
		}
		
		if(x > 273 && x < 253 + icon[1].getIconWidth() && y > 291 && y < 291 + icon[1].getIconHeight()) {
			label[1].setVisible(true);
		} else {
			label[1].setVisible(false);
		}
		
		if(x > 396 && x < 386 + icon[2].getIconWidth() && y > 232 && y < 232 + icon[2].getIconHeight()) {
			label[2].setVisible(true);
		} else {
			label[2].setVisible(false);
		}
		
		if(x > 525 && x < 505 + icon[3].getIconWidth() && y > 280 && y < 280 + icon[3].getIconHeight()) {
			label[3].setVisible(true);
		} else {
			label[3].setVisible(false);
		}
		
		if(x > 642 && x < 632 + icon[4].getIconWidth() && y > 220 && y < 220 + icon[4].getIconHeight()) {
			label[4].setVisible(true);
		} else {
			label[4].setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX(), y = arg0.getY();
		
		if(x > 125 && x < 115 + icon[0].getIconWidth() && y > 217 && y < 217 + icon[0].getIconHeight()) {
			mainpanel.card.next(mainpanel);
		}
		
		if(x > 273 && x < 253 + icon[1].getIconWidth() && y > 291 && y < 291 + icon[1].getIconHeight()) {
			mainpanel.card.last(mainpanel);
		}
		
		if(x > 396 && x < 386 + icon[2].getIconWidth() && y > 232 && y < 232 + icon[2].getIconHeight()) {
			mainpanel.card.last(mainpanel);
			mainpanel.card.previous(mainpanel);
			mainpanel.card.previous(mainpanel);
		}
		
		if(x > 525 && x < 505 + icon[3].getIconWidth() && y > 280 && y < 280 + icon[3].getIconHeight()) {
			mainpanel.card.last(mainpanel);
			mainpanel.card.previous(mainpanel);
		}
		
		if(x > 642 && x < 632 + icon[4].getIconWidth() && y > 220 && y < 220 + icon[4].getIconHeight()) {
			int n = JOptionPane.showConfirmDialog(null, "Are you sure to leave?", "Exit", JOptionPane.YES_NO_OPTION);
			if(n == 0) {
				System.exit(0);
			} 
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
