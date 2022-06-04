package com.bhargav.oddOrEven.ui;

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
	OddOrEvenGameModel oddOrEvenGameModel = null;

	public void createUserInputPanel() {
		userInputPanel = new JPanel();
		userExpectedChoiceLabel = new JLabel("You Expect");
		buttonGroup = new ButtonGroup();
		oddRadioButton = new JRadioButton("ODD", false);
		evenRadioButton = new JRadioButton("EVEN", false);
		userNumberLabel = new JLabel("Enter an integer");
		userNumberField = new JTextField(5);
		userNumberField.setHorizontalAlignment(JTextField.CENTER);
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
		userChoiceLabel = new JLabel("You Chose");
		userChoiceField = new JTextField(10);
		userChoiceField.setHorizontalAlignment(JTextField.CENTER);
		userChoiceField.setEditable(false);
		generatedChoiceLabel = new JLabel("Computer Chose");
		generatedChoiceField = new JTextField(10);
		generatedChoiceField.setHorizontalAlignment(JTextField.CENTER);
		generatedChoiceField.setEditable(false);
		expectedChoiceLabel = new JLabel("You Expected");
		expectedChoiceField = new JTextField(10);
		expectedChoiceField.setHorizontalAlignment(JTextField.CENTER);
		expectedChoiceField.setEditable(false);
		obtainedChoiceLabel = new JLabel("Obtained");
		obtainedChoiceField = new JTextField(10);
		obtainedChoiceField.setHorizontalAlignment(JTextField.CENTER);
		obtainedChoiceField.setEditable(false);
		resultLabel = new JLabel("Result");
		resultField = new JTextField(10);
		resultField.setHorizontalAlignment(JTextField.CENTER);
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
		matchesLabel = new JLabel("Matches Played");
		matchesField = new JTextField(5);
		matchesField.setHorizontalAlignment(JTextField.CENTER);
		matchesField.setEditable(false);
		winsLabel = new JLabel("Matches Won");
		winsField = new JTextField(5);
		winsField.setHorizontalAlignment(JTextField.CENTER);
		winsField.setEditable(false);
		lostsLabel = new JLabel("Matches Lost");
		lostsField = new JTextField(5);
		lostsField.setHorizontalAlignment(JTextField.CENTER);
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
		continuePlay = new JButton("Continue Play");
		resetPlay = new JButton("Reset Play");
		closePlay = new JButton("Exit Game");

		controlPanel.add(continuePlay);
		controlPanel.add(resetPlay);
		controlPanel.add(closePlay);

		controlPanel.setLayout(new GridLayout(2, 2, 5, 5));
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
		frame = new JFrame("Guess IT... ODD or EVEN!!");
		createGamePanel();
		createOtherPanel();

		frame.add(gamePanel);
		frame.add(otherPanel);

		frame.setLayout(new GridLayout(1, 2, 20, 0));
	}

	public void setInitialRestrictions() {
		oddOrEvenGameModel = new OddOrEvenGameModel();

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
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		oddRadioButton.addActionListener(this);
		evenRadioButton.addActionListener(this);
		submitInputButton.addActionListener(this);
		continuePlay.addActionListener(this);
		resetPlay.addActionListener(this);
		closePlay.addActionListener(this);
	}

	public void displayFrame() {
		frame.pack();
		frame.setVisible(true);
	}

	public void startGame() {
		createFrame();
		setInitialRestrictions();
		addListenersToComponents();
		displayFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object == oddRadioButton || object == evenRadioButton) {
			actionOfOddEvenRadioButtons();
		} else if (object == submitInputButton) {
			actionOfSubmitInputButton();
		} else if (object == continuePlay) {
			actionOfContinuePlayButton();
		} else if (object == resetPlay) {
			actionOfResetPlayButton();
		} else if (object == closePlay) {
			actionOfClosePlayButton();
		}
	}

	public void actionOfOddEvenRadioButtons() {
		userNumberField.setEditable(true);
		submitInputButton.setEnabled(true);
	}

	public void actionOfSubmitInputButton() {
		if (oddRadioButton.isSelected()) {
			oddOrEvenGameModel.setUserExpectedChoice("odd");
		} else {
			oddOrEvenGameModel.setUserExpectedChoice("even");
		}
		try {
			int num = Integer.parseInt(userNumberField.getText());
			oddOrEvenGameModel.setUserNumber(num);
			if (num % 2 == 0) {
				oddOrEvenGameModel.setUserChoice("even");
			} else {
				oddOrEvenGameModel.setUserChoice("odd");
			}
			oddOrEvenGameModel.generateNumberAndChoice();
			String obtained = oddOrEvenGameModel.createObtainedChoice();
			oddOrEvenGameModel.setObtainedChoice(obtained);
			oddOrEvenGameModel.setWon(oddOrEvenGameModel.decide());

			userChoiceField.setText(oddOrEvenGameModel.getUserNumber() + " -- " + oddOrEvenGameModel.getUserChoice());
			generatedChoiceField.setText(
					oddOrEvenGameModel.getGeneratedNumber() + " -- " + oddOrEvenGameModel.getGeneratedChoice());
			num = oddOrEvenGameModel.getUserNumber() + oddOrEvenGameModel.getGeneratedNumber();
			expectedChoiceField.setText(oddOrEvenGameModel.getUserExpectedChoice());
			obtainedChoiceField.setText(num + " -- " + oddOrEvenGameModel.getObtainedChoice());
			if (oddOrEvenGameModel.isWon()) {
				resultField.setText("You Won");
				wins += 1;
			} else {
				resultField.setText("You Lost");
				losts += 1;
			}
			totalMatches += 1;

			matchesField.setText(String.valueOf(totalMatches));
			winsField.setText(String.valueOf(wins));
			lostsField.setText(String.valueOf(losts));
		} catch (Exception ex) {
			resultField.setText("Invalid Input");
			JOptionPane.showMessageDialog(frame, "Please Enter an Integer");
		}

		oddRadioButton.setEnabled(false);
		evenRadioButton.setEnabled(false);
		userNumberField.setEditable(false);
		submitInputButton.setEnabled(false);
		continuePlay.setEnabled(true);
	}

	public void actionOfContinuePlayButton() {
		setInitialRestrictions();
	}

	public void actionOfResetPlayButton() {
		setInitialRestrictions();
		totalMatches = 0;
		wins = 0;
		losts = 0;
		matchesField.setText("");
		winsField.setText("");
		lostsField.setText("");
		resultField.setText("");
	}

	public void actionOfClosePlayButton() {
		int response = JOptionPane.showConfirmDialog(frame, "Are you sure to exit?");
		if (response == JOptionPane.YES_OPTION) {
			oddOrEvenGameModel = null;
			frame.dispose();
			System.exit(0);
		}
	}
}
