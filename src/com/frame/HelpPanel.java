package com.frame;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


class HelpPanel extends JPanel {
	CardLayout card;
	private Page1 panel1;
	private Page2 panel2;
	private MainPanel mainpanel;
	
	public HelpPanel(MainPanel mainpanel) {
		card = new CardLayout();
		this.mainpanel = mainpanel;
		
		setLayout(card);
		InitHelp();
	}
	
	private void InitHelp() {
		panel1 = new Page1((new ImageIcon("./img/help1.jpg")).getImage(), mainpanel, HelpPanel.this);
		panel2 = new Page2((new ImageIcon("./img/help2.jpg")).getImage(), HelpPanel.this);
		
		add(panel1);
		add(panel2);
	}
	
	
	
}


