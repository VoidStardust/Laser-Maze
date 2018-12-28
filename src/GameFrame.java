

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.panel.GamePanel;

public class GameFrame extends JFrame {
	int round;
	int grade;
	private Container c;
	private Toolkit tool;
	private Dimension dim;
	CardLayout card;
	JPanel gamepanel;
	MenuPanel menupanel;
	LevelPanel levelpanel;
	MainPanel mainpanel;
	
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
		menupanel = new MenuPanel((new ImageIcon("./img/back1.jpg")).getImage());
		levelpanel = new LevelPanel((new ImageIcon("./img/level.jpg")).getImage());
		mainpanel = new MainPanel((new ImageIcon("./img/back2.jpg")).getImage());

		gamepanel.add(menupanel);
		gamepanel.add(levelpanel);
		gamepanel.add(gPanel);
		gamepanel.add(mainpanel);
		c.add(gamepanel);
		
	}
	
	class MenuPanel extends JPanel implements MouseListener, MouseMotionListener {
		Image im;
		ImageIcon mode, help, start, developer, exit;
		JLabel label1, label2, label3, label4, label5;
		
		public MenuPanel(Image im) {
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
				int n = JOptionPane.showConfirmDialog(null, "Are you sure to quit?", "Exit",JOptionPane.YES_NO_OPTION);
				if(n == 0) {
					System.exit(0);
				} 
			}
			if(x > 75 && x < (75 + start.getIconWidth()) && y > 217 && y < (217 + start.getIconHeight())) {
				card.next(gamepanel);
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
			g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
		}
		
	}
	
	class LevelPanel extends JPanel implements MouseMotionListener, MouseListener {
		Image im;
		JLabel label1[], label2[], label3[], label4[], label;
		ImageIcon i1, i2, i3, i4, ret;
		
		public LevelPanel(Image im) {
			setLayout(null);
			this.im=im;
			this.setOpaque(true);
			
			label1 = new JLabel[5];
			i1 = new ImageIcon("./img/1.jpg");
			for(int i = 0; i < 5; i++) {
				label1[i] = new JLabel();
				label1[i].setIcon(i1);
				label1[i].setVisible(false);
				add(label1[i]);
			}
			label1[0].setBounds(30, 55, i1.getIconWidth(), i1.getIconHeight());
			label1[1].setBounds(180, 55, i1.getIconWidth(), i1.getIconHeight());
			label1[2].setBounds(327, 55, i1.getIconWidth(), i1.getIconHeight());
			label1[3].setBounds(477, 55, i1.getIconWidth(), i1.getIconHeight());
			label1[4].setBounds(625, 55, i1.getIconWidth(), i1.getIconHeight());
			
			label2 = new JLabel[5];
			i2 = new ImageIcon("./img/2.jpg");
			for(int i = 0; i < 5; i++) {
				label2[i] = new JLabel();
				label2[i].setIcon(i2);
				label2[i].setVisible(false);
				add(label2[i]);
			}
			label2[0].setBounds(30, 176, i2.getIconWidth(), i2.getIconHeight());
			label2[1].setBounds(180, 176, i2.getIconWidth(), i2.getIconHeight());
			label2[2].setBounds(327, 176, i2.getIconWidth(), i2.getIconHeight());
			label2[3].setBounds(477, 176, i2.getIconWidth(), i2.getIconHeight());
			label2[4].setBounds(625, 176, i2.getIconWidth(), i2.getIconHeight());
			
			label3 = new JLabel[5];
			i3 = new ImageIcon("./img/3.jpg");
			for(int i = 0; i < 5; i++) {
				label3[i] = new JLabel();
				label3[i].setIcon(i3);
				label3[i].setVisible(false);
				add(label3[i]);
			}
			label3[0].setBounds(28, 310, i3.getIconWidth(), i3.getIconHeight());
			label3[1].setBounds(175, 310, i3.getIconWidth(), i3.getIconHeight());
			label3[2].setBounds(325, 310, i3.getIconWidth(), i3.getIconHeight());
			label3[3].setBounds(473, 310, i3.getIconWidth(), i3.getIconHeight());
			label3[4].setBounds(621, 310, i3.getIconWidth(), i3.getIconHeight());
			
			label4 = new JLabel[5];
			i4 = new ImageIcon("./img/4.jpg");
			for(int i = 0; i < 5; i++) {
				label4[i] = new JLabel();
				label4[i].setIcon(i4);
				label4[i].setVisible(false);
				add(label4[i]);
			}
			label4[0].setBounds(28, 435, i4.getIconWidth(), i4.getIconHeight());
			label4[1].setBounds(175, 435, i4.getIconWidth(), i4.getIconHeight());
			label4[2].setBounds(325, 435, i4.getIconWidth(), i4.getIconHeight());
			label4[3].setBounds(473, 435, i4.getIconWidth(), i4.getIconHeight());
			label4[4].setBounds(621, 435, i4.getIconWidth(), i4.getIconHeight());
			
			label = new JLabel();
			ret = new ImageIcon("./img/return.jpg");
			label.setIcon(ret);
			label.setBounds(710, 0, ret.getIconWidth(), ret.getIconHeight());
			label.setVisible(false);
			add(label);
			
			addMouseMotionListener(this);
			addMouseListener(this);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
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
			
			if(x > 718 && x < 800 && y > 0 && y < 50) {
				label.setVisible(true);
			} else {
				label.setVisible(false);
			}
			
			for(int i = 0; i < 5; i++) {
				if(x > 30 + i * 150 && x < 30 + i1.getIconWidth() + i * 150 && y > 55 && y < 55 + i1.getIconHeight()) {
					label1[i].setVisible(true);
				} else {
					label1[i].setVisible(false);
				}
			}
			for(int i = 0; i < 5; i++) {
				if(x > 30 + i * 150 && x < 30 + i2.getIconWidth() + i * 150 && y > 217 && y < 217 + i2.getIconHeight()) {
					label2[i].setVisible(true);
				} else {
					label2[i].setVisible(false);
				}
			}
			for(int i = 0; i < 5; i++) {
				if(x > 30 + i * 150 && x < 30 + i3.getIconWidth() + i * 150 && y > 310 && y < 310 + i3.getIconHeight()) {
					label3[i].setVisible(true);
				} else {
					label3[i].setVisible(false);
				}
			}
			for(int i = 0; i < 5; i++) {
				if(x > 30 + i * 150 && x < 30 + i4.getIconWidth() + i * 150 && y > 435 && y < 435 + i4.getIconHeight()) {
					label4[i].setVisible(true);
				} else {
					label4[i].setVisible(false);
				}
			}
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int x = arg0.getX();
			int y = arg0.getY();
			if(x > 718 && x < 800 && y > 0 && y < 50) {
				card.previous(gamepanel);
			}
			for(int i = 0; i < 5; i++) {
				if(x > 30 + i * 150 && x < 30 + i1.getIconWidth() + i * 150 && y > 55 && y < 55 + i1.getIconHeight()) {
					round = i + 1;
					mainpanel.setscore();
					card.next(gamepanel);
					//System.out.println(round);
				}
			}
			for(int i = 0; i < 5; i++) {
				if(x > 30 + i * 150 && x < 30 + i2.getIconWidth() + i * 150 && y > 217 && y < 217 + i2.getIconHeight()) {
					round = i + 6;
					mainpanel.setscore();
					card.next(gamepanel);
				}
			}
			for(int i = 0; i < 5; i++) {
				if(x > 30 + i * 150 && x < 30 + i3.getIconWidth() + i * 150 && y > 310 && y < 310 + i3.getIconHeight()) {
					round = i + 11;
					mainpanel.setscore();
					card.next(gamepanel);
				}
			}
			for(int i = 0; i < 5; i++) {
				if(x > 30 + i * 150 && x < 30 + i4.getIconWidth() + i * 150 && y > 435 && y < 435 + i4.getIconHeight()) {
					round = i + 16;
					mainpanel.setscore();
					card.next(gamepanel);
				}
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
	
	class MainPanel extends JPanel implements MouseListener, MouseMotionListener {
		Image im;
		ImageIcon backward, hint, restart, giveup, option, quit;
		JLabel label1, label2, label3, label4, label5, label6, score;
		public MainPanel(Image im) {
			this.im = im;
			this.setOpaque(true);
			setLayout(new BorderLayout());
			
			
			
			
			
			
			score = new JLabel();
			score.setBounds(300, 50, 200, 20);
			score.setBackground(Color.white);
			score.setForeground(Color.BLUE);
			score.setOpaque(true);
			add(score);
			setscore();
			
			label1 = new JLabel();
			backward = new ImageIcon("./img/backward.jpg");
			label1.setIcon(backward);
			label1.setBounds(0, 85, backward.getIconWidth(), backward.getIconHeight());
			label1.setVisible(false);
			add(label1);
			
			label2 = new JLabel();
			hint = new ImageIcon("./img/hint.jpg");
			label2.setIcon(hint);
			label2.setBounds(0, 145, backward.getIconWidth(), backward.getIconHeight());
			label2.setVisible(false);
			add(label2);
			
			label3 = new JLabel();
			restart = new ImageIcon("./img/restart.jpg");
			label3.setIcon(restart);
			label3.setBounds(0, 205, backward.getIconWidth(), backward.getIconHeight());
			label3.setVisible(false);
			add(label3);
			
			label4 = new JLabel();
			giveup = new ImageIcon("./img/give up.jpg");
			label4.setIcon(giveup);
			label4.setBounds(0, 265, backward.getIconWidth(), backward.getIconHeight());
			label4.setVisible(false);
			add(label4);
			
			label5 = new JLabel();
			option = new ImageIcon("./img/option.jpg");
			label5.setIcon(option);
			label5.setBounds(0, 325, backward.getIconWidth(), backward.getIconHeight());
			label5.setVisible(false);
			add(label5);
			
			label6 = new JLabel();
			quit = new ImageIcon("./img/quit.jpg");
			label6.setIcon(quit);
			label6.setBounds(0, 385, backward.getIconWidth(), backward.getIconHeight());
			label6.setVisible(false);
			add(label6);
			
			addMouseListener(this);
			addMouseMotionListener(this);
		}
		
		private void setscore() {
			score.setText("Round " + round + "  " + "Score: "+ grade);
			score.setFont(new Font("Times New Roman", Font.BOLD, 20));
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
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
			if(x < backward.getIconWidth() && y > 85 && y < 85 + backward.getIconHeight()) {
				label1.setVisible(true);
			} else {
				label1.setVisible(false);
			}
			if(x < backward.getIconWidth() && y > 145 && y < 145 + backward.getIconHeight()) {
				label2.setVisible(true);
			} else {
				label2.setVisible(false);
			}
			if(x < backward.getIconWidth() && y > 205 && y < 205 + backward.getIconHeight()) {
				label3.setVisible(true);
			} else {
				label3.setVisible(false);
			}
			if(x < backward.getIconWidth() && y > 265 && y < 265 + backward.getIconHeight()) {
				label4.setVisible(true);
			} else {
				label4.setVisible(false);
			}
			if(x < backward.getIconWidth() && y > 325 && y < 325 + backward.getIconHeight()) {
				label5.setVisible(true);
			} else {
				label5.setVisible(false);
			}
			if(x < backward.getIconWidth() && y > 385 && y < 385 + backward.getIconHeight()) {
				label6.setVisible(true);
			} else {
				label6.setVisible(false);
			}
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int x = arg0.getX();
			int y = arg0.getY();
			if(x < backward.getIconWidth() && y > 385 && y < 385 + backward.getIconHeight()) {
				card.first(gamepanel);
			}
			if(x < backward.getIconWidth() && y > 325 && y < 325 + backward.getIconHeight()) {
				card.previous(gamepanel);
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
	
	public static void main(String[] args) {
		GameFrame gameframe = new GameFrame();
		gameframe.setVisible(true);
	}

}
