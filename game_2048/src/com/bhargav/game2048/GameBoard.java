package com.bhargav.game2048;

import java.util.*;

public class GameBoard {

	private int gameBoardSize;
	private int[][] gameBoardCells;
	private int score;

	public GameBoard(int gameBoardSize) {
		this.gameBoardSize = gameBoardSize;
		this.gameBoardCells = new int[this.gameBoardSize][this.gameBoardSize];
		this.score = 0;
	}

	public int getGameBoardSize() {
		return this.gameBoardSize;
	}
	
	public int[][] getGameBoardCells() {
		return this.gameBoardCells;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setGameBoardSize(int gameBoardSize) {
		this.gameBoardSize = gameBoardSize;
	}
	
	public void setGameBoardCells(int[][] gameBoardCells) {
		this.gameBoardCells = gameBoardCells;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	private void updateScore(int cellValue) {
		this.score += ((cellValue / 2) * 10);
	}

	public boolean isGameBoardEmpty() {
		boolean isEmpty = false;
		for (int i = 0; i < this.gameBoardSize; i++) {
			for (int j = 0; j < this.gameBoardSize; j++) {
				if (this.gameBoardCells[i][j] == 0) {
					isEmpty = true;
					break;
				}
			}
		}
		return isEmpty;
	}

	public boolean is2048Acheived() {
		boolean isPresent = false;
		for (int i = 0; i < this.gameBoardSize; i++) {
			for (int j = 0; j < this.gameBoardSize; j++) {
				if (this.gameBoardCells[i][j] == 2048) {
					isPresent = true;
					break;
				}
			}
		}
		return isPresent;
	}

	private boolean isRowEmpty(int[] row, int start) {
		boolean isEmpty = true;
		for (int i = start; i < row.length; i++) {
			if (row[i] != 0) {
				isEmpty = false;
				break;
			}
		}
		return isEmpty;
	}

	public void fillEmptyGameBoardCell() {
		Random random = new Random();
		int number;
		int i, j;
		while (true) {
			number = random.nextInt(this.gameBoardSize * this.gameBoardSize);
			i = number / this.gameBoardSize;
			j = number % this.gameBoardSize;
			if (this.gameBoardCells[i][j] == 0) {
				if (random.nextBoolean() == true) {
					this.gameBoardCells[i][j] = 2;
				} else {
					this.gameBoardCells[i][j] = 4;
				}
				break;
			}
		}
	}

	private int[] moveLeftByOne(int[] row, int start) {
		int i;
		for (i = start; i < row.length - 1; i++) {
			row[i] = row[i + 1];
		}
		row[i] = 0;
		return row;
	}

	private void modifyRow(int[] row) {
		int i, j;

		if (!this.isRowEmpty(row, 0)) {
			j = 0;
			while (j < this.gameBoardSize - 1) {
				i = 0;
				while (i < this.gameBoardSize - 1) {
					if (row[i] == row[i + 1]) {
						this.updateScore(row[i]);
						row[i] += row[i + 1];
						row = this.moveLeftByOne(row, i + 1);
						i++;
					} else if (row[i] == 0) {
						if (this.isRowEmpty(row, i + 1)) {
							j++;
							i = 0;
						} else {
							row = this.moveLeftByOne(row, i);
						}
					} else {
						i++;
					}
				}
				j++;
			}
		}
	}

	public void modifyGameBoardByMoveLeft() {
		int[] row = new int[this.gameBoardSize];
		int i, j, k;

		for (i = 0; i < this.gameBoardSize; i++) {
			for (j = 0, k = 0; j < this.gameBoardSize; j++, k++) {
				row[k] = this.gameBoardCells[i][j];
			}
			this.modifyRow(row);
			for (j = 0, k = 0; j < this.gameBoardSize; j++, k++) {
				this.gameBoardCells[i][j] = row[k];
			}
		}
	}

	public void modifyGameBoardByMoveRight() {
		int[] row = new int[this.gameBoardSize];
		int i, j, k;

		for (i = 0; i < this.gameBoardSize; i++) {
			for (j = this.gameBoardSize - 1, k = 0; j >= 0; j--, k++) {
				row[k] = this.gameBoardCells[i][j];
			}
			this.modifyRow(row);
			for (j = this.gameBoardSize - 1, k = 0; j >= 0; j--, k++) {
				this.gameBoardCells[i][j] = row[k];
			}
		}
	}

	public void modifyGameBoardByMoveUp() {
		int[] row = new int[this.gameBoardSize];
		int i, j, k;

		for (j = 0; j < this.gameBoardSize; j++) {
			for (i = 0, k = 0; i < this.gameBoardSize; i++, k++) {
				row[k] = this.gameBoardCells[i][j];
			}
			this.modifyRow(row);
			for (i = 0, k = 0; i < this.gameBoardSize; i++, k++) {
				this.gameBoardCells[i][j] = row[k];
			}
		}
	}

	public void modifyGameBoardByMoveDown() {
		int[] row = new int[this.gameBoardSize];
		int i, j, k;

		for (j = 0; j < this.gameBoardSize; j++) {
			for (i = this.gameBoardSize - 1, k = 0; i >= 0; i--, k++) {
				row[k] = this.gameBoardCells[i][j];
			}
			this.modifyRow(row);
			for (i = this.gameBoardSize - 1, k = 0; i >= 0; i--, k++) {
				this.gameBoardCells[i][j] = row[k];
			}
		}
	}
}
