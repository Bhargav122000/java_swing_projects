package com.bhargav.remembersquare.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class RememberSquareUI implements ActionListener {

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

				for (int i = 0; i < boardButtons.length; i++) {
					boardButtons[i].setBackground(Color.white);
					boardButtons[i].setForeground(Color.white);
					boardButtons[i].setEnabled(true);
				}

				runProgressBar();
			}
		}
	}

	RememberSquare rememberSquare = null;
	boolean isValidAttempt;
	boolean isResetClicked;

	JFrame frame;
	JPanel panelOne, scorePanel, levelPanel, controlButtonsPanel;
	JLabel scoreLabel, levelLabel;
	JTextField scoreField, levelField;
	JButton nextButton, continueButton, resetButton, exitButton;
	JPanel panelTwo, timerPanel, progressPanel, countDownPanel, dynamicPanel, boardPanel;
	JLabel timerLabel, progressLabel;
	JTextField timerField;
	JProgressBar progressBar;
	JButton[] boardButtons;

	public void createScorePanel() {
		scorePanel = new JPanel();
		scoreLabel = new JLabel("Score");
		scoreField = new JTextField(5);
		scoreField.setHorizontalAlignment(JTextField.CENTER);
		scoreField.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		scoreField.setBackground(Color.lightGray);
		scoreField.setForeground(Color.black);
		scoreField.setEditable(false);

		scorePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		scorePanel.add(scoreLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		scorePanel.add(scoreField, gbc);
	}

	public void createLevelPanel() {
		levelPanel = new JPanel();
		levelLabel = new JLabel("Level");
		levelField = new JTextField(5);
		levelField.setHorizontalAlignment(JTextField.CENTER);
		levelField.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		levelField.setBackground(Color.lightGray);
		levelField.setForeground(Color.black);
		levelField.setEditable(false);

		levelPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		levelPanel.add(levelLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		levelPanel.add(levelField, gbc);
	}

	public void createControlButtonsPanel() {
		controlButtonsPanel = new JPanel();
		exitButton = new JButton("Exit");
		resetButton = new JButton("Reset");
		continueButton = new JButton("Continue");
		nextButton = new JButton("Next..");

		controlButtonsPanel.add(continueButton);
		controlButtonsPanel.add(exitButton);
		controlButtonsPanel.add(resetButton);
		controlButtonsPanel.add(nextButton);
		controlButtonsPanel.setLayout(new GridLayout(2, 2, 2, 2));
	}

	public void createTimerPanel() {
		timerPanel = new JPanel();
		timerLabel = new JLabel("Timer");
		timerField = new JTextField(5);
		timerField.setHorizontalAlignment(JTextField.CENTER);
		timerField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		timerField.setBackground(Color.lightGray);
		timerField.setForeground(Color.red);
		timerField.setEditable(false);

		timerPanel.add(timerLabel);
		timerPanel.add(timerField);
		timerPanel.setLayout(new FlowLayout());
	}

	public void createProgressPanel() {
		progressPanel = new JPanel();
		progressLabel = new JLabel("Countdown");
		progressBar = new JProgressBar(0, 1000);
		progressBar.setValue(0);
		progressBar.setForeground(Color.darkGray);
		progressBar.setBackground(Color.green);
		progressBar.setStringPainted(false);

		progressPanel.add(progressLabel);
		progressPanel.add(progressBar);
		progressPanel.setLayout(new FlowLayout());
	}

	public void createCountDownPanel() {
		countDownPanel = new JPanel();
		createTimerPanel();
		createProgressPanel();

		countDownPanel.add(timerPanel);
		countDownPanel.add(progressPanel);
		countDownPanel.setLayout(new GridLayout(2, 1, 10, 10));
	}

	public void createDynamicPanel(int cells, int rows, int cols) {
		if (dynamicPanel == null) {
			dynamicPanel = new JPanel();
		}

		if (rows > 0 && cols > 0) {
			removeListenersToBoardButtons();
			dynamicPanel.removeAll();

			boardButtons = new JButton[cells];
			ArrayList<Integer> highlightedCells = rememberSquare.getHighlightedCellsIndices();
			for (int i = 0; i < boardButtons.length; i++) {
				boardButtons[i] = new JButton("  .  ");
				if (highlightedCells.indexOf(i) != -1) {
					boardButtons[i].setBackground(Color.red);
					boardButtons[i].setForeground(Color.red);
				} else {
					boardButtons[i].setForeground(Color.white);
					boardButtons[i].setBackground(Color.white);
				}
				boardButtons[i].setBorder(BorderFactory.createLineBorder(new Color(76, 52, 26), 2, false));
				// boardButtons[i].setBorderPainted(true);
				dynamicPanel.add(boardButtons[i]);
			}
			addListenersToBoardButtons();
			dynamicPanel.setLayout(new GridLayout(rows, cols, 2, 2));
		}
	}

	public void createBoardPanel() {
		boardPanel = new JPanel();
		createDynamicPanel(0, 0, 0);

		boardPanel.add(dynamicPanel);
		boardPanel.setLayout(new FlowLayout());
	}

	public void createPanelOne() {
		panelOne = new JPanel();
		createScorePanel();
		createLevelPanel();
		createControlButtonsPanel();

		panelOne.add(scorePanel);
		panelOne.add(levelPanel);
		panelOne.add(controlButtonsPanel);
		panelOne.setLayout(new GridLayout(1, 2, 5, 5));
	}

	public void createPanelTwo() {
		panelTwo = new JPanel();
		createCountDownPanel();
		createBoardPanel();

		panelTwo.add(countDownPanel);
		panelTwo.add(boardPanel);
		panelTwo.setLayout(new GridLayout(1, 2, 5, 5));
	}

	public void createFrame() {
		frame = new JFrame("View Sample..");
		createPanelOne();
		createPanelTwo();

		frame.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		frame.add(panelOne, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		frame.add(panelTwo, gbc);
	}

	public void addListenersToBoardButtons() {
		if (boardButtons != null) {
			for (int i = 0; i < boardButtons.length; i++) {
				boardButtons[i].addActionListener(this);
			}
		}
	}

	public void removeListenersToBoardButtons() {
		if (boardButtons != null) {
			for (int i = 0; i < boardButtons.length; i++) {
				boardButtons[i].removeActionListener(this);
			}
		}
	}

	public void addListeners() {
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		exitButton.addActionListener(this);
		resetButton.addActionListener(this);
		continueButton.addActionListener(this);
		nextButton.addActionListener(this);
		addListenersToBoardButtons();
	}

	public void setInitialRestrictions(int score, int level) {
		scoreField.setText(String.valueOf(score));
		levelField.setText(String.valueOf(level));

		nextButton.setEnabled(false);
		continueButton.setEnabled(false);
		exitButton.setEnabled(true);
		resetButton.setEnabled(true);

		timerPanel.setVisible(true);
		progressPanel.setVisible(false);

		if (boardButtons != null) {
			for (int i = 0; i < boardButtons.length; i++) {
				boardButtons[i].setEnabled(false);
			}
		}
	}

	public void startTimer() {
		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new RemindTask(), 0, 1 * 1000);
	}

	public void runProgressBar() {
		int i = 0;
		isValidAttempt = true;
		isResetClicked = false;

		while (i <= 1000 && !isResetClicked && isValidAttempt && !rememberSquare.isTotallyMatched()) {
			progressBar.setValue(i);
			i = i + 50;
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println("exception.. in progress bar iteration");
			}
		}

		timerPanel.setVisible(true);
		for (i = 0; i < boardButtons.length; i++) {
			boardButtons[i].setEnabled(false);
		}

		if (!isResetClicked) {
			if (rememberSquare.isTotallyMatched()) {
				String str = "Hurrah!! You cleared level-" + rememberSquare.getLevel() + ".. :)";
				JOptionPane.showMessageDialog(frame, str);
				nextButton.setEnabled(true);
				rememberSquare.updateScore();
				int score = rememberSquare.getScore();
				scoreField.setText(String.valueOf(score));
			} else {
				String str = "Ooops!! You failed in level-" + rememberSquare.getLevel() + ". Game OVER.. :(";
				JOptionPane.showMessageDialog(frame, str);
				continueButton.setEnabled(true);
				resetButton.setEnabled(false);
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
		setInitialRestrictions(0, 0);
		displayFrame();

		rememberSquare = new RememberSquare();
		rememberSquare.generateNow();
		int cells = rememberSquare.getCells();
		int rows = rememberSquare.getRows();
		int cols = rememberSquare.getCols();
		createDynamicPanel(cells, rows, cols);

		int level = rememberSquare.getLevel();
		int score = rememberSquare.getScore();
		setInitialRestrictions(score, level);

		displayFrame();
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
		} else if (object == nextButton) {
			actionOfNextButton();
		} else {
			actionOfBoardButtons(object);
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

			rememberSquare.setScore(0);
			rememberSquare.setLevel(0);
			rememberSquare.setCells(0);
			rememberSquare.setRows(0);
			rememberSquare.setCols(0);

			rememberSquare.generateNow();
			int cells = rememberSquare.getCells();
			int rows = rememberSquare.getRows();
			int cols = rememberSquare.getCols();
			createDynamicPanel(cells, rows, cols);

			int level = rememberSquare.getLevel();
			int score = rememberSquare.getScore();
			setInitialRestrictions(score, level);

			displayFrame();
			startTimer();
		}
	}

	public void actionOfContinueButton() {
		rememberSquare.setScore(0);
		rememberSquare.setLevel(0);
		rememberSquare.setCells(0);
		rememberSquare.setRows(0);
		rememberSquare.setCols(0);

		rememberSquare.generateNow();
		int cells = rememberSquare.getCells();
		int rows = rememberSquare.getRows();
		int cols = rememberSquare.getCols();
		createDynamicPanel(cells, rows, cols);

		int level = rememberSquare.getLevel();
		int score = rememberSquare.getScore();
		setInitialRestrictions(score, level);

		displayFrame();
		startTimer();
	}

	public void actionOfNextButton() {
		rememberSquare.generateNow();
		int cells = rememberSquare.getCells();
		int rows = rememberSquare.getRows();
		int cols = rememberSquare.getCols();
		createDynamicPanel(cells, rows, cols);

		int level = rememberSquare.getLevel();
		int score = rememberSquare.getScore();
		setInitialRestrictions(score, level);

		displayFrame();
		startTimer();
	}

	public void actionOfBoardButtons(Object object) {
		for (int i = 0; i < boardButtons.length; i++) {
			if (object == boardButtons[i]) {
				isValidAttempt = rememberSquare.isValidAttempt(i);
				if (isValidAttempt) {
					boardButtons[i].setBackground(Color.red);
					boardButtons[i].setForeground(Color.red);
					boardButtons[i].setEnabled(false);
				} else {
					for (int j = 0; j < boardButtons.length; j++) {
						boardButtons[j].setEnabled(false);
					}
					boardButtons[i].setBackground(Color.black);
					boardButtons[i].setForeground(Color.black);
				}
			}
		}
	}
}
