// View class
package com.bhargav.handCricket.ui;

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
		tossPanel = new JPanel();

		tossPanel1 = new JPanel();
		tossSelectLabel = new JLabel("Choose Heads/Tails");
		headsRadioButton = new JRadioButton("Heads", false);
		tailsRadioButton = new JRadioButton("Tails", false);
		buttonGroup1 = new ButtonGroup();
		tossButton = new JButton("submit");
		tossResultLabel = new JLabel("Toss Result");
		tossResultField = new JTextField(15);
		tossResultField.setEditable(false);

		tossPanel2 = new JPanel();
		batBowlSelectLabel = new JLabel("Choose Bat/Bowl");
		batRadioButton = new JRadioButton("Bat", false);
		bowlRadioButton = new JRadioButton("Bowl", false);
		buttonGroup2 = new ButtonGroup();
		batBowlButton = new JButton("submit");
		batBowlResultLabel = new JLabel("BatBowl status");
		batBowlResultField = new JTextField(15);
		batBowlResultField.setEditable(false);

		buttonGroup1.add(headsRadioButton);
		buttonGroup1.add(tailsRadioButton);
		tossPanel1.add(tossSelectLabel);
		tossPanel1.add(headsRadioButton);
		tossPanel1.add(tailsRadioButton);
		tossPanel1.add(tossButton);
		tossPanel1.add(tossResultLabel);
		tossPanel1.add(tossResultField);
		tossPanel1.setLayout(new GridLayout(2, 4, 2, 2));

		buttonGroup2.add(batRadioButton);
		buttonGroup2.add(bowlRadioButton);
		tossPanel2.add(batBowlSelectLabel);
		tossPanel2.add(batRadioButton);
		tossPanel2.add(bowlRadioButton);
		tossPanel2.add(batBowlButton);
		tossPanel2.add(batBowlResultLabel);
		tossPanel2.add(batBowlResultField);
		tossPanel2.setLayout(new GridLayout(2, 4, 2, 2));

		tossPanel.add(tossPanel1);
		tossPanel.add(tossPanel2);
		tossPanel.setLayout(new GridLayout(2, 1, 5, 0));
	}

	public void createResultPanel() {
		resultPanel = new JPanel();
		matchResultLabel = new JLabel("Match result");
		matchResultField = new JTextField(15);
		matchResultField.setEditable(false);
		matchesLabel = new JLabel("#Matches");
		matchesField = new JTextField(5);
		matchesField.setEditable(false);
		winsLabel = new JLabel("#Wins");
		winsField = new JTextField(5);
		winsField.setEditable(false);
		drawsLabel = new JLabel("#Draws");
		drawsField = new JTextField(5);
		drawsField.setEditable(false);
		lostsLabel = new JLabel("#Losts");
		lostsField = new JTextField(5);
		lostsField.setEditable(false);

		resultPanel.add(matchResultLabel);
		resultPanel.add(matchResultField);
		resultPanel.add(matchesLabel);
		resultPanel.add(matchesField);
		resultPanel.add(winsLabel);
		resultPanel.add(winsField);
		resultPanel.add(drawsLabel);
		resultPanel.add(drawsField);
		resultPanel.add(lostsLabel);
		resultPanel.add(lostsField);
		resultPanel.setLayout(new GridLayout(5, 2, 5, 2));
	}

	public void createControlPanel() {
		controlPanel = new JPanel();
		continueButton = new JButton("continue play");
		resetButton = new JButton("reset play");
		closeButton = new JButton("close play");

		controlPanel.add(continueButton);
		controlPanel.add(resetButton);
		controlPanel.add(closeButton);
		controlPanel.setLayout(new GridLayout(3, 1, 5, 0));
	}

	public void createBatPanel() {
		batPanel = new JPanel();

		batPanel1 = new JPanel();
		inningsBatLabel = new JLabel("Bat Innings#");
		inningsBatField = new JTextField(5);
		inningsBatField.setEditable(false);
		targetBatLabel = new JLabel("To WIN");
		targetBatField = new JTextField("---", 20);
		targetBatField.setEditable(false);

		batPanel2 = new JPanel();
		runChoiceBatLabel = new JLabel("Choose runs");
		runsBatButton = new JButton[7];
		for (int i = 0; i < 7; i++) {
			runsBatButton[i] = new JButton(String.valueOf(i));
		}

		batPanel3 = new JPanel();
		runSelectedBatLabel = new JLabel("chosen runs");
		runSelectedBatField = new JTextField(5);
		runSelectedBatField.setEditable(false);
		runGeneratedBatLabel = new JLabel("generated runs");
		runGeneratedBatField = new JTextField(5);
		runGeneratedBatField.setEditable(false);
		totalRunsBatLabel = new JLabel("Total runs scored");
		totalRunsBatField = new JTextField(5);
		totalRunsBatField.setEditable(false);

		batPanel1.add(inningsBatLabel);
		batPanel1.add(inningsBatField);
		batPanel1.add(targetBatLabel);
		batPanel1.add(targetBatField);
		batPanel1.setLayout(new GridLayout(2, 2, 2, 1));

		batPanel2.add(runChoiceBatLabel);
		for (int i = 0; i < 7; i++) {
			batPanel2.add(runsBatButton[i]);
		}
		batPanel2.setLayout(new GridLayout(2, 4, 1, 1));

		batPanel3.add(runSelectedBatLabel);
		batPanel3.add(runSelectedBatField);
		batPanel3.add(runGeneratedBatLabel);
		batPanel3.add(runGeneratedBatField);
		batPanel3.add(totalRunsBatLabel);
		batPanel3.add(totalRunsBatField);
		batPanel3.setLayout(new GridLayout(3, 2, 2, 1));

		batPanel.add(batPanel1);
		batPanel.add(batPanel2);
		batPanel.add(batPanel3);
		batPanel.setLayout(new GridLayout(3, 1, 4, 0));
	}

	public void createBowlPanel() {
		bowlPanel = new JPanel();

		bowlPanel1 = new JPanel();
		inningsBowlLabel = new JLabel("Bowl Innings#");
		inningsBowlField = new JTextField(5);
		inningsBowlField.setEditable(false);
		targetBowlLabel = new JLabel("To WIN");
		targetBowlField = new JTextField("---", 20);
		targetBowlField.setEditable(false);

		bowlPanel2 = new JPanel();
		runChoiceBowlLabel = new JLabel("Choose runs");
		runsBowlButton = new JButton[7];
		for (int i = 0; i < 7; i++) {
			runsBowlButton[i] = new JButton(String.valueOf(i));
		}
		bowlPanel2.setLayout(new GridLayout(2, 4, 1, 1));

		bowlPanel3 = new JPanel();
		runSelectedBowlLabel = new JLabel("chosen runs");
		runSelectedBowlField = new JTextField(5);
		runSelectedBowlField.setEditable(false);
		runGeneratedBowlLabel = new JLabel("generated runs");
		runGeneratedBowlField = new JTextField(5);
		runGeneratedBowlField.setEditable(false);
		totalRunsBowlLabel = new JLabel("Total runs conceded");
		totalRunsBowlField = new JTextField(5);
		totalRunsBowlField.setEditable(false);

		bowlPanel1.add(inningsBowlLabel);
		bowlPanel1.add(inningsBowlField);
		bowlPanel1.add(targetBowlLabel);
		bowlPanel1.add(targetBowlField);
		bowlPanel1.setLayout(new GridLayout(2, 2, 2, 1));

		bowlPanel2.add(runChoiceBowlLabel);
		for (int i = 0; i < 7; i++) {
			bowlPanel2.add(runsBowlButton[i]);
		}

		bowlPanel3.add(runSelectedBowlLabel);
		bowlPanel3.add(runSelectedBowlField);
		bowlPanel3.add(runGeneratedBowlLabel);
		bowlPanel3.add(runGeneratedBowlField);
		bowlPanel3.add(totalRunsBowlLabel);
		bowlPanel3.add(totalRunsBowlField);
		bowlPanel3.setLayout(new GridLayout(3, 2, 2, 1));

		bowlPanel.add(bowlPanel1);
		bowlPanel.add(bowlPanel2);
		bowlPanel.add(bowlPanel3);
		bowlPanel.setLayout(new GridLayout(3, 1, 4, 0));
	}

	public void createOtherPanel() {
		otherPanel = new JPanel();

		createTossPanel();
		createResultPanel();
		createControlPanel();

		otherPanel.add(tossPanel);
		otherPanel.add(resultPanel);
		otherPanel.add(controlPanel);
		otherPanel.setLayout(new GridLayout(3, 1, 10, 10));
	}

	public void createGamePanel() {
		gamePanel = new JPanel();

		createBatPanel();
		createBowlPanel();

		gamePanel.add(batPanel);
		gamePanel.add(bowlPanel);
		gamePanel.setLayout(new GridLayout(2, 1, 10, 10));
	}

	public void createFrame() {
		frame = new JFrame("Hand Cricket Game");

		createOtherPanel();
		createGamePanel();

		frame.add(otherPanel);
		frame.add(gamePanel);
		frame.setLayout(new GridLayout(1, 2, 10, 10));
	}

	public void addListenersToComponents() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tossButton.addActionListener(this);
		batBowlButton.addActionListener(this);

		continueButton.addActionListener(this);
		resetButton.addActionListener(this);
		closeButton.addActionListener(this);

		for (int i = 0; i < 7; i++) {
			runsBatButton[i].addActionListener(this);
			runsBowlButton[i].addActionListener(this);
		}
	}

	public void displayFrame() {
		frame.pack();
		// frame.setSize(600, 600);
		frame.setVisible(true);
	}

	public void initiateModel() {
		handCricketGame = new HandCricketGame();
	}

	public void setInitialRestrictions() {
		batRadioButton.setEnabled(false);
		bowlRadioButton.setEnabled(false);
		batBowlButton.setEnabled(false);

		continueButton.setEnabled(false);
		resetButton.setEnabled(false);

		for (int i = 0; i < 7; i++) {
			runsBatButton[i].setEnabled(false);
			runsBowlButton[i].setEnabled(false);
		}

		matchesField.setText("0");
		winsField.setText("0");
		drawsField.setText("0");
		lostsField.setText("0");
	}

	public void start() {
		createFrame();
		addListenersToComponents();
		displayFrame();
		initiateModel();
		setInitialRestrictions();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		if (object == tossButton) {
			actionOfTossButton();
		} else if (object == batBowlButton) {
			actionOfBatBowlButton();
		} else if (object == continueButton || object == resetButton) {
			actionOfContinueResetButtons(object);
		} else if (object == closeButton) {
			actionOfCloseButton();
		} else {
			actionOfRunsBatButtons(object);
			actionOfRunsBowlButtons(object);
		}
	}

	public void actionOfTossButton() {
		boolean result;
		if (headsRadioButton.isSelected() || tailsRadioButton.isSelected()) {
			if (headsRadioButton.isSelected()) {
				result = handCricketGame.isTossWon("heads");
			} else {
				result = handCricketGame.isTossWon("tails");
			}

			if (result) {
				tossResultField.setText("you won the toss");

				batRadioButton.setEnabled(true);
				bowlRadioButton.setEnabled(true);
				batBowlButton.setEnabled(true);
			} else {
				tossResultField.setText("you lost the toss");

				String choice = handCricketGame.getComputerChoiceForBatBowl();
				batBowlResultField.setText("you are to " + choice + " first");

				if (choice.equals("bat")) {
					inningsBatField.setText("First Innings");
					targetBatField.setText("---");
					for (int i = 0; i < 7; i++) {
						runsBatButton[i].setEnabled(true);
					}
				} else {
					inningsBowlField.setText("First Innings");
					targetBowlField.setText("---");
					for (int i = 0; i < 7; i++) {
						runsBowlButton[i].setEnabled(true);
					}
				}
				resetButton.setEnabled(true);

				headsRadioButton.setEnabled(false);
				tailsRadioButton.setEnabled(false);
				tossButton.setEnabled(false);
				batRadioButton.setEnabled(false);
				bowlRadioButton.setEnabled(false);
				batBowlButton.setEnabled(false);
			}
		}
	}

	public void actionOfBatBowlButton() {
		if (batRadioButton.isSelected() || bowlRadioButton.isSelected()) {
			if (batRadioButton.isSelected()) {
				batBowlResultField.setText("you are to bat first");
				for (int i = 0; i < 7; i++) {
					runsBatButton[i].setEnabled(true);
				}
				inningsBatField.setText("First Innings");
				targetBatField.setText("---");

				if (handCricketGame.isSecondInnings()) {
					inningsBatField.setText("Second Innings");
					int target = handCricketGame.getRunsConceded() + 1;
					targetBatField.setText("Score " + target + " runs to win");
				}
			} else {
				batBowlResultField.setText("you are to bowl first");
				for (int i = 0; i < 7; i++) {
					runsBowlButton[i].setEnabled(true);
				}
				inningsBowlField.setText("First Innings");
				targetBowlField.setText("---");

				if (handCricketGame.isSecondInnings()) {
					inningsBowlField.setText("Second Innings");
					int target = handCricketGame.getRunsScored();
					targetBowlField.setText("Defend " + target + " runs to win");
				}
			}
			resetButton.setEnabled(true);

			headsRadioButton.setEnabled(false);
			tailsRadioButton.setEnabled(false);
			tossButton.setEnabled(false);
			batRadioButton.setEnabled(false);
			bowlRadioButton.setEnabled(false);
			batBowlButton.setEnabled(false);
		}
	}

	public void actionOfContinueResetButtons(Object object) {
		handCricketGame.setIsSecondInnings(false);
		handCricketGame.setRunsConceded(0);
		handCricketGame.setRunsScored(0);

		buttonGroup1.clearSelection();
		tossResultField.setText("");
		buttonGroup2.clearSelection();
		batBowlResultField.setText("");

		matchResultField.setText("");

		continueButton.setEnabled(false);

		inningsBatField.setText("");
		targetBatField.setText("---");
		runSelectedBatField.setText("");
		runGeneratedBatField.setText("");
		totalRunsBatField.setText("");

		inningsBowlField.setText("");
		targetBowlField.setText("---");
		runSelectedBowlField.setText("");
		runGeneratedBowlField.setText("");
		totalRunsBowlField.setText("");

		headsRadioButton.setEnabled(true);
		tailsRadioButton.setEnabled(true);
		tossButton.setEnabled(true);

		if (object == resetButton) {
			resetButton.setEnabled(false);

			totalMatches = 0;
			winMatches = 0;
			drawMatches = 0;
			lostMatches = 0;

			matchesField.setText("0");
			winsField.setText("0");
			drawsField.setText("0");
			lostsField.setText("0");
		}
	}

	public void actionOfCloseButton() {
		int response = JOptionPane.showConfirmDialog(frame, "Are you sure to exit?");
		if (response == JOptionPane.YES_OPTION) {
			frame.dispose();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	public void actionOfRunsBatButtons(Object object) {
		for (int i = 0; i < 7; i++) {
			if (runsBatButton[i] == object) {
				int runSelected = i;
				int runGenerated = handCricketGame.getComputerGeneratedRun();

				runSelectedBatField.setText(String.valueOf(runSelected));
				runGeneratedBatField.setText(String.valueOf(runGenerated));

				if (handCricketGame.isOut(runSelected, runGenerated)) {
					totalRunsBatField.setText(totalRunsBatField.getText() + " (you are out)");
					if (handCricketGame.isSecondInnings()) {
						if (handCricketGame.getRunsScored() == handCricketGame.getRunsConceded()) {
							matchResultField.setText("the match is drawn");
							totalMatches += 1;
							drawMatches += 1;
							matchesField.setText(String.valueOf(totalMatches));
							drawsField.setText(String.valueOf(drawMatches));
						} else {
							matchResultField.setText("you lost the match");
							totalMatches += 1;
							lostMatches += 1;
							matchesField.setText(String.valueOf(totalMatches));
							lostsField.setText(String.valueOf(lostMatches));
						}

						for (int j = 0; j < 7; j++) {
							runsBatButton[j].setEnabled(false);
						}

						continueButton.setEnabled(true);
					} else {
						handCricketGame.setIsSecondInnings(true);
						inningsBowlField.setText("Second Innings");
						int target = handCricketGame.getRunsScored();
						targetBowlField.setText("Defend " + target + " runs to win");

						for (int j = 0; j < 7; j++) {
							runsBatButton[j].setEnabled(false);
							runsBowlButton[j].setEnabled(true);
						}
					}
				} else {
					handCricketGame.setRunsScored(handCricketGame.getRunsScored() + runSelected);
					totalRunsBatField.setText(String.valueOf(handCricketGame.getRunsScored()));
					if (handCricketGame.isSecondInnings()) {
						if (handCricketGame.isChasingDone()) {
							matchResultField.setText("you won the match");
							totalMatches += 1;
							winMatches += 1;
							matchesField.setText(String.valueOf(totalMatches));
							winsField.setText(String.valueOf(winMatches));

							for (int j = 0; j < 7; j++) {
								runsBatButton[j].setEnabled(false);
							}

							continueButton.setEnabled(true);
						}
					}
				}
				break;
			}
		}
	}

	public void actionOfRunsBowlButtons(Object object) {
		for (int i = 0; i < 7; i++) {
			if (runsBowlButton[i] == object) {
				int runSelected = i;
				int runGenerated = handCricketGame.getComputerGeneratedRun();

				runSelectedBowlField.setText(String.valueOf(runSelected));
				runGeneratedBowlField.setText(String.valueOf(runGenerated));

				if (handCricketGame.isOut(runSelected, runGenerated)) {
					totalRunsBowlField.setText(totalRunsBowlField.getText() + " (you got a wicket)");
					if (handCricketGame.isSecondInnings()) {
						if (handCricketGame.getRunsConceded() == handCricketGame.getRunsScored()) {
							matchResultField.setText("the match is drawn");
							totalMatches += 1;
							drawMatches += 1;
							matchesField.setText(String.valueOf(totalMatches));
							drawsField.setText(String.valueOf(drawMatches));
						} else {
							matchResultField.setText("you won the match");
							totalMatches += 1;
							winMatches += 1;
							matchesField.setText(String.valueOf(totalMatches));
							winsField.setText(String.valueOf(winMatches));
						}

						for (int j = 0; j < 7; j++) {
							runsBowlButton[j].setEnabled(false);
						}

						continueButton.setEnabled(true);
					} else {
						handCricketGame.setIsSecondInnings(true);
						inningsBatField.setText("Second Innings");
						int target = handCricketGame.getRunsConceded() + 1;
						targetBatField.setText("Score " + target + " runs to win");

						for (int j = 0; j < 7; j++) {
							runsBowlButton[j].setEnabled(false);
							runsBatButton[j].setEnabled(true);
						}
					}
				} else {
					handCricketGame.setRunsConceded(handCricketGame.getRunsConceded() + runGenerated);
					totalRunsBowlField.setText(String.valueOf(handCricketGame.getRunsConceded()));
					if (handCricketGame.isSecondInnings()) {
						if (handCricketGame.isDefendingDone()) {
							matchResultField.setText("you lost the match");
							totalMatches += 1;
							lostMatches += 1;
							matchesField.setText(String.valueOf(totalMatches));
							lostsField.setText(String.valueOf(lostMatches));

							for (int j = 0; j < 7; j++) {
								runsBowlButton[j].setEnabled(false);
							}

							continueButton.setEnabled(true);
						}
					}
				}
				break;
			}
		}
	}
}
