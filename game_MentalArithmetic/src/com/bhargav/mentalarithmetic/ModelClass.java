package com.bhargav.mentalarithmetic;

import java.util.ArrayList;
import java.util.Random;

public class ModelClass {
	private Random random;
	private int level;
	private ArrayList<String> terms;
	private int actualValue;
	private int providedValue;
	private int score;

	public ModelClass() {
		random = new Random();
		terms = new ArrayList<String>();
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public ArrayList<String> getTerms() {
		return terms;
	}

	public void setTerms(ArrayList<String> terms) {
		this.terms = terms;
	}

	public int getActualValue() {
		return actualValue;
	}

	public void setActualValue(int actualValue) {
		this.actualValue = actualValue;
	}

	public int getProvidedValue() {
		return providedValue;
	}

	public void setProvidedValue(int providedValue) {
		this.providedValue = providedValue;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String generateOperator() {
		String[] operators = { "+", "-", "*", "/" };
		int index = random.nextInt(0, operators.length);
		return operators[index];
	}

	public int generateOperand(String operator) {
		int operand = -1;
		if (operator.equals("+")) {
			operand = random.nextInt(1, 10);
			actualValue += operand;
		} else if (operator.equals("-")) {
			operand = random.nextInt(1, 10);
			actualValue -= operand;
		} else if (operator.equals("*")) {
			operand = random.nextInt(1, 10);
			actualValue *= operand;
		} else {
			do {
				operand = random.nextInt(1, 10);
			} while ((actualValue % operand) != 0);
			actualValue /= operand;
		}

		return operand;
	}

	public void generateTerms() {
		int temp = -1;
		String operator = null;
		int operand = -1;
		String term = null;

		for (int i = 0; i <= level + 1; i++) {
			if (terms.size() == 0) {
				temp = random.nextInt(1, 10);
				if (random.nextBoolean()) {
					temp *= -1;
				}
				actualValue = temp;
				term = String.valueOf(temp);
			} else {
				operator = generateOperator();
				operand = generateOperand(operator);
				term = operator + operand;
			}

			terms.add(term);
		}
	}

	public boolean isValueMatched() {
		boolean result = false;
		if (providedValue == actualValue) {
			result = true;
		}
		return result;
	}

	public void updateLevel() {
		if (isValueMatched()) {
			level += 1;
		}
		terms.clear();
	}

	public void updateScore() {
		if (isValueMatched()) {
			score += ((level + 1) * (25 + 5 * (level)));
		} else {
			score -= 50;
			if (score < 0) {
				score = 0;
			}
		}
	}
}
