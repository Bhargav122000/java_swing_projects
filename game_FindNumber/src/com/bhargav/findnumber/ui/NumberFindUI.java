package com.bhargav.findnumber.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class NumberFindUI implements ActionListener {

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
				timerButton.setText("Done");
				timer.cancel();

				requiredButton.setText("	");
				requiredButton.setForeground(null);
				requiredButton.setBackground(null);
				for (int i = 0; i < buttons.length; i++) {
					buttons[i].setText("	");
					buttons[i].setForeground(null);
					buttons[i].setBackground(null);
					buttons[i].setEnabled(false);
				}
				displayFrame();

				continueButton.setEnabled(true);
				resetButton.setEnabled(false);
			}
		}
	}

	NumberFindModel numberFindModel = null;

	JFrame frame;
	JPanel panelOne, timerPanel, requiredPanel, scorePanel, controlButtonsPanel;
	JLabel timerLabel, requiredLabel, scoreLabel;
	JTextField scoreField;
	JButton timerButton, requiredButton, continueButton, resetButton, exitButton;
	JPanel panelTwo;
	JButton[] buttons;

	public void createTimerPanel() {
		timerPanel = new JPanel();
		timerLabel = new JLabel("Timer");
		timerButton = new JButton("Start");
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

	public void createRequiredPanel() {
		requiredPanel = new JPanel();
		requiredLabel = new JLabel("Required Icon");
		requiredButton = new JButton();
		requiredButton.setFont(new Font("Times New Roman", Font.BOLD, 30));

		requiredPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		requiredPanel.add(requiredLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		requiredPanel.add(requiredButton, gbc);
	}

	public void createScorePanel() {
		scorePanel = new JPanel();
		scoreLabel = new JLabel("Score");
		scoreField = new JTextField(5);
		scoreField.setEditable(false);
		scoreField.setHorizontalAlignment(JTextField.CENTER);
		scoreField.setFont(new Font("Times New Roman", Font.BOLD, 30));

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
		continueButton = new JButton("Play Again");
		resetButton = new JButton("Reset Play");
		exitButton = new JButton("Exit Game");

		controlButtonsPanel.add(continueButton);
		controlButtonsPanel.add(resetButton);
		controlButtonsPanel.add(exitButton);
		controlButtonsPanel.setLayout(new GridLayout(3, 1, 2, 2));
	}

	public void createPanelOne() {
		panelOne = new JPanel();
		createTimerPanel();
		createRequiredPanel();
		createScorePanel();
		createControlButtonsPanel();

		panelOne.add(timerPanel);
		panelOne.add(requiredPanel);
		panelOne.add(scorePanel);
		panelOne.add(controlButtonsPanel);
		panelOne.setLayout(new GridLayout(1, 4, 5, 5));
	}

	public void createPanelTwo() {
		panelTwo = new JPanel();
		buttons = new JButton[30];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setFont(new Font("Arial Black", Font.BOLD, 20));
			panelTwo.add(buttons[i]);
		}
		panelTwo.setLayout(new GridLayout(6, 5, 2, 2));
	}

	public void createFrame() {
		frame = new JFrame("nUmBEr fINd");
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

	public void addListeners() {
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		timerButton.addActionListener(this);
		continueButton.addActionListener(this);
		resetButton.addActionListener(this);
		exitButton.addActionListener(this);
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
		}
	}

	public void setInitialRestrictions() {
		numberFindModel = null;

		timerButton.setText("Start");
		requiredButton.setText("	");
		scoreField.setText(" -- ");

		timerButton.setEnabled(true);
		exitButton.setEnabled(true);
		requiredButton.setEnabled(true);
		requiredButton.setForeground(null);
		requiredButton.setBackground(null);
		resetButton.setEnabled(false);
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setText("	");
			buttons[i].setForeground(null);
			buttons[i].setBackground(null);
			buttons[i].setEnabled(false);
		}
	}

	public void displayFrame() {
		frame.pack();
		frame.setVisible(true);
	}

	public void startProcess() {
		createFrame();
		addListeners();
		setInitialRestrictions();
		displayFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object == timerButton) {
			actionOfTimerButton();
		} else if (object == continueButton) {
			actionOfContinueButton();
		} else if (object == resetButton) {
			actionOfResetButton();
		} else if (object == exitButton) {
			actionOfExitButton();
		} else {
			if (buttons != null) {
				actionOfButtons(object);
			}
		}
	}

	public void actionOfTimerButton() {
		scoreField.setText("0");
		timerButton.setEnabled(false);
		continueButton.setEnabled(false);
		resetButton.setEnabled(true);

		numberFindModel = new NumberFindModel();
		numberFindModel.generateAgain();

		int requiredNumber = numberFindModel.getRequiredNumber();
		Color requiredForeground = numberFindModel.getRequiredForeground();
		Color requiredBackground = numberFindModel.getRequiredBackground();
		requiredButton.setText(String.valueOf(requiredNumber));
		requiredButton.setForeground(requiredForeground);
		requiredButton.setBackground(requiredBackground);

		int[] numbers = numberFindModel.getNumbers();
		Color[] foregrounds = numberFindModel.getForegrounds();
		Color[] backgrounds = numberFindModel.getBackgrounds();
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setText(String.valueOf(numbers[i]));
			buttons[i].setForeground(foregrounds[i]);
			buttons[i].setBackground(backgrounds[i]);
			buttons[i].setEnabled(true);
		}
		displayFrame();

		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new RemindTask(), 0, 1 * 1000);
	}

	public void actionOfContinueButton() {
		setInitialRestrictions();
		displayFrame();
	}

	public void actionOfResetButton() {
		timer.cancel();
		setInitialRestrictions();
		displayFrame();
	}

	public void actionOfExitButton() {
		int response = JOptionPane.showConfirmDialog(frame, "Are you sure to exit?");
		if (response == JOptionPane.YES_OPTION) {
			if (timer != null) {
				timer.cancel();
			}
			frame.dispose();
			System.exit(0);
		}
	}

	public void actionOfButtons(Object object) {
		for (int i = 0; i < buttons.length; i++) {
			if (object == buttons[i]) {
				int obtainedNumber = Integer.parseInt(buttons[i].getText());
				Color obtainedForeground = buttons[i].getForeground();
				numberFindModel.updateScore(obtainedNumber, obtainedForeground);

				int score = numberFindModel.getScore();
				scoreField.setText(String.valueOf(score));

				numberFindModel.generateAgain();
				int requiredNumber = numberFindModel.getRequiredNumber();
				Color requiredForeground = numberFindModel.getRequiredForeground();
				Color requiredBackground = numberFindModel.getRequiredBackground();
				requiredButton.setText(String.valueOf(requiredNumber));
				requiredButton.setForeground(requiredForeground);
				requiredButton.setBackground(requiredBackground);

				int[] numbers = numberFindModel.getNumbers();
				Color[] foregrounds = numberFindModel.getForegrounds();
				Color[] backgrounds = numberFindModel.getBackgrounds();
				for (int j = 0; j < buttons.length; j++) {
					buttons[j].setText(String.valueOf(numbers[j]));
					buttons[j].setForeground(foregrounds[j]);
					buttons[j].setBackground(backgrounds[j]);
					buttons[j].setEnabled(true);
				}
				displayFrame();
			}
		}
	}
}
