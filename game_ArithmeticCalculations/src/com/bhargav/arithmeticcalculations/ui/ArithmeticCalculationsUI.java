package com.bhargav.arithmeticcalculations.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class ArithmeticCalculationsUI implements ActionListener {

	Timer timer;
	Toolkit toolkit;

	// Internal class
	class RemindTask extends TimerTask {
		int numWarningBeeps = 60;

		public void run() {
			if (numWarningBeeps > 0) {
				timerButton.setText(String.format("%02d", numWarningBeeps));
				numWarningBeeps--;
			} else {
				toolkit.beep();
				timerButton.setText("done");
				timer.cancel();

				arithmeticCalculations.setScore(0);

				clearButton.setEnabled(false);
				validateButton.setEnabled(false);
				for (int i = 0; i < digitButtons.length; i++) {
					digitButtons[i].setEnabled(false);
				}
				continueButton.setEnabled(true);
				resetButton.setEnabled(false);
				changeDifficultyButton.setEnabled(true);
			}
		}
	}

	ArithmeticCalculations arithmeticCalculations = null;
	String difficulty = null;

	JDialog dialog;
	JPanel dialogPanelOne, dialogPanelTwo, dialogPanelThree;
	JLabel dialogLabel;
	ButtonGroup dialogButtonGroup;
	JRadioButton dialogEasyRButton, dialogMediumRButton, dialogHardRButton;
	JButton dialogButton;

	JFrame frame;
	JPanel panelOne, timerPanel, difficultyPanel, scorePanel, controlButtonsPanel;
	JLabel timerLabel, difficultyLabel, scoreLabel;
	JTextField difficultyField, scoreField;
	JButton timerButton, continueButton, resetButton, changeDifficultyButton, exitButton;
	JPanel panelTwo, expressionPanel, valuePanel, valuePanelOne, valuePanelTwo, digitsPanel;
	JTextField expressionField, valueField;
	JButton clearButton, validateButton;
	JButton[] digitButtons;

	public void createDialogPanelOne() {
		dialogPanelOne = new JPanel();
		dialogLabel = new JLabel("Choose a Difficulty Level..");

		dialogPanelOne.add(dialogLabel);
		dialogPanelOne.setLayout(new FlowLayout());
	}

	public void createDialogPanelTwo() {
		dialogPanelTwo = new JPanel();
		dialogButtonGroup = new ButtonGroup();
		dialogEasyRButton = new JRadioButton("Easy");
		dialogMediumRButton = new JRadioButton("Medium");
		dialogHardRButton = new JRadioButton("Hard");

		dialogButtonGroup.add(dialogEasyRButton);
		dialogButtonGroup.add(dialogMediumRButton);
		dialogButtonGroup.add(dialogHardRButton);
		dialogPanelTwo.add(dialogEasyRButton);
		dialogPanelTwo.add(dialogMediumRButton);
		dialogPanelTwo.add(dialogHardRButton);
		dialogPanelTwo.setLayout(new GridLayout(1, 3, 2, 2));
	}

	public void createDialogPanelThree() {
		dialogPanelThree = new JPanel();
		dialogButton = new JButton("proceed..");

		dialogPanelThree.add(dialogButton);
		dialogPanelThree.setLayout(new FlowLayout());
	}

	public void createDialog() {
		dialog = new JDialog();
		createDialogPanelOne();
		createDialogPanelTwo();
		createDialogPanelThree();

		dialog.add(dialogPanelOne);
		dialog.add(dialogPanelTwo);
		dialog.add(dialogPanelThree);
		dialog.setLayout(new GridLayout(3, 1, 2, 2));
	}

	public void addListenersToDialogComponents() {
		dialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		dialogButton.addActionListener(this);
	}

	public void displayDialog() {
		dialog.pack();
		dialog.setVisible(true);
	}

	public void createTimerPanel() {
		timerPanel = new JPanel();
		timerLabel = new JLabel("Timer");
		timerButton = new JButton("start");
		timerButton.setFont(new Font("Times New Roman", Font.BOLD, 30));

		timerPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		timerPanel.add(timerLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		timerPanel.add(timerButton, gbc);
	}

	public void createDifficultyPanel() {
		difficultyPanel = new JPanel();
		difficultyLabel = new JLabel("Score");
		difficultyField = new JTextField(5);
		difficultyField.setEditable(false);
		difficultyField.setHorizontalAlignment(JTextField.CENTER);
		difficultyField.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		difficultyField.setBackground(Color.lightGray);

		difficultyPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		difficultyPanel.add(difficultyLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		difficultyPanel.add(difficultyField, gbc);
	}

	public void createScorePanel() {
		scorePanel = new JPanel();
		scoreLabel = new JLabel("Score");
		scoreField = new JTextField(5);
		scoreField.setEditable(false);
		scoreField.setHorizontalAlignment(JTextField.CENTER);
		scoreField.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		scoreField.setBackground(Color.lightGray);

		scorePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		scorePanel.add(scoreLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		scorePanel.add(scoreField, gbc);
	}

	public void createControlButtonsPanel() {
		controlButtonsPanel = new JPanel();
		continueButton = new JButton("Continue Play");
		resetButton = new JButton("Reset Play");
		changeDifficultyButton = new JButton("Change Difficulty");
		exitButton = new JButton("Exit Game");

		controlButtonsPanel.add(continueButton);
		controlButtonsPanel.add(resetButton);
		controlButtonsPanel.add(changeDifficultyButton);
		controlButtonsPanel.add(exitButton);
		controlButtonsPanel.setLayout(new GridLayout(4, 1, 5, 5));
	}

	public void createPanelOne() {
		panelOne = new JPanel();
		createTimerPanel();
		createDifficultyPanel();
		createScorePanel();
		createControlButtonsPanel();

		panelOne.add(timerPanel);
		panelOne.add(difficultyPanel);
		panelOne.add(scorePanel);
		panelOne.add(controlButtonsPanel);
		panelOne.setLayout(new GridLayout(1, 4, 5, 5));
	}

	public void createExpressionPanel() {
		expressionPanel = new JPanel();
		expressionField = new JTextField("	", 8);
		expressionField.setHorizontalAlignment(JTextField.CENTER);
		expressionField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		expressionField.setBackground(Color.lightGray);
		expressionField.setEditable(false);

		expressionPanel.add(expressionField);
		expressionPanel.setLayout(new GridLayout(1, 1, 10, 10));
	}

	public void createValuePanelOne() {
		valuePanelOne = new JPanel();
		valueField = new JTextField("	", 8);
		valueField.setHorizontalAlignment(JTextField.CENTER);
		valueField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		valueField.setBackground(Color.lightGray);
		valueField.setEditable(false);

		valuePanelOne.add(valueField);
		valuePanelOne.setLayout(new GridLayout(1, 1, 10, 10));
	}

	public void createValuePanelTwo() {
		valuePanelTwo = new JPanel();
		clearButton = new JButton("clear");
		validateButton = new JButton("validate");

		valuePanelTwo.add(clearButton);
		valuePanelTwo.add(validateButton);
		valuePanelTwo.setLayout(new GridLayout(1, 2, 10, 10));
	}

	public void createValuePanel() {
		valuePanel = new JPanel();
		createValuePanelOne();
		createValuePanelTwo();

		valuePanel.add(valuePanelOne);
		valuePanel.add(valuePanelTwo);
		valuePanel.setLayout(new GridLayout(2, 1, 5, 5));
	}

	public void createDigitsPanel() {
		digitsPanel = new JPanel();
		digitButtons = new JButton[10];
		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i] = new JButton(String.valueOf(i));
			digitsPanel.add(digitButtons[i]);
		}

		digitsPanel.setLayout(new GridLayout(2, 5, 3, 3));
	}

	public void createPanelTwo() {
		panelTwo = new JPanel();
		createExpressionPanel();
		createValuePanel();
		createDigitsPanel();

		panelTwo.add(expressionPanel);
		panelTwo.add(valuePanel);
		panelTwo.add(digitsPanel);
		panelTwo.setLayout(new GridLayout(1, 3, 5, 5));
	}

	public void createFrame() {
		frame = new JFrame("Arithmetic Calculations Game..");
		createPanelOne();
		createPanelTwo();

		frame.add(panelOne);
		frame.add(panelTwo);
		frame.setLayout(new GridLayout(2, 1, 10, 10));
	}

	public void addListenersToFrameComponents() {
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		timerButton.addActionListener(this);
		continueButton.addActionListener(this);
		resetButton.addActionListener(this);
		changeDifficultyButton.addActionListener(this);
		exitButton.addActionListener(this);
		clearButton.addActionListener(this);
		validateButton.addActionListener(this);
		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i].addActionListener(this);
		}
	}

	public void setInitialRestrictions() {
		timerButton.setText("Start");
		if (difficulty != null) {
			difficultyField.setText(difficulty);
		} else {
			difficultyField.setText("	");
		}
		scoreField.setText("	");
		expressionField.setText("	");
		valueField.setText("	");

		timerButton.setEnabled(true);
		clearButton.setEnabled(false);
		validateButton.setEnabled(false);
		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i].setEnabled(false);
		}
		continueButton.setEnabled(false);
		resetButton.setEnabled(true);
		changeDifficultyButton.setEnabled(true);
		exitButton.setEnabled(true);
	}

	public void displayFrame() {
		frame.pack();
		frame.setVisible(true);
	}

	public void startDialogPhase() {
		createDialog();
		addListenersToDialogComponents();
		displayDialog();
	}

	public void startFramePhase() {
		createFrame();
		addListenersToFrameComponents();
		setInitialRestrictions();
		displayFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object == dialogButton) {
			actionOfDialogButton();
		} else if (object == timerButton) {
			actionOfTimerButton();
		} else if (object == continueButton) {
			actionOfContinueButton();
		} else if (object == resetButton) {
			actionOfResetButton();
		} else if (object == changeDifficultyButton) {
			actionOfChangeDifficultyButton();
		} else if (object == exitButton) {
			actionOfExitButton();
		} else if (object == clearButton) {
			actionOfClearButton();
		} else if (object == validateButton) {
			actionOfValidateButton();
		} else {
			actionOfDigitButtons(object);
		}
	}

	public void actionOfDialogButton() {
		if (dialogEasyRButton.isSelected()) {
			difficulty = "Easy";
			arithmeticCalculations = new EasyArithmeticCalculations();
			startFramePhase();
			dialog.setVisible(false);
			dialog.removeAll();
			dialog.dispose();
		} else if (dialogMediumRButton.isSelected()) {
			difficulty = "Medium";
			arithmeticCalculations = new MediumArithmeticCalculations();
			startFramePhase();
			dialog.setVisible(false);
			dialog.removeAll();
			dialog.dispose();
		} else if (dialogHardRButton.isSelected()) {
			difficulty = "Hard";
			arithmeticCalculations = new HardArithmeticCalculations();
			startFramePhase();
			dialog.setVisible(false);
			dialog.removeAll();
			dialog.dispose();
		} else {
			JOptionPane.showMessageDialog(dialog, "Please choose a Difficulty to proceed..");
		}
	}

	public void actionOfTimerButton() {
		scoreField.setText("0");
		timerButton.setEnabled(false);
		continueButton.setEnabled(false);
		resetButton.setEnabled(true);
		changeDifficultyButton.setEnabled(false);
		clearButton.setEnabled(true);
		validateButton.setEnabled(true);
		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i].setEnabled(true);
		}

		arithmeticCalculations.generateExpressionAndEvaluate();
		String expression = arithmeticCalculations.getExpression();
		expressionField.setText(expression);

		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new RemindTask(), 0, 1 * 1000);
	}

	public void actionOfContinueButton() {
		setInitialRestrictions();
	}

	public void actionOfResetButton() {
		if (timer != null) {
			timer.cancel();
		}
		setInitialRestrictions();
	}

	public void actionOfChangeDifficultyButton() {
		frame.setVisible(false);
		frame.removeAll();
		frame.dispose();

		startDialogPhase();
	}

	public void actionOfExitButton() {
		int response = JOptionPane.showConfirmDialog(frame, "Are you sure to exit?");
		if (response == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void actionOfClearButton() {
		valueField.setText("	");
	}

	public void actionOfValidateButton() {
		String valueText = valueField.getText().trim();
		int value;
		if (valueText == "") {

		} else {
			value = Integer.parseInt(valueText);
			arithmeticCalculations.setPredictedValue(value);

			arithmeticCalculations.updateScore();
			scoreField.setText(String.valueOf(arithmeticCalculations.getScore()));

			valueField.setText("	");
			arithmeticCalculations.generateExpressionAndEvaluate();
			expressionField.setText(arithmeticCalculations.getExpression());
		}

	}

	public void actionOfDigitButtons(Object object) {
		for (int i = 0; i < digitButtons.length; i++) {
			if (digitButtons[i] == object) {
				String valueText = valueField.getText().trim();
				int value;
				if (valueText == "") {
					value = i;
				} else {
					value = (Integer.parseInt(valueText) * 10) + i;
				}

				valueField.setText(String.valueOf(value));
			}
		}
	}
}
