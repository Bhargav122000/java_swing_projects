package com.bhargav.game2048.cli;

import java.util.*;

public class GameBoardCLI {

	static Scanner scanner = new Scanner(System.in);
	private int gameBoardSize;
	private int[][] gameBoardCells;
	private int score;

	public GameBoardCLI(int gameBoardSize) {
		this.gameBoardSize = gameBoardSize;
		this.gameBoardCells = new int[this.gameBoardSize][this.gameBoardSize];
		this.score = 0;
	}

	public void displayGameBoard() {
		System.out.println("The game board...");
		for (int i = 0; i < this.gameBoardSize; i++) {
			for (int j = 0; j < this.gameBoardSize; j++) {
				if (this.gameBoardCells[i][j] == 0) {
					System.out.print(String.format("[%6s]", ""));
				} else {
					System.out.print(String.format("[%6d]", gameBoardCells[i][j]));
				}
			}
			System.out.println("");
		}
	}

	public void displayScore() {
		System.out.println("your score: " + this.score);
		System.out.println("");
	}

	public void updateScore(int cellValue) {
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

	public boolean isRowEmpty(int[] row, int start) {
		boolean isEmpty = true;
		for (int i = start; i < row.length; i++) {
			if (row[i] != 0) {
				isEmpty = false;
				break;
			}
		}
		return isEmpty;
	}

	public String getDirection() {
		System.out.println("Directions to choose: left, right, up or down");
		System.out.println("To quit choose: quit");
		System.out.print("Enter your choice: ");
		String direction = GameBoardCLI.scanner.next();
		return direction;
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

	public int[] moveLeftByOne(int[] row, int start) {
		int i;
		for (i = start; i < row.length - 1; i++) {
			row[i] = row[i + 1];
		}
		row[i] = 0;
		return row;
	}

	public void modifyRow(int[] row) {
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

	public void modifyGameBoard(String direction) {
		if (direction.equalsIgnoreCase("left")) {
			this.modifyGameBoardByMoveLeft();
		} else if (direction.equalsIgnoreCase("right")) {
			this.modifyGameBoardByMoveRight();
		} else if (direction.equalsIgnoreCase("up")) {
			this.modifyGameBoardByMoveUp();
		} else if (direction.equalsIgnoreCase("down")) {
			this.modifyGameBoardByMoveDown();
		} else {
			System.out.println("Invalid direction chosen...");
		}
	}

	public void startPlay() {
		String direction;
		boolean isStopped = false;
		boolean is2048Reached = false;

		while (!is2048Reached && this.isGameBoardEmpty()) {
			this.fillEmptyGameBoardCell();
			this.displayGameBoard();
			this.displayScore();

			direction = this.getDirection();
			if (direction.equalsIgnoreCase("quit")) {
				isStopped = true;
				break;
			}
			this.modifyGameBoard(direction);

			is2048Reached = this.is2048Acheived();
			if (is2048Reached) {
				System.out.println("Congratulations!! you have reached 2048...");
				System.out.print("Do you want to continue [yes/no]?");
				String toContinue = scanner.next();
				if (toContinue.equalsIgnoreCase("yes")) {
					continue;
				} else {
					break;
				}
			}
		}

		if (is2048Reached) {
			System.out.println("Well played!! you won the game...");
		} else if (isStopped) {
			System.out.println("You quit the game...");
		} else {
			System.out.println("Sorry!! you lost the game...");
		}
		this.displayScore();
	}

	public static void main(String[] args) {

		System.out.print("Enter the game board size(n for nxn): ");
		int n = GameBoardCLI.scanner.nextInt();

		GameBoardCLI gameBoard = new GameBoardCLI(n);
		gameBoard.startPlay();
	}

}
