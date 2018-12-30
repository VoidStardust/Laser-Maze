package com.frame;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class BasePanel extends JPanel {
	private MainPanel mainpanel;
	private OptionPanel optionpanel;
	private GamePanel gamepanel;
	int round, score;
	
	public BasePanel(MainPanel mainpanel) {
		this.mainpanel = mainpanel;
		
		round = 50;
		setLayout(null);
		initBase();
	}
	
	void setRound() {
		optionpanel.label[5].setText("Round: " + round);
	}
	
	void setScore(int score) {
		this.score += score;
	}
	
	void showScore() {
		optionpanel.label[6].setText("Score" + score);
	}
	
	private void initBase() {
		optionpanel = new OptionPanel((new ImageIcon("./img/option1.jpg")).getImage(), mainpanel, BasePanel.this);
		gamepanel = new GamePanel((new ImageIcon("./img/white.jpg")).getImage());
		
		optionpanel.setBounds(0, 0, 170, 570);
		gamepanel.setBounds(180, 0, 720, 582);
		add(optionpanel);
		add(gamepanel);
	}
}
