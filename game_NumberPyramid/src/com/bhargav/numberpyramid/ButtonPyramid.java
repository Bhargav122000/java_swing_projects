package com.bhargav.numberpyramid;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPyramid implements ActionListener {
	
	
	JDialog dialog;
	JPanel dialogPanelOne, dialogPanelTwo, dialogPanelThree;
	JLabel dialogLabel;
	ButtonGroup buttonGroup;
	JRadioButton easyRButton, mediumRButton, hardRButton;
	JButton dialogButton;
	
	String difficulty = null;
	int[] colums = { 1, 2, 3, 4, 5, 6, 7};
	NumberPyramidModel numberPyramidModel = null;
	
	JFrame frame;
	JPanel panelOne, timerPanel,  difficultyPanel, scorePanel;
	JLabel timerLabel, difficultyLabel, scoreLabel;
	JTextField difficultyField, scoreField;
	JButton timerButton;
	JPanel panelTwo, pyramidPanel, textPanel, keysPanel, controlButtonsPanel;
	JPanel[] pyramidPanels;
	JButton[][] pyramidButtons;
	JTextField textField;
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
		int rows = numberPyramidModel.getRows();
		numberPyramidModel.generateNumbers();
		int[][] numbers = numberPyramidModel.getNumbers();
		numberPyramidModel.decideVisibility();
		boolean[][] visible = numberPyramidModel.getVisible();
		
		pyramidButtons = new JButton[rows][];
		pyramidPanels = new JPanel[rows];
		
		for (int i = 0; i < pyramidButtons.length; i++) {
			pyramidPanels[i] = new JPanel();
			pyramidButtons[i] = new JButton[i + 1];
			for (int j = 0; j < pyramidButtons[i].length; j++) {
				if (visible[i][j]) {
					pyramidButtons[i][j] = new JButton(String.valueOf(numbers[i][j]));
					pyramidButtons[i][j].setBackground(Color.gray);
				} else {
					pyramidButtons[i][j] = new JButton(" -- ");
					pyramidButtons[i][j].setBackground(Color.white);
				}
				pyramidPanels[i].add(pyramidButtons[i][j]);
			}
			
			pyramidPanels[i].setLayout(new FlowLayout());
			pyramidPanel.add(pyramidPanels[i]);
		}
		
		pyramidPanel.setLayout(new GridLayout(pyramidPanels.length, 1, 0, 0));
	}
	
	public void createTextPanel() {
		textPanel = new JPanel();
		textField = new JTextField(5);
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField.setBackground(Color.lightGray);
		textField.setForeground(Color.black);
		textField.setEditable(false);
		
		textPanel.add(textField);
		textPanel.setLayout(new FlowLayout());
	}
	
	public void createKeysPanel() {
		keysPanel = new JPanel();
		digitButtons = new JButton[10];
		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i] = new JButton(String.valueOf(i));
			keysPanel.add(digitButtons[i]);
		}
		clearButton = new JButton("C");
		assignButton = new JButton("assign");
		
		keysPanel.add(clearButton);
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
		createTextPanel();
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
		panelTwo.add(textPanel, gbc);
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
	}
	
	public void setInitialRestrictions() {
		
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
		ButtonPyramid buttonPyramid = new ButtonPyramid();
		buttonPyramid.startDialogPhase();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object == dialogButton) {
			actionOfDialogButton();
		}
	}
	
	public void actionOfDialogButton() {
		if (easyRButton.isSelected() || mediumRButton.isSelected() || hardRButton.isSelected()) {
			numberPyramidModel = new NumberPyramidModel();
			if (easyRButton.isSelected()) {
				difficulty = "easy";
				numberPyramidModel.setRows(5);
			} else if (mediumRButton.isSelected()) {
				difficulty = "medium";
				numberPyramidModel.setRows(6);
			} else {
				difficulty = "hard";
				numberPyramidModel.setRows(7);
			}
			dialog.setVisible(false);
			dialog.dispose();

			startFramePhase();
		} else {
			JOptionPane.showMessageDialog(dialog, "Please choose a difficulty level to proceed..");
			dialog.setVisible(true);
		}
	}
}
