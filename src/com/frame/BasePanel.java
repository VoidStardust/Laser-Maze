package com.frame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import com.panel.GamePanel;

class BasePanel extends JPanel {
	private MainPanel mainpanel;
	private OptionPanel optionpanel;
	private GamePanel gamepanel;
	private GameFrame frame;
	int round, score;
	boolean []noSolution;
	boolean []accepted;
	String []state;
	public BasePanel(MainPanel mainpanel) {

		this.mainpanel = mainpanel;
		
		score = 50;
		noSolution = new boolean[20];
		accepted = new boolean[20];
		state = new String[20];
		for(int i=0;i<20;i++) {
			noSolution[i]=true;
			accepted[i]=false;
			state[i]="Unsolved";
		}
		setLayout(null);
		initBase();
		showScore();


	}

	void setRound() {
		optionpanel.label[5].setText("Round:" + round);
		gamepanel.setRound(round);
		optionpanel.label[8].setText("State:" + state[round-1]);
	}
	
	void reStart() {
		gamepanel.setRound(round);
	}

	void setScore(int score) {
		this.score += score;
	}

	void showScore() {
		optionpanel.label[6].setText("Score:" + score);
	}
	void showState(){
		optionpanel.label[8].setText("State:"+state[round-1]);
	}
	void withDraw() {
		gamepanel.withdraw();
	}
	void giveUp() {
		gamepanel.setSolution(round);
		System.out.println("give up");
		noSolution[round-1]=false;
		System.out.println(round);
	}
	void confirm() {
		if(gamepanel.isCorrect(round-1) ) {
			if(noSolution[round-1] && !accepted[round-1]) {
				this.score+=gamepanel.getBoard().giveGrade();
				accepted[round-1] = true;
				System.out.println("you win");
				showScore();
			}
			Dialog dog=new Dialog("./img/AC.jpg");
			state[round-1]="Solved";
			round=round%20;
			round++;
			setRound();
		} else {
			Dialog dog=new Dialog("./img/Wrong.jpg");
		}
	}

		private void initBase() {
		optionpanel = new OptionPanel((new ImageIcon("./img/option1.jpg")).getImage(), mainpanel, BasePanel.this);
		gamepanel = new GamePanel();
		

		optionpanel.setBounds(0, 0, 170, 570);
		gamepanel.setBounds(180, 0, 720, 582);
		add(optionpanel);
		add(gamepanel);
	}


	class Dialog extends JDialog {
		BackgroundPanel panel;
		JButton button;
		private Toolkit tool;
		private Dimension dim;

		public Dialog(String icon) {
			panel = new BackgroundPanel((new ImageIcon(icon)).getImage());
			setResizable(false);
			this.setContentPane(panel);
			setSize(314, 202);
			tool = Toolkit.getDefaultToolkit();
			dim = tool.getScreenSize();
			setLocation((dim.width - getWidth()) / 2, (dim.height - getHeight()) / 2);
			setVisible(true);
		}
	}

	class BackgroundPanel extends JPanel {
		Image im;

		public BackgroundPanel(Image im) {
			this.im = im;

			setLayout(null);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
		}
	}



}
