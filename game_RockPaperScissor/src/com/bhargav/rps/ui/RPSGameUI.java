// View Class
package com.bhargav.rps.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RPSGameUI implements ActionListener {

	private static ImageIcon rockIcon = new ImageIcon("D:\\myFiles\\filesForJavaProjects\\rock.png");
	private static ImageIcon paperIcon = new ImageIcon("D:\\myFiles\\filesForJavaProjects\\paper.png");
	private static ImageIcon scissorIcon = new ImageIcon("D:\\myFiles\\filesForJavaProjects\\scissor.png");

	static {
		Image tempImage;

		tempImage = rockIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		rockIcon = new ImageIcon(tempImage);

		tempImage = paperIcon.getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
		paperIcon = new ImageIcon(tempImage);

		tempImage = scissorIcon.getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
		scissorIcon = new ImageIcon(tempImage);
	}

	RPSGameModel rpsGameModel = null;
	int matches = 0, wins = 0, draws = 0, losts = 0;

	JFrame frame;
	JPanel panelOne, choicePanel, resultPanel;
	JLabel choiceLabel, rockLabel, paperLabel, scissorLabel;
	JButton rockButton, paperButton, scissorButton;
	JLabel userChoiceLabel, computerChoiceLabel, resultLabel;
	JButton userChoiceButton, computerChoiceButton;
	JTextField resultField;
	JPanel panelTwo, summaryPanel, controlButtonsPanel;
	JLabel matchesLabel, winsLabel, drawsLabel, lostsLabel;
	JTextField matchesField, winsField, drawsField, lostsField;
	JButton continueButton, resetButton, exitButton;

	public void createChoicePanel() {
		choicePanel = new JPanel();
		choiceLabel = new JLabel("Click to choose and proceed ...");
		rockLabel = new JLabel("ROCK");
		paperLabel = new JLabel("PAPER");
		scissorLabel = new JLabel("SCISSOR");
		rockButton = new JButton(RPSGameUI.rockIcon);
		rockButton.setBackground(Color.white);
		paperButton = new JButton(RPSGameUI.paperIcon);
		paperButton.setBackground(Color.white);
		scissorButton = new JButton(RPSGameUI.scissorIcon);
		scissorButton.setBackground(Color.white);

		choicePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		choicePanel.add(choiceLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		choicePanel.add(rockLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		choicePanel.add(paperLabel, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		choicePanel.add(scissorLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		choicePanel.add(rockButton, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		choicePanel.add(paperButton, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		choicePanel.add(scissorButton, gbc);
	}

	public void createResultPanel() {
		resultPanel = new JPanel();
		userChoiceLabel = new JLabel("You chose");
		computerChoiceLabel = new JLabel("Computer chose");
		resultLabel = new JLabel("Result");
		userChoiceButton = new JButton("	");
		userChoiceButton.setBackground(Color.white);
		computerChoiceButton = new JButton("	");
		computerChoiceButton.setBackground(Color.white);
		resultField = new JTextField(10);
		resultField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		resultField.setHorizontalAlignment(JTextField.CENTER);
		resultField.setEditable(false);

		resultPanel.add(userChoiceLabel);
		resultPanel.add(userChoiceButton);
		resultPanel.add(computerChoiceLabel);
		resultPanel.add(computerChoiceButton);
		resultPanel.add(resultLabel);
		resultPanel.add(resultField);
		resultPanel.setLayout(new GridLayout(3, 2, 2, 2));
	}

	public void createSummaryPanel() {
		summaryPanel = new JPanel();
		matchesLabel = new JLabel("Matches Played");
		winsLabel = new JLabel("Matches Won");
		drawsLabel = new JLabel("Matches Drawn");
		lostsLabel = new JLabel("Matches Lost");
		matchesField = new JTextField(5);
		matchesField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		matchesField.setHorizontalAlignment(JTextField.CENTER);
		matchesField.setEditable(false);
		winsField = new JTextField(5);
		winsField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		winsField.setHorizontalAlignment(JTextField.CENTER);
		winsField.setEditable(false);
		drawsField = new JTextField(5);
		drawsField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		drawsField.setHorizontalAlignment(JTextField.CENTER);
		drawsField.setEditable(false);
		lostsField = new JTextField(5);
		lostsField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lostsField.setHorizontalAlignment(JTextField.CENTER);
		lostsField.setEditable(false);

		summaryPanel.add(matchesLabel);
		summaryPanel.add(matchesField);
		summaryPanel.add(winsLabel);
		summaryPanel.add(winsField);
		summaryPanel.add(drawsLabel);
		summaryPanel.add(drawsField);
		summaryPanel.add(lostsLabel);
		summaryPanel.add(lostsField);
		summaryPanel.setLayout(new GridLayout(4, 2, 2, 2));
	}

	public void createControlButtonsPanel() {
		controlButtonsPanel = new JPanel();
		continueButton = new JButton("Continue Play");
		resetButton = new JButton("Reset Play");
		exitButton = new JButton("Exit Play");

		controlButtonsPanel.add(continueButton);
		controlButtonsPanel.add(resetButton);
		controlButtonsPanel.add(exitButton);
		controlButtonsPanel.setLayout(new GridLayout(2, 2, 5, 5));
	}

	public void createPanelOne() {
		panelOne = new JPanel();
		createChoicePanel();
		createResultPanel();

		panelOne.add(choicePanel);
		panelOne.add(resultPanel);
		panelOne.setLayout(new GridLayout(2, 1, 10, 10));
	}

	public void createPanelTwo() {
		panelTwo = new JPanel();
		createSummaryPanel();
		createControlButtonsPanel();

		panelTwo.add(summaryPanel);
		panelTwo.add(controlButtonsPanel);
		panelTwo.setLayout(new GridLayout(2, 1, 20, 20));
	}

	public void createFrame() {
		frame = new JFrame("RocK PapeR ScissoR");
		createPanelOne();
		createPanelTwo();

		frame.add(panelOne);
		frame.add(panelTwo);
		frame.setLayout(new GridLayout(1, 2, 10, 10));
	}

	public void addListeners() {
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		rockButton.addActionListener(this);
		paperButton.addActionListener(this);
		scissorButton.addActionListener(this);
		continueButton.addActionListener(this);
		resetButton.addActionListener(this);
		exitButton.addActionListener(this);
	}

	public void setInitialRestrictions() {
		rpsGameModel = null;
		matches = 0;
		wins = 0;
		draws = 0;
		losts = 0;

		rockButton.setEnabled(true);
		paperButton.setEnabled(true);
		scissorButton.setEnabled(true);
		continueButton.setEnabled(false);
		userChoiceButton.setIcon(null);
		computerChoiceButton.setIcon(null);
		resultField.setText(" -- ");
		matchesField.setText("0");
		winsField.setText("0");
		drawsField.setText("0");
		lostsField.setText("0");
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
		if (object == rockButton || object == paperButton || object == scissorButton) {
			actionOfRockPaperScissorButtons(object);
		} else if (object == continueButton) {
			actionOfContinueButton();
		} else if (object == resetButton) {
			actionOfResetButton();
		} else if (object == exitButton) {
			actionOfExitButton();
		}
	}

	public void actionOfRockPaperScissorButtons(Object object) {
		continueButton.setEnabled(true);
		rockButton.setEnabled(false);
		paperButton.setEnabled(false);
		scissorButton.setEnabled(false);

		rpsGameModel = new RPSGameModel();
		if (object == rockButton) {
			rpsGameModel.setUserChoice("rock");
			userChoiceButton.setIcon(rockIcon);
		} else if (object == paperButton) {
			rpsGameModel.setUserChoice("paper");
			userChoiceButton.setIcon(paperIcon);
		} else {
			rpsGameModel.setUserChoice("scissor");
			userChoiceButton.setIcon(scissorIcon);
		}

		rpsGameModel.generateComputerChoice();
		String computerChoice = rpsGameModel.getComputerChoice();
		if (computerChoice.equals("rock")) {
			computerChoiceButton.setIcon(rockIcon);
		} else if (computerChoice.equals("paper")) {
			computerChoiceButton.setIcon(paperIcon);
		} else {
			computerChoiceButton.setIcon(scissorIcon);
		}

		rpsGameModel.updateResult();
		matches += 1;
		String result = rpsGameModel.getResult();
		if (result.equals("won")) {
			resultField.setText("Heyy : ) You Won ..!");
			wins += 1;
		} else if (result.equals("lost")) {
			resultField.setText("Aww : ( You Lost");
			losts += 1;
		} else {
			resultField.setText("Oops!! It's a Draw");
			draws += 1;
		}

		matchesField.setText(String.valueOf(matches));
		winsField.setText(String.valueOf(wins));
		drawsField.setText(String.valueOf(draws));
		lostsField.setText(String.valueOf(losts));
	}

	public void actionOfContinueButton() {
		continueButton.setEnabled(false);

		rockButton.setEnabled(true);
		paperButton.setEnabled(true);
		scissorButton.setEnabled(true);
		userChoiceButton.setIcon(null);
		computerChoiceButton.setIcon(null);
		resultField.setText(" -- ");
	}

	public void actionOfResetButton() {
		setInitialRestrictions();
	}

	public void actionOfExitButton() {
		int response = JOptionPane.showConfirmDialog(frame, "Are you sure to exit?");
		if (response == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
