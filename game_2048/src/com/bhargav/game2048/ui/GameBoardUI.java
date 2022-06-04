// View Class

package com.bhargav.game2048.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameBoardUI implements ActionListener {

	JFrame frame;
	JPanel boardPanel, otherPanel, choicePanel, resultPanel, controlPanel;
	JButton[][] board;
	JButton leftButton, rightButton, upButton, downButton;
	JButton stopButton, restartButton, closeButton;
	JLabel resultLabel, scoreLabel;
	JTextField resultField, scoreField;

	JDialog dialog;
	JPanel dialogPanel1, dialogPanel2, dialogPanel3;
	JLabel dialogLabel;
	JRadioButton dialogRadioButton4, dialogRadioButton5, dialogRadioButton6;
	ButtonGroup dialogButtonGroup;
	JButton dialogButton;

	int boardSize;

	GameBoard gameBoard = null;

	public void displayDialog() {
		initializeDialogComponents();
		addDialogComponents();
		addDialogListeners();

		// dialog.pack();
		dialog.setVisible(true);
	}

	public void displayFrame() {
		initializeFrameComponents();
		addFrameComponents();
		addFrameListeners();

		// frame.pack();
		frame.setVisible(true);
	}

	public void initializeDialogComponents() {
		dialog = new JDialog(frame, "GameBoard size input", true);

		dialogPanel1 = new JPanel();
		dialogPanel2 = new JPanel();
		dialogPanel3 = new JPanel();

		dialogLabel = new JLabel("Choose game board size..");

		dialogRadioButton4 = new JRadioButton("4x4", false);
		dialogRadioButton5 = new JRadioButton("5x5", false);
		dialogRadioButton6 = new JRadioButton("6x6", false);
		dialogButtonGroup = new ButtonGroup();

		dialogButton = new JButton("OK");
	}

	public void addDialogComponents() {
		dialog.add(dialogLabel);

		dialogPanel1.add(dialogLabel);
		dialogPanel1.setLayout(new FlowLayout());

		dialogButtonGroup.add(dialogRadioButton4);
		dialogButtonGroup.add(dialogRadioButton5);
		dialogButtonGroup.add(dialogRadioButton6);
		dialogPanel2.add(dialogRadioButton4);
		dialogPanel2.add(dialogRadioButton5);
		dialogPanel2.add(dialogRadioButton6);
		dialogPanel2.setLayout(new FlowLayout());

		dialogPanel3.add(dialogButton);
		dialogPanel3.setLayout(new FlowLayout());

		dialog.add(dialogPanel1);
		dialog.add(dialogPanel2);
		dialog.add(dialogPanel3);
		dialog.setLayout(new GridLayout(3, 1, 1, 1));
		dialog.setSize(200, 150);
	}

	public void addDialogListeners() {
		dialogButton.addActionListener(this);
	}

	public void initializeFrameComponents() {
		frame = new JFrame("2048 GameBoard");

		boardPanel = new JPanel();
		otherPanel = new JPanel();
		choicePanel = new JPanel();
		resultPanel = new JPanel();
		controlPanel = new JPanel();

		board = new JButton[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				board[i][j] = new JButton("");
				board[i][j].setBackground(new Color(150, 150, 150, 50));
				board[i][j].setEnabled(false);
			}
		}

		leftButton = new JButton("move left");
		rightButton = new JButton("move right");
		upButton = new JButton("move up");
		downButton = new JButton("move down");

		stopButton = new JButton("quit game");
		restartButton = new JButton("restart game");
		closeButton = new JButton("close game");

		resultLabel = new JLabel("status");
		scoreLabel = new JLabel("score");
		resultField = new JTextField(15);
		resultField.setEditable(false);
		resultField.setBackground(new Color(200, 200, 200));
		scoreField = new JTextField(10);
		scoreField.setEditable(false);
		scoreField.setBackground(new Color(200, 200, 200));
	}

	public void addFrameComponents() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				boardPanel.add(board[i][j]);
			}
		}
		boardPanel.setLayout(new GridLayout(boardSize, boardSize, 1, 1));

		choicePanel.add(leftButton);
		choicePanel.add(rightButton);
		choicePanel.add(upButton);
		choicePanel.add(downButton);
		choicePanel.setLayout(new GridLayout(2, 2, 1, 1));

		resultPanel.add(resultLabel);
		resultPanel.add(resultField);
		resultPanel.add(scoreLabel);
		resultPanel.add(scoreField);
		resultPanel.setLayout(new GridLayout(2, 2, 1, 1));

		controlPanel.add(stopButton);
		controlPanel.add(restartButton);
		controlPanel.add(closeButton);
		controlPanel.setLayout(new GridLayout(3, 1, 1, 1));

		otherPanel.add(choicePanel);
		otherPanel.add(resultPanel);
		otherPanel.add(controlPanel);
		otherPanel.setLayout(new GridLayout(3, 1, 5, 5));

		frame.add(boardPanel);
		frame.add(otherPanel);
		frame.setLayout(new GridLayout(1, 2, 5, 5));
		frame.setSize(600, 300);
	}

	public void addFrameListeners() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		upButton.addActionListener(this);
		downButton.addActionListener(this);

		restartButton.addActionListener(this);
		stopButton.addActionListener(this);
		closeButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dialogButton) {
			
			if (dialogRadioButton4.isSelected() || dialogRadioButton5.isSelected() || dialogRadioButton6.isSelected()) {
				dialog.setVisible(false);
				dialog.dispose();

				if (dialogRadioButton4.isSelected()) {
					boardSize = 4;
				} else if (dialogRadioButton5.isSelected()) {
					boardSize = 5;
				} else if (dialogRadioButton6.isSelected()) {
					boardSize = 6;
				}

				if (gameBoard != null) {
					gameBoard = null;
				}
				createGameBoard(boardSize);
				displayFrame();
				playGame();
			} else {
				JOptionPane.showMessageDialog(dialog, "Please choose a size to proceed");
			}	
		}

		if (e.getSource() == restartButton) {
			frame.dispose();
			displayDialog();
		}

		if (e.getSource() == stopButton) {
			leftButton.setEnabled(false);
			rightButton.setEnabled(false);
			upButton.setEnabled(false);
			downButton.setEnabled(false);

			stopButton.setEnabled(false);

			resultField.setText("game stopped");
		}

		if (e.getSource() == closeButton) {
			int response = JOptionPane.showConfirmDialog(frame, "Are you sure to exit?");
			if (response == JOptionPane.YES_OPTION) {
				frame.dispose();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}

		if (e.getSource() == leftButton) {
			getBoardFromFrame();
			getScoreFromFrame();
			gameBoard.modifyGameBoardByMoveLeft();
			setBoardOnFrame();
			setScoreOnFrame();

			playGame();
		}

		if (e.getSource() == rightButton) {
			getBoardFromFrame();
			getScoreFromFrame();
			gameBoard.modifyGameBoardByMoveRight();
			setBoardOnFrame();
			setScoreOnFrame();

			playGame();
		}

		if (e.getSource() == upButton) {
			getBoardFromFrame();
			getScoreFromFrame();
			gameBoard.modifyGameBoardByMoveUp();
			setBoardOnFrame();
			setScoreOnFrame();

			playGame();
		}

		if (e.getSource() == downButton) {
			getBoardFromFrame();
			getScoreFromFrame();
			gameBoard.modifyGameBoardByMoveDown();
			setBoardOnFrame();
			setScoreOnFrame();

			playGame();
		}
	}

	public void createGameBoard(int size) {
		gameBoard = new GameBoard(size);
	}

	public void playGame() {
		if (!gameBoard.is2048Acheived() && gameBoard.isGameBoardEmpty()) {
			gameBoard.fillEmptyGameBoardCell();
			frame.setVisible(false);
			setBoardOnFrame();
			setScoreOnFrame();
			frame.setVisible(true);
		} else {
			if (gameBoard.is2048Acheived()) {
				resultField.setText("game won");
			} else {
				resultField.setText("game lost");

				leftButton.setEnabled(false);
				rightButton.setEnabled(false);
				upButton.setEnabled(false);
				downButton.setEnabled(false);

				stopButton.setEnabled(false);
			}
		}
	}

	public void setBoardOnFrame() {
		int[][] cells = gameBoard.getGameBoardCells();
		int boardSize = gameBoard.getGameBoardSize();

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (cells[i][j] > 0) {
					board[i][j].setText(String.valueOf(cells[i][j]));
				} else {
					board[i][j].setText("");
				}
			}
		}
	}

	public void getBoardFromFrame() {
		int boardSize = gameBoard.getGameBoardSize();
		int[][] cells = new int[boardSize][boardSize];
		String text;

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				text = board[i][j].getText();
				if (text.equals("")) {
					cells[i][j] = 0;
				} else {
					cells[i][j] = Integer.parseInt(text);
				}
			}
		}
		gameBoard.setGameBoardCells(cells);
	}

	public void setScoreOnFrame() {
		int score = gameBoard.getScore();
		scoreField.setText(String.valueOf(score));
	}

	public void getScoreFromFrame() {
		int score = Integer.parseInt(scoreField.getText());
		gameBoard.setScore(score);
	}

}
