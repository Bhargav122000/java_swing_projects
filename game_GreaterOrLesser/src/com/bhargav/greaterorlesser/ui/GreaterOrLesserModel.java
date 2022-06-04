package com.bhargav.greaterorlesser.ui;

import java.util.Random;

public class GreaterOrLesserModel {
	private static Random random = new Random();
	private static String[] operators = { "+", "-", "*", "/" };

	private String level;
	private String expression;
	private String leftExpression;
	private int leftExpressionValue;
	private String rightExpression;
	private int rightExpressionValue;
	private String comparator;
	private boolean expectedResult;
	private boolean expressionResult;
	private int score;

	public GreaterOrLesserModel() {
		level = null;
		expression = null;
		leftExpression = null;
		rightExpression = null;
		comparator = null;
		expectedResult = false;
		expressionResult = false;
		score = 0;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public boolean isExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(boolean expectedResult) {
		this.expectedResult = expectedResult;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	private void generateComparator() {
		boolean temp = GreaterOrLesserModel.random.nextBoolean();
		if (temp) {
			comparator = ">";
		} else {
			comparator = "<";
		}
	}

	private String generateOperator() {
		return operators[GreaterOrLesserModel.random.nextInt(4)];
	}

	private void generateSubExpressionAndEvaluate(String name) {
		boolean hasOperator = false;
		String operator = null;
		String expr = null;
		int exprValue = 0;
		boolean temp = false;
		int operand1 = 0, operand2 = 0;

		if (level.equals("easy")) {
			temp = GreaterOrLesserModel.random.nextBoolean();
			if (temp) {
				hasOperator = true;
				operator = generateOperator();
				if (operator.equals("+")) {
					operand1 = GreaterOrLesserModel.random.nextInt(1, 10);
					operand2 = GreaterOrLesserModel.random.nextInt(1, 10);
					exprValue = operand1 + operand2;
				} else if (operator.equals("-")) {
					operand1 = GreaterOrLesserModel.random.nextInt(1, 10);
					do {
						operand2 = GreaterOrLesserModel.random.nextInt(1, 10);
					} while (operand2 >= operand1);
					exprValue = operand1 - operand2;
				} else if (operator.equals("*")) {
					operand1 = GreaterOrLesserModel.random.nextInt(1, 6);
					operand2 = GreaterOrLesserModel.random.nextInt(1, 6);
					exprValue = operand1 * operand2;
				} else {
					operand2 = GreaterOrLesserModel.random.nextInt(1, 6);
					operand1 = operand2 * GreaterOrLesserModel.random.nextInt(1, 10);
					exprValue = operand1 / operand2;
				}
			} else {
				hasOperator = false;
				operand1 = GreaterOrLesserModel.random.nextInt(1, 100);
				exprValue = operand1;
			}
		} else if (level.equals("medium")) {
			hasOperator = true;
			operator = generateOperator();
			if (operator.equals("+")) {
				operand1 = GreaterOrLesserModel.random.nextInt(1, 50);
				operand2 = GreaterOrLesserModel.random.nextInt(1, 50);
				exprValue = operand1 + operand2;
			} else if (operator.equals("-")) {
				operand1 = GreaterOrLesserModel.random.nextInt(1, 100);
				do {
					operand2 = GreaterOrLesserModel.random.nextInt(1, 100);
				} while (operand2 >= operand1);
				exprValue = operand1 - operand2;
			} else if (operator.equals("*")) {
				operand1 = GreaterOrLesserModel.random.nextInt(1, 10);
				operand2 = GreaterOrLesserModel.random.nextInt(1, 10);
				exprValue = operand1 * operand2;
			} else {
				operand2 = GreaterOrLesserModel.random.nextInt(1, 10);
				operand1 = operand2 * GreaterOrLesserModel.random.nextInt(1, 10);
				exprValue = operand1 / operand2;
			}
		} else {
			hasOperator = true;
			operator = generateOperator();
			if (operator.equals("+")) {
				operand1 = GreaterOrLesserModel.random.nextInt(1, 200);
				operand2 = GreaterOrLesserModel.random.nextInt(1, 200);
				exprValue = operand1 + operand2;
			} else if (operator.equals("-")) {
				operand1 = GreaterOrLesserModel.random.nextInt(1, 200);
				do {
					operand2 = GreaterOrLesserModel.random.nextInt(1, 200);
				} while (operand2 >= operand1);
				exprValue = operand1 - operand2;
			} else if (operator.equals("*")) {
				operand1 = GreaterOrLesserModel.random.nextInt(1, 20);
				operand2 = GreaterOrLesserModel.random.nextInt(1, 20);
				exprValue = operand1 * operand2;
			} else {
				operand2 = GreaterOrLesserModel.random.nextInt(1, 20);
				operand1 = operand2 * GreaterOrLesserModel.random.nextInt(1, 20);
				exprValue = operand1 / operand2;
			}
		}

		if (hasOperator) {
			expr = String.valueOf(operand1) + " " + operator + " " + String.valueOf(operand2);
		} else {
			expr = String.valueOf(operand1);
		}

		if (name.equals("left")) {
			leftExpression = expr;
			leftExpressionValue = exprValue;
		} else {
			rightExpression = expr;
			rightExpressionValue = exprValue;
		}
	}

	public void generateExpressionAndEvaluate() {
		generateSubExpressionAndEvaluate("left");
		generateSubExpressionAndEvaluate("right");
		generateComparator();
		expression = leftExpression + " " + comparator + " " + rightExpression;

		if (comparator.equals(">")) {
			if (leftExpressionValue > rightExpressionValue) {
				expressionResult = true;
			} else {
				expressionResult = false;
			}
		} else {
			if (leftExpressionValue < rightExpressionValue) {
				expressionResult = true;
			} else {
				expressionResult = false;
			}
		}
	}

	public void updateScore() {
		if (expectedResult == expressionResult) {
			score += 100;
		} else {
			score -= 50;
			if (score < 0) {
				score = 0;
			}
		}
	}
}
