package com.bhargav.immediatememory;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ProgressBarExample extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JProgressBar jb;
	JButton[] digitButtons;
	JPanel panelOne, panelTwo;
	int i = 0, num = 0;

	ProgressBarExample() {
		panelOne = new JPanel();
		jb = new JProgressBar(0, 2000);
		jb.setValue(0);
		//jb.setStringPainted(true);
		panelOne.add(jb);
		
		panelTwo = new JPanel();
		digitButtons = new JButton[10];
		for (int i = 0; i < 10; i++) {
			digitButtons[i] = new JButton(String.valueOf(i));
			digitButtons[i].addActionListener(this);
			panelTwo.add(digitButtons[i]);
		}
		panelTwo.setLayout(new GridLayout(2, 5, 2, 2));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.gridheight = 2;
		add(panelOne, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		gbc.gridheight = 4;
		add(panelTwo, gbc);
		pack();
	}

	public void iterate() {
		while (i <= 2000) {
			jb.setValue(i);
			i = i + 100;
			try {
				Thread.sleep(150);
			} catch (Exception e) {
			}
		}
		for (int i = 0; i < 10; i++) {
			digitButtons[i].setEnabled(false);
		}
	}

	public static void main(String[] args) {
		ProgressBarExample m = new ProgressBarExample();
		m.setVisible(true);
		m.iterate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == digitButtons[i]) {
				JOptionPane.showMessageDialog(jb, "selected: " + i);
			}
		}
	}
}
