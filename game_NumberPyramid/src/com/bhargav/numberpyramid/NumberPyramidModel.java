package com.bhargav.numberpyramid;

import java.util.Random;

public class NumberPyramidModel {
	private Random random;
	private int rows;
	private int[][] numbers;
	private boolean[][] visible;
	
	public NumberPyramidModel() {
		random = new Random();
		rows = 0;
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
		
		
//		for (int i = 0; i < visible.length; i++) {
//			visible[i] = new boolean[i + 1];
//			if (i == 0) {
//				visible[i][0] = random.nextBoolean();
//			} else {
//				int temp = random.nextInt(0, visible[i].length);
//				for (int j = 0; j < visible[i].length; j++) {
//					if (temp == j) {
//						visible[i][j] = true;
//					} else {
//						visible[i][j] = false;
//					}
//				}
//			}
//		}
	}
}
