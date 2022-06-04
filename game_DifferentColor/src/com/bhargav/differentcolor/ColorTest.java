package com.bhargav.differentcolor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorTest {
	JFrame frame;
	JButton colorButtons[];
	JButton colorLightButtons[];
	JButton colorDarkButtons[];

	Color colorChoices[] = { new Color(255, 0, 0), new Color(255, 51, 0), new Color(204, 102, 0),
			new Color(255, 0, 102), new Color(0, 255, 0), new Color(255, 255, 0), new Color(0, 0, 255),
			new Color(0, 77, 153), new Color(153, 0, 204), new Color(255, 102, 0) };
	Color colorUniqueLight[] = { new Color(255, 51, 51), new Color(255, 92, 51), new Color(230, 115, 0),
			new Color(255, 51, 133), new Color(77, 255, 77), new Color(255, 255, 51), new Color(51, 51, 255),
			new Color(0, 102, 204), new Color(191, 0, 255), new Color(255, 133, 51) };
	Color colorUniqueDark[] = { new Color(204, 0, 0), new Color(230, 46, 0), new Color(179, 89, 0),
			new Color(204, 0, 82), new Color(0, 204, 0), new Color(230, 230, 0), new Color(0, 0, 204),
			new Color(0, 64, 128), new Color(115, 0, 153), new Color(204, 82, 0) };

	public void createFrame() {
		frame = new JFrame();
		colorButtons = new JButton[10];
		colorLightButtons = new JButton[10];
		colorDarkButtons = new JButton[10];
		for (int i = 0; i < 10; i++) {
			colorLightButtons[i] = new JButton("   ");
			colorButtons[i] = new JButton("   ");
			colorDarkButtons[i] = new JButton("   ");
			
			colorLightButtons[i].setBackground(colorUniqueLight[i]);
			colorButtons[i].setBackground(colorChoices[i]);
			colorDarkButtons[i].setBackground(colorUniqueDark[i]);
			
			frame.add(colorLightButtons[i]);
			frame.add(colorButtons[i]);
			frame.add(colorDarkButtons[i]);
		}
		frame.setLayout(new GridLayout(10, 3, 2, 2));
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
		ColorTest colorTest = new ColorTest();
		colorTest.createFrame();
		colorTest.addListeners();
		colorTest.displayFrame();
	}
}
