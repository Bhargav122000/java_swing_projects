package com.bhargav.greaterorlesser;

import java.util.Scanner;
import java.util.Random;

public class ExpressionsGeneration {
	private static Scanner scanner = new Scanner(System.in);
	private static Random random = new Random();
	private static String[] operators = { "+", "-", "*", "/" };

	private String level;
	private String expression;
	private boolean hasLeftOperator;
	private String leftOperator;
	private String leftExpression;
	private boolean hasRightOperator;
	private String rightOperator;
	private String rightExpression;
	private String comparator;

	private void generateComparator() {
		boolean temp = ExpressionsGeneration.random.nextBoolean();
		if (temp) {
			comparator = ">";
		} else {
			comparator = "<";
		}
	}

	private String generateOperator() {
		return operators[ExpressionsGeneration.random.nextInt(4)];
	}
	
	private void generateLeftExpression() {
		boolean temp;
		int operand1 = 0, operand2 = 0;

		if (level.equals("easy")) {
			temp = ExpressionsGeneration.random.nextBoolean();
			if (temp) {
				hasLeftOperator = true;
				leftOperator = generateOperator();
				if (leftOperator.equals("+")) {
					operand1 = ExpressionsGeneration.random.nextInt(1, 10);
					operand2 = ExpressionsGeneration.random.nextInt(1, 10);
				} else if (leftOperator.equals("-")) {
					operand1 = ExpressionsGeneration.random.nextInt(1, 10);
					do {
						operand2 = ExpressionsGeneration.random.nextInt(1, 10);
					} while (operand2 >= operand1);
				} else if (leftOperator.equals("*")) {
					operand1 = ExpressionsGeneration.random.nextInt(1, 6);
					operand2 = ExpressionsGeneration.random.nextInt(1, 6);
				} else {
					operand2 = ExpressionsGeneration.random.nextInt(1, 6);
					operand1 = operand2 * ExpressionsGeneration.random.nextInt(1, 10);
				}
			} else {
				hasLeftOperator = false;
				operand1 = ExpressionsGeneration.random.nextInt(1, 100);
			}
		} else if (level.equals("medium")) {
			hasLeftOperator = true;
			leftOperator = generateOperator();
			if (leftOperator.equals("+")) {
				operand1 = ExpressionsGeneration.random.nextInt(1, 50);
				operand2 = ExpressionsGeneration.random.nextInt(1, 50);
			} else if (leftOperator.equals("-")) {
				operand1 = ExpressionsGeneration.random.nextInt(1, 100);
				do {
					operand2 = ExpressionsGeneration.random.nextInt(1, 100);
				} while (operand2 >= operand1);
			} else if (leftOperator.equals("*")) {
				operand1 = ExpressionsGeneration.random.nextInt(1, 10);
				operand2 = ExpressionsGeneration.random.nextInt(1, 10);
			} else {
				operand2 = ExpressionsGeneration.random.nextInt(1, 10);
				operand1 = operand2 * ExpressionsGeneration.random.nextInt(1, 10);
			}
		} else {
			hasLeftOperator = true;
			leftOperator = generateOperator();
			if (leftOperator.equals("+")) {
				operand1 = ExpressionsGeneration.random.nextInt(1, 200);
				operand2 = ExpressionsGeneration.random.nextInt(1, 200);
			} else if (leftOperator.equals("-")) {
				operand1 = ExpressionsGeneration.random.nextInt(1, 200);
				do {
					operand2 = ExpressionsGeneration.random.nextInt(1, 200);
				} while (operand2 >= operand1);
			} else if (leftOperator.equals("*")) {
				operand1 = ExpressionsGeneration.random.nextInt(1, 20);
				operand2 = ExpressionsGeneration.random.nextInt(1, 20);
			} else {
				operand2 = ExpressionsGeneration.random.nextInt(1, 20);
				operand1 = operand2 * ExpressionsGeneration.random.nextInt(1, 20);
			}
		}

		if (hasLeftOperator) {
			leftExpression = String.valueOf(operand1) + " " + leftOperator + " " + String.valueOf(operand2);
		} else {
			leftExpression = String.valueOf(operand1);
		}
	}

	private void generateRightExpression() {
		boolean temp;
		int operand1 = 0, operand2 = 0;

		if (level.equals("easy")) {
			temp = ExpressionsGeneration.random.nextBoolean();
			if (temp) {
				hasRightOperator = true;
				rightOperator = generateOperator();
				if (rightOperator.equals("+")) {
					operand1 = ExpressionsGeneration.random.nextInt(1, 10);
					operand2 = ExpressionsGeneration.random.nextInt(1, 10);
				} else if (rightOperator.equals("-")) {
					operand1 = ExpressionsGeneration.random.nextInt(1, 10);
					do {
						operand2 = ExpressionsGeneration.random.nextInt(1, 10);
					} while (operand2 >= operand1);
				} else if (rightOperator.equals("*")) {
					operand1 = ExpressionsGeneration.random.nextInt(1, 6);
					operand2 = ExpressionsGeneration.random.nextInt(1, 6);
				} else {
					operand2 = ExpressionsGeneration.random.nextInt(1, 6);
					operand1 = operand2 * ExpressionsGeneration.random.nextInt(1, 10);
				}
			} else {
				hasRightOperator = false;
				operand1 = ExpressionsGeneration.random.nextInt(1, 100);
			}
		} else if (level.equals("medium")) {
			hasRightOperator = true;
			rightOperator = generateOperator();
			if (rightOperator.equals("+")) {
				operand1 = ExpressionsGeneration.random.nextInt(1, 50);
				operand2 = ExpressionsGeneration.random.nextInt(1, 50);
			} else if (rightOperator.equals("-")) {
				operand1 = ExpressionsGeneration.random.nextInt(1, 100);
				do {
					operand2 = ExpressionsGeneration.random.nextInt(1, 100);
				} while (operand2 >= operand1);
			} else if (rightOperator.equals("*")) {
				operand1 = ExpressionsGeneration.random.nextInt(1, 10);
				operand2 = ExpressionsGeneration.random.nextInt(1, 10);
			} else {
				operand2 = ExpressionsGeneration.random.nextInt(1, 10);
				operand1 = operand2 * ExpressionsGeneration.random.nextInt(1, 10);
			}
		} else {
			hasRightOperator = true;
			rightOperator = generateOperator();
			if (rightOperator.equals("+")) {
				operand1 = ExpressionsGeneration.random.nextInt(1, 200);
				operand2 = ExpressionsGeneration.random.nextInt(1, 200);
			} else if (rightOperator.equals("-")) {
				operand1 = ExpressionsGeneration.random.nextInt(1, 200);
				do {
					operand2 = ExpressionsGeneration.random.nextInt(1, 200);
				} while (operand2 >= operand1);
			} else if (rightOperator.equals("*")) {
				operand1 = ExpressionsGeneration.random.nextInt(1, 20);
				operand2 = ExpressionsGeneration.random.nextInt(1, 20);
			} else {
				operand2 = ExpressionsGeneration.random.nextInt(1, 20);
				operand1 = operand2 * ExpressionsGeneration.random.nextInt(1, 20);
			}
		}

		if (hasRightOperator) {
			rightExpression = String.valueOf(operand1) + " " + rightOperator + " " + String.valueOf(operand2);
		} else {
			rightExpression = String.valueOf(operand1);
		}
	}
	
	private void generateExpression() {
		generateLeftExpression();
		generateComparator();
		generateRightExpression();
		expression = leftExpression + " " + comparator + " " + rightExpression;
	}

	public void start() {
		String choice;
		do {
			System.out.println("Difficulty levels: Easy Medium Hard");
			System.out.println("Choose one level:");
			level = scanner.nextLine().toLowerCase();
			if (level.equals("easy") || level.equals("medium") || level.equals("hard")) {
				generateExpression();
				System.out.println(expression);
			} else {
				System.out.println("Invalid choice of difficulty level");
			}
			System.out.println("want to continue??[yes/no]");
			choice = scanner.nextLine().toLowerCase();
		} while (choice.equals("yes"));
		System.out.println("Done..");
	}

	public static void main(String[] args) {
		ExpressionsGeneration expressionsGeneration = new ExpressionsGeneration();
		expressionsGeneration.start();
	}
}
