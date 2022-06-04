package com.bhargav.greaterorlesser.cli;

import java.util.Scanner;
import java.util.Random;

public class GreaterOrLesserCLI {
	private static Scanner scanner = new Scanner(System.in);
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
	private boolean isResultMatched;

	public GreaterOrLesserCLI() {
		level = null;
		expression = null;
		leftExpression = null;
		rightExpression = null;
		comparator = null;
		expectedResult = false;
		expressionResult = false;
		isResultMatched = false;
	}

	private void generateComparator() {
		boolean temp = GreaterOrLesserCLI.random.nextBoolean();
		if (temp) {
			comparator = ">";
		} else {
			comparator = "<";
		}
	}

	private String generateOperator() {
		return operators[GreaterOrLesserCLI.random.nextInt(4)];
	}

	private void generateSubExpressionAndEvaluate(String name) {
		boolean hasOperator = false;
		String operator = null;
		String expr = null;
		int exprValue = 0;
		boolean temp = false;
		int operand1 = 0, operand2 = 0;

		if (level.equals("easy")) {
			temp = GreaterOrLesserCLI.random.nextBoolean();
			if (temp) {
				hasOperator = true;
				operator = generateOperator();
				if (operator.equals("+")) {
					operand1 = GreaterOrLesserCLI.random.nextInt(1, 10);
					operand2 = GreaterOrLesserCLI.random.nextInt(1, 10);
					exprValue = operand1 + operand2;
				} else if (operator.equals("-")) {
					operand1 = GreaterOrLesserCLI.random.nextInt(1, 10);
					do {
						operand2 = GreaterOrLesserCLI.random.nextInt(1, 10);
					} while (operand2 >= operand1);
					exprValue = operand1 - operand2;
				} else if (operator.equals("*")) {
					operand1 = GreaterOrLesserCLI.random.nextInt(1, 6);
					operand2 = GreaterOrLesserCLI.random.nextInt(1, 6);
					exprValue = operand1 * operand2;
				} else {
					operand2 = GreaterOrLesserCLI.random.nextInt(1, 6);
					operand1 = operand2 * GreaterOrLesserCLI.random.nextInt(1, 10);
					exprValue = operand1 / operand2;
				}
			} else {
				hasOperator = false;
				operand1 = GreaterOrLesserCLI.random.nextInt(1, 100);
				exprValue = operand1;
			}
		} else if (level.equals("medium")) {
			hasOperator = true;
			operator = generateOperator();
			if (operator.equals("+")) {
				operand1 = GreaterOrLesserCLI.random.nextInt(1, 50);
				operand2 = GreaterOrLesserCLI.random.nextInt(1, 50);
				exprValue = operand1 + operand2;
			} else if (operator.equals("-")) {
				operand1 = GreaterOrLesserCLI.random.nextInt(1, 100);
				do {
					operand2 = GreaterOrLesserCLI.random.nextInt(1, 100);
				} while (operand2 >= operand1);
				exprValue = operand1 - operand2;
			} else if (operator.equals("*")) {
				operand1 = GreaterOrLesserCLI.random.nextInt(1, 10);
				operand2 = GreaterOrLesserCLI.random.nextInt(1, 10);
				exprValue = operand1 * operand2;
			} else {
				operand2 = GreaterOrLesserCLI.random.nextInt(1, 10);
				operand1 = operand2 * GreaterOrLesserCLI.random.nextInt(1, 10);
				exprValue = operand1 / operand2;
			}
		} else {
			hasOperator = true;
			operator = generateOperator();
			if (operator.equals("+")) {
				operand1 = GreaterOrLesserCLI.random.nextInt(1, 200);
				operand2 = GreaterOrLesserCLI.random.nextInt(1, 200);
				exprValue = operand1 + operand2;
			} else if (operator.equals("-")) {
				operand1 = GreaterOrLesserCLI.random.nextInt(1, 200);
				do {
					operand2 = GreaterOrLesserCLI.random.nextInt(1, 200);
				} while (operand2 >= operand1);
				exprValue = operand1 - operand2;
			} else if (operator.equals("*")) {
				operand1 = GreaterOrLesserCLI.random.nextInt(1, 20);
				operand2 = GreaterOrLesserCLI.random.nextInt(1, 20);
				exprValue = operand1 * operand2;
			} else {
				operand2 = GreaterOrLesserCLI.random.nextInt(1, 20);
				operand1 = operand2 * GreaterOrLesserCLI.random.nextInt(1, 20);
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

	public void decideResult() {
		if (expectedResult == expressionResult) {
			isResultMatched = true;
		} else {
			isResultMatched = false;
		}
	}

	public void playGame() {
		String continueChoice;
		String choice;
		do {
			generateExpressionAndEvaluate();
			System.out.println("\nGiven Expression: " + expression);

			do {
				System.out.println("Is it [true/false]: ");
				choice = scanner.nextLine().toLowerCase().trim();
			} while (!(choice.equals("true") || choice.equals("false")));
			expectedResult = Boolean.parseBoolean(choice);

			decideResult();
			if (isResultMatched) {
				System.out.println("Right choice\n");
			} else {
				System.out.println("Wrong choice\n");
			}

			System.out.println("want to continue with same difficulty level??[yes/no]");
			continueChoice = scanner.nextLine().toLowerCase();
		} while (continueChoice.equals("yes"));
	}

	public void startGame() {
		System.out.println("Game is started...");

		String choice = null;
		do {
			System.out.println("Difficulty levels: Easy Medium Hard");
			System.out.println("Choose one level:");
			level = scanner.nextLine().toLowerCase().trim();
			if (level.equals("easy") || level.equals("medium") || level.equals("hard")) {
				playGame();
			} else {
				System.out.println("Please choose a valid Difficulty level");
			}
			System.out.println("Do you want to continue play??[yes/no]");
			choice = scanner.nextLine().toLowerCase().trim();
		} while (choice.equals("yes"));

		System.out.println("Game is ended...");
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Greater or Lesser game..!");
		GreaterOrLesserCLI expressionsGeneration = new GreaterOrLesserCLI();
		expressionsGeneration.startGame();
	}
}
