package gameframe3;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;



class GameFrame extends JFrame {
	MainPanel mainpanel;
	
	private Container c;
	private Toolkit tool;
	private Dimension dim;
	
	public GameFrame() {
		setTitle("Laser Maze");
		setSize(900, 582);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		tool = Toolkit.getDefaultToolkit(); 
		dim = tool.getScreenSize();
		setLocation((dim.width - getWidth()) / 2, (dim.height - getHeight()) / 2);
		c = getContentPane();
		
		mainpanel = new MainPanel();
		c.add(mainpanel);
	}
}