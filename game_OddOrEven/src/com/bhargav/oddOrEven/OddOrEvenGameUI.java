package com.bhargav.oddOrEven;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OddOrEvenGameUI implements ActionListener {

	JFrame frame;
	JPanel gamePanel, userInputPanel, resultPanel;
	JPanel otherPanel, controlPanel, summaryPanel;
	JLabel userNumberLabel, userExpectedChoiceLabel;
	JTextField userNumberField;
	JRadioButton oddRadioButton, evenRadioButton;
	ButtonGroup buttonGroup;
	JButton submitInputButton;
	JLabel userChoiceLabel, generatedChoiceLabel, expectedChoiceLabel, obtainedChoiceLabel, resultLabel;
	JTextField userChoiceField, generatedChoiceField, expectedChoiceField, obtainedChoiceField, resultField;
	JLabel matchesLabel, winsLabel, lostsLabel;
	JTextField matchesField, winsField, lostsField;
	JButton continuePlay, resetPlay, closePlay;

	int totalMatches = 0, wins = 0, losts = 0;
	OddOrEvenGame oddOrEvenGame = null;

	public void createUserInputPanel() {
		userInputPanel = new JPanel();
		userExpectedChoiceLabel = new JLabel("Expected choice");
		buttonGroup = new ButtonGroup();
		oddRadioButton = new JRadioButton("odd", false);
		evenRadioButton = new JRadioButton("even", false);
		userNumberLabel = new JLabel("Enter an integer");
		userNumberField = new JTextField(5);
		userNumberField.setEditable(false);
		submitInputButton = new JButton("submit");

		buttonGroup.add(oddRadioButton);
		buttonGroup.add(evenRadioButton);
		userInputPanel.add(userExpectedChoiceLabel);
		userInputPanel.add(oddRadioButton);
		userInputPanel.add(evenRadioButton);
		userInputPanel.add(userNumberLabel);
		userInputPanel.add(userNumberField);
		userInputPanel.add(submitInputButton);

		userInputPanel.setLayout(new GridLayout(2, 3, 1, 1));
	}

	public void createResultPanel() {
		resultPanel = new JPanel();
		userChoiceLabel = new JLabel("your choice");
		userChoiceField = new JTextField(10);
		userChoiceField.setEditable(false);
		generatedChoiceLabel = new JLabel("generated choice");
		generatedChoiceField = new JTextField(10);
		generatedChoiceField.setEditable(false);
		expectedChoiceLabel = new JLabel("your expected choice");
		expectedChoiceField = new JTextField(10);
		expectedChoiceField.setEditable(false);
		obtainedChoiceLabel = new JLabel("obtained choice");
		obtainedChoiceField = new JTextField(10);
		obtainedChoiceField.setEditable(false);
		resultLabel = new JLabel("result");
		resultField = new JTextField(10);
		resultField.setEditable(false);

		resultPanel.add(userChoiceLabel);
		resultPanel.add(userChoiceField);
		resultPanel.add(generatedChoiceLabel);
		resultPanel.add(generatedChoiceField);
		resultPanel.add(expectedChoiceLabel);
		resultPanel.add(expectedChoiceField);
		resultPanel.add(obtainedChoiceLabel);
		resultPanel.add(obtainedChoiceField);
		resultPanel.add(resultLabel);
		resultPanel.add(resultField);

		resultPanel.setLayout(new GridLayout(5, 2, 1, 1));
	}

	public void createSummaryPanel() {
		summaryPanel = new JPanel();
		matchesLabel = new JLabel("# mathes");
		matchesField = new JTextField(5);
		matchesField.setEditable(false);
		winsLabel = new JLabel("# wins");
		winsField = new JTextField(5);
		winsField.setEditable(false);
		lostsLabel = new JLabel("# losts");
		lostsField = new JTextField(5);
		lostsField.setEditable(false);

		summaryPanel.add(matchesLabel);
		summaryPanel.add(matchesField);
		summaryPanel.add(winsLabel);
		summaryPanel.add(winsField);
		summaryPanel.add(lostsLabel);
		summaryPanel.add(lostsField);

		summaryPanel.setLayout(new GridLayout(3, 2, 1, 1));
	}

	public void createControlPanel() {
		controlPanel = new JPanel();
		continuePlay = new JButton("continue play");
		resetPlay = new JButton("reset play");
		closePlay = new JButton("close play");

		controlPanel.add(continuePlay);
		controlPanel.add(resetPlay);
		controlPanel.add(closePlay);

		controlPanel.setLayout(new GridLayout(3, 1, 1, 1));
	}

	public void createGamePanel() {
		gamePanel = new JPanel();
		createUserInputPanel();
		createResultPanel();

		gamePanel.add(userInputPanel);
		gamePanel.add(resultPanel);

		gamePanel.setLayout(new GridLayout(2, 1, 5, 5));
	}

	public void createOtherPanel() {
		otherPanel = new JPanel();
		createSummaryPanel();
		createControlPanel();

		otherPanel.add(summaryPanel);
		otherPanel.add(controlPanel);

		otherPanel.setLayout(new GridLayout(2, 1, 5, 5));
	}

	public void createFrame() {
		frame = new JFrame("Odd or Even Guess game");
		createGamePanel();
		createOtherPanel();

		frame.add(gamePanel);
		frame.add(otherPanel);

		frame.setLayout(new GridLayout(1, 2, 10, 0));
	}

	public void setInitialRestrictions() {
		oddOrEvenGame = new OddOrEvenGame();

		buttonGroup.clearSelection();
		oddRadioButton.setEnabled(true);
		evenRadioButton.setEnabled(true);
		userNumberField.setEditable(false);
		userNumberField.setText("");
		submitInputButton.setEnabled(false);
		
		userChoiceField.setText("");
		generatedChoiceField.setText("");
		expectedChoiceField.setText("");
		obtainedChoiceField.setText("");
		resultField.setText("");
		
		continuePlay.setEnabled(false);
	}

	public void addListenersToComponents() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		oddRadioButton.addActionListener(this);
		evenRadioButton.addActionListener(this);
		submitInputButton.addActionListener(this);
		continuePlay.addActionListener(this);
		resetPlay.addActionListener(this);
		closePlay.addActionListener(this);
	}

	public void displayFrame() {
		frame.setSize(600, 300);
		frame.setVisible(true);
	}

	public void startGame() {
		createFrame();
		setInitialRestrictions();
		addListenersToComponents();
		displayFrame();
	}

	public static void main(String[] args) {
		new OddOrEvenGameUI().startGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		if (object == oddRadioButton || object == evenRadioButton) {
			userNumberField.setEditable(true);
			submitInputButton.setEnabled(true);
		} else if (object == submitInputButton) {
			if (oddRadioButton.isSelected()) {
				oddOrEvenGame.setUserExpectedChoice("odd");
			} else {
				oddOrEvenGame.setUserExpectedChoice("even");
			}
			try {
				int num = Integer.parseInt(userNumberField.getText());
				oddOrEvenGame.setUserNumber(num);
				if (num % 2 == 0) {
					oddOrEvenGame.setUserChoice("even");
				} else {
					oddOrEvenGame.setUserChoice("odd");
				}
				oddOrEvenGame.generateNumberAndChoice();
				String obtained = oddOrEvenGame.createObtainedChoice();
				oddOrEvenGame.setObtainedChoice(obtained);
				oddOrEvenGame.setWon(oddOrEvenGame.decide());

				userChoiceField.setText(oddOrEvenGame.getUserNumber() + " -- " + oddOrEvenGame.getUserChoice());
				generatedChoiceField
						.setText(oddOrEvenGame.getGeneratedNumber() + " -- " + oddOrEvenGame.getGeneratedChoice());
				num = oddOrEvenGame.getUserNumber() + oddOrEvenGame.getGeneratedNumber();
				expectedChoiceField.setText(oddOrEvenGame.getUserExpectedChoice());
				obtainedChoiceField.setText(num + " -- " + oddOrEvenGame.getObtainedChoice());
				if (oddOrEvenGame.isWon()) {
					resultField.setText("you won");
					wins += 1;
				} else {
					resultField.setText("you lost");
					losts += 1;
				}
				totalMatches += 1;

				matchesField.setText(String.valueOf(totalMatches));
				winsField.setText(String.valueOf(wins));
				lostsField.setText(String.valueOf(losts));
			} catch (Exception ex) {
				resultField.setText("select an integer to get result");
			}

			oddRadioButton.setEnabled(false);
			evenRadioButton.setEnabled(false);
			userNumberField.setEditable(false);
			submitInputButton.setEnabled(false);
			continuePlay.setEnabled(true);
		} else if (object == continuePlay) {
			setInitialRestrictions();
		} else if (object == resetPlay) {
			setInitialRestrictions();
			totalMatches = 0;
			wins = 0;
			losts = 0;
			matchesField.setText("");
			winsField.setText("");
			lostsField.setText("");
			resultField.setText("");
		} else if (object == closePlay) {
			oddOrEvenGame = null;

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.dispose();
		}
	}
}
