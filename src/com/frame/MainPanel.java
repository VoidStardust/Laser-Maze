package gameframe3;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class MainPanel extends JPanel {
	CardLayout card;
	MenuPanel menupanel;
	LevelPanel levelpanel;
	BasePanel basepanel;
	
	public MainPanel() {
		card = new CardLayout();
		setLayout(card);
		
		initMain();
	}
	
	private void initMain() {
		menupanel = new MenuPanel((new ImageIcon("src/pic1/background.jpg")).getImage(), MainPanel.this);
		basepanel = new BasePanel(MainPanel.this);
		levelpanel = new LevelPanel((new ImageIcon("src/pic1/level.jpg")).getImage(), MainPanel.this, basepanel);

		add(menupanel);
		add(levelpanel);
		add(basepanel);
	}
}
