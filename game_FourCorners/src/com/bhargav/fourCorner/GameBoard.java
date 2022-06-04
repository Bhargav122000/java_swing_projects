package com.bhargav.fourCorner;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameBoard implements ActionListener {

	// Internal class
	class RemindTask extends TimerTask {
		int numWarningBeeps = 60;

		public void run() {
			if (numWarningBeeps > 0) {
				timerField.setText(String.format("%02d", numWarningBeeps));
				// System.out.println(String.format("%02d", numWarningBeeps));
				numWarningBeeps--;
			} else {
				toolkit.beep();
				timerField.setText("Time's up!");
				timer.cancel(); // Not necessary because we call System.exit
				// System.exit(0); // Stops the AWT thread (and everything else)
				continueButton.setEnabled(true);

				submitButton.setEnabled(false);
				clearButton.setEnabled(false);
				for (int i = 0; i < GameBoard.boardSize; i++) {
					for (int j = 0; j < GameBoard.boardSize; j++) {
						cells[i][j].setEnabled(false);
					}
				}
			}
		}
	}

	JFrame frame;
	JPanel panel;
	JPanel boardPanel;
	JPanel otherPanel, controlPanel, instructionsPanel;
	JButton[][] cells;
	JButton startButton, clearButton, resetButton, continueButton, closeButton, submitButton;
	JLabel timerLabel, scoreLabel, maxrectSelectedLabel, rectsSelectedLabel, resultLabel;
	JLabel[] instructionsLabels;
	JTextField timerField, scoreField, maxrectSelectedField, rectsSelectedField, resultField;
	JTextField instructionsSelectedField;

	Color[][] cellsColor = null;
	Toolkit toolkit;
	Timer timer;

	int selectedCellsCount;
	int[][] selectedCells;
	int totalScore, rects, maxRectWidth, maxRectHeight;

	static int boardSize = 12;
	static Color[] colors = new Color[] { Color.red, Color.green, Color.yellow, Color.blue, Color.lightGray };
	static Color selected = new Color(153, 102, 0);
	static Random random = new Random();

	public void createBoardPanel() {
		this.boardPanel = new JPanel();

		this.cells = new JButton[GameBoard.boardSize][GameBoard.boardSize];
		this.cellsColor = new Color[GameBoard.boardSize][GameBoard.boardSize];
		for (int i = 0; i < GameBoard.boardSize; i++) {
			for (int j = 0; j < GameBoard.boardSize; j++) {
				this.cells[i][j] = new JButton();
				this.boardPanel.add(this.cells[i][j]);
			}
		}

		this.boardPanel.setLayout(new GridLayout(GameBoard.boardSize, GameBoard.boardSize, 1, 1));
	}

	public void createControlPanel() {
		this.controlPanel = new JPanel();

		this.timerLabel = new JLabel("Timer");
		this.timerField = new JTextField(5);
		this.timerField.setEditable(false);
		this.scoreLabel = new JLabel("total score");
		this.scoreField = new JTextField(10);
		this.scoreField.setEditable(false);
		this.rectsSelectedLabel = new JLabel("#rects selected");
		this.rectsSelectedField = new JTextField(5);
		this.rectsSelectedField.setEditable(false);
		this.maxrectSelectedLabel = new JLabel("max rect selected");
		this.maxrectSelectedField = new JTextField(10);
		this.maxrectSelectedField.setEditable(false);
		this.resultLabel = new JLabel("current result");
		this.resultField = new JTextField(15);
		this.resultField.setEditable(false);
		this.submitButton = new JButton("submit");
		this.startButton = new JButton("start play");
		this.clearButton = new JButton("clear selection");
		this.continueButton = new JButton("continue play");
		this.resetButton = new JButton("reset play");
		this.closeButton = new JButton("exit play");

		this.controlPanel.add(this.timerLabel);
		this.controlPanel.add(this.timerField);
		this.controlPanel.add(this.scoreLabel);
		this.controlPanel.add(this.scoreField);
		this.controlPanel.add(this.rectsSelectedLabel);
		this.controlPanel.add(this.rectsSelectedField);
		this.controlPanel.add(this.maxrectSelectedLabel);
		this.controlPanel.add(this.maxrectSelectedField);
		this.controlPanel.add(this.resultLabel);
		this.controlPanel.add(this.resultField);
		this.controlPanel.add(this.startButton);
		this.controlPanel.add(this.continueButton);
		this.controlPanel.add(this.submitButton);
		this.controlPanel.add(this.resetButton);
		this.controlPanel.add(this.clearButton);
		this.controlPanel.add(this.closeButton);

		this.controlPanel.setLayout(new GridLayout(8, 2, 2, 1));
	}

	public void createOtherPanel() {
		this.otherPanel = new JPanel();

		this.createControlPanel();
		this.createInstructionsPanel();

		this.otherPanel.add(this.controlPanel);
		this.otherPanel.add(this.instructionsPanel);
		this.otherPanel.setLayout(new GridLayout(2, 1, 5, 0));
	}

	public void createInstructionsPanel() {
		this.instructionsPanel = new JPanel();

		this.instructionsSelectedField = new JTextField("Selected buttons in this color");
		this.instructionsSelectedField.setBackground(GameBoard.selected);
		this.instructionsSelectedField.setEditable(false);
		this.instructionsLabels = new JLabel[7];
		this.instructionsLabels[0] = new JLabel("Here are the instructions :");
		this.instructionsLabels[1] = new JLabel("# Timer displays the countdown time of 120 seconds");
		this.instructionsLabels[2] = new JLabel("# Click on start to start the timer and play game");
		this.instructionsLabels[3] = new JLabel("# Choose any 4 buttons which forms a rectangle, then submit");
		this.instructionsLabels[4] = new JLabel("# The score is updated accordingly");
		this.instructionsLabels[5] = new JLabel("# The game stops when timer reaches 0 seconds");
		this.instructionsLabels[6] = new JLabel("# Try to choose large rect to get max score");

		this.instructionsPanel.add(this.instructionsSelectedField);
		for (int i = 0; i < 7; i++) {
			this.instructionsPanel.add(this.instructionsLabels[i]);
		}
		this.instructionsPanel.setLayout(new GridLayout(8, 1, 0, 0));
	}

	public void createPanel() {
		this.createBoardPanel();
		this.createOtherPanel();

		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		this.panel.add(this.boardPanel, gbc);

		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.panel.add(this.otherPanel);
	}

	public void createFrame() {
		this.frame = new JFrame("Four Corners");
		this.createPanel();
		this.frame.add(this.panel);
	}

	public void addListenersToComponents() {
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.startButton.addActionListener(this);
		this.clearButton.addActionListener(this);
		this.submitButton.addActionListener(this);
		this.continueButton.addActionListener(this);
		this.resetButton.addActionListener(this);
		this.closeButton.addActionListener(this);
		for (int i = 0; i < GameBoard.boardSize; i++) {
			for (int j = 0; j < GameBoard.boardSize; j++) {
				this.cells[i][j].addActionListener(this);
			}
		}
	}

	public void setInitialRestrictions() {
		this.selectedCellsCount = 0;
		this.selectedCells = new int[4][2];
		for (int i = 0; i < 4; i++) {
			Arrays.fill(this.selectedCells[i], 0);
		}
		this.totalScore = 0;
		this.rects = 0;
		this.maxRectWidth = 0;
		this.maxRectHeight = 0;

		for (int i = 0; i < GameBoard.boardSize; i++) {
			for (int j = 0; j < GameBoard.boardSize; j++) {
				this.cells[i][j].setEnabled(false);
				this.cells[i][j].setBackground(colors[random.nextInt(5)]);
				this.cellsColor[i][j] = this.cells[i][j].getBackground();
			}
		}
		this.submitButton.setEnabled(false);
		this.clearButton.setEnabled(false);
		this.continueButton.setEnabled(false);
		this.resetButton.setEnabled(false);

		this.timerField.setText("Click start to play");
		this.scoreField.setText("");
		this.rectsSelectedField.setText("");
		this.maxrectSelectedField.setText("");
		this.resultField.setText("");
	}

	public void displayFrame() {
		this.frame.pack();
		this.frame.setVisible(true);
	}

	public void startGame() {
		this.createFrame();
		this.addListenersToComponents();
		this.setInitialRestrictions();
		this.displayFrame();
	}

	public boolean isRectangleFormed() {
		boolean result = false;
		int x0 = this.selectedCells[0][0], y0 = this.selectedCells[0][1];
		int x1 = this.selectedCells[1][0], y1 = this.selectedCells[1][1];
		int x2 = this.selectedCells[2][0], y2 = this.selectedCells[2][1];
		int x3 = this.selectedCells[3][0], y3 = this.selectedCells[3][1];

		if (x0 == x1) {
			if (x2 == x3) {
				if ((y1 - y0) == (y3 - y2)) {
					result = true;
				}
			}
		}
		return result;
	}

	public void modifyCellsColor() {
		int x0 = this.selectedCells[0][0], y0 = this.selectedCells[0][1];
		int y1 = this.selectedCells[1][1];
		int x2 = this.selectedCells[2][0];

		for (int i = x0; i <= x2; i++) {
			for (int j = y0; j <= y1; j++) {
				this.cells[i][j].setBackground(GameBoard.colors[random.nextInt(5)]);
				this.cellsColor[i][j] = this.cells[i][j].getBackground();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		if (object == this.startButton) {
			for (int i = 0; i < GameBoard.boardSize; i++) {
				for (int j = 0; j < GameBoard.boardSize; j++) {
					cells[i][j].setEnabled(true);
				}
			}
			startButton.setEnabled(false);

			this.scoreField.setText("0");
			this.rectsSelectedField.setText("0");
			this.maxrectSelectedField.setText("0x0");
			this.resultField.setText("---");

			submitButton.setEnabled(true);
			clearButton.setEnabled(true);
			resetButton.setEnabled(true);

			toolkit = Toolkit.getDefaultToolkit();
			timer = new Timer();
			timer.schedule(new RemindTask(), 0, 1 * 1000);
		} else if (object == this.submitButton) {
			int i, j, k;
			if (this.selectedCellsCount != 4) {
				for (i = 0; i < GameBoard.boardSize; i++) {
					for (j = 0; j < GameBoard.boardSize; j++) {
						this.cells[i][j].setBackground(this.cellsColor[i][j]);
					}
				}
				this.selectedCellsCount = 0;
				this.resultField.setText("Please select 4 cells");
			} else {
				for (i = 0, k = 0; i < GameBoard.boardSize; i++) {
					for (j = 0; j < GameBoard.boardSize; j++) {
						if (this.cells[i][j].getBackground().equals(GameBoard.selected)) {
							this.selectedCells[k][0] = i;
							this.selectedCells[k][1] = j;
							k++;
						}
					}
				}

				Color c1 = this.cellsColor[this.selectedCells[0][0]][this.selectedCells[0][1]];
				Color c2 = null;
				for (k = 1; k < 4; k++) {
					c2 = this.cellsColor[this.selectedCells[k][0]][this.selectedCells[k][1]];
					if (!c1.equals(c2)) {
						break;
					}
				}
				if (k < 4) {
					for (i = 0; i < GameBoard.boardSize; i++) {
						for (j = 0; j < GameBoard.boardSize; j++) {
							this.cells[i][j].setBackground(this.cellsColor[i][j]);
						}
					}
					this.selectedCellsCount = 0;
					this.resultField.setText("Please select 4 cells of same color");
				} else {
					boolean isValid = this.isRectangleFormed();
					if (isValid) {
						int width = this.selectedCells[1][1] - this.selectedCells[0][1] + 1;
						int height = this.selectedCells[2][0] - this.selectedCells[0][0] + 1;
						int area = width * height;

						this.totalScore += area;
						this.scoreField.setText(String.valueOf(this.totalScore));
						this.rects += 1;
						this.rectsSelectedField.setText(String.valueOf(this.rects));
						if (area > (this.maxRectWidth * this.maxRectHeight)) {
							this.maxRectWidth = width;
							this.maxRectHeight = height;
							this.maxrectSelectedField.setText(width + " x " + height);
						}
						this.resultField.setText("you scored " + area + " points");

						this.modifyCellsColor();
					} else {
						for (k = 0; k < 4; k++) {
							i = this.selectedCells[k][0];
							j = this.selectedCells[k][1];
							this.cells[i][j].setBackground(this.cellsColor[i][j]);
						}
						this.resultField.setText("Please select cells forming rectangle");
					}
					this.selectedCellsCount = 0;
				}
			}
		} else if (object == this.clearButton) {
			for (int i = 0; i < GameBoard.boardSize; i++) {
				for (int j = 0; j < GameBoard.boardSize; j++) {
					if (this.cells[i][j].getBackground().equals(GameBoard.selected)) {
						this.cells[i][j].setBackground(this.cellsColor[i][j]);
					}
				}
			}
			this.selectedCellsCount = 0;
		} else if (object == this.continueButton) {
			this.startButton.setEnabled(true);
			this.setInitialRestrictions();
		} else if (object == this.resetButton) {
			timer.cancel();
			this.setInitialRestrictions();
			this.startButton.setEnabled(true);
		} else if (object == this.closeButton) {
			this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.frame.dispose();
		} else {
			for (int i = 0; i < GameBoard.boardSize; i++) {
				for (int j = 0; j < GameBoard.boardSize; j++) {
					if (object == this.cells[i][j]) {
						if (this.cells[i][j].getBackground().equals(GameBoard.selected)) {
							this.cells[i][j].setBackground(this.cellsColor[i][j]);
							this.selectedCellsCount -= 1;
						} else {
							this.cells[i][j].setBackground(GameBoard.selected);
							this.selectedCellsCount += 1;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new GameBoard().startGame();
	}
}
