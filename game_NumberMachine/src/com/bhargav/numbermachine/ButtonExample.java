package com.bhargav.numbermachine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonExample {

	JFrame frame;
	JPanel panelOne, panelTwo;
	JLabel labelOne, labelTwo;
	JButton buttonOne, buttonTwo;
	
	public void displayFrame() {
		frame = new JFrame("JButton sample");
		
		panelOne = new JPanel();
		labelOne = new JLabel("click for yellow");
		buttonOne = new JButton("proceed");
		buttonOne.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panelOne.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		gbc1.gridheight = 1;
		gbc1.gridwidth = 1;
		panelOne.add(labelOne, gbc1);
		gbc1.gridx = 0;
		gbc1.gridy = 1;
		gbc1.gridheight = 3;
		gbc1.gridwidth = 2;
		panelOne.add(buttonOne, gbc1);
		//panelOne.setLayout(new GridLayout(2, 1));
		
		panelTwo = new JPanel();
		labelTwo = new JLabel("click for green");
		buttonTwo = new JButton("proceed");
		buttonTwo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panelTwo.setLayout(new GridBagLayout());
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		gbc2.gridheight = 1;
		gbc2.gridwidth = 1;
		panelTwo.add(labelTwo, gbc2);
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		gbc2.gridheight = 3;
		gbc2.gridwidth = 2;
		panelTwo.add(buttonTwo, gbc2);
		//panelTwo.setLayout(new GridLayout(2, 1));
		
		frame.add(panelOne);
		frame.add(panelTwo);
		frame.setLayout(new FlowLayout());
		frame.pack();
		frame.setVisible(true);
		
		buttonOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonOne.setBackground(Color.YELLOW);
			}
		});
		
		buttonTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonTwo.setBackground(Color.GREEN);
			}
		});
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new ButtonExample().displayFrame();
	}

}
