package com.bhargav.mentalarithmetic;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class ViewSample implements ActionListener {
	
	Timer timer;
	Toolkit toolkit;

	// Internal class
	class RemindTask extends TimerTask {
		int numWarningBeeps = 150;

		public void run() {
			if (numWarningBeeps > 0) {
				timerButton.setText(String.format("%03d", numWarningBeeps));
				
				if (!isShown) {
					if (numWarningBeeps % 2 == 0) {
						displayTerms();
					}
				}
				
				numWarningBeeps--;
			} else {
				toolkit.beep();
				timerButton.setText("done");
				timer.cancel();

				clearButton.setEnabled(false);
				signButton.setEnabled(false);
				for (int i = 0; i < digitButtons.length; i++) {
					digitButtons[i].setEnabled(false);
				}

				continueButton.setEnabled(true);
				resetButton.setEnabled(false);
			}
		}
	}

	ModelClass modelClass;
	ArrayList<String> terms;
	boolean isShown;
	
	JFrame frame;
	JPanel panelOne, timerPanel, scorePanel, controlButtonsPanel;
	JLabel timerLabel, scoreLabel;
	JTextField scoreField;
	JButton timerButton, continueButton, resetButton, exitButton;
	JPanel panelTwo, textPanel, keysPanel;
	JTextField textField;
	JButton[] digitButtons;
	JButton signButton, clearButton, validateButton;
	
	public void createTimerPanel() {
		timerPanel = new JPanel();
		timerLabel = new JLabel("Timer");
		timerButton = new JButton("Start");
		timerButton.setFont(new Font("Showcard Gothic", Font.BOLD, 30));
		
		timerPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		timerPanel.add(timerLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		timerPanel.add(timerButton, gbc);
	}
	
	public void createScorePanel() {
		scorePanel = new JPanel();
		scoreLabel = new JLabel("Score");
		scoreField = new JTextField(5);
		scoreField.setFont(new Font("Showcard Gothic", Font.BOLD, 30));
		scoreField.setHorizontalAlignment(JTextField.CENTER);
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
	
	public void createControlButtonsPanel() {
		controlButtonsPanel = new JPanel();
		continueButton = new JButton("Continue");
		resetButton = new JButton("Reset");
		exitButton = new JButton("Exit");
		
		controlButtonsPanel.add(continueButton);
		controlButtonsPanel.add(resetButton);
		controlButtonsPanel.add(exitButton);
		controlButtonsPanel.setLayout(new GridLayout(2, 2, 1, 1));
	}
	
	public void createTextPanel() {
		textPanel = new JPanel();
		textField = new JTextField(5);
		textField.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setBackground(Color.lightGray);
		textField.setForeground(Color.black);
		textField.setEditable(false);
		
		textPanel.add(textField);
		textPanel.setLayout(new GridLayout(1, 1, 0, 0));
	}
	
	public void createKeysPanel() {
		keysPanel = new JPanel();
		signButton = new JButton("-");
		clearButton = new JButton("C");
		validateButton = new JButton("Validate");
		digitButtons = new JButton[10];
		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i] = new JButton(String.valueOf(i));
		}
		
		for (int i = digitButtons.length - 1; i >= 0; i--) {
			keysPanel.add(digitButtons[i]);
			if (i == 7) {
				keysPanel.add(clearButton);
			} else if (i == 4) {
				keysPanel.add(signButton);
			}
		}
		keysPanel.add(validateButton);
		keysPanel.setLayout(new GridLayout(4, 4, 2, 2));
	}
	
	public void createPanelOne() {
		panelOne = new JPanel();
		createTimerPanel();
		createScorePanel();
		createControlButtonsPanel();
		
		panelOne.add(timerPanel);
		panelOne.add(scorePanel);
		panelOne.add(controlButtonsPanel);
		panelOne.setLayout(new GridLayout(1, 3, 2, 2));
	}
	
	public void createPanelTwo() {
		panelTwo = new JPanel();
		createTextPanel();
		createKeysPanel();
		
		panelTwo.add(textPanel);
		panelTwo.add(keysPanel);
		panelTwo.setLayout(new GridLayout(1, 2, 5, 5));
	}
	
	public void createFrame() {
		frame = new JFrame("Mental Arithmetic..");
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
		clearButton.addActionListener(this);
		signButton.addActionListener(this);
		validateButton.addActionListener(this);
		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i].addActionListener(this);
		}
	}
	
	public void setInitialRestrictions() {
		timerButton.setText("Start");
		scoreField.setText("--");
		textField.setText("");
		
		timerButton.setEnabled(true);
		continueButton.setEnabled(false);
		resetButton.setEnabled(false);
		exitButton.setEnabled(true);
		clearButton.setEnabled(false);
		signButton.setEnabled(false);
		validateButton.setEnabled(false);
		for (int i = 0; i < digitButtons.length; i++) {
			digitButtons[i].setEnabled(false);
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
	
	public static void main(String[] args) {
		new ViewSample().startProcess();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object == continueButton) {
			actionOfContinueButton();
		} else if (object == resetButton) {
			actionOfResetButton();
		} else if (object == exitButton) {
			actionOfExitButton();
		} else if (object == timerButton) {
			actionOfTimerButton();
		} else if (object == clearButton) {
			actionOfClearButton();
		} else if (object == signButton) {
			actionOfSignButton();
		} else if (object == validateButton) {
			actionOfValidateButton();
		} else {
			actionOfDigitButtons(object);
		}
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
	
	public void actionOfExitButton() {
		int response = JOptionPane.showConfirmDialog(frame, "Are you sure to exit?");
		if (response == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void displayTerms() {
		if (terms.size() == 0) {
			isShown = true;
			textField.setText(null);
			
			clearButton.setEnabled(true);
			signButton.setEnabled(true);
			validateButton.setEnabled(true);
			for (int i = 0; i < digitButtons.length; i++) {
				digitButtons[i].setEnabled(true);
			}
		} else if (terms.size() != 0) {
			textField.setText(terms.get(0));
			terms.remove(0);
		}
	}
	
	public void actionOfTimerButton() {
		scoreField.setText("0");
		
		timerButton.setEnabled(false);
		continueButton.setEnabled(false);
		resetButton.setEnabled(true);
		
		modelClass = new ModelClass();
		modelClass.generateTerms();
		terms = modelClass.getTerms();
		isShown = false;
		
		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new RemindTask(), 0, 1 * 1000);		
	}
	
	public void actionOfClearButton() {
		textField.setText(null);
	}
	
	public void actionOfSignButton() {
		String str = textField.getText().trim();
		if (str.equals(null) || str.equals("")) {
			str = "-";
		}
		textField.setText(str);
	}
	
	public void actionOfValidateButton() {
		try {
			int providedValue = Integer.parseInt(textField.getText().trim());
			modelClass.setProvidedValue(providedValue);
			modelClass.updateScore();
			String score = String.valueOf(modelClass.getScore());
			scoreField.setText(score);
			
			if (modelClass.isValueMatched()) {
				textField.setText("correct");
			} else {
				textField.setText("wrong");
				toolkit.beep();
			}
			
			modelClass.updateLevel();
			modelClass.generateTerms();
			terms = modelClass.getTerms();
			isShown = false;
			
			clearButton.setEnabled(false);
			signButton.setEnabled(false);
			validateButton.setEnabled(false);
			for (int i = 0; i < digitButtons.length; i++) {
				digitButtons[i].setEnabled(false);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "Invalid value provided..");
		}
	}
	
	public void actionOfDigitButtons(Object object) {
		for (int i = 0; i < digitButtons.length; i++) {
			if (object == digitButtons[i]) {
				String str = textField.getText().trim();
				str = str + String.valueOf(i);
				textField.setText(str);
			}
		}
	}

}
