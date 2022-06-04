package com.bhargav.romannumerals.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class RomanNumeralsUI implements ActionListener {

	Timer timer;
	Toolkit toolkit;

	// Internal class
	class RemindTask extends TimerTask {
		int numWarningBeeps = 120;

		public void run() {
			if (numWarningBeeps > 0) {
				timerButton.setText(String.format("%03d", numWarningBeeps));
				numWarningBeeps--;
			} else {
				toolkit.beep();
				timerButton.setText("done");
				timer.cancel();

				romanNumerals.setScore(0);

				if (difficulty.equals("easy")) {
					for (int i = 0; i < numberButtons.length; i++) {
						numberButtons[i].setEnabled(false);
					}
				} else if (difficulty.equals("medium") || difficulty.equals("hard")) {
					for (int i = 0; i < romanButtons.length; i++) {
						romanButtons[i].setEnabled(false);
					}
				}
				clearButton.setEnabled(false);
				validateButton.setEnabled(false);

				continueButton.setEnabled(true);
				resetButton.setEnabled(false);
				changeDifficultyButton.setEnabled(true);
			}
		}
	}

	JDialog dialog;
	JPanel dialogPanel;
	JLabel dialogLabel;
	ButtonGroup buttonGroup;
	JRadioButton easyRButton, mediumRButton, hardRButton;
	JButton dialogButton;

	RomanNumerals romanNumerals = null;
	String difficulty = null;

	JFrame frame;
	JPanel panelOne, timerPanel, difficultyPanel, scorePanel, controlButtonsPanel;
	JLabel timerLabel, difficultyLabel, scoreLabel;
	JTextField difficultyField, scoreField;
	JButton timerButton, continueButton, resetButton, changeDifficultyButton, exitButton;
	JPanel panelTwo, inTextPanel, outTextPanel, keysPanel, numberButtonsPanel, romanButtonsPanel;
	JTextField inField, outField;
	JButton[] numberButtons;
	JButton[] romanButtons;
	JButton clearButton, validateButton;

	public void createDialogPanel() {
		dialogPanel = new JPanel();
		dialogLabel = new JLabel("Choose difficulty level and proceed..");
		buttonGroup = new ButtonGroup();
		easyRButton = new JRadioButton("Easy");
		mediumRButton = new JRadioButton("Medium");
		hardRButton = new JRadioButton("Hard");
		dialogButton = new JButton("Proceed..");

		buttonGroup.add(easyRButton);
		buttonGroup.add(mediumRButton);
		buttonGroup.add(hardRButton);

		dialogPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		dialogPanel.add(dialogLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		dialogPanel.add(easyRButton, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		dialogPanel.add(mediumRButton, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		dialogPanel.add(hardRButton, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		dialogPanel.add(dialogButton, gbc);
	}

	public void createDialog() {
		dialog = new JDialog();
		createDialogPanel();

		dialog.add(dialogPanel);
		dialog.setLayout(new GridLayout(1, 1, 5, 5));
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

	public void startDialogPhase() {
		createDialog();
		addListenersToDialogComponents();
		displayDialog();
	}

	public void createTimerPanel() {
		timerPanel = new JPanel();
		timerLabel = new JLabel("Timer");
		timerButton = new JButton("start");
		timerButton.setFont(new Font("Showcard Gothic", Font.BOLD, 30));

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
		difficultyLabel = new JLabel("Difficulty");
		difficultyField = new JTextField(5);
		difficultyField.setEditable(false);
		difficultyField.setHorizontalAlignment(JTextField.CENTER);
		difficultyField.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		difficultyField.setBackground(Color.lightGray);
		difficultyField.setForeground(Color.black);

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
		scoreField.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		scoreField.setBackground(Color.lightGray);
		scoreField.setForeground(Color.black);

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
		continueButton = new JButton("Continue");
		resetButton = new JButton("Reset");
		changeDifficultyButton = new JButton("changeDifficulty");
		exitButton = new JButton("Exit");

		controlButtonsPanel.add(continueButton);
		controlButtonsPanel.add(resetButton);
		controlButtonsPanel.add(changeDifficultyButton);
		controlButtonsPanel.add(exitButton);
		controlButtonsPanel.setLayout(new GridLayout(2, 2, 1, 1));
	}

	public void createInTextPanel() {
		inTextPanel = new JPanel();
		inField = new JTextField(5);
		inField.setEditable(false);
		inField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inField.setHorizontalAlignment(JTextField.CENTER);
		inField.setBackground(Color.lightGray);
		inField.setForeground(Color.red);

		inTextPanel.add(inField);
		inTextPanel.setLayout(new GridLayout(1, 1, 5, 5));
	}

	public void createOutTextPanel() {
		outTextPanel = new JPanel();
		outField = new JTextField(5);
		outField.setEditable(false);
		outField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		outField.setHorizontalAlignment(JTextField.CENTER);
		outField.setBackground(Color.lightGray);
		outField.setForeground(Color.blue);

		outTextPanel.add(outField);
		outTextPanel.setLayout(new GridLayout(1, 1, 5, 5));
	}

	public void createNumberButtonsPanel() {
		numberButtonsPanel = new JPanel();
		numberButtons = new JButton[10];
		for (int i = 0; i < numberButtons.length; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtonsPanel.add(numberButtons[i]);
		}
		clearButton = new JButton("Clear");
		validateButton = new JButton("validate");

		numberButtonsPanel.add(clearButton);
		numberButtonsPanel.add(validateButton);
		numberButtonsPanel.setLayout(new GridLayout(4, 3, 1, 1));
	}

	public void createRomanButtonsPanel() {
		romanButtonsPanel = new JPanel();
		char[] romanSigns = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		romanButtons = new JButton[7];
		for (int i = 0; i < romanButtons.length; i++) {
			romanButtons[i] = new JButton(String.valueOf(romanSigns[i]));
			romanButtonsPanel.add(romanButtons[i]);
		}
		clearButton = new JButton("Clear");
		validateButton = new JButton("validate");

		romanButtonsPanel.add(clearButton);
		romanButtonsPanel.add(validateButton);
		romanButtonsPanel.setLayout(new GridLayout(3, 3, 1, 1));
	}

	public void createKeysPanel() {
		keysPanel = new JPanel();
		if (difficulty.equals("easy")) {
			createNumberButtonsPanel();
			keysPanel.add(numberButtonsPanel);
		} else if (difficulty.equals("medium") || difficulty.equals("hard")) {
			createRomanButtonsPanel();
			keysPanel.add(romanButtonsPanel);
		}

		keysPanel.setLayout(new FlowLayout());
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
		panelOne.setLayout(new FlowLayout());
	}

	public void createPanelTwo() {
		panelTwo = new JPanel();
		createInTextPanel();
		createOutTextPanel();
		createKeysPanel();

		panelTwo.add(inTextPanel);
		panelTwo.add(outTextPanel);
		panelTwo.add(keysPanel);
		panelTwo.setLayout(new GridLayout(1, 3, 1, 1));
	}

	public void createFrame() {
		frame = new JFrame("Roman Numericals Game...");
		createPanelOne();
		createPanelTwo();

		frame.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		frame.add(panelOne, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		frame.add(panelTwo, gbc);
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
		if (difficulty.equals("easy")) {
			for (int i = 0; i < numberButtons.length; i++) {
				numberButtons[i].addActionListener(this);
			}
		} else if (difficulty.equals("medium") || difficulty.equals("hard")) {
			for (int i = 0; i < romanButtons.length; i++) {
				romanButtons[i].addActionListener(this);
			}
		}
		clearButton.addActionListener(this);
		validateButton.addActionListener(this);
	}

	public void setInitialRestrictions() {
		romanNumerals.setScore(0);

		timerButton.setText("Start");
		scoreField.setText("--");
		difficultyField.setText(difficulty);

		timerButton.setEnabled(true);
		continueButton.setEnabled(false);
		resetButton.setEnabled(false);
		changeDifficultyButton.setEnabled(true);
		exitButton.setEnabled(true);

		inField.setText("");
		outField.setText("");

		if (difficulty.equals("easy")) {
			for (int i = 0; i < numberButtons.length; i++) {
				numberButtons[i].setEnabled(false);
			}
		} else if (difficulty.equals("medium") || difficulty.equals("hard")) {
			for (int i = 0; i < romanButtons.length; i++) {
				romanButtons[i].setEnabled(false);
			}
		}
		clearButton.setEnabled(false);
		validateButton.setEnabled(false);
	}

	public void displayFrame() {
		frame.pack();
		frame.setVisible(true);
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
			if (difficulty.equals("easy")) {
				actionOfNumberButtons(object);
			} else if (difficulty.equals("medium") || difficulty.equals("hard")) {
				actionOfRomanButtons(object);
			}
		}
	}

	public void actionOfDialogButton() {
		if (easyRButton.isSelected() || mediumRButton.isSelected() || hardRButton.isSelected()) {
			if (easyRButton.isSelected()) {
				difficulty = "easy";
				romanNumerals = new EasyRomanNumerals();
			} else if (mediumRButton.isSelected()) {
				difficulty = "medium";
				romanNumerals = new MediumRomanNumerals();
			} else {
				difficulty = "hard";
				romanNumerals = new HardRomanNumerals();
			}
			dialog.setVisible(false);
			dialog.dispose();

			startFramePhase();
		} else {
			JOptionPane.showMessageDialog(dialog, "Please choose a difficulty level to proceed..");
			dialog.setVisible(true);
		}
	}

	public void actionOfTimerButton() {
		scoreField.setText("0");
		timerButton.setEnabled(false);
		continueButton.setEnabled(false);
		resetButton.setEnabled(true);
		changeDifficultyButton.setEnabled(false);

		if (difficulty.equals("easy")) {
			for (int i = 0; i < numberButtons.length; i++) {
				numberButtons[i].setEnabled(true);
			}
		} else if (difficulty.equals("medium") || difficulty.equals("hard")) {
			for (int i = 0; i < romanButtons.length; i++) {
				romanButtons[i].setEnabled(true);
			}
		}
		clearButton.setEnabled(true);
		validateButton.setEnabled(true);

		String text;
		romanNumerals.generateInputValue();
		if (difficulty.equals("easy")) {
			text = romanNumerals.getRomanValue();
		} else if (difficulty.equals("medium")) {
			text = String.valueOf(romanNumerals.getNumberValue());
		} else {
			text = romanNumerals.getExpression();
		}
		inField.setText(text);

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
		outField.setText("");
	}

	public void actionOfValidateButton() {
		String text = outField.getText().trim();
		if (text.equals(null) || text.equals("")) {
			JOptionPane.showMessageDialog(frame, "Please provide some value to validate..");
		} else {
			int score;
			romanNumerals.convert();
			if (difficulty.equals("easy")) {
				romanNumerals.setProvidedNumberValue(Integer.parseInt(text));
			} else if (difficulty.equals("medium")) {
				romanNumerals.setProvidedRomanValue(text);
			} else {
				romanNumerals.setProvidedRomanValue(text);
			}
			romanNumerals.updateScore();
			score = romanNumerals.getScore();
			scoreField.setText(String.valueOf(score));
			outField.setText("");
			inField.setText("");

			romanNumerals.generateInputValue();
			if (difficulty.equals("easy")) {
				text = romanNumerals.getRomanValue();
			} else if (difficulty.equals("medium")) {
				text = String.valueOf(romanNumerals.getNumberValue());
			} else {
				text = romanNumerals.getExpression();
			}
			inField.setText(text);
		}
	}

	public void actionOfNumberButtons(Object object) {
		for (int i = 0; i < numberButtons.length; i++) {
			if (numberButtons[i] == object) {
				String text = outField.getText().trim();
				text += i;
				outField.setText(text);
			}
		}
	}

	public void actionOfRomanButtons(Object object) {
		char[] romanSigns = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		for (int i = 0; i < romanButtons.length; i++) {
			if (romanButtons[i] == object) {
				String text = outField.getText().trim();
				text += romanSigns[i];
				outField.setText(text);
			}
		}
	}
}
