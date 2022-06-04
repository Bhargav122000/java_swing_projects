// Model class
package com.bhargav.colorswords.ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class ColorsAndWords {

	private static Color[] colors = { Color.black, Color.blue, Color.gray, Color.green, Color.magenta, Color.orange,
			Color.pink, Color.red, Color.white, Color.yellow };
	private static String[] words = { "Black", "Blue", "Gray", "Green", "Magenta", "Orange", "Pink", "Red", "White",
			"Yellow" };
	private static Random random = new Random();

	private int wordIndex;
	private int wordColorIndex;
	private String word;
	private Color wordColor;
	private Color[] colorOptions;

	public int getWordIndex() {
		return wordIndex;
	}

	public void setWordIndex(int wordIndex) {
		this.wordIndex = wordIndex;
	}

	public int getWordColorIndex() {
		return wordColorIndex;
	}

	public void setWordColorIndex(int wordColorIndex) {
		this.wordColorIndex = wordColorIndex;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Color getWordColor() {
		return wordColor;
	}

	public void setWordColor(Color wordColor) {
		this.wordColor = wordColor;
	}

	public Color[] getColorOptions() {
		return colorOptions;
	}

	public void setColorOptions(Color[] colorOptions) {
		this.colorOptions = colorOptions;
	}

	public ColorsAndWords(int size) {
		colorOptions = new Color[size];
	}

	public void generateWord() {
		wordIndex = ColorsAndWords.random.nextInt(10);
		word = ColorsAndWords.words[wordIndex];
		wordColorIndex = ColorsAndWords.random.nextInt(10);
		wordColor = ColorsAndWords.colors[wordColorIndex];
	}

	public void generateColorOptions() {
		Color temp;
		ArrayList<Color> chosenIndices = new ArrayList<Color>();
		chosenIndices.add(ColorsAndWords.colors[wordIndex]);

		for (int i = 0; i < colorOptions.length; i++) {
			do {
				temp = ColorsAndWords.colors[ColorsAndWords.random.nextInt(10)];
			} while (chosenIndices.indexOf(temp) != -1);

			colorOptions[i] = temp;
			chosenIndices.add(temp);
		}

		temp = ColorsAndWords.colors[wordIndex];
		int index1 = ColorsAndWords.random.nextInt(colorOptions.length);
		colorOptions[index1] = temp;

		if (wordIndex != wordColorIndex && chosenIndices.indexOf(wordColor) == -1) {
			while (true) {
				int index2 = ColorsAndWords.random.nextInt(colorOptions.length);
				if (index2 != index1) {
					temp = ColorsAndWords.colors[wordColorIndex];
					colorOptions[index2] = temp;
					break;
				}
			}
		}

		chosenIndices.clear();
	}

	public boolean isMatched(Color color) {
		boolean result = false;
		if (color.equals(ColorsAndWords.colors[wordIndex])) {
			result = true;
		}
		return result;
	}

}
