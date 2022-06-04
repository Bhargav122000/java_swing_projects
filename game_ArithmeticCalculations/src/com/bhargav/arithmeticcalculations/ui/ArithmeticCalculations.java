package com.bhargav.arithmeticcalculations.ui;

import java.util.*;

public abstract class ArithmeticCalculations {

	private String expression;
	private String leftSubExpression;
	private String rightSubExpression;
	private boolean hasLeftSubExpressionOperator;
	private boolean hasRightSubExpressionOperator;
	private String expressionOperator;
	private String leftSubExpressionOperator;
	private String rightSubExpressionOperator;
	private int expressionValue;
	private int leftSubExpressionValue;
	private int rightSubExpressionValue;
	private int predictedValue;
	private int score;

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getLeftSubExpression() {
		return leftSubExpression;
	}

	public void setLeftSubExpression(String leftSubExpression) {
		this.leftSubExpression = leftSubExpression;
	}

	public String getRightSubExpression() {
		return rightSubExpression;
	}

	public void setRightSubExpression(String rightSubExpression) {
		this.rightSubExpression = rightSubExpression;
	}

	public boolean isHasLeftSubExpressionOperator() {
		return hasLeftSubExpressionOperator;
	}

	public void setHasLeftSubExpressionOperator(boolean hasLeftSubExpressionOperator) {
		this.hasLeftSubExpressionOperator = hasLeftSubExpressionOperator;
	}

	public boolean isHasRightSubExpressionOperator() {
		return hasRightSubExpressionOperator;
	}

	public void setHasRightSubExpressionOperator(boolean hasRightSubExpressionOperator) {
		this.hasRightSubExpressionOperator = hasRightSubExpressionOperator;
	}

	public String getExpressionOperator() {
		return expressionOperator;
	}

	public void setExpressionOperator(String expressionOperator) {
		this.expressionOperator = expressionOperator;
	}

	public String getLeftSubExpressionOperator() {
		return leftSubExpressionOperator;
	}

	public void setLeftSubExpressionOperator(String leftSubExpressionOperator) {
		this.leftSubExpressionOperator = leftSubExpressionOperator;
	}

	public String getRightSubExpressionOperator() {
		return rightSubExpressionOperator;
	}

	public void setRightSubExpressionOperator(String rightSubExpressionOperator) {
		this.rightSubExpressionOperator = rightSubExpressionOperator;
	}

	public int getExpressionValue() {
		return expressionValue;
	}

	public void setExpressionValue(int expressionValue) {
		this.expressionValue = expressionValue;
	}

	public int getLeftSubExpressionValue() {
		return leftSubExpressionValue;
	}

	public void setLeftSubExpressionValue(int leftSubExpressionValue) {
		this.leftSubExpressionValue = leftSubExpressionValue;
	}

	public int getRightSubExpressionValue() {
		return rightSubExpressionValue;
	}

	public void setRightSubExpressionValue(int rightSubExpressionValue) {
		this.rightSubExpressionValue = rightSubExpressionValue;
	}

	public int getPredictedValue() {
		return predictedValue;
	}

	public void setPredictedValue(int predictedValue) {
		this.predictedValue = predictedValue;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String generateOperator() {
		String[] operators = { "+", "-", "*", "/" };
		return operators[new Random().nextInt(operators.length)];
	}

	public abstract void generateRightSubExpressionAndEvaluate();

	public abstract void generateLeftSubExpressionAndEvaluate();

	public void generateExpressionAndEvaluate() {
		expressionOperator = generateOperator();
		generateRightSubExpressionAndEvaluate();
		generateLeftSubExpressionAndEvaluate();

		if (expressionOperator.equals("+")) {
			expressionValue = leftSubExpressionValue + rightSubExpressionValue;
		} else if (expressionOperator.equals("-")) {
			expressionValue = leftSubExpressionValue - rightSubExpressionValue;
		} else if (expressionOperator.equals("*")) {
			expressionValue = leftSubExpressionValue * rightSubExpressionValue;
		} else {
			expressionValue = leftSubExpressionValue / rightSubExpressionValue;
		}

		expression = leftSubExpression + " " + expressionOperator + " " + rightSubExpression;
	}

	public void updateScore() {
		if (predictedValue == expressionValue) {
			score += 150;
		} else {
			score -= 75;
			if (score < 0) {
				score = 0;
			}
		}
	}
}
