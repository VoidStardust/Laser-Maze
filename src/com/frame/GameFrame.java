package com.frame;

import com.panel.GamePanel;
import com.panel.LevelPanel;
import com.panel.MainPanel;
import com.panel.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
	public int round;
	public int grade;
	private Container c;
	private Toolkit tool;
	private Dimension dim;
	public CardLayout card;
	public JPanel gamepanel;
	public MenuPanel menupanel;
	public LevelPanel levelpanel;
	public MainPanel mainpanel;

	public GameFrame() {
		setTitle("Laser Maze");
		setSize(800, 582);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		tool = Toolkit.getDefaultToolkit();
		dim = tool.getScreenSize();
		setLocation((dim.width - getWidth()) / 2, (dim.height - getHeight()) / 2);
		c = getContentPane();

		GamePanel gPanel = new GamePanel();
		gPanel.setRound(1);

		card = new CardLayout();
		gamepanel = new JPanel();
		gamepanel.setLayout(card);
		menupanel = new MenuPanel(new ImageIcon("./img/back1.jpg").getImage(), this);
		levelpanel = new LevelPanel(new ImageIcon("./img/level.jpg").getImage(), this);
		mainpanel = new MainPanel(new ImageIcon("./img/back2.jpg").getImage(), this);

		gamepanel.add(menupanel);
		gamepanel.add(levelpanel);
		gamepanel.add(gPanel);
		gamepanel.add(mainpanel);
		c.add(gamepanel);
	}

	public static void main(String[] args) {
		GameFrame gameframe = new GameFrame();
		gameframe.setVisible(true);
	}
}

