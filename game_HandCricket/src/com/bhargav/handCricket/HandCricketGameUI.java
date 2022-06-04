package com.bhargav.handCricket;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HandCricketGameUI implements ActionListener {

	JFrame frame;
	JPanel otherPanel, gamePanel;
	JPanel tossPanel, tossPanel1, tossPanel2;
	JPanel resultPanel;
	JPanel controlPanel;
	JPanel batPanel, batPanel1, batPanel2, batPanel3;
	JPanel bowlPanel, bowlPanel1, bowlPanel2, bowlPanel3;
	JLabel tossSelectLabel, tossResultLabel, batBowlSelectLabel, batBowlResultLabel;
	JLabel matchResultLabel, matchesLabel, winsLabel, drawsLabel, lostsLabel;
	JLabel inningsBatLabel, targetBatLabel, runChoiceBatLabel, runSelectedBatLabel, runGeneratedBatLabel,
			totalRunsBatLabel;
	JLabel inningsBowlLabel, targetBowlLabel, runChoiceBowlLabel, runSelectedBowlLabel, runGeneratedBowlLabel,
			totalRunsBowlLabel;
	JTextField tossResultField, batBowlResultField;
	JTextField matchResultField, matchesField, winsField, drawsField, lostsField;
	JTextField inningsBatField, targetBatField, runSelectedBatField, runGeneratedBatField, totalRunsBatField;
	JTextField inningsBowlField, targetBowlField, runSelectedBowlField, runGeneratedBowlField, totalRunsBowlField;
	JRadioButton headsRadioButton, tailsRadioButton, batRadioButton, bowlRadioButton;
	ButtonGroup buttonGroup1, buttonGroup2;
	JButton tossButton, batBowlButton;
	JButton continueButton, resetButton, closeButton;
	JButton[] runsBatButton;
	JButton[] runsBowlButton;

	HandCricketGame handCricketGame = null;
	String matchResult = null;
	int totalMatches = 0, winMatches = 0, drawMatches = 0, lostMatches = 0;

	public void createTossPanel() {
		this.tossPanel = new JPanel();

		this.tossPanel1 = new JPanel();
		this.tossSelectLabel = new JLabel("Choose");
		this.headsRadioButton = new JRadioButton("Heads", false);
		this.tailsRadioButton = new JRadioButton("Tails", false);
		this.buttonGroup1 = new ButtonGroup();
		this.tossButton = new JButton("submit");
		this.tossResultLabel = new JLabel("Toss Result");
		this.tossResultField = new JTextField(15);
		this.tossResultField.setEditable(false);

		this.tossPanel2 = new JPanel();
		this.batBowlSelectLabel = new JLabel("Choose");
		this.batRadioButton = new JRadioButton("Bat", false);
		this.bowlRadioButton = new JRadioButton("Bowl", false);
		this.buttonGroup2 = new ButtonGroup();
		this.batBowlButton = new JButton("submit");
		this.batBowlResultLabel = new JLabel("Result");
		this.batBowlResultField = new JTextField(15);
		this.batBowlResultField.setEditable(false);

		this.buttonGroup1.add(this.headsRadioButton);
		this.buttonGroup1.add(this.tailsRadioButton);
		this.tossPanel1.add(this.tossSelectLabel);
		this.tossPanel1.add(this.headsRadioButton);
		this.tossPanel1.add(this.tailsRadioButton);
		this.tossPanel1.add(this.tossButton);
		this.tossPanel1.add(this.tossResultLabel);
		this.tossPanel1.add(this.tossResultField);
		this.tossPanel1.setLayout(new GridLayout(2, 4, 2, 2));

		this.buttonGroup2.add(this.batRadioButton);
		this.buttonGroup2.add(this.bowlRadioButton);
		this.tossPanel2.add(this.batBowlSelectLabel);
		this.tossPanel2.add(this.batRadioButton);
		this.tossPanel2.add(this.bowlRadioButton);
		this.tossPanel2.add(this.batBowlButton);
		this.tossPanel2.add(this.batBowlResultLabel);
		this.tossPanel2.add(this.batBowlResultField);
		this.tossPanel2.setLayout(new GridLayout(2, 4, 2, 2));

		this.tossPanel.add(this.tossPanel1);
		this.tossPanel.add(this.tossPanel2);
		this.tossPanel.setLayout(new GridLayout(2, 1, 5, 0));
	}

	public void createResultPanel() {
		this.resultPanel = new JPanel();
		this.matchResultLabel = new JLabel("Match result");
		this.matchResultField = new JTextField(15);
		this.matchResultField.setEditable(false);
		this.matchesLabel = new JLabel("#Matches");
		this.matchesField = new JTextField(5);
		this.matchesField.setEditable(false);
		this.winsLabel = new JLabel("#Wins");
		this.winsField = new JTextField(5);
		this.winsField.setEditable(false);
		this.drawsLabel = new JLabel("#Draws");
		this.drawsField = new JTextField(5);
		this.drawsField.setEditable(false);
		this.lostsLabel = new JLabel("#Losts");
		this.lostsField = new JTextField(5);
		this.lostsField.setEditable(false);

		this.resultPanel.add(this.matchResultLabel);
		this.resultPanel.add(this.matchResultField);
		this.resultPanel.add(this.matchesLabel);
		this.resultPanel.add(this.matchesField);
		this.resultPanel.add(this.winsLabel);
		this.resultPanel.add(this.winsField);
		this.resultPanel.add(this.drawsLabel);
		this.resultPanel.add(this.drawsField);
		this.resultPanel.add(this.lostsLabel);
		this.resultPanel.add(this.lostsField);
		this.resultPanel.setLayout(new GridLayout(5, 2, 5, 2));
	}

	public void createControlPanel() {
		this.controlPanel = new JPanel();
		this.continueButton = new JButton("continue play");
		this.resetButton = new JButton("reset play");
		this.closeButton = new JButton("close play");

		this.controlPanel.add(this.continueButton);
		this.controlPanel.add(this.resetButton);
		this.controlPanel.add(this.closeButton);
		this.controlPanel.setLayout(new GridLayout(3, 1, 5, 0));
	}

	public void createBatPanel() {
		this.batPanel = new JPanel();

		this.batPanel1 = new JPanel();
		this.inningsBatLabel = new JLabel("Bat Innings#");
		this.inningsBatField = new JTextField(5);
		this.inningsBatField.setEditable(false);
		this.targetBatLabel = new JLabel("Target");
		this.targetBatField = new JTextField(20);
		this.targetBatField.setEditable(false);

		this.batPanel2 = new JPanel();
		this.runChoiceBatLabel = new JLabel("Choose");
		this.runsBatButton = new JButton[7];
		for (int i = 0; i < 7; i++) {
			this.runsBatButton[i] = new JButton(String.valueOf(i));
		}

		this.batPanel3 = new JPanel();
		this.runSelectedBatLabel = new JLabel("selected");
		this.runSelectedBatField = new JTextField(5);
		this.runSelectedBatField.setEditable(false);
		this.runGeneratedBatLabel = new JLabel("generated");
		this.runGeneratedBatField = new JTextField(5);
		this.runGeneratedBatField.setEditable(false);
		this.totalRunsBatLabel = new JLabel("Total score");
		this.totalRunsBatField = new JTextField(5);
		this.totalRunsBatField.setEditable(false);

		this.batPanel1.add(this.inningsBatLabel);
		this.batPanel1.add(this.inningsBatField);
		this.batPanel1.add(this.targetBatLabel);
		this.batPanel1.add(this.targetBatField);
		this.batPanel1.setLayout(new GridLayout(2, 2, 2, 1));

		this.batPanel2.add(this.runChoiceBatLabel);
		for (int i = 0; i < 7; i++) {
			this.batPanel2.add(this.runsBatButton[i]);
		}
		this.batPanel2.setLayout(new GridLayout(2, 4, 1, 1));

		this.batPanel3.add(this.runSelectedBatLabel);
		this.batPanel3.add(this.runSelectedBatField);
		this.batPanel3.add(this.runGeneratedBatLabel);
		this.batPanel3.add(this.runGeneratedBatField);
		this.batPanel3.add(this.totalRunsBatLabel);
		this.batPanel3.add(this.totalRunsBatField);
		this.batPanel3.setLayout(new GridLayout(3, 2, 2, 1));

		this.batPanel.add(this.batPanel1);
		this.batPanel.add(this.batPanel2);
		this.batPanel.add(this.batPanel3);
		this.batPanel.setLayout(new GridLayout(3, 1, 4, 0));
	}

	public void createBowlPanel() {
		this.bowlPanel = new JPanel();

		this.bowlPanel1 = new JPanel();
		this.inningsBowlLabel = new JLabel("Bowl Innings#");
		this.inningsBowlField = new JTextField(5);
		this.inningsBowlField.setEditable(false);
		this.targetBowlLabel = new JLabel("Target");
		this.targetBowlField = new JTextField(20);
		this.targetBowlField.setEditable(false);

		this.bowlPanel2 = new JPanel();
		this.runChoiceBowlLabel = new JLabel("Choose");
		this.runsBowlButton = new JButton[7];
		for (int i = 0; i < 7; i++) {
			this.runsBowlButton[i] = new JButton(String.valueOf(i));
		}
		this.bowlPanel2.setLayout(new GridLayout(2, 4, 1, 1));

		this.bowlPanel3 = new JPanel();
		this.runSelectedBowlLabel = new JLabel("selected");
		this.runSelectedBowlField = new JTextField(5);
		this.runSelectedBowlField.setEditable(false);
		this.runGeneratedBowlLabel = new JLabel("generated");
		this.runGeneratedBowlField = new JTextField(5);
		this.runGeneratedBowlField.setEditable(false);
		this.totalRunsBowlLabel = new JLabel("Total score");
		this.totalRunsBowlField = new JTextField(5);
		this.totalRunsBowlField.setEditable(false);

		this.bowlPanel1.add(this.inningsBowlLabel);
		this.bowlPanel1.add(this.inningsBowlField);
		this.bowlPanel1.add(this.targetBowlLabel);
		this.bowlPanel1.add(this.targetBowlField);
		this.bowlPanel1.setLayout(new GridLayout(2, 2, 2, 1));

		this.bowlPanel2.add(this.runChoiceBowlLabel);
		for (int i = 0; i < 7; i++) {
			this.bowlPanel2.add(this.runsBowlButton[i]);
		}

		this.bowlPanel3.add(this.runSelectedBowlLabel);
		this.bowlPanel3.add(this.runSelectedBowlField);
		this.bowlPanel3.add(this.runGeneratedBowlLabel);
		this.bowlPanel3.add(this.runGeneratedBowlField);
		this.bowlPanel3.add(this.totalRunsBowlLabel);
		this.bowlPanel3.add(this.totalRunsBowlField);
		this.bowlPanel3.setLayout(new GridLayout(3, 2, 2, 1));

		this.bowlPanel.add(this.bowlPanel1);
		this.bowlPanel.add(this.bowlPanel2);
		this.bowlPanel.add(this.bowlPanel3);
		this.bowlPanel.setLayout(new GridLayout(3, 1, 4, 0));
	}

	public void createOtherPanel() {
		this.otherPanel = new JPanel();

		this.createTossPanel();
		this.createResultPanel();
		this.createControlPanel();

		this.otherPanel.add(this.tossPanel);
		this.otherPanel.add(this.resultPanel);
		this.otherPanel.add(this.controlPanel);
		this.otherPanel.setLayout(new GridLayout(3, 1, 10, 10));
	}

	public void createGamePanel() {
		this.gamePanel = new JPanel();

		this.createBatPanel();
		this.createBowlPanel();

		this.gamePanel.add(this.batPanel);
		this.gamePanel.add(this.bowlPanel);
		this.gamePanel.setLayout(new GridLayout(2, 1, 10, 10));
	}

	public void createFrame() {
		this.frame = new JFrame("Hand Cricket Game");

		this.createOtherPanel();
		this.createGamePanel();

		this.frame.add(this.otherPanel);
		this.frame.add(this.gamePanel);
		this.frame.setLayout(new GridLayout(1, 2, 10, 10));
	}

	public void addListenersToComponents() {
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.tossButton.addActionListener(this);
		this.batBowlButton.addActionListener(this);

		this.continueButton.addActionListener(this);
		this.resetButton.addActionListener(this);
		this.closeButton.addActionListener(this);

		for (int i = 0; i < 7; i++) {
			this.runsBatButton[i].addActionListener(this);
			this.runsBowlButton[i].addActionListener(this);
		}
	}

	public void displayFrame() {
		this.frame.pack();
		// this.frame.setSize(600, 600);
		this.frame.setVisible(true);
	}

	public void initiateModel() {
		this.handCricketGame = new HandCricketGame();
	}

	public void setInitialRestrictions() {
		this.batRadioButton.setEnabled(false);
		this.bowlRadioButton.setEnabled(false);
		this.batBowlButton.setEnabled(false);

		this.continueButton.setEnabled(false);
		this.resetButton.setEnabled(false);

		for (int i = 0; i < 7; i++) {
			this.runsBatButton[i].setEnabled(false);
			this.runsBowlButton[i].setEnabled(false);
		}
		
		this.matchesField.setText("0");
		this.winsField.setText("0");
		this.drawsField.setText("0");
		this.lostsField.setText("0");
	}

	public void start() {
		this.createFrame();
		this.addListenersToComponents();
		this.displayFrame();
		this.initiateModel();
		this.setInitialRestrictions();
	}

	public static void main(String[] args) {
		new HandCricketGameUI().start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		if (object == this.tossButton) {
			boolean result;
			if (this.headsRadioButton.isSelected() || this.tailsRadioButton.isSelected()) {
				if (this.headsRadioButton.isSelected()) {
					result = this.handCricketGame.isTossWon("heads");
				} else {
					result = this.handCricketGame.isTossWon("tails");
				}

				if (result) {
					this.tossResultField.setText("you won the toss");
					
					this.batRadioButton.setEnabled(true);
					this.bowlRadioButton.setEnabled(true);
					this.batBowlButton.setEnabled(true);
				} else {
					this.tossResultField.setText("you lost the toss");
					
					String choice = this.handCricketGame.getComputerChoiceForBatBowl();
					this.batBowlResultField.setText("you are to " + choice + " first");

					if (choice.equals("bat")) {
						this.inningsBatField.setText("First Innings");
						this.targetBatField.setText("not applicable");
						for (int i = 0; i < 7; i++) {
							this.runsBatButton[i].setEnabled(true);
						}
					} else {
						for (int i = 0; i < 7; i++) {
							this.inningsBowlField.setText("First Innings");
							this.targetBowlField.setText("not applicable");
							this.runsBowlButton[i].setEnabled(true);
						}
					}
					this.continueButton.setEnabled(true);
					this.resetButton.setEnabled(true);

					this.headsRadioButton.setEnabled(false);
					this.tailsRadioButton.setEnabled(false);
					this.tossButton.setEnabled(false);
					this.batRadioButton.setEnabled(false);
					this.bowlRadioButton.setEnabled(false);
					this.batBowlButton.setEnabled(false);
				}
			}
		} else if (object == this.batBowlButton) {
			if (this.batRadioButton.isSelected() || this.bowlRadioButton.isSelected()) {
				if (this.batRadioButton.isSelected()) {
					this.batBowlResultField.setText("you are to bat first");
					for (int i = 0; i < 7; i++) {
						this.runsBatButton[i].setEnabled(true);
					}
					this.inningsBatField.setText("First Innings");
					this.targetBatField.setText("not applicable");

					if (this.handCricketGame.isSecondInnings()) {
						this.inningsBatField.setText("Second Innings");
						int target = this.handCricketGame.getRunsConceded() + 1;
						this.targetBatField.setText("Score " + target + " runs to win");
					}
				} else {
					this.batBowlResultField.setText("you are to bowl first");
					for (int i = 0; i < 7; i++) {
						this.runsBowlButton[i].setEnabled(true);
					}
					this.inningsBowlField.setText("First Innings");
					this.targetBowlField.setText("not applicable");
					
					if (this.handCricketGame.isSecondInnings()) {
						this.inningsBowlField.setText("Second Innings");
						int target = this.handCricketGame.getRunsScored();
						this.targetBowlField.setText("Defend " + target + " runs to win");
					}
				}
				this.continueButton.setEnabled(true);
				this.resetButton.setEnabled(true);

				this.headsRadioButton.setEnabled(false);
				this.tailsRadioButton.setEnabled(false);
				this.tossButton.setEnabled(false);
				this.batRadioButton.setEnabled(false);
				this.bowlRadioButton.setEnabled(false);
				this.batBowlButton.setEnabled(false);
			}
		} else if (object == this.continueButton || object == this.resetButton) {
			this.buttonGroup1.clearSelection();
			this.tossResultField.setText("");
			this.buttonGroup2.clearSelection();
			this.batBowlResultField.setText("");
			
			this.matchResultField.setText("");
			
			this.inningsBatField.setText("");
			this.targetBatField.setText("");
			this.runSelectedBatField.setText("");
			this.runGeneratedBatField.setText("");
			this.totalRunsBatField.setText("");
			
			this.inningsBowlField.setText("");
			this.targetBowlField.setText("");
			this.runSelectedBowlField.setText("");
			this.runGeneratedBowlField.setText("");
			this.totalRunsBowlField.setText("");
			
			this.headsRadioButton.setEnabled(true);
			this.tailsRadioButton.setEnabled(true);
			this.tossButton.setEnabled(true);
			
			if (object == this.resetButton) {
				this.totalMatches = 0;
				this.winMatches = 0;
				this.drawMatches = 0;
				this.lostMatches = 0;
				
				this.matchesField.setText("0");
				this.winsField.setText("0");
				this.drawsField.setText("0");
				this.lostsField.setText("0");
			}
		} else if (object == this.closeButton) {
			this.frame.dispose();
			this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else {
			for (int i = 0; i < 7; i++) {
				if (this.runsBatButton[i] == object) {
					int runSelected = i;
					int runGenerated = this.handCricketGame.getComputerGeneratedRun();

					this.runSelectedBatField.setText(String.valueOf(runSelected));
					this.runGeneratedBatField.setText(String.valueOf(runGenerated));

					if (this.handCricketGame.isOut(runSelected, runGenerated)) {
						this.totalRunsBatField.setText(this.totalRunsBatField.getText() + " (you are out)");
						if (this.handCricketGame.isSecondInnings()) {
							if (this.handCricketGame.getRunsScored() == this.handCricketGame.getRunsConceded()) {
								this.matchResultField.setText("the match is drawn");
								this.totalMatches += 1;
								this.drawMatches += 1;
								this.matchesField.setText(String.valueOf(this.totalMatches));
								this.drawsField.setText(String.valueOf(this.drawMatches));
							} else {
								this.matchResultField.setText("you lost the match");
								this.totalMatches += 1;
								this.lostMatches += 1;
								this.matchesField.setText(String.valueOf(this.totalMatches));
								this.lostsField.setText(String.valueOf(this.lostMatches));
							}
							
							for (int j = 0; j < 7; j++) {
								this.runsBatButton[j].setEnabled(false);
							}
							
							this.handCricketGame.setIsSecondInnings(false);
							this.handCricketGame.setRunsConceded(0);
							this.handCricketGame.setRunsScored(0);
						} else {
							this.handCricketGame.setIsSecondInnings(true);
							this.inningsBowlField.setText("Second Innings");
							int target = this.handCricketGame.getRunsScored();
							this.targetBowlField.setText("Defend " + target + " runs to win");
							
							for (int j = 0; j < 7; j++) {
								this.runsBatButton[j].setEnabled(false);
								this.runsBowlButton[j].setEnabled(true);
							}
						}
					} else {
						this.handCricketGame.setRunsScored(this.handCricketGame.getRunsScored() + runSelected);
						this.totalRunsBatField.setText(String.valueOf(this.handCricketGame.getRunsScored()));
						if (this.handCricketGame.isSecondInnings()) {
							if (this.handCricketGame.isChasingDone()) {
								this.matchResultField.setText("you won the match");
								this.totalMatches += 1;
								this.winMatches += 1;
								this.matchesField.setText(String.valueOf(this.totalMatches));
								this.winsField.setText(String.valueOf(this.winMatches));
								
								for (int j = 0; j < 7; j++) {
									this.runsBatButton[j].setEnabled(false);
								}
								
								this.handCricketGame.setIsSecondInnings(false);
								this.handCricketGame.setRunsConceded(0);
								this.handCricketGame.setRunsScored(0);
							}
						}
					}
					break;
				}
			}
			for (int i = 0; i < 7; i++) {
				if (this.runsBowlButton[i] == object) {
					int runSelected = i;
					int runGenerated = this.handCricketGame.getComputerGeneratedRun();

					this.runSelectedBowlField.setText(String.valueOf(runSelected));
					this.runGeneratedBowlField.setText(String.valueOf(runGenerated));

					if (this.handCricketGame.isOut(runSelected, runGenerated)) {
						this.totalRunsBowlField.setText(this.totalRunsBowlField.getText() + " (you got a wicket)");
						if (this.handCricketGame.isSecondInnings()) {
							if (this.handCricketGame.getRunsConceded() == this.handCricketGame.getRunsScored()) {
								this.matchResultField.setText("the match is drawn");
								this.totalMatches += 1;
								this.drawMatches += 1;
								this.matchesField.setText(String.valueOf(this.totalMatches));
								this.drawsField.setText(String.valueOf(this.drawMatches));
							} else {
								this.matchResultField.setText("you won the match");
								this.totalMatches += 1;
								this.winMatches += 1;
								this.matchesField.setText(String.valueOf(this.totalMatches));
								this.winsField.setText(String.valueOf(this.winMatches));
							}
							
							for (int j = 0; j < 7; j++) {
								this.runsBowlButton[j].setEnabled(false);
							}
							
							this.handCricketGame.setIsSecondInnings(false);
							this.handCricketGame.setRunsConceded(0);
							this.handCricketGame.setRunsScored(0);
						} else {
							this.handCricketGame.setIsSecondInnings(true);
							this.inningsBatField.setText("Second Innings");
							int target = this.handCricketGame.getRunsConceded() + 1;
							this.targetBatField.setText("Score " + target + " runs to win");
							
							for (int j = 0; j < 7; j++) {
								this.runsBowlButton[j].setEnabled(false);
								this.runsBatButton[j].setEnabled(true);
							}
						}
					} else {
						this.handCricketGame.setRunsConceded(this.handCricketGame.getRunsConceded() + runGenerated);
						this.totalRunsBowlField.setText(String.valueOf(this.handCricketGame.getRunsConceded()));
						if (this.handCricketGame.isSecondInnings()) {
							if (this.handCricketGame.isDefendingDone()) {
								this.matchResultField.setText("you lost the match");
								this.totalMatches += 1;
								this.lostMatches += 1;
								this.matchesField.setText(String.valueOf(this.totalMatches));
								this.lostsField.setText(String.valueOf(this.lostMatches));
								
								for (int j = 0; j < 7; j++) {
									this.runsBowlButton[j].setEnabled(false);
								}
								
								this.handCricketGame.setIsSecondInnings(false);
								this.handCricketGame.setRunsConceded(0);
								this.handCricketGame.setRunsScored(0);
							}
						} 
					}
					break;
				}
			}
		}
	}

}
