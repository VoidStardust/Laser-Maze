package com.panel;

import com.frame.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MenuPanel extends JPanel implements MouseListener, MouseMotionListener {
	Image im;
	ImageIcon mode, help, start, developer, exit;
	JLabel label1, label2, label3, label4, label5;
	GameFrame gameFrame;

	public MenuPanel(Image im, GameFrame gameFrame) {
		this.gameFrame = gameFrame;

		setLayout(null);
		this.im = im;
		this.setOpaque(true);
		addMouseListener(this);
		addMouseMotionListener(this);

		label1 = new JLabel();
		start = new ImageIcon("./img/start.jpg");
		label1.setIcon(start);
		label1.setBounds(75, 217, start.getIconWidth(), start.getIconHeight());
		label1.setVisible(false);
		add(label1);

		label2 = new JLabel();
		mode = new ImageIcon("./img/mode.jpg");
		label2.setIcon(mode);
		label2.setBounds(221, 290, mode.getIconWidth(), mode.getIconHeight());
		label2.setVisible(false);
		add(label2);

		label3 = new JLabel();
		help = new ImageIcon("./img/help.jpg");
		label3.setIcon(help);
		label3.setBounds(336, 231, help.getIconWidth(), help.getIconHeight());
		label3.setVisible(false);
		add(label3);

		label4 = new JLabel();
		developer = new ImageIcon("./img/developer.jpg");
		label4.setIcon(developer);
		label4.setBounds(475, 280, developer.getIconWidth(), developer.getIconHeight());
		label4.setVisible(false);
		add(label4);

		label5 = new JLabel();
		exit = new ImageIcon("./img/exit.jpg");
		label5.setIcon(exit);
		label5.setBounds(578, 213, exit.getIconWidth(), exit.getIconHeight());
		label5.setVisible(false);
		add(label5);

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
		if(x > 80 && x < (80 + start.getIconWidth()) && y > 219 && y < (219 + start.getIconHeight())) {
			label1.setVisible(true);
		} else {
			label1.setVisible(false);
		}

		if(x > 225 && x < (205 + mode.getIconWidth()) && y > 288 && y < (288 + mode.getIconHeight())) {
			label2.setVisible(true);
		} else {
			label2.setVisible(false);
		}

		if(x > 350 && x < (336 + help.getIconWidth()) && y > 234 && y < (234 + help.getIconHeight())) {
			label3.setVisible(true);
		} else {
			label3.setVisible(false);
		}

		if(x > 470 && x < (445 + developer.getIconWidth()) && y > 277 && y < (277 + developer.getIconHeight())) {
			label4.setVisible(true);
		} else {
			label4.setVisible(false);
		}

		if(x > 585 && x < (575 + exit.getIconWidth()) && y > 215 && y < (215 + exit.getIconHeight())) {
			label5.setVisible(true);
		} else {
			label5.setVisible(false);
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX();
		int y = arg0.getY();
		if(x > 585 && x < (575 + exit.getIconWidth()) && y > 215 && y < (215 + exit.getIconHeight())) {
			int n = JOptionPane.showConfirmDialog(null, "Are you sure to quit?", "Exit", JOptionPane.YES_NO_OPTION);
			if(n == 0) {
				System.exit(0);
			}
		}
		if(x > 75 && x < (75 + start.getIconWidth()) && y > 217 && y < (217 + start.getIconHeight())) {
			gameFrame.card.next(gameFrame.gamepanel);
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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}
