package com.frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class LevelPanel extends JPanel implements MouseListener, MouseMotionListener {
	private Image im;
	private MainPanel mainpanel;
	private BasePanel basepanel;
	private JLabel label[];
	private ImageIcon icon[];
			
	public LevelPanel(Image im, MainPanel mainpanel, BasePanel basepanel) {
		this.im = im;
		this.mainpanel = mainpanel;
		this.basepanel = basepanel;
		
		setLayout(null);
		setOpaque(true);
		
		initLevel();
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	private void initLevel() {
		label = new JLabel[5];
		icon = new ImageIcon[5];
		
		for(int i = 0; i < 5; i++) {
			icon[i] = new ImageIcon("./img/x"+ (i + 1) + ".jpg");
			label[i] = new JLabel();
			label[i].setIcon(icon[i]);
			label[i].setVisible(false);
			add(label[i]);
		}
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
		int x= arg0.getX(), y = arg0.getY();
		int width = icon[0].getIconWidth();
		int height = icon[0].getIconHeight();
		
		
		if (x < icon[4].getIconWidth() && y < icon[4].getIconHeight()) {
			label[4].setBounds(0, 0, icon[4].getIconWidth(), icon[4].getIconHeight());
			label[4].setVisible(true);
		} else {
			label[4].setVisible(false);
		}
		
		if(y > 90 && y < 70 + height) {
			if(x > 200 && x < 180 + width) {
				label[0].setBounds(200, 90, width, height);
				label[0].setVisible(true);
			} else if(x > 200 + width && x < 180 + width * 2) {
				label[0].setBounds(200 + width, 90, width, height);
				label[0].setVisible(true);
			} else if(x > 200 + width * 2 && x < 180 + width *3) {
				label[0].setBounds(200 + width * 2, 90, width, height);
				label[0].setVisible(true);
			} else if(x > 200 + width * 3 && x < 180 + width *4 ) {
				label[0].setBounds(200 + width * 3, 90, width, height);
				label[0].setVisible(true);
			} else if(x > 200 + width * 4 && x < 180 + width * 5) {
				label[0].setBounds(200 + width * 4, 90, width, height);
				label[0].setVisible(true);
		    } else {
		    	label[0].setVisible(false);
		    }
		} else {
			label[0].setVisible(false);
		}
		
		if(y > 90 + height && y < 70 + height * 2) {
			if(x > 200 && x < 180 + width) {
				label[1].setBounds(200, 85 + height, width, height);
				label[1].setVisible(true);
			} else if(x > 200 + width && x < 180 + width * 2) {
				label[1].setBounds(200 + width, 85 + height, width, height);
				label[1].setVisible(true);
			} else if(x > 200 + width * 2 && x < 180 + width *3) {
				label[1].setBounds(200 + width * 2, 85 + height, width, height);
				label[1].setVisible(true);
			} else if(x > 200 + width * 3 && x < 180 + width *4 ) {
				label[1].setBounds(200 + width * 3, 85 + height, width, height);
				label[1].setVisible(true);
			} else if(x > 200 + width * 4 && x < 180 + width * 5) {
				label[1].setBounds(200 + width * 4, 85 + height, width, height);
				label[1].setVisible(true);
		    } else {
		    	label[1].setVisible(false);
		    }
		} else {
			label[1].setVisible(false);
		}
		
		if(y > 90 + height * 2 && y < 70 + height * 3) {
			if(x > 200 && x < 180 + width) {
				label[2].setBounds(200, 80 + height * 2, width, height);
				label[2].setVisible(true);
			} else if(x > 200 + width && x < 180 + width * 2) {
				label[2].setBounds(200 + width, 80 + height * 2, width, height);
				label[2].setVisible(true);
			} else if(x > 200 + width * 2 && x < 180 + width * 3) {
				label[2].setBounds(200 + width * 2, 80 + height * 2, width, height);
				label[2].setVisible(true);
			} else if(x > 200 + width * 3 && x < 180 + width * 4 ) {
				label[2].setBounds(200 + width * 3, 80 + height * 2, width, height);
				label[2].setVisible(true);
			} else if(x > 200 + width * 4 && x < 180 + width * 5) {
				label[2].setBounds(200 + width * 4, 80 + height * 2, width, height);
				label[2].setVisible(true);
		    } else {
		    	label[2].setVisible(false);
		    }
		} else {
			label[2].setVisible(false);
		}
		
		if(y > 90 + height * 3 && y < 70 + height * 4) {
			if(x > 200 && x < 180 + width) {
				label[3].setBounds(200, 75 + height * 3, width, height);
				label[3].setVisible(true);
			} else if(x > 200 + width && x < 180 + width * 2) {
				label[3].setBounds(200 + width, 75 + height * 3, width, height);
				label[3].setVisible(true);
			} else if(x > 200 + width * 2 && x < 180 + width *3) {
				label[3].setBounds(200 + width * 2, 75 + height * 3, width, height);
				label[3].setVisible(true);
			} else if(x > 200 + width * 3 && x < 180 + width *4 ) {
				label[3].setBounds(200 + width * 3, 75 + height * 3, width, height);
				label[3].setVisible(true);
			} else if(x > 200 + width * 4 && x < 180 + width * 5) {
				label[3].setBounds(200 + width * 4, 75 + height * 3, width, height);
				label[3].setVisible(true);
		    } else {
		    	label[3].setVisible(false);
		    }
		} else {
			label[3].setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX(), y = arg0.getY();
		int width = icon[0].getIconWidth();
		int height = icon[0].getIconHeight();
		
		if(x < icon[4].getIconWidth() && y < icon[4].getIconHeight()) {
			mainpanel.card.previous(mainpanel);
		}
		
		if(y > 90 && y < 70 + height) {
			if(x > 200 && x < 180 + width) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 1;
				basepanel.setRound();
			} else if(x > 200 + width && x < 180 + width * 2) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 2;
				basepanel.setRound();
			} else if(x > 200 + width * 2 && x < 180 + width *3) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 3;
				basepanel.setRound();
			} else if(x > 200 + width * 3 && x < 180 + width *4 ) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 4;
				basepanel.setRound();
			} else if(x > 200 + width * 4 && x < 180 + width * 5) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 5;
				basepanel.setRound();
		    } 
		    
		}
		
		if(y > 90 + height && y < 70 + height * 2) {
			if(x > 200 && x < 180 + width) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 6;
				basepanel.setRound();
			} else if(x > 200 + width && x < 180 + width * 2) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 7;
				basepanel.setRound();
			} else if(x > 200 + width * 2 && x < 180 + width *3) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 8;
				basepanel.setRound();
			} else if(x > 200 + width * 3 && x < 180 + width *4 ) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 9;
				basepanel.setRound();
			} else if(x > 200 + width * 4 && x < 180 + width * 5) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 10;
				basepanel.setRound();
		    } 
		} 
		
		if(y > 90 + height * 2 && y < 70 + height * 3) {
			if(x > 200 && x < 180 + width) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 11;
				basepanel.setRound();
			} else if(x > 200 + width && x < 180 + width * 2) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 12;
				basepanel.setRound();
			} else if(x > 200 + width * 2 && x < 180 + width * 3) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 13;
				basepanel.setRound();
			} else if(x > 200 + width * 3 && x < 180 + width * 4 ) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 14;
				basepanel.setRound();
			} else if(x > 200 + width * 4 && x < 180 + width * 5) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 15;
				basepanel.setRound();
		    } 
		} 
		
		if(y > 90 + height * 3 && y < 70 + height * 4) {
			if(x > 200 && x < 180 + width) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 16;
				basepanel.setRound();
			} else if(x > 200 + width && x < 180 + width * 2) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 17;
				basepanel.setRound();
			} else if(x > 200 + width * 2 && x < 180 + width *3) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 18;
				basepanel.setRound();
			} else if(x > 200 + width * 3 && x < 180 + width *4 ) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 19;
				basepanel.setRound();
			} else if(x > 200 + width * 4 && x < 180 + width * 5) {
				mainpanel.card.next(mainpanel);
				basepanel.round = 20;
				basepanel.setRound();
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
