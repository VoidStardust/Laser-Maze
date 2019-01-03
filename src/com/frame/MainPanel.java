package com.frame;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class MainPanel extends JPanel {
	CardLayout card;
	MenuPanel menupanel;
	LevelPanel levelpanel;
	BasePanel basepanel;
	HelpPanel helppanel;
	AboutPanel aboutpanel;
	
	public MainPanel() {
		card = new CardLayout();
		setLayout(card);
		
		initMain();
	}
	
	private void initMain() {
		menupanel = new MenuPanel((new ImageIcon("./img/background.jpg")).getImage(), MainPanel.this);
		basepanel = new BasePanel(MainPanel.this);
		levelpanel = new LevelPanel((new ImageIcon("./img/level.jpg")).getImage(), MainPanel.this, basepanel);
		helppanel = new HelpPanel(MainPanel.this);
		aboutpanel = new AboutPanel((new ImageIcon("./img/about.jpg")).getImage(), MainPanel.this);
		
		add(menupanel);
		add(levelpanel);
		add(basepanel);
		add(helppanel);
		add(aboutpanel);
	}
}
