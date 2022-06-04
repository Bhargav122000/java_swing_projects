package com.bhargav.numberpyramid.ui;

import java.util.Random;

public class NumberPyramid {
	private Random random;
	private String difficulty;
	private int rows;
	private int[][] numbers;
	private boolean[][] visible;
	private int score;

	public NumberPyramid() {
		random = new Random();
		difficulty = null;
		rows = 0;
		score = 0;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int[][] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[][] numbers) {
		this.numbers = numbers;
	}

	public boolean[][] getVisible() {
		return visible;
	}

	public void setVisible(boolean[][] visible) {
		this.visible = visible;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void generateRows() {
		if (difficulty.equals("easy")) {
			rows = 5;
		} else if (difficulty.equals("medium")) {
			rows = 6;
		} else {
			rows = 7;
		}
	}

	public void generateNumbers() {
		numbers = new int[rows][];
		for (int i = rows - 1; i >= 0; i--) {
			numbers[i] = new int[i + 1];
			if (i == rows - 1) {
				for (int j = 0; j < numbers[i].length; j++) {
					numbers[i][j] = random.nextInt(1, 10);
				}
			} else {
				for (int j = 0; j < numbers[i].length; j++) {
					numbers[i][j] = numbers[i + 1][j] + numbers[i + 1][j + 1];
				}
			}
		}
	}

	public void decideVisibility() {
		visible = new boolean[rows][];
		for (int i = 0; i < visible.length; i++) {
			visible[i] = new boolean[i + 1];
			for (int j = 0; j < visible[i].length; j++) {
				visible[i][j] = false;
			}
		}

		int type = random.nextInt(0, 4);
		if (type == 0) {
			for (int i = 0; i < visible.length; i++) {
				visible[i][0] = true;
			}
		} else if (type == 1) {
			for (int i = 0; i < visible.length; i++) {
				visible[i][visible[i].length - 1] = true;
			}
		} else if (type == 2) {
			for (int i = 0; i < visible[rows - 1].length; i++) {
				visible[rows - 1][i] = true;
			}
		} else {
			for (int i = 0; i < visible.length; i++) {
				for (int j = 0; j < visible[i].length; j++) {
					visible[i][j] = random.nextBoolean();
				}
			}
		}
	}

	public boolean isMatched(int[][] provided) {
		boolean isEqual = true;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				if (numbers[i][j] != provided[i][j]) {
					isEqual = false;
					break;
				}
			}
		}
		return isEqual;
	}

	public void updateScore(int[][] provided) {
		boolean isEqual = isMatched(provided);

		if (difficulty.equals("easy")) {
			if (isEqual) {
				score += 150;
			} else {
				score -= 75;
			}
		} else if (difficulty.equals("medium")) {
			if (isEqual) {
				score += 250;
			} else {
				score -= 125;
			}
		} else {
			if (isEqual) {
				score += 350;
			} else {
				score -= 175;
			}
		}

		if (score < 0) {
			score = 0;
		}
	}
}
