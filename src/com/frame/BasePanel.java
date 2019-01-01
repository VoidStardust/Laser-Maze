package com.frame;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.panel.GamePanel;

class BasePanel extends JPanel implements MouseListener {
	private MainPanel mainpanel;
	private OptionPanel optionpanel;
	private GamePanel gamepanel;
	private GameFrame frame;
	int round, score;
	boolean []noSolution;
	boolean []scoreOnce;
	public BasePanel(MainPanel mainpanel) {
		this.mainpanel = mainpanel;
		
		score = 50;
		noSolution = new boolean[10];
		scoreOnce = new boolean[10];
		setLayout(null);
		initBase();
		showScore();
		//setFocusable(true);
		
		addMouseListener(this);
	}

	void setRound() {
		optionpanel.label[5].setText("Round:" + round);
		gamepanel.setRound(round);
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
	
	void withDraw() {
		gamepanel.withdraw();
	}
	void giveUp() {
		gamepanel.setSolution(round);
		noSolution[round-1]=false;
	}
	void getHint() {
		if(gamepanel.getBoard().isCorrect() ) {
			
			if(noSolution[round-1] && scoreOnce[round-1]) {
				this.score+=gamepanel.getBoard().giveGrade();
				scoreOnce[round-1] = false;
				
			}
			else if(noSolution[round-1] == false){
				System.out.println("you use answer");
			}
			else if(scoreOnce[round-1] == false) {
				System.out.println("you try twice");
			}
			
			int n = JOptionPane.showConfirmDialog(null, "Congratulations", "", JOptionPane.PLAIN_MESSAGE);
			if(n == 0) {
				round++;
				setRound();
			}
			
		} else {
			System.out.println("wrong");
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == gamepanel) {
			if(gamepanel.getBoard().isCorrect()) {
				System.out.println("Correct！");
			}
			else {
				System.out.println("WRONG!");
			}
		}
		else {
			System.out.println("no way");
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
