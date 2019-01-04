package com.frame;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.panel.GamePanel;

class ModePanel extends JPanel {
	private MainPanel mainpanel;
	private GamePanel gamepanel;
	private ModeOption modeoption;
	
	public ModePanel(MainPanel mainpanel) {
		this.mainpanel = mainpanel;
		
		initMode();
		setLayout(null);
	}

	public void restart(){
		gamepanel.setDIYBoard();
	}

	public void withDraw(){
		gamepanel.withdraw();
	}
	
	private void initMode() {
		gamepanel = new GamePanel();
		modeoption = new ModeOption((new ImageIcon("./img/option2.jpg")).getImage(), mainpanel, ModePanel.this);
		
		modeoption.setBounds(0, 0, 170, 570);
		gamepanel.setBounds(180, 0, 720, 582);
		gamepanel.setMode(true);
		gamepanel.setDIYBoard();
		
		add(modeoption);
		add(gamepanel);
	}
}
