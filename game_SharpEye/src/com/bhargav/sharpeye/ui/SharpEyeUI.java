package com.bhargav.sharpeye.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class SharpEyeUI implements ActionListener {

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

				requiredIconButton.setIcon(null);
				requiredIconButton.setBackground(null);
				requiredIconButton.setEnabled(false);
				for (int i = 0; i < iconButtons.length; i++) {
					iconButtons[i].setText("	");
					iconButtons[i].setIcon(null);
					iconButtons[i].setBackground(Color.white);
					iconButtons[i].setEnabled(false);
				}
				displayFrame();

				continueButton.setEnabled(true);
				resetButton.setEnabled(false);
			}
		}
	}

	SharpEyeModel sharpEyeModel = null;

	JFrame frame;
	JPanel panelOne, timerPanel, requiredIconPanel, scorePanel, controlButtonsPanel;
	JLabel timerLabel, requiredIconLabel, scoreLabel;
	JTextField scoreField;
	JButton timerButton, requiredIconButton, continueButton, resetButton, exitButton;
	JPanel panelTwo;
	JButton[] iconButtons;

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

	public void createRequiredIconPanel() {
		requiredIconPanel = new JPanel();
		requiredIconLabel = new JLabel("Required Icon");
		requiredIconButton = new JButton();

		requiredIconPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		requiredIconPanel.add(requiredIconLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		requiredIconPanel.add(requiredIconButton, gbc);
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
		createRequiredIconPanel();
		createScorePanel();
		createControlButtonsPanel();

		panelOne.add(timerPanel);
		panelOne.add(requiredIconPanel);
		panelOne.add(scorePanel);
		panelOne.add(controlButtonsPanel);
		panelOne.setLayout(new GridLayout(1, 4, 5, 5));
	}

	public void createPanelTwo() {
		panelTwo = new JPanel();
		iconButtons = new JButton[56];
		for (int i = 0; i < iconButtons.length; i++) {
			iconButtons[i] = new JButton();
			panelTwo.add(iconButtons[i]);
		}
		panelTwo.setLayout(new GridLayout(8, 7, 2, 2));
	}

	public void createFrame() {
		frame = new JFrame("sHaRP EyE");
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
		for (int i = 0; i < iconButtons.length; i++) {
			iconButtons[i].addActionListener(this);
		}
	}

	public void setInitialRestrictions() {
		sharpEyeModel = null;

		timerButton.setText("Start");
		requiredIconButton.setText("	");
		scoreField.setText(" -- ");

		timerButton.setEnabled(true);
		exitButton.setEnabled(true);
		requiredIconButton.setEnabled(true);
		requiredIconButton.setIcon(null);
		continueButton.setEnabled(false);
		resetButton.setEnabled(false);
		for (int i = 0; i < iconButtons.length; i++) {
			iconButtons[i].setText("	");
			iconButtons[i].setIcon(null);
			iconButtons[i].setEnabled(false);
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
			if (iconButtons != null) {
				actionOfIconButtons(object);
			}
		}
	}

	public void actionOfTimerButton() {
		scoreField.setText("0");
		timerButton.setEnabled(false);
		continueButton.setEnabled(false);
		resetButton.setEnabled(true);

		sharpEyeModel = new SharpEyeModel();
		sharpEyeModel.generateIcons();
		ImageIcon[] icons = sharpEyeModel.getIcons();
		for (int i = 0; i < iconButtons.length; i++) {
			iconButtons[i].setIcon(icons[i]);
			iconButtons[i].setText("");
			iconButtons[i].setBackground(Color.white);
			iconButtons[i].setEnabled(true);
		}
		displayFrame();

		sharpEyeModel.generateRequiredIcon();
		ImageIcon requiredIcon = sharpEyeModel.getRequiredIcon();
		requiredIconButton.setIcon(requiredIcon);
		requiredIconButton.setBackground(Color.white);

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

	public void actionOfIconButtons(Object object) {
		for (int i = 0; i < iconButtons.length; i++) {
			if (object == iconButtons[i]) {
				sharpEyeModel.updateScore((ImageIcon) iconButtons[i].getIcon());
				int score = sharpEyeModel.getScore();
				scoreField.setText(String.valueOf(score));

				if (sharpEyeModel.getRequiredIcon().equals((ImageIcon) iconButtons[i].getIcon())) {
					iconButtons[i].setBackground(Color.lightGray);
					iconButtons[i].setEnabled(false);
				}

				if (sharpEyeModel.isFinished()) {
					sharpEyeModel.generateIcons();
					ImageIcon[] icons = sharpEyeModel.getIcons();
					for (int j = 0; j < iconButtons.length; j++) {
						iconButtons[j].setIcon(icons[j]);
						iconButtons[j].setText("");
						iconButtons[j].setBackground(Color.white);
						iconButtons[j].setEnabled(true);
					}
					sharpEyeModel.generateRequiredIcon();
					ImageIcon requiredIcon = sharpEyeModel.getRequiredIcon();
					requiredIconButton.setIcon(requiredIcon);
					requiredIconButton.setBackground(Color.white);
				}
			}
		}
	}
}
