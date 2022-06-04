package com.bhargav.immediatememory.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class ImmediateMemoryUI implements ActionListener {

	Timer timer;
	RemindTask remindTask;
	Toolkit toolkit;

	// Internal class
	class RemindTask extends TimerTask {
		int numWarningBeeps = 3;

		public void run() {
			if (numWarningBeeps > 0) {
				timerField.setText(String.format("-00:%02d", numWarningBeeps));
				numWarningBeeps--;
			} else {
				timer.cancel();

				timerField.setText("--");
				timerPanel.setVisible(false);
				progressBar.setValue(0);
				progressPanel.setVisible(true);

				clearButton.setEnabled(true);
				validateButton.setEnabled(true);
				for (int i = 0; i < digitButtons.length; i++) {
					digitButtons[i].setEnabled(true);
				}

				textField.setText(null);
				runProgressBar();
			}
		}
	}

	ImmediateMemory immediateMemory = null;
	boolean isValidated;
	boolean isResetClicked;

	JFrame frame;
	JPanel panelOne, scorePanel, countPanel, controlButtonsPanel;
	JLabel scoreLabel, countLabel;
	JTextField scoreField, countField;
	JButton continueButton, resetButton, exitButton;
	JPanel panelTwo, timerPanel, progressPanel;
	JLabel timerLabel;
	JTextField timerField;
	JProgressBar progressBar;
	JPanel panelThree, textPanel;
	JTextField textField;
	JPanel panelFour, digitsPanel;
	JButton[] digitButtons;
	JButton clearButton, validateButton;

	public void createScorePanel() {
		scorePanel = new JPanel();
		scoreLabel = new JLabel("Score");
		scoreField = new JTextField(5);
		scoreField.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		scoreField.setHorizontalAlignment(JTextField.CENTER);
		scoreField.setBackground(Color.lightGray);
		scoreField.setForeground(Color.black);
		scoreField.setEditable(false);

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

	public void createCountPanel() {
		countPanel = new JPanel();
		countLabel = new JLabel("Count");
		countField = new JTextField(5);
		countField.setHorizontalAlignment(JTextField.CENTER);
		countField.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		countField.setBackground(Color.lightGray);
		countField.setForeground(Color.blue);
		countField.setEditable(false);

		countPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		countPanel.add(countLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		countPanel.add(countField, gbc);
	}

	public void createControlButtonsPanel() {
		controlButtonsPanel = new JPanel();
		continueButton = new JButton("Continue");
		resetButton = new JButton("Reset");
		exitButton = new JButton("Exit");

		controlButtonsPanel.add(continueButton);
		controlButtonsPanel.add(resetButton);
		controlButtonsPanel.add(exitButton);
		controlButtonsPanel.setLayout(new GridLayout(2, 2, 2, 2));
	}

	public void createTimerPanel() {
		timerPanel = new JPanel();
		timerLabel = new JLabel("Timer");
		timerField = new JTextField(5);
		timerField.setHorizontalAlignment(JTextField.CENTER);
		timerField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		timerField.setBackground(Color.lightGray);
		timerField.setForeground(Color.red);
		timerField.setEditable(false);

		timerPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		timerPanel.add(timerLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		timerPanel.add(timerField, gbc);
	}

	public void createProgressPanel() {
		progressPanel = new JPanel();
		progressBar = new JProgressBar(0, 1000);
		progressBar.setValue(0);
		progressBar.setForeground(Color.darkGray);
		progressBar.setBackground(Color.green);
		progressBar.setStringPainted(false);

		progressPanel.add(progressBar);
		progressPanel.setLayout(new GridLayout(1, 1, 0, 0));
	}

	public void createTextPanel() {
		textPanel = new JPanel();
		textField = new JTextField(8);
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField.setBackground(Color.lightGray);
		textField.setForeground(Color.black);
		textField.setEditable(false);

		textPanel.add(textField);
		textPanel.setLayout(new GridLayout(1, 1, 0, 0));
	}

	public void createDigitsPanel() {
		digitsPanel = new JPanel();
		digitButtons = new JButton[10];
		for (int i = digitButtons.length - 1; i >= 0; i--) {
			digitButtons[i] = new JButton(String.valueOf(i));
			digitsPanel.add(digitButtons[i]);
		}
		clearButton = new JButton("Clear");
		validateButton = new JButton("Validate");

		digitsPanel.add(clearButton);
		digitsPanel.add(validateButton);

		digitsPanel.setLayout(new GridLayout(4, 3, 2, 2));
	}

	public void createPanelOne() {
		panelOne = new JPanel();
		createScorePanel();
		createCountPanel();
		createControlButtonsPanel();

		panelOne.add(scorePanel);
		panelOne.add(countPanel);
		panelOne.add(controlButtonsPanel);
		panelOne.setLayout(new GridLayout(1, 3, 5, 5));
	}

	public void createPanelTwo() {
		panelTwo = new JPanel();
		createTimerPanel();
		createProgressPanel();

		panelTwo.add(timerPanel);
		panelTwo.add(progressPanel);
		panelTwo.setLayout(new GridLayout(2, 1, 10, 10));
	}

	public void createPanelThree() {
		panelThree = new JPanel();
		createTextPanel();

		panelThree.add(textPanel);
		panelThree.setLayout(new GridLayout(1, 1, 5, 5));
	}

	public void createPanelFour() {
		panelFour = new JPanel();
		createDigitsPanel();

		panelFour.add(digitsPanel);
		panelFour.setLayout(new GridLayout(1, 1, 5, 5));
	}

	public void createFrame() {
		frame = new JFrame("Immediate Memory...");
		createPanelOne();
		createPanelTwo();
		createPanelThree();
		createPanelFour();

		frame.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		frame.add(panelOne, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		frame.add(panelTwo, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		frame.add(panelThree, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 3;
		gbc.gridwidth = 2;
		frame.add(panelFour, gbc);
	}

	public void addListeners() {
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		exitButton.addActionListener(this);
		continueButton.addActionListener(this);
		resetButton.addActionListener(this);
		clearButton.addActionListener(this);
		validateButton.addActionListener(this);
		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i].addActionListener(this);
		}
	}

	public void setInitialRestrictions() {
		scoreField.setText("0");
		countField.setText("0");

		exitButton.setEnabled(true);
		continueButton.setEnabled(false);
		resetButton.setEnabled(true);

		progressBar.setValue(0);
		progressPanel.setVisible(false);
		timerPanel.setVisible(true);

		textField.setText("    ");
		clearButton.setEnabled(false);
		validateButton.setEnabled(false);

		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i].setEnabled(false);
		}
	}

	public void displayFrame() {
		frame.pack();
		frame.setVisible(true);
	}

	public void displayNumberOnTextField() {
		immediateMemory.generateNumber();
		textField.setText(String.valueOf(immediateMemory.getGeneratedNumber()));
	}

	public void startTimer() {
		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new RemindTask(), 0, 1 * 1000);
	}

	public void runProgressBar() {
		int i = 0;
		isValidated = false;
		isResetClicked = false;

		while (i <= 1000 && !isResetClicked && !isValidated) {
			progressBar.setValue(i);
			i = i + 50;
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println("exception.. in progress bar iteration");
			}
		}

		timerPanel.setVisible(true);
		progressPanel.setVisible(false);

		if (!isResetClicked) {
			clearButton.setEnabled(false);
			validateButton.setEnabled(false);
			for (i = 0; i < 10; i++) {
				digitButtons[i].setEnabled(false);
			}

			if (!isValidated || !immediateMemory.isMatched()) {
				immediateMemory.setMatched(false);
				JOptionPane.showMessageDialog(frame, "Correct number: " + immediateMemory.getGeneratedNumber());
				continueButton.setEnabled(true);
				resetButton.setEnabled(false);
			}

			if (isValidated && immediateMemory.isMatched()) {
				displayNumberOnTextField();
				startTimer();
			}
		}
	}

	public void startProcess() {
		createFrame();
		addListeners();
		setInitialRestrictions();
		displayFrame();

		immediateMemory = new ImmediateMemory();
		displayNumberOnTextField();
		startTimer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object == exitButton) {
			actionOfExitButton();
		} else if (object == resetButton) {
			actionOfResetButton();
		} else if (object == continueButton) {
			actionOfContinueButton();
		} else if (object == clearButton) {
			actionOfClearButton();
		} else if (object == validateButton) {
			actionOfValidateButton();
		} else {
			actionOfDigitButtons(object);
		}
	}

	public void actionOfExitButton() {
		int response = JOptionPane.showConfirmDialog(frame, "Are you sure to exit?");
		if (response == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void actionOfResetButton() {
		int response = JOptionPane.showConfirmDialog(frame, "Are you sure to reset?");
		if (response == JOptionPane.YES_OPTION) {
			isResetClicked = true;
			if (timer != null) {
				timer.cancel();
			}
			progressBar.setValue(0);

			immediateMemory.setCount(0);
			immediateMemory.setScore(0);
			immediateMemory.setOrigin(10);
			immediateMemory.setBound(100);

			setInitialRestrictions();
			displayNumberOnTextField();
			startTimer();
		}
	}

	public void actionOfContinueButton() {
		immediateMemory.setCount(0);
		immediateMemory.setScore(0);
		immediateMemory.setOrigin(10);
		immediateMemory.setBound(100);

		setInitialRestrictions();
		displayNumberOnTextField();
		startTimer();
	}

	public void actionOfClearButton() {
		textField.setText(null);
	}

	public void actionOfValidateButton() {
		String text = textField.getText().trim();
		try {
			int providedValue = Integer.parseInt(text);
			immediateMemory.setProvidedNumber(providedValue);
			immediateMemory.decideResult();
			immediateMemory.updateScore(progressBar.getValue());

			if (immediateMemory.isMatched()) {
				scoreField.setText(String.valueOf(immediateMemory.getScore()));
				countField.setText(String.valueOf(immediateMemory.getCount()));
			}

			validateButton.setEnabled(false);
			isValidated = true;
		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(frame, "Invalid input..");
		}
	}

	public void actionOfDigitButtons(Object object) {
		String text = textField.getText().trim();
		for (int i = 0; i < digitButtons.length; i++) {
			if (object == digitButtons[i]) {
				if (text.equals(null) || text.equals("")) {
					textField.setText(String.valueOf(i));
				} else {
					text = text + String.valueOf(i);
					textField.setText(text);
				}
			}
		}
	}
}
