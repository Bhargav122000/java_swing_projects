package com.bhargav.findnumber;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class NumberSample {
	JFrame frame;
	JPanel panelOne, panelTwo;
	JButton[] buttonsOne;
	JButton[] buttonsTwo;

	static Random random = new Random();
	static Color[] lightColors = { new Color(51, 102, 204), new Color(0, 153, 204), new Color(179, 102, 255),
			new Color(255, 102, 255), new Color(51, 255, 51), new Color(255, 102, 179), new Color(255, 133, 51),
			new Color(255, 77, 77), new Color(255, 153, 51), new Color(255, 184, 77), new Color(210, 121, 121),
			new Color(255, 255, 77) };
	static Color[] darkColors = { new Color(0, 0, 102), new Color(0, 51, 102), new Color(51, 0, 102),
			new Color(128, 0, 128), new Color(0, 102, 0), new Color(153, 0, 77), new Color(204, 82, 0),
			new Color(255, 0, 0), new Color(153, 77, 0), new Color(255, 153, 0), new Color(153, 51, 51),
			new Color(102, 102, 0) };

	public void createPanelOne() {
		panelOne = new JPanel();
		buttonsOne = new JButton[30];
		for (int i = 0; i < buttonsOne.length; i++) {
			buttonsOne[i] = new JButton("	");
			buttonsOne[i].setText(String.valueOf(NumberSample.random.nextInt(10)));
			buttonsOne[i].setBackground(NumberSample.lightColors[NumberSample.random.nextInt(NumberSample.lightColors.length)]);
			buttonsOne[i].setForeground(NumberSample.darkColors[NumberSample.random.nextInt(NumberSample.darkColors.length)]);
			panelOne.add(buttonsOne[i]);
		}
		panelOne.setLayout(new GridLayout(6, 5, 2, 2));
	}

	public void createPanelTwo() {
		panelTwo = new JPanel();
		buttonsTwo = new JButton[30];
		for (int i = 0; i < buttonsTwo.length; i++) {
			buttonsTwo[i] = new JButton("	");
			buttonsTwo[i].setText(String.valueOf(NumberSample.random.nextInt(10)));
			buttonsTwo[i].setBackground(NumberSample.darkColors[NumberSample.random.nextInt(NumberSample.darkColors.length)]);
			buttonsTwo[i].setForeground(NumberSample.lightColors[NumberSample.random.nextInt(NumberSample.lightColors.length)]);
			panelTwo.add(buttonsTwo[i]);
		}
		panelTwo.setLayout(new GridLayout(6, 5, 2, 2));
	}

	public void createFrame() {
		frame = new JFrame("sample..");
		createPanelOne();
		createPanelTwo();

		frame.add(panelOne);
		frame.add(panelTwo);
		frame.setLayout(new FlowLayout());
	}

	public void addListeners() {
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void displayFrame() {
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		NumberSample numberSample = new NumberSample();
		numberSample.createFrame();
		numberSample.addListeners();
		numberSample.displayFrame();
	}
}
