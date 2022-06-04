package com.bhargav.game2048;

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
		this.initializeDialogComponents();
		this.addDialogComponents();
		this.addDialogListeners();

		// this.dialog.pack();
		this.dialog.setVisible(true);
	}

	public void displayFrame() {
		this.initializeFrameComponents();
		this.addFrameComponents();
		this.addFrameListeners();

		// this.frame.pack();
		this.frame.setVisible(true);
	}

	public void initializeDialogComponents() {
		this.dialog = new JDialog(this.frame, "GameBoard size input", true);

		this.dialogPanel1 = new JPanel();
		this.dialogPanel2 = new JPanel();
		this.dialogPanel3 = new JPanel();

		this.dialogLabel = new JLabel("Choose game board size..");

		this.dialogRadioButton4 = new JRadioButton("4x4", false);
		this.dialogRadioButton5 = new JRadioButton("5x5", false);
		this.dialogRadioButton6 = new JRadioButton("6x6", false);
		this.dialogButtonGroup = new ButtonGroup();

		this.dialogButton = new JButton("OK");
	}

	public void addDialogComponents() {
		this.dialog.add(this.dialogLabel);

		this.dialogPanel1.add(this.dialogLabel);
		this.dialogPanel1.setLayout(new FlowLayout());

		this.dialogButtonGroup.add(this.dialogRadioButton4);
		this.dialogButtonGroup.add(this.dialogRadioButton5);
		this.dialogButtonGroup.add(this.dialogRadioButton6);
		this.dialogPanel2.add(this.dialogRadioButton4);
		this.dialogPanel2.add(this.dialogRadioButton5);
		this.dialogPanel2.add(this.dialogRadioButton6);
		this.dialogPanel2.setLayout(new FlowLayout());

		this.dialogPanel3.add(this.dialogButton);
		this.dialogPanel3.setLayout(new FlowLayout());

		this.dialog.add(this.dialogPanel1);
		this.dialog.add(this.dialogPanel2);
		this.dialog.add(this.dialogPanel3);
		this.dialog.setLayout(new GridLayout(3, 1, 1, 1));
		this.dialog.setSize(200, 150);
	}

	public void addDialogListeners() {
		this.dialogButton.addActionListener(this);
	}

	public void initializeFrameComponents() {
		this.frame = new JFrame("2048 GameBoard");

		this.boardPanel = new JPanel();
		this.otherPanel = new JPanel();
		this.choicePanel = new JPanel();
		this.resultPanel = new JPanel();
		this.controlPanel = new JPanel();

		this.board = new JButton[this.boardSize][this.boardSize];
		for (int i = 0; i < this.boardSize; i++) {
			for (int j = 0; j < this.boardSize; j++) {
				this.board[i][j] = new JButton("");
				this.board[i][j].setBackground(new Color(150, 150, 150, 50));
				this.board[i][j].setEnabled(false);
			}
		}

		this.leftButton = new JButton("move left");
		this.rightButton = new JButton("move right");
		this.upButton = new JButton("move up");
		this.downButton = new JButton("move down");

		this.stopButton = new JButton("quit game");
		this.restartButton = new JButton("restart game");
		this.closeButton = new JButton("close game");

		this.resultLabel = new JLabel("status");
		this.scoreLabel = new JLabel("score");
		this.resultField = new JTextField(15);
		this.resultField.setEditable(false);
		this.resultField.setBackground(new Color(200, 200, 200));
		this.scoreField = new JTextField(10);
		this.scoreField.setEditable(false);
		this.scoreField.setBackground(new Color(200, 200, 200));
	}

	public void addFrameComponents() {
		for (int i = 0; i < this.boardSize; i++) {
			for (int j = 0; j < this.boardSize; j++) {
				this.boardPanel.add(this.board[i][j]);
			}
		}
		this.boardPanel.setLayout(new GridLayout(this.boardSize, this.boardSize, 1, 1));

		this.choicePanel.add(this.leftButton);
		this.choicePanel.add(this.rightButton);
		this.choicePanel.add(this.upButton);
		this.choicePanel.add(this.downButton);
		this.choicePanel.setLayout(new GridLayout(2, 2, 1, 1));

		this.resultPanel.add(this.resultLabel);
		this.resultPanel.add(this.resultField);
		this.resultPanel.add(this.scoreLabel);
		this.resultPanel.add(this.scoreField);
		this.resultPanel.setLayout(new GridLayout(2, 2, 1, 1));

		this.controlPanel.add(this.stopButton);
		this.controlPanel.add(this.restartButton);
		this.controlPanel.add(this.closeButton);
		this.controlPanel.setLayout(new GridLayout(3, 1, 1, 1));

		this.otherPanel.add(this.choicePanel);
		this.otherPanel.add(this.resultPanel);
		this.otherPanel.add(this.controlPanel);
		this.otherPanel.setLayout(new GridLayout(3, 1, 5, 5));

		this.frame.add(this.boardPanel);
		this.frame.add(this.otherPanel);
		this.frame.setLayout(new GridLayout(1, 2, 5, 5));
		this.frame.setSize(600, 300);
	}

	public void addFrameListeners() {
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.leftButton.addActionListener(this);
		this.rightButton.addActionListener(this);
		this.upButton.addActionListener(this);
		this.downButton.addActionListener(this);
		
		this.restartButton.addActionListener(this);
		this.stopButton.addActionListener(this);
		this.closeButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.dialogButton) {
			this.dialog.setVisible(false);
			this.dialog.dispose();

			if (this.dialogRadioButton4.isSelected()) {
				this.boardSize = 4;
			} else if (this.dialogRadioButton5.isSelected()) {
				this.boardSize = 5;
			} else if (this.dialogRadioButton6.isSelected()) {
				this.boardSize = 6;
			}

			if (this.gameBoard != null) {
				this.gameBoard = null;
			}
			this.createGameBoard(this.boardSize);
			this.displayFrame();
			this.playGame();
		}

		if (e.getSource() == this.restartButton) {
			this.frame.dispose();
			this.displayDialog();
		}

		if (e.getSource() == this.stopButton) {
			this.leftButton.setEnabled(false);
			this.rightButton.setEnabled(false);
			this.upButton.setEnabled(false);
			this.downButton.setEnabled(false);
			
			this.resultField.setText("game stopped");
		}

		if (e.getSource() == this.closeButton) {
			this.frame.dispose();
			this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		if (e.getSource() == this.leftButton) {
			this.getBoardFromFrame();
			this.getScoreFromFrame();
			this.gameBoard.modifyGameBoardByMoveLeft();
			this.setBoardOnFrame();
			this.setScoreOnFrame();
			
			this.playGame();
		}

		if (e.getSource() == this.rightButton) {
			this.getBoardFromFrame();
			this.getScoreFromFrame();
			this.gameBoard.modifyGameBoardByMoveRight();
			this.setBoardOnFrame();
			this.setScoreOnFrame();
			
			this.playGame();
		}

		if (e.getSource() == this.upButton) {
			this.getBoardFromFrame();
			this.getScoreFromFrame();
			this.gameBoard.modifyGameBoardByMoveUp();
			this.setBoardOnFrame();
			this.setScoreOnFrame();
			
			this.playGame();
		}

		if (e.getSource() == this.downButton) {
			this.getBoardFromFrame();
			this.getScoreFromFrame();
			this.gameBoard.modifyGameBoardByMoveDown();
			this.setBoardOnFrame();
			this.setScoreOnFrame();
			
			this.playGame();
		}
	}

	public void createGameBoard(int size) {
		this.gameBoard = new GameBoard(size);
	}

	public void playGame() {
		if (!this.gameBoard.is2048Acheived() && this.gameBoard.isGameBoardEmpty()) {
			this.gameBoard.fillEmptyGameBoardCell();
			this.frame.setVisible(false);
			this.setBoardOnFrame();
			this.setScoreOnFrame();
			this.frame.setVisible(true);
		} else {
			if (this.gameBoard.is2048Acheived()) {
				this.resultField.setText("game won");
			} else {
				this.resultField.setText("game lost");
				
				this.leftButton.setEnabled(false);
				this.rightButton.setEnabled(false);
				this.upButton.setEnabled(false);
				this.downButton.setEnabled(false);
				
				this.stopButton.setEnabled(false);
			}
		}
	}

	public void setBoardOnFrame() {
		int[][] cells = this.gameBoard.getGameBoardCells();
		int boardSize = this.gameBoard.getGameBoardSize();

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (cells[i][j] > 0) {
					this.board[i][j].setText(String.valueOf(cells[i][j]));
				} else {
					this.board[i][j].setText("");
				}
			}
		}
	}

	public void getBoardFromFrame() {
		int boardSize = this.gameBoard.getGameBoardSize();
		int[][] cells = new int[boardSize][boardSize];
		String text;

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				text = this.board[i][j].getText();
				if (text.equals("")) {
					cells[i][j] = 0;
				} else {
					cells[i][j] = Integer.parseInt(text);
				}
			}
		}
		this.gameBoard.setGameBoardCells(cells);
	}

	public void setScoreOnFrame() {
		int score = this.gameBoard.getScore();
		this.scoreField.setText(String.valueOf(score));
	}

	public void getScoreFromFrame() {
		int score = Integer.parseInt(this.scoreField.getText());
		this.gameBoard.setScore(score);
	}
	
	public static void main(String[] args) {
		new GameBoardUI().displayDialog();
	}

}
