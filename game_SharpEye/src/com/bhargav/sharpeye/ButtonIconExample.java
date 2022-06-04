package com.bhargav.sharpeye;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class ButtonIconExample {
	JFrame frame;
	JPanel panelOne, panelTwo, panelThree;
	JButton triangleButtonOne, squareButtonOne, pentagonButtonOne, starButtonOne;
	JButton circleButtonOne;
	JButton triangleButtonTwo, squareButtonTwo, pentagonButtonTwo, starButtonTwo;
	JButton circleButtonTwo;
	JButton triangleButtonThree, squareButtonThree, pentagonButtonThree, starButtonThree;
	JButton circleButtonThree;
	JButton shapeButtons[];
	
	ImageIcon shapeIcons[];
	ImageIcon adjustedShapeIcons[];
	
	public void createIcons() {
		shapeIcons = new ImageIcon[5];
		adjustedShapeIcons = new ImageIcon[5];
		Image tempImage, tempNewImage;
		
		shapeIcons[0] = new ImageIcon("D:\\myFiles\\filesForJavaProjects\\triangle.png");
		shapeIcons[1] = new ImageIcon("D:\\myFiles\\filesForJavaProjects\\square.png");
		shapeIcons[2] = new ImageIcon("D:\\myFiles\\filesForJavaProjects\\pentagon.png");
		shapeIcons[3] = new ImageIcon("D:\\myFiles\\filesForJavaProjects\\star.png");
		shapeIcons[4] = new ImageIcon("D:\\myFiles\\filesForJavaProjects\\circle.png");
		
		for (int i = 0; i < adjustedShapeIcons.length; i++) {
			tempImage = shapeIcons[i].getImage();
			tempNewImage = tempImage.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			adjustedShapeIcons[i] = new ImageIcon(tempNewImage);
		}
	}
	
	public void createFrame() {
		frame = new JFrame("Buttons with Icons");
		
		createIcons();
		
		Random random = new Random();
		
		shapeButtons = new JButton[56];
		for (int i = 0; i < shapeButtons.length; i++) {
			shapeButtons[i] = new JButton();
			shapeButtons[i].setBackground(Color.white);
			int num = random.nextInt(5);
			shapeButtons[i].setIcon(adjustedShapeIcons[num]);
			frame.add(shapeButtons[i]);
		}
		frame.setLayout(new GridLayout(8, 7, 2, 2));
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
		ButtonIconExample buttonIconExample = new ButtonIconExample();
		buttonIconExample.createIcons();
		buttonIconExample.createFrame();
		buttonIconExample.addListeners();
		buttonIconExample.displayFrame();
	}
}
