package com.bhargav.differentcolor.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class DifferentColorUI implements ActionListener {

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

				if (colorButtons != null) {
					for (int i = 0; i < colorButtons.length; i++) {
						for (int j = 0; j < colorButtons[i].length; j++) {
							colorButtons[i][j].setEnabled(false);
						}
					}
				}

				continueButton.setEnabled(true);
				resetButton.setEnabled(false);
			}
		}
	}

	DifferentColorModel differentColorModel = null;

	JFrame frame;
	JPanel panelOne, timerPanel, scorePanel;
	JLabel timerLabel, scoreLabel;
	JTextField scoreField;
	JButton timerButton;
	JPanel panelTwo, dynamicPanel, boardPanel, controlButtonsPanel;
	JButton colorButtons[][];
	JButton continueButton, resetButton, exitButton;

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

	public void createDynamicPanel(int rows, int cols) {
		if (dynamicPanel == null) {
			dynamicPanel = new JPanel();
		}

		if (rows > 0 && cols > 0) {
			removeListenersToColorButtons();
			dynamicPanel.removeAll();

			colorButtons = new JButton[rows][cols];
			Color colors[][] = differentColorModel.getColors();
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					colorButtons[i][j] = new JButton("		");
					colorButtons[i][j].setBackground(colors[i][j]);
					dynamicPanel.add(colorButtons[i][j]);
				}
			}
			addListenersToColorButtons();
			dynamicPanel.setLayout(new GridLayout(rows, cols));
		}
	}

	public void createBoardPanel() {
		boardPanel = new JPanel();
		createDynamicPanel(0, 0);

		boardPanel.add(dynamicPanel);
		boardPanel.setLayout(new FlowLayout());
	}

	public void createControlButtonsPanel() {
		controlButtonsPanel = new JPanel();
		continueButton = new JButton("Play Again");
		resetButton = new JButton("Reset Play");
		exitButton = new JButton("Exit Game");

		controlButtonsPanel.add(continueButton);
		controlButtonsPanel.add(resetButton);
		controlButtonsPanel.add(exitButton);
		controlButtonsPanel.setLayout(new GridLayout(3, 1, 5, 5));
	}

	public void createPanelOne() {
		panelOne = new JPanel();
		createTimerPanel();
		createScorePanel();

		panelOne.add(timerPanel);
		panelOne.add(scorePanel);
		panelOne.setLayout(new GridLayout(1, 2, 5, 5));
	}

	public void createPanelTwo() {
		panelTwo = new JPanel();
		createBoardPanel();
		createControlButtonsPanel();

		panelTwo.add(boardPanel);
		panelTwo.add(controlButtonsPanel);
		panelTwo.setLayout(new FlowLayout());
	}

	public void createFrame() {
		frame = new JFrame("DiFFirent COlOR");
		createPanelOne();
		createPanelTwo();

		frame.add(panelOne);
		frame.add(panelTwo);
		frame.setLayout(new GridLayout(2, 1, 5, 5));
	}

	public void addListenersToColorButtons() {
		if (colorButtons != null) {
			for (int i = 0; i < colorButtons.length; i++) {
				for (int j = 0; j < colorButtons[i].length; j++) {
					colorButtons[i][j].addActionListener(this);
				}
			}
		}
	}

	public void removeListenersToColorButtons() {
		if (colorButtons != null) {
			for (int i = 0; i < colorButtons.length; i++) {
				for (int j = 0; j < colorButtons[i].length; j++) {
					colorButtons[i][j].removeActionListener(this);
				}
			}
		}
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
		addListenersToColorButtons();
	}

	public void setInitialRestrictions() {
		differentColorModel = null;

		timerButton.setText("Start");
		timerButton.setEnabled(true);
		scoreField.setText(" -- ");
		exitButton.setEnabled(true);
		continueButton.setEnabled(false);
		resetButton.setEnabled(false);
		if (colorButtons != null) {
			for (int i = 0; i < colorButtons.length; i++) {
				for (int j = 0; j < colorButtons[i].length; j++) {
					colorButtons[i][j].setEnabled(false);
				}
			}
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
			if (colorButtons != null) {
				actionOfColorButtons(object);
			}
		}
	}

	public void actionOfTimerButton() {
		scoreField.setText("0");
		timerButton.setEnabled(false);
		continueButton.setEnabled(false);
		resetButton.setEnabled(true);

		differentColorModel = new DifferentColorModel();
		differentColorModel.generateColors();
		createDynamicPanel(differentColorModel.getRows(), differentColorModel.getCols());
		frame.setVisible(true);

		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new RemindTask(), 0, 1 * 1000);
	}

	public void actionOfContinueButton() {
		setInitialRestrictions();
	}

	public void actionOfResetButton() {
		timer.cancel();
		setInitialRestrictions();
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

	public void actionOfColorButtons(Object object) {
		for (int i = 0; i < colorButtons.length; i++) {
			for (int j = 0; j < colorButtons[i].length; j++) {
				if (object == colorButtons[i][j]) {
					differentColorModel.updateScore(colorButtons[i][j].getBackground());
					int score = differentColorModel.getScore();
					scoreField.setText(String.valueOf(score));

					differentColorModel.generateColors();
					createDynamicPanel(differentColorModel.getRows(), differentColorModel.getCols());
					frame.pack();
					frame.setVisible(true);
				}
			}
		}
	}
}
