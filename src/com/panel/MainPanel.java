package com.panel;

import com.frame.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MainPanel extends JPanel implements MouseListener, MouseMotionListener {
	Image im;
	ImageIcon backward, hint, restart, giveup, option, quit;
	JLabel label1, label2, label3, label4, label5, label6, score;
	GameFrame gameFrame;

	public MainPanel(Image im, GameFrame gameFrame) {
		this.gameFrame = gameFrame;

		this.im = im;
		this.setOpaque(true);
		setLayout(new BorderLayout());


		score = new JLabel();
		score.setBounds(300, 50, 200, 20);
		score.setBackground(Color.white);
		score.setForeground(Color.BLUE);
		score.setOpaque(true);
		add(score);
		setscore();

		label1 = new JLabel();
		backward = new ImageIcon("./img/backward.jpg");
		label1.setIcon(backward);
		label1.setBounds(0, 85, backward.getIconWidth(), backward.getIconHeight());
		label1.setVisible(false);
		add(label1);

		label2 = new JLabel();
		hint = new ImageIcon("./img/hint.jpg");
		label2.setIcon(hint);
		label2.setBounds(0, 145, backward.getIconWidth(), backward.getIconHeight());
		label2.setVisible(false);
		add(label2);

		label3 = new JLabel();
		restart = new ImageIcon("./img/restart.jpg");
		label3.setIcon(restart);
		label3.setBounds(0, 205, backward.getIconWidth(), backward.getIconHeight());
		label3.setVisible(false);
		add(label3);

		label4 = new JLabel();
		giveup = new ImageIcon("./img/give up.jpg");
		label4.setIcon(giveup);
		label4.setBounds(0, 265, backward.getIconWidth(), backward.getIconHeight());
		label4.setVisible(false);
		add(label4);

		label5 = new JLabel();
		option = new ImageIcon("./img/option.jpg");
		label5.setIcon(option);
		label5.setBounds(0, 325, backward.getIconWidth(), backward.getIconHeight());
		label5.setVisible(false);
		add(label5);

		label6 = new JLabel();
		quit = new ImageIcon("./img/quit.jpg");
		label6.setIcon(quit);
		label6.setBounds(0, 385, backward.getIconWidth(), backward.getIconHeight());
		label6.setVisible(false);
		add(label6);

		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void setscore() {
		score.setText("Round " + gameFrame.round + "  " + "Score: " + gameFrame.grade);
		score.setFont(new Font("Times New Roman", Font.BOLD, 20));
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
		if(x < backward.getIconWidth() && y > 85 && y < 85 + backward.getIconHeight()) {
			label1.setVisible(true);
		} else {
			label1.setVisible(false);
		}
		if(x < backward.getIconWidth() && y > 145 && y < 145 + backward.getIconHeight()) {
			label2.setVisible(true);
		} else {
			label2.setVisible(false);
		}
		if(x < backward.getIconWidth() && y > 205 && y < 205 + backward.getIconHeight()) {
			label3.setVisible(true);
		} else {
			label3.setVisible(false);
		}
		if(x < backward.getIconWidth() && y > 265 && y < 265 + backward.getIconHeight()) {
			label4.setVisible(true);
		} else {
			label4.setVisible(false);
		}
		if(x < backward.getIconWidth() && y > 325 && y < 325 + backward.getIconHeight()) {
			label5.setVisible(true);
		} else {
			label5.setVisible(false);
		}
		if(x < backward.getIconWidth() && y > 385 && y < 385 + backward.getIconHeight()) {
			label6.setVisible(true);
		} else {
			label6.setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX();
		int y = arg0.getY();
		if(x < backward.getIconWidth() && y > 385 && y < 385 + backward.getIconHeight()) {
			gameFrame.card.first(gameFrame.gamepanel);
		}
		if(x < backward.getIconWidth() && y > 325 && y < 325 + backward.getIconHeight()) {
			gameFrame.card.previous(gameFrame.gamepanel);
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
