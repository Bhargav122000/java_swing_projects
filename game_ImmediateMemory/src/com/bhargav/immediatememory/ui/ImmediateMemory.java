package com.bhargav.immediatememory.ui;

import java.util.Random;

public class ImmediateMemory {
	private Random random;
	private int count;
	private int generatedNumber;
	private int providedNumber;
	private boolean isMatched;
	private int score;
	private int origin = 10, bound = 100;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getGeneratedNumber() {
		return generatedNumber;
	}

	public void setGeneratedNumber(int generatedNumber) {
		this.generatedNumber = generatedNumber;
	}

	public int getProvidedNumber() {
		return providedNumber;
	}

	public void setProvidedNumber(int providedNumber) {
		this.providedNumber = providedNumber;
	}

	public boolean isMatched() {
		return isMatched;
	}

	public void setMatched(boolean isMatched) {
		this.isMatched = isMatched;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getOrigin() {
		return origin;
	}

	public void setOrigin(int origin) {
		this.origin = origin;
	}

	public int getBound() {
		return bound;
	}

	public void setBound(int bound) {
		this.bound = bound;
	}

	public ImmediateMemory() {
		random = new Random();
	}

	public void generateNumber() {
		generatedNumber = 0;

		if (count >= 2) {
			if (count % 2 == 0) {
				origin = origin * 10;
				bound = bound * 10;
			}
		}
		generatedNumber = random.nextInt(origin, bound);
		count++;
	}

	public void decideResult() {
		if (providedNumber == generatedNumber) {
			isMatched = true;
		} else {
			isMatched = false;
		}
	}

	public void updateScore(int value) {
		if (isMatched) {
			score = score + (int) Math.floor(1000 * 20 / value);
		}
	}
}
