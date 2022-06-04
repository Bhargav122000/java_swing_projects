// View class
package com.bhargav.colorswords.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class ColorsAndWordsUI extends WindowAdapter implements ActionListener {

	// Internal class
	class RemindTask extends TimerTask {
		int numWarningBeeps = 60;

		public void run() {
			if (numWarningBeeps > 0) {
				timerButton.setText(String.format("%02d", numWarningBeeps));
				numWarningBeeps--;
			} else {
				toolkit.beep();
				timerButton.setText("Time's up!");
				timer.cancel();

				continueButton.setEnabled(true);
				resetButton.setEnabled(false);
				if (difficulty.equals("easy")) {
					for (int i = 0; i < easyLevelButtons.length; i++) {
						easyLevelButtons[i].setEnabled(false);
					}
				} else if (difficulty.equals("medium")) {
					for (int i = 0; i < mediumLevelButtons.length; i++) {
						mediumLevelButtons[i].setEnabled(false);
					}
				} else if (difficulty.equals("hard")) {
					for (int i = 0; i < hardLevelButtons.length; i++) {
						hardLevelButtons[i].setEnabled(false);
					}
				}
			}
		}
	}

	String difficulty = null;
	int score = 0;

	ColorsAndWords colorsAndWords = null;

	Toolkit toolkit;
	Timer timer;

	JDialog dialog;
	JPanel dialogPanelOne, dialogPanelTwo, dialogPanelThree;
	JLabel dialogLabel;
	ButtonGroup dialogButtonGroup;
	JRadioButton dialogEasyRButton, dialogMediumRButton, dialogHardRButton;
	JButton dialogButton;
	JFrame frame;
	JPanel firstPanel;
	JLabel timerLabel, scoreLabel;
	JButton timerButton, continueButton, resetButton, exitButton;
	JTextField scoreField;
	JPanel secondPanel;
	JTextField wordField;
	JPanel thirdPanel;
	JPanel easyLevelPanel, mediumLevelPanel, hardLevelPanel;
	JButton[] easyLevelButtons, mediumLevelButtons, hardLevelButtons;

	public void initializeDialogComponents() {
		dialog = new JDialog(frame, "Difficulty Level selection", true);

		dialogPanelOne = new JPanel();
		dialogLabel = new JLabel("select difficulty level");

		dialogPanelTwo = new JPanel();
		dialogButtonGroup = new ButtonGroup();
		dialogEasyRButton = new JRadioButton("easy level");
		dialogMediumRButton = new JRadioButton("medium level");
		dialogHardRButton = new JRadioButton("hard level");

		dialogPanelThree = new JPanel();
		dialogButton = new JButton("proceed");
	}

	public void addDialogComponents() {
		dialogPanelOne.add(dialogLabel);
		dialogPanelOne.setLayout(new FlowLayout());

		dialogButtonGroup.add(dialogEasyRButton);
		dialogButtonGroup.add(dialogMediumRButton);
		dialogButtonGroup.add(dialogHardRButton);
		dialogPanelTwo.add(dialogEasyRButton);
		dialogPanelTwo.add(dialogMediumRButton);
		dialogPanelTwo.add(dialogHardRButton);
		dialogPanelTwo.setLayout(new FlowLayout());

		dialogPanelThree.add(dialogButton);
		dialogPanelThree.setLayout(new FlowLayout());

		dialog.add(dialogPanelOne);
		dialog.add(dialogPanelTwo);
		dialog.add(dialogPanelThree);
		dialog.setLayout(new GridLayout(3, 1, 2, 2));
	}

	public void addListenersToDialogComponents() {
		dialog.addWindowListener(this);
		dialogButton.addActionListener(this);
	}

	public void createDialog() {
		initializeDialogComponents();
		addDialogComponents();
		addListenersToDialogComponents();
	}

	public void displayDialog() {
		dialog.pack();
		dialog.setVisible(true);
	}

	public void createFirstPanel() {
		firstPanel = new JPanel();
		timerLabel = new JLabel("Timer");
		scoreLabel = new JLabel("Score");
		scoreField = new JTextField(5);
		scoreField.setEditable(false);
		timerButton = new JButton("Start Timer");
		continueButton = new JButton("Play Again");
		resetButton = new JButton("Reset Play");
		exitButton = new JButton("Exit Game");

		firstPanel.add(timerLabel);
		firstPanel.add(timerButton);
		firstPanel.add(scoreLabel);
		firstPanel.add(scoreField);
		firstPanel.add(continueButton);
		firstPanel.add(resetButton);
		firstPanel.add(exitButton);
		firstPanel.setLayout(new GridLayout(4, 2, 2, 2));
	}

	public void createSecondPanel() {
		secondPanel = new JPanel();
		wordField = new JTextField("	", 5);
		wordField.setEditable(false);
		wordField.setHorizontalAlignment(JTextField.CENTER);
		wordField.setBackground(new Color(220, 220, 220));
		wordField.setFont(new Font("Times New Roman", Font.BOLD, 60));

		secondPanel.add(wordField);
		secondPanel.setLayout(new FlowLayout());
	}

	public void createEasyLevelPanel() {
		easyLevelPanel = new JPanel();
		easyLevelButtons = new JButton[4];
		for (int i = 0; i < easyLevelButtons.length; i++) {
			easyLevelButtons[i] = new JButton("  .  ");
			easyLevelPanel.add(easyLevelButtons[i]);
		}
		easyLevelPanel.setLayout(new GridLayout(2, 2, 4, 4));
	}

	public void createMediumLevelPanel() {
		mediumLevelPanel = new JPanel();
		mediumLevelButtons = new JButton[6];
		for (int i = 0; i < mediumLevelButtons.length; i++) {
			mediumLevelButtons[i] = new JButton("  .  ");
			mediumLevelPanel.add(mediumLevelButtons[i]);
		}
		mediumLevelPanel.setLayout(new GridLayout(2, 3, 4, 4));
	}

	public void createHardLevelPanel() {
		hardLevelPanel = new JPanel();
		hardLevelButtons = new JButton[9];
		for (int i = 0; i < hardLevelButtons.length; i++) {
			hardLevelButtons[i] = new JButton("  .  ");
			hardLevelPanel.add(hardLevelButtons[i]);
		}
		hardLevelPanel.setLayout(new GridLayout(3, 3, 4, 4));
	}

	public void createThirdPanel() {
		thirdPanel = new JPanel();
		if (difficulty.equals("easy")) {
			createEasyLevelPanel();
			thirdPanel.add(easyLevelPanel);
		} else if (difficulty.equals("medium")) {
			createMediumLevelPanel();
			thirdPanel.add(mediumLevelPanel);
		} else if (difficulty.equals("hard")) {
			createHardLevelPanel();
			thirdPanel.add(hardLevelPanel);
		}

		thirdPanel.setLayout(new FlowLayout());
	}

	public void createFrame() {
		frame = new JFrame("cOLOrs n WorDS");
		createFirstPanel();
		createSecondPanel();
		createThirdPanel();

		frame.add(firstPanel);
		frame.add(secondPanel);
		frame.add(thirdPanel);
		frame.setLayout(new GridLayout(1, 3, 5, 5));
	}

	public void addListenersToFrameComponents() {
		frame.addWindowListener(this);
		timerButton.addActionListener(this);
		continueButton.addActionListener(this);
		resetButton.addActionListener(this);
		exitButton.addActionListener(this);

		if (difficulty.equals("easy")) {
			for (int i = 0; i < easyLevelButtons.length; i++) {
				easyLevelButtons[i].addActionListener(this);
			}
		} else if (difficulty.equals("medium")) {
			for (int i = 0; i < mediumLevelButtons.length; i++) {
				mediumLevelButtons[i].addActionListener(this);
			}
		} else if (difficulty.equals("hard")) {
			for (int i = 0; i < hardLevelButtons.length; i++) {
				hardLevelButtons[i].addActionListener(this);
			}
		}
	}

	public void setInitialRestrictions() {
		score = 0;
		scoreField.setText("---");
		timerButton.setEnabled(true);
		continueButton.setEnabled(false);
		resetButton.setEnabled(false);

		if (difficulty.equals("easy")) {
			for (int i = 0; i < easyLevelButtons.length; i++) {
				easyLevelButtons[i].setEnabled(false);
			}
		} else if (difficulty.equals("medium")) {
			for (int i = 0; i < mediumLevelButtons.length; i++) {
				mediumLevelButtons[i].setEnabled(false);
			}
		} else if (difficulty.equals("hard")) {
			for (int i = 0; i < hardLevelButtons.length; i++) {
				hardLevelButtons[i].setEnabled(false);
			}
		}
	}

	public void displayFrame() {
		frame.pack();
		frame.setVisible(true);
	}

	public void startGame() {
		createFrame();
		addListenersToFrameComponents();
		setInitialRestrictions();
		displayFrame();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		if (object == dialogButton) {
			actionOfDialogButton();
		} else if (object == exitButton) {
			actionOfExitButton();
		} else if (object == continueButton) {
			actionOfContinueButton();
		} else if (object == resetButton) {
			actionOfResetButton();
		} else if (object == timerButton) {
			actionOfTimerButton();
		} else {
			if (difficulty.equals("easy")) {
				actionOfEasyLevelButtons(object);
			} else if (difficulty.equals("medium")) {
				actionOfMediumLevelButtons(object);
			} else if (difficulty.equals("hard")) {
				actionOfHardLevelButtons(object);
			}
		}
	}

	public void actionOfDialogButton() {
		if (dialogEasyRButton.isSelected() || dialogMediumRButton.isSelected() || dialogHardRButton.isSelected()) {
			if (dialogEasyRButton.isSelected()) {
				difficulty = "easy";
				colorsAndWords = new ColorsAndWords(4);
			} else if (dialogMediumRButton.isSelected()) {
				difficulty = "medium";
				colorsAndWords = new ColorsAndWords(6);
			} else {
				difficulty = "hard";
				colorsAndWords = new ColorsAndWords(9);
			}
			dialog.setVisible(false);
			dialog.dispose();
			startGame();
		} else {
			JOptionPane.showMessageDialog(dialog, "Please choose a size to proceed");
			System.out.println("not selected");
		}
	}

	public void actionOfExitButton() {
		int response = JOptionPane.showConfirmDialog(frame, "Are you sure to exit?");
		if (response == JOptionPane.YES_OPTION) {
			if (timer != null) {
				timer.cancel();
			}
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.dispose();
		}
	}

	public void actionOfContinueButton() {
		difficulty = null;
		frame.dispose();
		createDialog();
		displayDialog();
	}

	public void actionOfResetButton() {
		timer.cancel();
		difficulty = null;
		frame.dispose();
		createDialog();
		displayDialog();
	}

	public void updateWordAndColors() {
		colorsAndWords.generateWord();
		wordField.setText(colorsAndWords.getWord());
		wordField.setForeground(colorsAndWords.getWordColor());

		colorsAndWords.generateColorOptions();
		Color[] colors = colorsAndWords.getColorOptions();
		if (difficulty.equals("easy")) {
			for (int i = 0; i < easyLevelButtons.length; i++) {
				easyLevelButtons[i].setBackground(colors[i]);
				easyLevelButtons[i].setForeground(colors[i]);
			}
		} else if (difficulty.equals("medium")) {
			for (int i = 0; i < mediumLevelButtons.length; i++) {
				mediumLevelButtons[i].setBackground(colors[i]);
				mediumLevelButtons[i].setForeground(colors[i]);
			}
		} else if (difficulty.equals("hard")) {
			for (int i = 0; i < hardLevelButtons.length; i++) {
				hardLevelButtons[i].setBackground(colors[i]);
				hardLevelButtons[i].setForeground(colors[i]);
			}
		}
	}

	public void actionOfTimerButton() {
		scoreField.setText("0");
		timerButton.setEnabled(false);
		continueButton.setEnabled(false);
		resetButton.setEnabled(true);

		if (difficulty.equals("easy")) {
			for (int i = 0; i < easyLevelButtons.length; i++) {
				easyLevelButtons[i].setEnabled(true);
			}
		} else if (difficulty.equals("medium")) {
			for (int i = 0; i < mediumLevelButtons.length; i++) {
				mediumLevelButtons[i].setEnabled(true);
			}
		} else if (difficulty.equals("hard")) {
			for (int i = 0; i < hardLevelButtons.length; i++) {
				hardLevelButtons[i].setEnabled(true);
			}
		}

		updateWordAndColors();

		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new RemindTask(), 0, 1 * 1000);
	}

	public void actionOfEasyLevelButtons(Object object) {
		for (int i = 0; i < easyLevelButtons.length; i++) {
			if (object == easyLevelButtons[i]) {
				if (colorsAndWords.isMatched(easyLevelButtons[i].getBackground())) {
					score += 50;
				} else {
					score -= 100;
				}
				scoreField.setText(String.valueOf(score));
				updateWordAndColors();
			}
		}
	}

	public void actionOfMediumLevelButtons(Object object) {
		for (int i = 0; i < mediumLevelButtons.length; i++) {
			if (object == mediumLevelButtons[i]) {
				if (colorsAndWords.isMatched(mediumLevelButtons[i].getBackground())) {
					score += 50;
				} else {
					score -= 100;
				}
				scoreField.setText(String.valueOf(score));
				updateWordAndColors();
			}
		}
	}

	public void actionOfHardLevelButtons(Object object) {
		for (int i = 0; i < hardLevelButtons.length; i++) {
			if (object == hardLevelButtons[i]) {
				if (colorsAndWords.isMatched(hardLevelButtons[i].getBackground())) {
					score += 50;
				} else {
					score -= 100;
				}
				scoreField.setText(String.valueOf(score));
				updateWordAndColors();
			}
		}
	}
}
