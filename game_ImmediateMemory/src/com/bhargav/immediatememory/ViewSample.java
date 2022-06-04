package com.bhargav.immediatememory;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class ViewSample implements ActionListener {

	Timer timer;
	RemindTask remindTask;
	Toolkit toolkit;

	// Internal class
	class RemindTask extends TimerTask {
		int numWarningBeeps = 5;

		public void run() {
			System.out.println("isValidated: " + isValidated);
			if (numWarningBeeps > 0) {
				System.out.println("running..");
				timerField.setText(String.format("-00:%02d", numWarningBeeps));
				numWarningBeeps--;
			} else {
				System.out.println("stopped");
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
				System.out.println("Enabled buttons after timer stopped");
			}
		}
	}

	public void iterate() {
		int i = 0;
		while (i <= 1000 && !isValidated) {
			progressBar.setValue(i);
			i = i + 50;
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println("exception.. in progress bar iteration");
			}
			System.out.println("value of progress bar: " + i);
		}

		timerPanel.setVisible(true);
		progressPanel.setVisible(false);

		clearButton.setEnabled(false);
		validateButton.setEnabled(false);
		for (i = 0; i < 10; i++) {
			digitButtons[i].setEnabled(false);
		}

		if (!isValidated) {
			modelClass.setMatched(false);
		}

	}

	ModelClass modelClass = null;
	boolean isValidated = false;

	JFrame frame;
	JPanel panelOne, scorePanel, controlButtonsPanel;
	JLabel scoreLabel;
	JTextField scoreField;
	JButton exitButton;
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
		scoreField.setForeground(Color.orange);
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

	public void createControlButtonsPanel() {
		controlButtonsPanel = new JPanel();
		exitButton = new JButton("Exit game");

		controlButtonsPanel.add(exitButton);
		controlButtonsPanel.setLayout(new FlowLayout());
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
		createControlButtonsPanel();

		panelOne.add(scorePanel);
		panelOne.add(controlButtonsPanel);
		panelOne.setLayout(new GridLayout(1, 2, 10, 10));
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
		clearButton.addActionListener(this);
		validateButton.addActionListener(this);
		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i].addActionListener(this);
		}
	}

	public void setInitialRestrictions() {
		System.out.println("In set restrictions..");
		isValidated = false;
		modelClass = new ModelClass();
		modelClass.setCount(0);
		modelClass.setScore(0);
		modelClass.setMatched(true);
		scoreField.setText("0");

		exitButton.setEnabled(true);

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
		System.out.println("In display numer...");
		modelClass.generateNumber();
		textField.setText(String.valueOf(modelClass.getGeneratedNumber()));
		System.out.println("text: " + textField.getText());
	}

	public void startTimer() {
		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new RemindTask(), 0, 1 * 1000);
	}

	public void playGame() {
		// starts
		do {
			isValidated = false;
			displayNumberOnTextField();
			startTimer();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println("exception... in play game");
			}
			iterate();
		} while (modelClass.isMatched());
		// ends
	}

	public void startProcess() {
		createFrame();
		addListeners();
		setInitialRestrictions();
		displayFrame();
		playGame();
	}

	public static void main(String[] args) {
		new ViewSample().startProcess();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object == exitButton) {
			actionOfExitButton();
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

	public void actionOfClearButton() {
		textField.setText(null);
	}

	public void actionOfValidateButton() {
		String text = textField.getText().trim();
		System.out.println("provided: " + text);
		try {
			int providedValue = Integer.parseInt(text);
			modelClass.setProvidedNumber(providedValue);
			modelClass.decideResult();
			modelClass.updateScore();

			scoreField.setText(String.valueOf(modelClass.getScore()));

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
