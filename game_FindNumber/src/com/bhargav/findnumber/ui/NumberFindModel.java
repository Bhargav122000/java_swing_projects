package com.bhargav.findnumber.ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class NumberFindModel {
	private static Random random = new Random();
	private static ArrayList<Color> lightColors = new ArrayList<Color>(Arrays.asList(new Color(51, 102, 204),
			new Color(0, 153, 204), new Color(179, 102, 255), new Color(255, 102, 255), new Color(51, 255, 51),
			new Color(255, 102, 179), new Color(255, 133, 51), new Color(255, 77, 77), new Color(255, 153, 51),
			new Color(255, 184, 77), new Color(210, 121, 121), new Color(255, 255, 77)));
	private static ArrayList<Color> darkColors = new ArrayList<Color>(
			Arrays.asList(new Color(0, 0, 102), new Color(0, 51, 102), new Color(51, 0, 102), new Color(128, 0, 128),
					new Color(0, 102, 0), new Color(153, 0, 77), new Color(204, 82, 0), new Color(255, 0, 0),
					new Color(153, 77, 0), new Color(255, 153, 0), new Color(153, 51, 51), new Color(102, 102, 0)));
	private static final int size = 30;

	private int requiredNumber;
	private Color requiredForeground;
	private Color requiredBackground;
	private int[] numbers;
	private Color[] foregrounds;
	private Color[] backgrounds;
	private int score;

	private int bufferCount;
	private ArrayList<Integer> bufferIndices;

	public NumberFindModel() {
		numbers = new int[NumberFindModel.size];
		foregrounds = new Color[NumberFindModel.size];
		backgrounds = new Color[NumberFindModel.size];
		bufferCount = 0;
		bufferIndices = new ArrayList<Integer>();
	}

	public int getRequiredNumber() {
		return requiredNumber;
	}

	public void setRequiredNumber(int requiredNumber) {
		this.requiredNumber = requiredNumber;
	}

	public Color getRequiredForeground() {
		return requiredForeground;
	}

	public void setRequiredForeground(Color requiredForeground) {
		this.requiredForeground = requiredForeground;
	}

	public Color getRequiredBackground() {
		return requiredBackground;
	}

	public void setRequiredBackground(Color requiredBackground) {
		this.requiredBackground = requiredBackground;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public Color[] getForegrounds() {
		return foregrounds;
	}

	public void setForegrounds(Color[] foregrounds) {
		this.foregrounds = foregrounds;
	}

	public Color[] getBackgrounds() {
		return backgrounds;
	}

	public void setBackgrounds(Color[] backgrounds) {
		this.backgrounds = backgrounds;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	private void generateRequiredNumber() {
		requiredNumber = NumberFindModel.random.nextInt(10);
	}

	private void generateRequiredForeground() {
		int type = NumberFindModel.random.nextInt(2);
		int index;
		if (type == 0) {
			index = NumberFindModel.random.nextInt(lightColors.size());
			requiredForeground = lightColors.get(index);
		} else {
			index = NumberFindModel.random.nextInt(darkColors.size());
			requiredForeground = darkColors.get(index);
		}
	}

	private void generateRequiredBackground() {
		int index;
		if (NumberFindModel.lightColors.indexOf(requiredForeground) == -1) {
			index = NumberFindModel.random.nextInt(lightColors.size());
			requiredBackground = lightColors.get(index);
		} else {
			index = NumberFindModel.random.nextInt(darkColors.size());
			requiredBackground = darkColors.get(index);
		}
	}

	private void generateNumbers() {
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = NumberFindModel.random.nextInt(10);
		}

		bufferCount = NumberFindModel.random.nextInt(2, 6);
		bufferIndices.clear();
		int index;
		for (int i = 0; i < bufferCount; i++) {
			do {
				index = NumberFindModel.random.nextInt(numbers.length);
				if (numbers[index] == requiredNumber) {
					continue;
				}
			} while (bufferIndices.indexOf(index) != -1);
			bufferIndices.add(index);
			numbers[index] = requiredNumber;
		}
	}

	private void generateForegrounds() {
		int type;
		int index;
		for (int i = 0; i < foregrounds.length; i++) {
			do {
				type = NumberFindModel.random.nextInt(2);
				if (type == 0) {
					index = NumberFindModel.random.nextInt(lightColors.size());
					foregrounds[i] = lightColors.get(index);
				} else {
					index = NumberFindModel.random.nextInt(darkColors.size());
					foregrounds[i] = darkColors.get(index);
				}
			} while (numbers[i] == requiredNumber && foregrounds[i].equals(requiredForeground));
		}
	}

	private void generateBackgrounds() {
		int index;
		for (int i = 0; i < backgrounds.length; i++) {
			if (NumberFindModel.lightColors.indexOf(foregrounds[i]) == -1) {
				index = NumberFindModel.random.nextInt(lightColors.size());
				backgrounds[i] = lightColors.get(index);
			} else {
				index = NumberFindModel.random.nextInt(darkColors.size());
				backgrounds[i] = darkColors.get(index);
			}
		}

		index = NumberFindModel.random.nextInt(numbers.length);
		numbers[index] = requiredNumber;
		foregrounds[index] = requiredForeground;
	}

	public void generateAgain() {
		generateRequiredNumber();
		generateRequiredForeground();
		generateRequiredBackground();
		generateNumbers();
		generateForegrounds();
		generateBackgrounds();
	}

	public void updateScore(int obtainedNumber, Color obtainedForeground) {
		if (obtainedNumber == requiredNumber) {
			if (obtainedForeground.equals(requiredForeground)) {
				score += 100;
			} else {
				score -= 50;
			}
		} else {
			score -= 50;
		}

		if (score < 0) {
			score = 0;
		}
	}
}
