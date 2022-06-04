package com.bhargav.numbermachine.ui;

import java.util.Random;

public class NumberMachineGameModel {
	private int obtainedSum = 0;
	private int requiredSum = 0;
	private int[][] numbers = null;
	private int score = 0;
	private int selectedCellsCount = 0;
	private int maxSelectedCellsCount = 0;
	private static Random random = new Random();

	public int getObtainedSum() {
		return obtainedSum;
	}

	public void setObtainedSum(int obtainedSum) {
		this.obtainedSum = obtainedSum;
	}

	public int getRequiredSum() {
		return requiredSum;
	}

	public void setRequiredSum(int requiredSum) {
		this.requiredSum = requiredSum;
	}

	public int[][] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[][] numbers) {
		this.numbers = numbers;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getSelectedCellsCount() {
		return selectedCellsCount;
	}

	public void setSelectedCellsCount(int selectedCellsCount) {
		this.selectedCellsCount = selectedCellsCount;
	}

	public int getMaxSelectedCellsCount() {
		return maxSelectedCellsCount;
	}

	public void setMaxSelectedCellsCount(int maxSelectedCellsCount) {
		this.maxSelectedCellsCount = maxSelectedCellsCount;
	}

	public void generateNumbers() {
		if (numbers == null) {
			numbers = new int[9][9];
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				numbers[i][j] = random.nextInt(1, 10);
			}
		}
	}

	public void generateRequiredSum() {
		if (numbers != null) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (numbers[i][j] == 9) {
						requiredSum = random.nextInt(10, 46);
					} else if (numbers[i][j] == 8) {
						requiredSum = random.nextInt(10, 41);
					} else if (numbers[i][j] == 7) {
						requiredSum = random.nextInt(10, 36);
					} else if (numbers[i][j] == 6) {
						requiredSum = random.nextInt(10, 31);
					} else if (numbers[i][j] == 5) {
						requiredSum = random.nextInt(10, 26);
					} else if (numbers[i][j] == 4) {
						requiredSum = random.nextInt(4, 21);
					} else if (numbers[i][j] == 3) {
						requiredSum = random.nextInt(4, 16);
					} else if (numbers[i][j] == 2) {
						requiredSum = random.nextInt(4, 11);
					} else if (numbers[i][j] == 1) {
						requiredSum = random.nextInt(4, 6);
					}
				}
			}
		}
	}

	public boolean checkSumStatus() {
		boolean isCompleted = false;
		if (obtainedSum >= requiredSum) {
			isCompleted = true;
		}
		return isCompleted;
	}

	public void updateScore() {
		if (obtainedSum == requiredSum) {
			score += (selectedCellsCount * selectedCellsCount * 5);
		} else {
			score -= 100;
			if (score < 0) {
				score = 0;
			}
		}
	}

	public void updateMaxSelectedCellsCount() {
		if (selectedCellsCount > maxSelectedCellsCount) {
			maxSelectedCellsCount = selectedCellsCount;
		}
	}
}
