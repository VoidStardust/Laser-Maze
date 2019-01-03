package com.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class OptionPanel extends JPanel implements MouseListener, MouseMotionListener {
	private Image im;
	private MainPanel mainpanel;
	private ImageIcon icon[];
	private BasePanel basepanel;
	JLabel label[];
	
	public OptionPanel(Image im, MainPanel mainpanel, BasePanel basepanel) {
		this.im = im;
		this.mainpanel = mainpanel;
		this.basepanel = basepanel;
		
		setLayout(null);
		setOpaque(true);
		
		initOption();
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	private void initOption(){
		label = new JLabel[9];
		icon = new ImageIcon[6];
		
		for(int i = 0; i < 5; i++) {
			icon[i] = new ImageIcon("./img/op" + (i + 1) + ".jpg");
			label[i] = new JLabel();
			label[i].setIcon(icon[i]);
			label[i].setVisible(false);
			add(label[i]);
		}
			
			label[0].setBounds(0, 100, icon[0].getIconWidth(), icon[0].getIconHeight());
			label[1].setBounds(0, 160, icon[1].getIconWidth(), icon[1].getIconHeight());
			label[2].setBounds(0, 220, icon[2].getIconWidth(), icon[2].getIconHeight());
			label[3].setBounds(0, 280, icon[0].getIconWidth(), icon[0].getIconHeight());
			label[4].setBounds(0, 340, icon[0].getIconWidth(), icon[0].getIconHeight());
			
			label[5] = new JLabel();
			label[6] = new JLabel();
			label[8] = new JLabel();
			label[5].setVisible(true);
			label[6].setVisible(true);
			label[8].setVisible(true);
			label[5].setForeground(Color.BLUE);
			label[6].setForeground(Color.BLUE);
			label[8].setForeground(Color.GREEN);
			label[5].setFont(new Font("Times New Roman", Font.BOLD, 15));
			label[6].setFont(new Font("Times New Roman", Font.BOLD, 15));
			label[8].setFont(new Font("Times New Roman", Font.BOLD, 15));;
			label[6].setText("Score: " + basepanel.score);

			label[5].setBounds(20, 430, 80, 30);
			label[6].setBounds(20, 460, 80, 30);
			label[8].setBounds(20, 490, 80, 30);
			add(label[5]);
			add(label[6]);
			add(label[8]);

			icon[5] = new ImageIcon("./img/op6.jpg");
			label[7] = new JLabel();
			label[7].setIcon(icon[5]);
			label[7].setBounds(0, 40, icon[5].getIconWidth(), icon[5].getIconHeight());
			label[7].setVisible(false);
			add(label[7]);



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
		
		if(x < icon[0].getIconWidth() && y > 100 && y < 150) {
			label[0].setVisible(true);
		} else {
			label[0].setVisible(false);
		}
		
		if(x < icon[1].getIconWidth() && y > 160 && y < 210) {
			label[1].setVisible(true);
		} else {
			label[1].setVisible(false);
		}
		
		if(x < icon[2].getIconWidth() && y > 220 && y < 270) {
			label[2].setVisible(true);
		} else {
			label[2].setVisible(false);
		}
		
		if(x < icon[3].getIconWidth() && y > 280 && y < 330) {
			label[3].setVisible(true);
		} else {
			label[3].setVisible(false);
		}
		
		if(x < icon[4].getIconWidth() && y > 340 && y < 390) {
			label[4].setVisible(true);
		} else {
			label[4].setVisible(false);
		}

		if(x < icon[5].getIconWidth() && y > 40 && y < 90) {
			label[7].setVisible(true);
		} else {
			label[7].setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX(), y = arg0.getY();

		if(x < icon[5].getIconWidth() && y > 40 && y < 90) {
			basepanel.confirm();
		}
		
		if(x < icon[0].getIconWidth() && y > 100 && y < 150) {
			basepanel.withDraw();
		} 
		
		if(x < icon[1].getIconWidth() && y > 160 && y < 210) {
			//basepanel.setScore(-5);
			//basepanel.confirm();
			basepanel.showScore();
		}		
		if(x < icon[2].getIconWidth() && y > 220 && y < 270) {
			basepanel.reStart();
		} 
		
		if(x < icon[3].getIconWidth() && y > 280 && y < 330) {
			basepanel.giveUp();
		} 
		
		if(x < icon[4].getIconWidth() && y > 340 && y < 390) {
			int n = JOptionPane.showConfirmDialog(null, "Are you sure to quit?", "Quit", JOptionPane.YES_NO_OPTION);
			if(n == 0) {
				mainpanel.card.previous(mainpanel);
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
