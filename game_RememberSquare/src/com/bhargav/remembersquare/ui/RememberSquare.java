package com.bhargav.remembersquare.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RememberSquare {
	private Random random;
	private int level;
	private int cells;
	private int rows;
	private int cols;
	private int highlightedCellsCount;
	private ArrayList<Integer> highlightedCellsIndices;
	private int score;

	public RememberSquare() {
		random = new Random();
		level = cells = rows = cols = highlightedCellsCount = score = 0;
		highlightedCellsIndices = new ArrayList<Integer>();
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCells() {
		return cells;
	}

	public void setCells(int cells) {
		this.cells = cells;
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

	public int getHighlightedCellsCount() {
		return highlightedCellsCount;
	}

	public void setHighlightedCellsCount(int highlightedCellsCount) {
		this.highlightedCellsCount = highlightedCellsCount;
	}

	public ArrayList<Integer> getHighlightedCellsIndices() {
		return highlightedCellsIndices;
	}

	public void setHighlightedCellsIndices(ArrayList<Integer> highlightedCellsIndices) {
		this.highlightedCellsIndices = highlightedCellsIndices;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	private void highlightCells() {
		int i = 0, cell = -1;
		while (i < highlightedCellsCount) {
			cell = random.nextInt(0, cells);
			if (highlightedCellsIndices.indexOf(cell) == -1) {
				highlightedCellsIndices.add(cell);
				i++;
			}
		}
		Collections.sort(highlightedCellsIndices);
	}

	public void generateNow() {
		level += 1;

		if (level % 2 == 0) {
			rows = 3 + ((level - 2) / 2);
			cols = 3 + (level / 2);
		} else {
			rows = cols = 3 + (level / 2);
		}
		cells = rows * cols;
		highlightedCellsCount = level + 2;
		highlightedCellsIndices.clear();
		highlightCells();
	}

	public boolean isTotallyMatched() {
		if (highlightedCellsCount == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValidAttempt(int cell) {
		boolean result = false;
		int index = highlightedCellsIndices.indexOf(cell);
		if (index != -1) {
			highlightedCellsIndices.remove(index);
			highlightedCellsCount -= 1;
			result = true;
		}
		return result;
	}

	public void updateScore() {
		score = score + (level * 25);
	}
}
