package com.bhargav.greaterorlesser.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class GreaterOrLesserUI implements ActionListener {

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

				greaterOrLesserModel.setScore(0);

				trueButton.setEnabled(false);
				falseButton.setEnabled(false);
				continueButton.setEnabled(true);
				resetButton.setEnabled(false);
				changeLevelButton.setEnabled(true);
			}
		}
	}

	GreaterOrLesserModel greaterOrLesserModel = null;

	JDialog dialog;
	JPanel dialogPanelOne, dialogPanelTwo, dialogPanelThree;
	JLabel dialogLabel;
	ButtonGroup dialogButtonGroup;
	JRadioButton dialogEasyRButton, dialogMediumRButton, dialogHardRButton;
	JButton dialogButton;

	JFrame frame;
	JPanel panelOne, timerPanel, scorePanel, controlButtonsPanel;
	JLabel timerLabel, scoreLabel;
	JTextField scoreField;
	JButton timerButton, continueButton, resetButton, changeLevelButton, exitButton;
	JPanel panelTwo, expressionPanel, optionsPanel;
	JTextField expressionField;
	JTextField levelField;
	JButton trueButton, falseButton;

	public void createDialogPanelOne() {
		dialogPanelOne = new JPanel();
		dialogLabel = new JLabel("Choose a Difficulty Level..");

		dialogPanelOne.add(dialogLabel);
		dialogPanelOne.setLayout(new FlowLayout());
	}

	public void createDialogPanelTwo() {
		dialogPanelTwo = new JPanel();
		dialogButtonGroup = new ButtonGroup();
		dialogEasyRButton = new JRadioButton("Easy");
		dialogMediumRButton = new JRadioButton("Medium");
		dialogHardRButton = new JRadioButton("Hard");

		dialogButtonGroup.add(dialogEasyRButton);
		dialogButtonGroup.add(dialogMediumRButton);
		dialogButtonGroup.add(dialogHardRButton);
		dialogPanelTwo.add(dialogEasyRButton);
		dialogPanelTwo.add(dialogMediumRButton);
		dialogPanelTwo.add(dialogHardRButton);
		dialogPanelTwo.setLayout(new GridLayout(1, 3, 2, 2));
	}

	public void createDialogPanelThree() {
		dialogPanelThree = new JPanel();
		dialogButton = new JButton("proceed..");

		dialogPanelThree.add(dialogButton);
		dialogPanelThree.setLayout(new FlowLayout());
	}

	public void createDialog() {
		dialog = new JDialog();
		createDialogPanelOne();
		createDialogPanelTwo();
		createDialogPanelThree();

		dialog.add(dialogPanelOne);
		dialog.add(dialogPanelTwo);
		dialog.add(dialogPanelThree);
		dialog.setLayout(new GridLayout(3, 1, 2, 2));
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
		scoreField.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		scoreField.setBackground(Color.lightGray);

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
		continueButton = new JButton("Continue Play");
		resetButton = new JButton("Reset Play");
		changeLevelButton = new JButton("Change Level");
		exitButton = new JButton("Exit Game");

		controlButtonsPanel.add(continueButton);
		controlButtonsPanel.add(resetButton);
		controlButtonsPanel.add(changeLevelButton);
		controlButtonsPanel.add(exitButton);
		controlButtonsPanel.setLayout(new GridLayout(4, 1, 5, 5));
	}

	public void createPanelOne() {
		panelOne = new JPanel();
		createTimerPanel();
		createScorePanel();
		createControlButtonsPanel();

		panelOne.add(timerPanel);
		panelOne.add(scorePanel);
		panelOne.add(controlButtonsPanel);
		panelOne.setLayout(new GridLayout(1, 3, 5, 5));
	}

	public void createExpressionPanel() {
		expressionPanel = new JPanel();
		expressionField = new JTextField("	", 8);
		expressionField.setHorizontalAlignment(JTextField.CENTER);
		expressionField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		expressionField.setBackground(Color.lightGray);
		expressionField.setEditable(false);

		expressionPanel.add(expressionField);
		expressionPanel.setLayout(new GridLayout(1, 1, 10, 10));
	}

	public void createOptionsPanel() {
		optionsPanel = new JPanel();
		levelField = new JTextField(greaterOrLesserModel.getLevel() + " level");
		levelField.setHorizontalAlignment(JTextField.CENTER);
		levelField.setFont(new Font("ARIAL BLACK", Font.PLAIN, 20));
		levelField.setBackground(Color.lightGray);
		levelField.setEditable(false);
		trueButton = new JButton("True");
		trueButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		trueButton.setBackground(Color.green);
		falseButton = new JButton("False");
		falseButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		falseButton.setBackground(Color.red);

		optionsPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		optionsPanel.add(levelField, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		optionsPanel.add(trueButton, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		optionsPanel.add(falseButton, gbc);
	}

	public void createPanelTwo() {
		panelTwo = new JPanel();
		createExpressionPanel();
		createOptionsPanel();

		panelTwo.add(expressionPanel);
		panelTwo.add(optionsPanel);
		panelTwo.setLayout(new GridLayout(1, 2, 5, 5));
	}

	public void createFrame() {
		frame = new JFrame("Greater Or Lesser Game");
		createPanelOne();
		createPanelTwo();

		frame.add(panelOne);
		frame.add(panelTwo);
		frame.setLayout(new GridLayout(2, 1, 10, 10));
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
		changeLevelButton.addActionListener(this);
		exitButton.addActionListener(this);
		trueButton.addActionListener(this);
		falseButton.addActionListener(this);
	}

	public void setInitialRestrictions() {
		greaterOrLesserModel.setScore(0);
		
		timerButton.setText("Start");
		scoreField.setText("	");
		expressionField.setText("	");

		timerButton.setEnabled(true);
		trueButton.setEnabled(false);
		falseButton.setEnabled(false);
		continueButton.setEnabled(false);
		resetButton.setEnabled(true);
		changeLevelButton.setEnabled(true);
		exitButton.setEnabled(true);
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
		} else if (object == changeLevelButton) {
			actionOfChangeLevelButton();
		} else if (object == exitButton) {
			actionOfExitButton();
		} else {
			actionOfTrueFalseButtons(object);
		}
	}

	public void actionOfDialogButton() {
		if (greaterOrLesserModel == null) {
			greaterOrLesserModel = new GreaterOrLesserModel();
		}

		if (dialogEasyRButton.isSelected()) {
			greaterOrLesserModel.setLevel("easy");
			startFramePhase();
			dialog.setVisible(false);
			dialog.removeAll();
			dialog.dispose();
		} else if (dialogMediumRButton.isSelected()) {
			greaterOrLesserModel.setLevel("medium");
			startFramePhase();
			dialog.setVisible(false);
			dialog.removeAll();
			dialog.dispose();
		} else if (dialogHardRButton.isSelected()) {
			greaterOrLesserModel.setLevel("hard");
			startFramePhase();
			dialog.setVisible(false);
			dialog.removeAll();
			dialog.dispose();
		} else {
			JOptionPane.showMessageDialog(dialog, "Please choose a Level to proceed..");
		}
	}

	public void actionOfTimerButton() {
		scoreField.setText("0");
		timerButton.setEnabled(false);
		continueButton.setEnabled(false);
		resetButton.setEnabled(true);
		changeLevelButton.setEnabled(false);
		trueButton.setEnabled(true);
		falseButton.setEnabled(true);

		greaterOrLesserModel.generateExpressionAndEvaluate();
		String expression = greaterOrLesserModel.getExpression();
		expressionField.setText(expression);

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

	public void actionOfChangeLevelButton() {
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

	public void actionOfTrueFalseButtons(Object object) {
		if (object == trueButton) {
			greaterOrLesserModel.setExpectedResult(true);
		} else {
			greaterOrLesserModel.setExpectedResult(false);
		}

		greaterOrLesserModel.updateScore();
		int score = greaterOrLesserModel.getScore();
		scoreField.setText(String.valueOf(score));

		greaterOrLesserModel.generateExpressionAndEvaluate();
		String expression = greaterOrLesserModel.getExpression();
		expressionField.setText(expression);
	}
}
