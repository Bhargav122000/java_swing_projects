package com.bhargav.numbermachine.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class NumberMachineGameUI implements ActionListener {

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

				for (int i = 0; i < numberButtons.length; i++) {
					for (int j = 0; j < numberButtons[i].length; j++) {
						numberButtons[i][j].setEnabled(false);
					}
				}

				continueButton.setEnabled(true);
				resetButton.setEnabled(false);
			}
		}
	}

	NumberMachineGameModel numberMachineGameModel = null;
	int buttonsSelected = 0;
	int obtainedSum = 0;
	ArrayList<String> selectedButtonsIndices = null;
	Color selectedColor = new Color(191, 128, 64);
	Color deselectedColor = Color.lightGray;
	Color disabledColor = Color.black;

	JFrame frame;
	JPanel panelOne, panelTwo;
	JPanel timerPanel, sumPanel, scorePanel, maxCellsPanel, controlButtonsPanel;
	JLabel timerLabel, sumLabel, scoreLabel, maxCellsLabel;
	JTextField sumField, scoreField, maxCellsField;
	JButton timerButton, continueButton, resetButton, exitButton;
	JButton numberButtons[][];

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

	public void createSumPanel() {
		sumPanel = new JPanel();
		sumLabel = new JLabel("Required Sum");
		sumField = new JTextField(5);
		sumField.setEditable(false);
		sumField.setHorizontalAlignment(JTextField.CENTER);
		sumField.setFont(new Font("Times New Roman", Font.BOLD, 30));

		sumPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		sumPanel.add(sumLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		sumPanel.add(sumField, gbc);
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

	public void createMaxCellsPanel() {
		maxCellsPanel = new JPanel();
		maxCellsLabel = new JLabel("maximum cells");
		maxCellsField = new JTextField(5);
		maxCellsField.setEditable(false);
		maxCellsField.setHorizontalAlignment(JTextField.CENTER);
		maxCellsField.setFont(new Font("Times New Roman", Font.BOLD, 30));

		maxCellsPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		maxCellsPanel.add(maxCellsLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		maxCellsPanel.add(maxCellsField, gbc);
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
		createSumPanel();
		createScorePanel();
		createMaxCellsPanel();
		createControlButtonsPanel();

		panelOne.add(timerPanel);
		panelOne.add(sumPanel);
		panelOne.add(scorePanel);
		panelOne.add(maxCellsPanel);
		panelOne.add(controlButtonsPanel);
		panelOne.setLayout(new GridLayout(1, 5, 5, 5));
	}

	public void createPanelTwo() {
		panelTwo = new JPanel();
		numberButtons = new JButton[9][9];
		for (int i = 0; i < numberButtons.length; i++) {
			for (int j = 0; j < numberButtons[i].length; j++) {
				numberButtons[i][j] = new JButton(" -- ");
				panelTwo.add(numberButtons[i][j]);
			}
		}
		panelTwo.setLayout(new GridLayout(9, 9, 2, 2));
	}

	public void createFrame() {
		frame = new JFrame("NUmber MAChine");
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
		for (int i = 0; i < numberButtons.length; i++) {
			for (int j = 0; j < numberButtons[i].length; j++) {
				numberButtons[i][j].addActionListener(this);
			}
		}
	}

	public void setInitialRestrictions() {
		buttonsSelected = 0;
		obtainedSum = 0;
		numberMachineGameModel = null;
		selectedButtonsIndices = null;

		timerButton.setText("Start");
		sumField.setText(" -- ");
		scoreField.setText(" -- ");
		maxCellsField.setText(" -- ");

		timerButton.setEnabled(true);
		exitButton.setEnabled(true);
		continueButton.setEnabled(false);
		resetButton.setEnabled(false);
		for (int i = 0; i < numberButtons.length; i++) {
			for (int j = 0; j < numberButtons[i].length; j++) {
				numberButtons[i][j].setText(" -- ");
				numberButtons[i][j].setBackground(deselectedColor);
				numberButtons[i][j].setEnabled(false);
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
			actionOfNumberButtons(object);
		}
	}

	public void actionOfTimerButton() {
		scoreField.setText("0");
		timerButton.setEnabled(false);
		continueButton.setEnabled(false);
		resetButton.setEnabled(true);

		numberMachineGameModel = new NumberMachineGameModel();
		numberMachineGameModel.generateNumbers();
		int numbers[][] = numberMachineGameModel.getNumbers();
		for (int i = 0; i < numberButtons.length; i++) {
			for (int j = 0; j < numberButtons[i].length; j++) {
				numberButtons[i][j].setText(String.valueOf(numbers[i][j]));
				numberButtons[i][j].setEnabled(true);
			}
		}
		numberMachineGameModel.generateRequiredSum();
		int sum = numberMachineGameModel.getRequiredSum();
		sumField.setText(String.valueOf(sum));

		selectedButtonsIndices = new ArrayList<String>();

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

	public void disableSelectedButtons() {
		int i, j;
		StringTokenizer stringTokenizer = null;
		for (int iter = 0; iter < selectedButtonsIndices.size(); iter++) {
			stringTokenizer = new StringTokenizer(selectedButtonsIndices.get(iter));
			i = Integer.parseInt(stringTokenizer.nextToken());
			j = Integer.parseInt(stringTokenizer.nextToken());
			numberButtons[i][j].setBackground(disabledColor);
			numberButtons[i][j].setEnabled(false);
		}
		selectedButtonsIndices.clear();
	}

	public void enableSelectedButtons() {
		int i, j;
		StringTokenizer stringTokenizer = null;
		for (int iter = 0; iter < selectedButtonsIndices.size(); iter++) {
			stringTokenizer = new StringTokenizer(selectedButtonsIndices.get(iter));
			i = Integer.parseInt(stringTokenizer.nextToken());
			j = Integer.parseInt(stringTokenizer.nextToken());
			numberButtons[i][j].setBackground(deselectedColor);
			numberButtons[i][j].setEnabled(true);
		}
		selectedButtonsIndices.clear();
	}

	public void actionOfNumberButtons(Object object) {
		for (int i = 0; i < numberButtons.length; i++) {
			for (int j = 0; j < numberButtons[i].length; j++) {
				if (numberButtons[i][j].isEnabled() && object == numberButtons[i][j]) {
					obtainedSum = numberMachineGameModel.getObtainedSum();
					if (numberButtons[i][j].getBackground().equals(selectedColor)) {
						numberButtons[i][j].setBackground(deselectedColor);

						obtainedSum -= Integer.parseInt(numberButtons[i][j].getText());
						numberMachineGameModel.setObtainedSum(obtainedSum);
						buttonsSelected -= 1;
						numberMachineGameModel.setSelectedCellsCount(buttonsSelected);

						int index = selectedButtonsIndices.indexOf(i + " " + j);
						if (index != -1) {
							selectedButtonsIndices.remove(index);
						}
					} else {
						numberButtons[i][j].setBackground(selectedColor);
						obtainedSum += Integer.parseInt(numberButtons[i][j].getText());
						numberMachineGameModel.setObtainedSum(obtainedSum);
						buttonsSelected += 1;
						numberMachineGameModel.setSelectedCellsCount(buttonsSelected);

						selectedButtonsIndices.add(i + " " + j);

						if (numberMachineGameModel.checkSumStatus()) {
							if (numberMachineGameModel.getObtainedSum() == numberMachineGameModel.getRequiredSum()) {
								disableSelectedButtons();

								numberMachineGameModel.updateScore();
								numberMachineGameModel.updateMaxSelectedCellsCount();
								scoreField.setText(String.valueOf(numberMachineGameModel.getScore()));
								maxCellsField
										.setText(String.valueOf(numberMachineGameModel.getMaxSelectedCellsCount()));

								numberMachineGameModel.generateRequiredSum();
								int sum = numberMachineGameModel.getRequiredSum();
								sumField.setText(String.valueOf(sum));

								buttonsSelected = 0;
								obtainedSum = 0;
								numberMachineGameModel.setSelectedCellsCount(0);
								numberMachineGameModel.setObtainedSum(0);
							} else {
								enableSelectedButtons();

								numberMachineGameModel.updateScore();
								scoreField.setText(String.valueOf(numberMachineGameModel.getScore()));

								buttonsSelected = 0;
								obtainedSum = 0;
								numberMachineGameModel.setSelectedCellsCount(0);
								numberMachineGameModel.setObtainedSum(0);
							}
						}
					}

				}
			}
		}
	}
}
