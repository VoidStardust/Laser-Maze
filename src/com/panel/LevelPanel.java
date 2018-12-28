package com.panel;

import com.frame.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class LevelPanel extends JPanel implements MouseMotionListener, MouseListener {
	Image im;
	JLabel[] label1, label2, label3, label4;
	JLabel label;
	ImageIcon i1, i2, i3, i4, ret;
	GameFrame gameFrame;

	public LevelPanel(Image im, GameFrame gameFrame) {
		this.gameFrame = gameFrame;

		setLayout(null);
		this.im = im;
		this.setOpaque(true);

		label1 = new JLabel[5];
		i1 = new ImageIcon("./img/1.jpg");
		for(int i = 0; i < 5; i++) {
			label1[i] = new JLabel();
			label1[i].setIcon(i1);
			label1[i].setVisible(false);
			add(label1[i]);
		}
		label1[0].setBounds(30, 55, i1.getIconWidth(), i1.getIconHeight());
		label1[1].setBounds(180, 55, i1.getIconWidth(), i1.getIconHeight());
		label1[2].setBounds(327, 55, i1.getIconWidth(), i1.getIconHeight());
		label1[3].setBounds(477, 55, i1.getIconWidth(), i1.getIconHeight());
		label1[4].setBounds(625, 55, i1.getIconWidth(), i1.getIconHeight());

		label2 = new JLabel[5];
		i2 = new ImageIcon("./img/2.jpg");
		for(int i = 0; i < 5; i++) {
			label2[i] = new JLabel();
			label2[i].setIcon(i2);
			label2[i].setVisible(false);
			add(label2[i]);
		}
		label2[0].setBounds(30, 176, i2.getIconWidth(), i2.getIconHeight());
		label2[1].setBounds(180, 176, i2.getIconWidth(), i2.getIconHeight());
		label2[2].setBounds(327, 176, i2.getIconWidth(), i2.getIconHeight());
		label2[3].setBounds(477, 176, i2.getIconWidth(), i2.getIconHeight());
		label2[4].setBounds(625, 176, i2.getIconWidth(), i2.getIconHeight());

		label3 = new JLabel[5];
		i3 = new ImageIcon("./img/3.jpg");
		for(int i = 0; i < 5; i++) {
			label3[i] = new JLabel();
			label3[i].setIcon(i3);
			label3[i].setVisible(false);
			add(label3[i]);
		}
		label3[0].setBounds(28, 310, i3.getIconWidth(), i3.getIconHeight());
		label3[1].setBounds(175, 310, i3.getIconWidth(), i3.getIconHeight());
		label3[2].setBounds(325, 310, i3.getIconWidth(), i3.getIconHeight());
		label3[3].setBounds(473, 310, i3.getIconWidth(), i3.getIconHeight());
		label3[4].setBounds(621, 310, i3.getIconWidth(), i3.getIconHeight());

		label4 = new JLabel[5];
		i4 = new ImageIcon("./img/4.jpg");
		for(int i = 0; i < 5; i++) {
			label4[i] = new JLabel();
			label4[i].setIcon(i4);
			label4[i].setVisible(false);
			add(label4[i]);
		}
		label4[0].setBounds(28, 435, i4.getIconWidth(), i4.getIconHeight());
		label4[1].setBounds(175, 435, i4.getIconWidth(), i4.getIconHeight());
		label4[2].setBounds(325, 435, i4.getIconWidth(), i4.getIconHeight());
		label4[3].setBounds(473, 435, i4.getIconWidth(), i4.getIconHeight());
		label4[4].setBounds(621, 435, i4.getIconWidth(), i4.getIconHeight());

		label = new JLabel();
		ret = new ImageIcon("./img/return.jpg");
		label.setIcon(ret);
		label.setBounds(710, 0, ret.getIconWidth(), ret.getIconHeight());
		label.setVisible(false);
		add(label);

		addMouseMotionListener(this);
		addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX();
		int y = arg0.getY();

		if(x > 718 && x < 800 && y > 0 && y < 50) {
			label.setVisible(true);
		} else {
			label.setVisible(false);
		}

		for(int i = 0; i < 5; i++) {
			if(x > 30 + i * 150 && x < 30 + i1.getIconWidth() + i * 150 && y > 55 && y < 55 + i1.getIconHeight()) {
				label1[i].setVisible(true);
			} else {
				label1[i].setVisible(false);
			}
		}
		for(int i = 0; i < 5; i++) {
			if(x > 30 + i * 150 && x < 30 + i2.getIconWidth() + i * 150 && y > 217 &&
					y < 217 + i2.getIconHeight()) {
				label2[i].setVisible(true);
			} else {
				label2[i].setVisible(false);
			}
		}
		for(int i = 0; i < 5; i++) {
			if(x > 30 + i * 150 && x < 30 + i3.getIconWidth() + i * 150 && y > 310 &&
					y < 310 + i3.getIconHeight()) {
				label3[i].setVisible(true);
			} else {
				label3[i].setVisible(false);
			}
		}
		for(int i = 0; i < 5; i++) {
			if(x > 30 + i * 150 && x < 30 + i4.getIconWidth() + i * 150 && y > 435 &&
					y < 435 + i4.getIconHeight()) {
				label4[i].setVisible(true);
			} else {
				label4[i].setVisible(false);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX();
		int y = arg0.getY();
		if(x > 718 && x < 800 && y > 0 && y < 50) {
			gameFrame.card.previous(gameFrame.gamepanel);
		}
		for(int i = 0; i < 5; i++) {
			if(x > 30 + i * 150 && x < 30 + i1.getIconWidth() + i * 150 && y > 55 && y < 55 + i1.getIconHeight()) {
				gameFrame.round = i + 1;
				gameFrame.mainpanel.setscore();
				gameFrame.card.next(gameFrame.gamepanel);
				//System.out.println(round);
			}
		}
		for(int i = 0; i < 5; i++) {
			if(x > 30 + i * 150 && x < 30 + i2.getIconWidth() + i * 150 && y > 217 &&
					y < 217 + i2.getIconHeight()) {
				gameFrame.round = i + 6;
				gameFrame.mainpanel.setscore();
				gameFrame.card.next(gameFrame.gamepanel);
			}
		}
		for(int i = 0; i < 5; i++) {
			if(x > 30 + i * 150 && x < 30 + i3.getIconWidth() + i * 150 && y > 310 &&
					y < 310 + i3.getIconHeight()) {
				gameFrame.round = i + 11;
				gameFrame.mainpanel.setscore();
				gameFrame.card.next(gameFrame.gamepanel);
			}
		}
		for(int i = 0; i < 5; i++) {
			if(x > 30 + i * 150 && x < 30 + i4.getIconWidth() + i * 150 && y > 435 &&
					y < 435 + i4.getIconHeight()) {
				gameFrame.round = i + 16;
				gameFrame.mainpanel.setscore();
				gameFrame.card.next(gameFrame.gamepanel);
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
