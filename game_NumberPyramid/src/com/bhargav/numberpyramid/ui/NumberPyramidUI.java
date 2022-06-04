package com.bhargav.numberpyramid.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class NumberPyramidUI implements ActionListener {

	Timer timer;
	Toolkit toolkit;

	// Internal class
	class RemindTask extends TimerTask {
		int numWarningBeeps = 150;

		public void run() {
			if (numWarningBeeps > 0) {
				timerButton.setText(String.format("%03d", numWarningBeeps));
				numWarningBeeps--;
			} else {
				toolkit.beep();
				timerButton.setText("done");
				timer.cancel();

				numberPyramid.setScore(0);

				if (selectedRow != -1 && selectedColumn != -1) {
					pyramidButtons[selectedRow][selectedColumn].setBackground(Color.white);
					selectedRow = -1;
					selectedColumn = -1;
				}

				for (int i = 0; i < pyramidButtons.length; i++) {
					for (int j = 0; j < pyramidButtons[i].length; j++) {
						pyramidButtons[i][j].setEnabled(false);
					}
				}

				for (int i = 0; i < digitButtons.length; i++) {
					digitButtons[i].setEnabled(false);
				}
				clearButton.setEnabled(false);
				assignButton.setEnabled(false);

				continueButton.setEnabled(true);
				resetButton.setEnabled(false);
				changeDifficultyButton.setEnabled(true);
			}
		}
	}

	JDialog dialog;
	JPanel dialogPanelOne, dialogPanelTwo, dialogPanelThree;
	JLabel dialogLabel;
	ButtonGroup buttonGroup;
	JRadioButton easyRButton, mediumRButton, hardRButton;
	JButton dialogButton;

	String difficulty = null;
	int count = 0;
	int selectedRow = -1, selectedColumn = -1;
	int[] colums = { 1, 2, 3, 4, 5, 6, 7 };
	NumberPyramid numberPyramid = null;

	JFrame frame;
	JPanel panelOne, timerPanel, difficultyPanel, scorePanel;
	JLabel timerLabel, difficultyLabel, scoreLabel;
	JTextField difficultyField, scoreField;
	JButton timerButton;
	JPanel panelTwo, pyramidPanel, pyramidCountPanel, keysPanel, controlButtonsPanel;
	JPanel[] pyramidPanels;
	JButton[][] pyramidButtons;
	JLabel pyramidCountLabel;
	JTextField pyramidCountField;
	JButton[] digitButtons;
	JButton clearButton, assignButton;
	JButton continueButton, resetButton, changeDifficultyButton, exitButton;

	public void createDialog() {
		dialog = new JDialog();

		dialogPanelOne = new JPanel();
		dialogLabel = new JLabel("Choose difficulty level and proceed..");
		dialogPanelOne.add(dialogLabel);
		dialogPanelOne.setLayout(new FlowLayout());

		dialogPanelTwo = new JPanel();
		buttonGroup = new ButtonGroup();
		easyRButton = new JRadioButton("Easy");
		mediumRButton = new JRadioButton("Medium");
		hardRButton = new JRadioButton("Hard");
		buttonGroup.add(easyRButton);
		buttonGroup.add(mediumRButton);
		buttonGroup.add(hardRButton);
		dialogPanelTwo.add(easyRButton);
		dialogPanelTwo.add(mediumRButton);
		dialogPanelTwo.add(hardRButton);
		dialogPanelTwo.setLayout(new GridLayout(1, 3, 5, 5));

		dialogPanelThree = new JPanel();
		dialogButton = new JButton("Proceed..");
		dialogPanelThree.add(dialogButton);
		dialogPanelThree.setLayout(new FlowLayout());

		dialog.add(dialogPanelOne);
		dialog.add(dialogPanelTwo);
		dialog.add(dialogPanelThree);
		dialog.setLayout(new GridLayout(3, 1, 0, 0));
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

	public void createPyramidPanel() {
		pyramidPanel = new JPanel();
		numberPyramid.generateRows();
		int rows = numberPyramid.getRows();

		pyramidButtons = new JButton[rows][];
		pyramidPanels = new JPanel[rows];

		for (int i = 0; i < pyramidButtons.length; i++) {
			pyramidPanels[i] = new JPanel();
			pyramidButtons[i] = new JButton[i + 1];
			for (int j = 0; j < pyramidButtons[i].length; j++) {
				pyramidButtons[i][j] = new JButton(" -- ");
				pyramidButtons[i][j].setForeground(Color.black);
				pyramidPanels[i].add(pyramidButtons[i][j]);
			}

			pyramidPanels[i].setLayout(new FlowLayout());
			pyramidPanel.add(pyramidPanels[i]);
		}

		pyramidPanel.setLayout(new GridLayout(pyramidPanels.length, 1, 0, 0));
	}

	public void createPyramidCountPanel() {
		pyramidCountPanel = new JPanel();
		pyramidCountLabel = new JLabel("Pyramid #");
		pyramidCountField = new JTextField(5);
		pyramidCountField.setHorizontalAlignment(JTextField.CENTER);
		pyramidCountField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		pyramidCountField.setBackground(Color.lightGray);
		pyramidCountField.setForeground(Color.black);
		pyramidCountField.setEditable(false);

		pyramidCountPanel.add(pyramidCountLabel);
		pyramidCountPanel.add(pyramidCountField);
		pyramidCountPanel.setLayout(new GridLayout(1, 2, 2, 2));
	}

	public void createKeysPanel() {
		keysPanel = new JPanel();
		digitButtons = new JButton[10];
		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i] = new JButton(String.valueOf(i));
		}
		clearButton = new JButton("C");
		assignButton = new JButton("assign");

		for (int i = digitButtons.length - 1; i > 0; i--) {
			keysPanel.add(digitButtons[i]);
		}
		keysPanel.add(clearButton);
		keysPanel.add(digitButtons[0]);
		keysPanel.add(assignButton);

		keysPanel.setLayout(new GridLayout(4, 3, 1, 1));
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
		createPyramidPanel();
		createPyramidCountPanel();
		createKeysPanel();

		panelTwo.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 6;
		gbc.gridwidth = 2;
		panelTwo.add(pyramidPanel, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		panelTwo.add(pyramidCountPanel, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridheight = 3;
		gbc.gridwidth = 1;
		panelTwo.add(keysPanel, gbc);
	}

	public void createFrame() {
		frame = new JFrame("Number Pyramid..");
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
		gbc.gridheight = 1;
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

		for (int i = 0; i < pyramidButtons.length; i++) {
			for (int j = 0; j < pyramidButtons[i].length; j++) {
				pyramidButtons[i][j].addActionListener(this);
			}
		}

		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i].addActionListener(this);
		}
		clearButton.addActionListener(this);
		assignButton.addActionListener(this);
	}

	public void setInitialRestrictions() {
		count = 0;
		selectedRow = -1;
		selectedColumn = -1;

		if (selectedRow != -1 && selectedColumn != -1) {
			pyramidButtons[selectedRow][selectedColumn].setBackground(Color.white);
			selectedRow = -1;
			selectedColumn = -1;
		}

		numberPyramid.setScore(0);

		timerButton.setText("Start");
		difficultyField.setText(numberPyramid.getDifficulty());
		scoreField.setText("--");
		pyramidCountField.setText("--");

		timerButton.setEnabled(true);
		continueButton.setEnabled(false);
		resetButton.setEnabled(false);
		changeDifficultyButton.setEnabled(true);
		exitButton.setEnabled(true);

		for (int i = 0; i < pyramidButtons.length; i++) {
			for (int j = 0; j < pyramidButtons[i].length; j++) {
				pyramidButtons[i][j].setText("--");
				pyramidButtons[i][j].setEnabled(false);
			}
		}

		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i].setEnabled(false);
		}
		clearButton.setEnabled(false);
		assignButton.setEnabled(false);
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

	public static void main(String[] args) {
		NumberPyramidUI buttonPyramid = new NumberPyramidUI();
		buttonPyramid.startDialogPhase();
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
		} else if (object == assignButton) {
			actionOfAssignButton();
		} else {
			actionOfDigitButtons(object);
			actionOfPyramidButtons(object);
		}
	}

	public void actionOfDialogButton() {
		if (easyRButton.isSelected() || mediumRButton.isSelected() || hardRButton.isSelected()) {
			numberPyramid = new NumberPyramid();
			if (easyRButton.isSelected()) {
				difficulty = "easy";
			} else if (mediumRButton.isSelected()) {
				difficulty = "medium";
			} else {
				difficulty = "hard";
			}
			numberPyramid.setDifficulty(difficulty);
			dialog.setVisible(false);
			dialog.dispose();

			startFramePhase();
		} else {
			JOptionPane.showMessageDialog(dialog, "Please choose a difficulty level to proceed..");
			dialog.setVisible(true);
		}
	}

	public void displayPyramid() {
		count += 1;
		pyramidCountField.setText(String.valueOf(count));

		numberPyramid.generateNumbers();
		int[][] numbers = numberPyramid.getNumbers();
		numberPyramid.decideVisibility();
		boolean[][] visible = numberPyramid.getVisible();

		for (int i = 0; i < pyramidButtons.length; i++) {
			for (int j = 0; j < pyramidButtons[i].length; j++) {
				if (visible[i][j]) {
					pyramidButtons[i][j].setText(String.valueOf(numbers[i][j]));
					pyramidButtons[i][j].setBackground(Color.lightGray);
					pyramidButtons[i][j].setForeground(Color.black);
					pyramidButtons[i][j].setEnabled(false);
				} else {
					pyramidButtons[i][j].setText("  ");
					pyramidButtons[i][j].setBackground(Color.white);
					pyramidButtons[i][j].setForeground(Color.black);
					pyramidButtons[i][j].setEnabled(true);
				}
			}
		}
	}

	public void actionOfTimerButton() {
		timerButton.setEnabled(false);
		continueButton.setEnabled(false);
		changeDifficultyButton.setEnabled(false);
		resetButton.setEnabled(true);

		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i].setEnabled(true);
		}
		clearButton.setEnabled(true);
		assignButton.setEnabled(true);

		scoreField.setText("0");

		displayPyramid();

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
		if (selectedRow >= 0 && selectedColumn >= 0) {
			pyramidButtons[selectedRow][selectedColumn].setText("  ");
		}
	}

	public void actionOfAssignButton() {
		boolean filled = true;
		boolean matched = false;
		int[][] provided = new int[numberPyramid.getRows()][];

		for (int i = 0; i < pyramidButtons.length; i++) {
			provided[i] = new int[i + 1];
			for (int j = 0; j < pyramidButtons[i].length; j++) {
				String text = pyramidButtons[i][j].getText().trim();
				if (text == "") {
					filled = false;
					break;
				} else {
					provided[i][j] = Integer.parseInt(text);
				}
			}
		}

		if (filled) {
			matched = numberPyramid.isMatched(provided);

			if (matched) {
				numberPyramid.updateScore(provided);
				scoreField.setText(String.valueOf(numberPyramid.getScore()));

				pyramidButtons[selectedRow][selectedColumn].setBackground(Color.white);
				selectedRow = -1;
				selectedColumn = -1;

				displayPyramid();
			} else {
				JOptionPane.showMessageDialog(frame, "Oops! It is a Wrong Pyramid.Try again..");
			}
		}
	}

	public void actionOfDigitButtons(Object object) {
		if (selectedRow >= 0 && selectedColumn >= 0) {
			for (int i = 0; i < digitButtons.length; i++) {
				if (object == digitButtons[i]) {
					String text = pyramidButtons[selectedRow][selectedColumn].getText().trim();
					if (text == "") {
						pyramidButtons[selectedRow][selectedColumn].setText(String.valueOf(i));
					} else {
						int value = (Integer.parseInt(text) * 10) + i;
						pyramidButtons[selectedRow][selectedColumn].setText(String.valueOf(value));
					}
				}
			}
		}
	}

	public void actionOfPyramidButtons(Object object) {
		for (int i = 0; i < pyramidButtons.length; i++) {
			for (int j = 0; j < pyramidButtons[i].length; j++) {
				if (object == pyramidButtons[i][j]) {
					if (selectedRow != -1 && selectedColumn != -1) {
						pyramidButtons[selectedRow][selectedColumn].setBackground(Color.white);
					}

					selectedRow = i;
					selectedColumn = j;
					pyramidButtons[selectedRow][selectedColumn].setBackground(Color.blue);
				}
			}
		}
	}
}
