package com.frame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoadFrame extends JFrame {
	private Container c;
	private Toolkit tool;
	private Dimension dim;
	private JLabel label, headline;
	private JTextField textfield;
	private JButton button[];
	private JPanel panel1, panel2;
	private Box hbox;
	
	public LoadFrame() {
		c = getContentPane();
		tool = Toolkit.getDefaultToolkit();
		dim = tool.getScreenSize();
		c.setLayout(new GridLayout(3, 1, 10, 0));
		
		setTitle("Load in the game");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocation((dim.width - getWidth()) / 2, (dim.height - getHeight()) / 2);
		initLoad();
		setVisible(true);
	}
	
	private void initLoad() {
		panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		headline = new JLabel("Welcome to the game");
		headline.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel1.add(headline);
		c.add(panel1);
		
		label = new JLabel("Name:");
		textfield = new JTextField(20);
		panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel2.add(label);
		panel2.add(textfield);
		c.add(panel2);

		button = new JButton[3];
		button[0] = new JButton("Ok");
		button[1] = new JButton("Cancel");
		button[2] = new JButton("Exit");
		
		hbox = Box.createHorizontalBox();
		hbox.add(Box.createHorizontalStrut(20));
		hbox.add(button[0]);
		hbox.add(Box.createHorizontalGlue());
		hbox.add(button[1]);
		hbox.add(Box.createHorizontalGlue());
		hbox.add(button[2]);
		hbox.add(Box.createHorizontalStrut(20));
		c.add(hbox);
		
		button[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!textfield.getText().isEmpty()) {
					GameFrame gf = new GameFrame();
					gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					gf.setVisible(true);
					dispose();
				} else {
					textfield.setText("Username can not be empty.");
				}
			}
			
		});
		
		button[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textfield.setText(" ");
			}
			
		});
		
		button[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
	}
}

