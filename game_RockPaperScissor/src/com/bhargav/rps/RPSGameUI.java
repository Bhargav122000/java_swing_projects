package com.bhargav.rps;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RPSGameUI implements ActionListener {

	JFrame frame;
	JPanel gamePanel, otherPanel;
	JPanel choicePanel, resultPanel, summaryPanel, controlPanel;
	JPanel choicePanel1, choicePanel2;
	JLabel choiceLabel, resultLabel, userChoiceLabel, computerChoiceLabel;
	JLabel totalLabel, winLabel, drawLabel, lostLabel;
	JButton rockButton, paperButton, scissorButton;
	JButton continueButton, stopButton, closeButton, resetButton;
	JTextField userChoiceField, computerChoiceField, resultField;
	JTextField totalField, winField, drawField, lostField;
	
	RPSGame rpsGame = null;
	int totalMatches = 0, winMatches = 0, drawMatches = 0, lostMatches = 0;
	
	public void startGame() {
		this.initializeComponents();
		this.addComponentsToFrame();
		this.addListenersToComponents();
		
		this.rpsGame = new RPSGame();
		this.frame.setVisible(true);
	}
	
	public void initializeFrame() {
		this.frame = new JFrame("rOCK - pAPEr - scISSOr");
		this.frame.setSize(700, 300);
	}
	
	public void initializePanels() {
		this.gamePanel = new JPanel();
		this.choicePanel = new JPanel();
		this.resultPanel = new JPanel();
		this.choicePanel1 = new JPanel();
		this.choicePanel2 = new JPanel();
		this.otherPanel = new JPanel();
		this.summaryPanel = new JPanel();
		this.controlPanel = new JPanel();
	}
	
	public void initializeLabels() {
		this.choiceLabel = new JLabel("Click on buttons to choose");
		this.resultLabel = new JLabel("Result of current match");
		this.userChoiceLabel = new JLabel("User selected");
		this.computerChoiceLabel = new JLabel("Computer selected");
		this.totalLabel = new JLabel("#Total Matches");
		this.winLabel = new JLabel("#Matches Won");
		this.drawLabel = new JLabel("#Matches Drawn");
		this.lostLabel = new JLabel("#Matches Lost");
	}
	
	public void initializeButtons() {
		this.rockButton = new JButton("ROCK");
		this.paperButton = new JButton("PAPER");
		this.scissorButton = new JButton("SCISSOR");
		this.continueButton = new JButton("continue play");
		if (this.totalMatches == 0) {
			this.continueButton.setEnabled(false);
		}
		this.stopButton = new JButton("stop play");
		this.resetButton = new JButton("reset play");
		this.closeButton = new JButton("close");
	}
	
	public void initializeTextFields() {
		this.userChoiceField = new JTextField(10);
		this.userChoiceField.setEditable(false);
		this.computerChoiceField = new JTextField(10);
		this.computerChoiceField.setEditable(false);
		this.resultField = new JTextField(15);
		this.resultField.setEditable(false);
		this.totalField = new JTextField(10);
		this.totalField.setEditable(false);
		this.winField = new JTextField(10);
		this.winField.setEditable(false);
		this.drawField = new JTextField(10);
		this.drawField.setEditable(false);
		this.lostField = new JTextField(10);
		this.lostField.setEditable(false);
	}
	
	public void initializeComponents() {
		this.initializeFrame();
		this.initializePanels();
		this.initializeLabels();
		this.initializeButtons();
		this.initializeTextFields();
	}
	
	public void addComponentsToGamePanel() {
		this.choicePanel1.add(this.choiceLabel);
		this.choicePanel1.setLayout(new FlowLayout());
		this.choicePanel2.add(this.rockButton);
		this.choicePanel2.add(this.paperButton);
		this.choicePanel2.add(this.scissorButton);
		this.choicePanel2.setLayout(new GridLayout(1, 3, 1, 1));
		this.choicePanel.add(this.choicePanel1);
		this.choicePanel.add(this.choicePanel2);
		this.choicePanel.setLayout(new GridLayout(2, 1, 2, 2));
		
		this.resultPanel.add(this.userChoiceLabel);
		this.resultPanel.add(this.userChoiceField);
		this.resultPanel.add(this.computerChoiceLabel);
		this.resultPanel.add(this.computerChoiceField);
		this.resultPanel.add(this.resultLabel);
		this.resultPanel.add(this.resultField);
		this.resultPanel.setLayout(new GridLayout(3, 2, 2, 2));
		
		this.gamePanel.add(this.choicePanel);
		this.gamePanel.add(this.resultPanel);
		this.gamePanel.setLayout(new GridLayout(2, 1, 5, 5));
	}
	
	public void addComponentsToOtherPanel() {
		this.summaryPanel.add(this.totalLabel);
		this.summaryPanel.add(this.totalField);
		this.summaryPanel.add(this.winLabel);
		this.summaryPanel.add(this.winField);
		this.summaryPanel.add(this.drawLabel);
		this.summaryPanel.add(this.drawField);
		this.summaryPanel.add(this.lostLabel);
		this.summaryPanel.add(this.lostField);
		this.summaryPanel.setLayout(new GridLayout(4, 2, 2, 2));
		
		this.controlPanel.add(this.continueButton);
		this.controlPanel.add(this.stopButton);
		this.controlPanel.add(this.resetButton);
		this.controlPanel.add(this.closeButton);
		this.controlPanel.setLayout(new GridLayout(2, 2, 2, 2));
		
		this.otherPanel.add(this.summaryPanel);
		this.otherPanel.add(this.controlPanel);
		this.otherPanel.setLayout(new GridLayout(2, 1, 5, 5));
	}
	
	public void addComponentsToFrame() {
		this.addComponentsToGamePanel();
		this.addComponentsToOtherPanel();
		this.frame.add(this.gamePanel);
		this.frame.add(this.otherPanel);
		this.frame.setLayout(new GridLayout(1, 2, 10, 10));
	}
	
	public void addListenersToComponents() {
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.rockButton.addActionListener(this);
		this.paperButton.addActionListener(this);
		this.scissorButton.addActionListener(this);
		
		this.continueButton.addActionListener(this);
		this.stopButton.addActionListener(this);
		this.resetButton.addActionListener(this);
		this.closeButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == this.rockButton || obj == this.paperButton || obj == this.scissorButton) {
			this.rockButton.setEnabled(false);
			this.paperButton.setEnabled(false);
			this.scissorButton.setEnabled(false);
			
			if (obj == this.rockButton) {
				this.rpsGame.setUserChoice("rock");
			} else if (obj == this.paperButton) {
				this.rpsGame.setUserChoice("paper");
			} else if (obj == this.scissorButton) {
				this.rpsGame.setUserChoice("scissor");
			}
			this.rpsGame.generateComputerChoice();
			this.rpsGame.playGame();
			
			this.userChoiceField.setText(this.rpsGame.getUserChoice());
			this.computerChoiceField.setText(this.rpsGame.getComputerChoice());
			
			String result = this.rpsGame.getResult();
			this.resultField.setText(result);
			this.totalMatches += 1;
			if (result.equalsIgnoreCase("won")) {
				this.winMatches += 1;
			} else if (result.equalsIgnoreCase("draw")) {
				this.drawMatches += 1;
			} else if (result.equalsIgnoreCase("lost")) {
				this.lostMatches += 1;
			}
			this.totalField.setText(String.valueOf(this.totalMatches));
			this.winField.setText(String.valueOf(this.winMatches));
			this.drawField.setText(String.valueOf(this.drawMatches));
			this.lostField.setText(String.valueOf(this.lostMatches));
			
			this.continueButton.setEnabled(true);
		} else if (obj == this.continueButton) {
			this.userChoiceField.setText("");
			this.computerChoiceField.setText("");
			this.resultField.setText("");
			
			this.rockButton.setEnabled(true);
			this.paperButton.setEnabled(true);
			this.scissorButton.setEnabled(true);
		} else if (obj == this.stopButton) {
			this.rpsGame = null;
			this.totalMatches = 0;
			this.winMatches = 0;
			this.drawMatches = 0;
			this.lostMatches = 0;
			
			this.rockButton.setEnabled(false);
			this.paperButton.setEnabled(false);
			this.scissorButton.setEnabled(false);
			
			this.continueButton.setEnabled(false);
			this.stopButton.setEnabled(false);
		} else if (obj == this.resetButton) {
			this.rpsGame = null;
			this.totalMatches = 0;
			this.winMatches = 0;
			this.drawMatches = 0;
			this.lostMatches = 0;
			
			this.frame.dispose();
			this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			this.startGame();
		} else if (obj == this.closeButton) {
			this.frame.dispose();
			this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
	public static void main(String[] args) {
		RPSGameUI rpsGameUI = new RPSGameUI();
		rpsGameUI.startGame();
	}
}
