package com.bhargav.differentcolor.ui;

import java.awt.Color;
import java.util.Random;

public class DifferentColorModel {
	private static Random random = new Random();

	private static Color colorChoices[] = { new Color(255, 0, 0), new Color(255, 51, 0), new Color(204, 102, 0),
			new Color(255, 0, 102), new Color(0, 255, 0), new Color(255, 255, 0), new Color(0, 0, 255),
			new Color(0, 77, 153), new Color(153, 0, 204), new Color(255, 102, 0) };
	private static Color colorUniqueLight[] = { new Color(255, 51, 51), new Color(255, 92, 51), new Color(230, 115, 0),
			new Color(255, 51, 133), new Color(77, 255, 77), new Color(255, 255, 51), new Color(51, 51, 255),
			new Color(0, 102, 204), new Color(191, 0, 255), new Color(255, 133, 51) };
	private static Color colorUniqueDark[] = { new Color(204, 0, 0), new Color(230, 46, 0), new Color(179, 89, 0),
			new Color(204, 0, 82), new Color(0, 204, 0), new Color(230, 230, 0), new Color(0, 0, 204),
			new Color(0, 64, 128), new Color(115, 0, 153), new Color(204, 82, 0) };

	private int generatedCount = 0;
	private int rows = 0;
	private int cols = 0;
	private int colorIndex = -1;
	private boolean isLightColor; // true-lightColor, false-darkColor
	private int score = 0;
	private Color colors[][];

	public int getGeneratedCount() {
		return generatedCount;
	}

	public void setGeneratedCount(int generatedCount) {
		this.generatedCount = generatedCount;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getColorIndex() {
		return colorIndex;
	}

	public void setColorIndex(int colorIndex) {
		this.colorIndex = colorIndex;
	}

	public boolean isLightColor() {
		return isLightColor;
	}

	public void setLightColor(boolean isLightColor) {
		this.isLightColor = isLightColor;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Color[][] getColors() {
		return colors;
	}

	public void setColors(Color[][] colors) {
		this.colors = colors;
	}

	public void generateRowsAndCols() {
		if (generatedCount == 0) {
			rows = 3;
			cols = 3;
		} else if (generatedCount == 1) {
			rows = 4;
			cols = 4;
		} else if (generatedCount <= 3) {
			rows = 5;
			cols = 5;
		} else if (generatedCount <= 5) {
			rows = 6;
			cols = 5;
		} else if (generatedCount <= 7) {
			rows = 6;
			cols = 6;
		} else {
			rows = 7;
			cols = 6;
		}
	}

	public void generateColorIndex() {
		colorIndex = random.nextInt(DifferentColorModel.colorChoices.length);
	}

	public void generateUniqueColorType() {
		int temp = random.nextInt(2);
		if (temp == 0) {
			isLightColor = true;
		} else {
			isLightColor = false;
		}
	}

	public void generateColors() {
		generateRowsAndCols();
		generateColorIndex();
		generateUniqueColorType(); // for light or dark

		colors = new Color[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				colors[i][j] = colorChoices[colorIndex];
			}
		}

		if (isLightColor) {
			colors[random.nextInt(rows)][random.nextInt(cols)] = colorUniqueLight[colorIndex];
		} else {
			colors[random.nextInt(rows)][random.nextInt(cols)] = colorUniqueDark[colorIndex];
		}
		generatedCount += 1;
	}

	public void updateScore(Color obtainedColor) {
		Color requiredColor = null;
		if (isLightColor) {
			requiredColor = colorUniqueLight[colorIndex];
		} else {
			requiredColor = colorUniqueDark[colorIndex];
		}
		if (requiredColor.equals(obtainedColor)) {
			score += 100;
		} else {
			score -= 50;
			if (score < 0) {
				score = 0;
			}
		}
	}
}
