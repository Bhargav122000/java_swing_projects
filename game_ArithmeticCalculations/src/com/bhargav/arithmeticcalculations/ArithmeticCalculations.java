package com.bhargav.arithmeticcalculations;

import java.util.*;

public class ArithmeticCalculations {
	private Scanner scanner;
	private Random random;
	private String difficultyLevel;
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

	public ArithmeticCalculations() {
		scanner = new Scanner(System.in);
		random = new Random();
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

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

	public String generateOperator() {
		String[] operators = { "+", "-", "*", "/" };
		return operators[random.nextInt(operators.length)];
	}

	public void generateRightSubExpressionAndEvaluate() {
		int operand = -1;
		int operand1 = -1, operand2 = -1;

		if (difficultyLevel.equals("easy")) {
			hasRightSubExpressionOperator = false;
			rightSubExpressionOperator = null;

			if (expressionOperator.equals("+")) {
				operand = random.nextInt(0, 100);
			} else if (expressionOperator.equals("-")) {
				operand = random.nextInt(0, 100);
			} else if (expressionOperator.equals("*")) {
				operand = random.nextInt(0, 21);
			} else {
				operand = random.nextInt(1, 10);
			}

			rightSubExpressionValue = operand;
		} else if (difficultyLevel.equals("medium")) {
			hasRightSubExpressionOperator = random.nextBoolean();

			if (hasRightSubExpressionOperator) {
				rightSubExpressionOperator = generateOperator();

				if (rightSubExpressionOperator.equals("+")) {
					if (expressionOperator.equals("+")) {
						operand2 = random.nextInt(1, 51);
						operand1 = random.nextInt(1, 51);
					} else if (expressionOperator.equals("-")) {
						operand2 = random.nextInt(1, 101);
						operand1 = random.nextInt(1, 101);
					} else if (expressionOperator.equals("*")) {
						operand2 = random.nextInt(1, 16);
						operand1 = random.nextInt(1, 16);
					} else {
						operand2 = random.nextInt(1, 21);
						operand1 = random.nextInt(1, 21);
					}

					rightSubExpressionValue = operand1 + operand2;
				} else if (rightSubExpressionOperator.equals("-")) {
					if (expressionOperator.equals("+")) {
						operand2 = random.nextInt(1, 201);
						do {
							operand1 = random.nextInt(1, 201);
						} while (operand1 < operand2);
					} else if (expressionOperator.equals("-")) {
						operand2 = random.nextInt(1, 301);
						do {
							operand1 = random.nextInt(1, 301);
						} while (operand1 < operand2);
					} else if (expressionOperator.equals("*")) {
						operand2 = random.nextInt(1, 31);
						do {
							operand1 = random.nextInt(1, 31);
						} while (operand1 < operand2);
					} else {
						operand2 = random.nextInt(1, 31);
						do {
							operand1 = random.nextInt(1, 31);
						} while (operand1 <= operand2);
					}

					rightSubExpressionValue = operand1 - operand2;
				} else if (rightSubExpressionOperator.equals("*")) {
					if (expressionOperator.equals("+")) {
						operand2 = random.nextInt(0, 21);
						operand1 = random.nextInt(0, 21);
					} else if (expressionOperator.equals("-")) {
						operand2 = random.nextInt(0, 21);
						operand1 = random.nextInt(0, 21);
					} else if (expressionOperator.equals("*")) {
						operand2 = random.nextInt(0, 21);
						operand1 = random.nextInt(0, 21);
					} else {
						operand2 = random.nextInt(1, 11);
						operand1 = random.nextInt(1, 11);
					}

					rightSubExpressionValue = operand1 * operand2;
				} else {
					if (expressionOperator.equals("+")) {
						operand2 = random.nextInt(1, 21);
						operand1 = operand2 * random.nextInt(0, 21);
					} else if (expressionOperator.equals("-")) {
						operand2 = random.nextInt(1, 21);
						operand1 = operand2 * random.nextInt(0, 31);
					} else if (expressionOperator.equals("*")) {
						operand2 = random.nextInt(1, 11);
						operand1 = operand2 * random.nextInt(0, 11);
					} else {
						operand2 = random.nextInt(1, 6);
						operand1 = operand2 * random.nextInt(1, 11);
					}

					rightSubExpressionValue = operand1 / operand2;
				}
			} else {
				rightSubExpressionOperator = null;

				if (expressionOperator.equals("+")) {
					operand = random.nextInt(0, 500);
				} else if (expressionOperator.equals("-")) {
					operand = random.nextInt(0, 500);
				} else if (expressionOperator.equals("*")) {
					operand = random.nextInt(0, 31);
				} else {
					operand = random.nextInt(1, 21);
				}

				rightSubExpressionValue = operand;
			}
		} else {
			hasRightSubExpressionOperator = true;
			rightSubExpressionOperator = generateOperator();

			if (rightSubExpressionOperator.equals("+")) {
				if (expressionOperator.equals("+")) {
					operand2 = random.nextInt(1, 51);
					operand1 = random.nextInt(1, 51);
				} else if (expressionOperator.equals("-")) {
					operand2 = random.nextInt(1, 101);
					operand1 = random.nextInt(1, 101);
				} else if (expressionOperator.equals("*")) {
					operand2 = random.nextInt(1, 16);
					operand1 = random.nextInt(1, 16);
				} else {
					operand2 = random.nextInt(1, 21);
					operand1 = random.nextInt(1, 21);
				}

				rightSubExpressionValue = operand1 + operand2;
			} else if (rightSubExpressionOperator.equals("-")) {
				if (expressionOperator.equals("+")) {
					operand2 = random.nextInt(1, 201);
					do {
						operand1 = random.nextInt(1, 201);
					} while (operand1 < operand2);
				} else if (expressionOperator.equals("-")) {
					operand2 = random.nextInt(1, 301);
					do {
						operand1 = random.nextInt(1, 301);
					} while (operand1 < operand2);
				} else if (expressionOperator.equals("*")) {
					operand2 = random.nextInt(1, 31);
					do {
						operand1 = random.nextInt(1, 31);
					} while (operand1 < operand2);
				} else {
					operand2 = random.nextInt(1, 31);
					do {
						operand1 = random.nextInt(1, 31);
					} while (operand1 <= operand2);
				}

				rightSubExpressionValue = operand1 - operand2;
			} else if (rightSubExpressionOperator.equals("*")) {
				if (expressionOperator.equals("+")) {
					operand2 = random.nextInt(0, 21);
					operand1 = random.nextInt(0, 21);
				} else if (expressionOperator.equals("-")) {
					operand2 = random.nextInt(0, 21);
					operand1 = random.nextInt(0, 21);
				} else if (expressionOperator.equals("*")) {
					operand2 = random.nextInt(0, 21);
					operand1 = random.nextInt(0, 21);
				} else {
					operand2 = random.nextInt(1, 11);
					operand1 = random.nextInt(1, 11);
				}

				rightSubExpressionValue = operand1 * operand2;
			} else {
				if (expressionOperator.equals("+")) {
					operand2 = random.nextInt(1, 21);
					operand1 = operand2 * random.nextInt(0, 21);
				} else if (expressionOperator.equals("-")) {
					operand2 = random.nextInt(1, 21);
					operand1 = operand2 * random.nextInt(0, 31);
				} else if (expressionOperator.equals("*")) {
					operand2 = random.nextInt(1, 11);
					operand1 = operand2 * random.nextInt(0, 11);
				} else {
					operand2 = random.nextInt(1, 6);
					operand1 = operand2 * random.nextInt(1, 11);
				}

				rightSubExpressionValue = operand1 / operand2;
			}
		}

		if (!hasRightSubExpressionOperator) {
			rightSubExpression = String.valueOf(operand);
		} else {
			rightSubExpression = "(" + operand1 + " " + rightSubExpressionOperator + " " + operand2 + ")";
		}
	}

	public void generateLeftSubExpressionAndEvaluate() {
		int operand = -1;
		int operand1 = -1, operand2 = -1;

		if (difficultyLevel.equals("easy")) {
			hasLeftSubExpressionOperator = false;
			leftSubExpressionOperator = null;

			if (expressionOperator.equals("+")) {
				operand = random.nextInt(0, 100);
			} else if (expressionOperator.equals("-")) {
				do {
					operand = random.nextInt(0, 100);
				} while (operand < rightSubExpressionValue);
			} else if (expressionOperator.equals("*")) {
				operand = random.nextInt(0, 21);
			} else {
				operand = rightSubExpressionValue * random.nextInt(1, 10);
			}

			leftSubExpressionValue = operand;
		} else if (difficultyLevel.equals("medium")) {
			hasLeftSubExpressionOperator = random.nextBoolean();

			if (hasLeftSubExpressionOperator) {
				leftSubExpressionOperator = generateOperator();

				if (leftSubExpressionOperator.equals("+")) {
					if (expressionOperator.equals("+")) {
						operand2 = random.nextInt(1, 101);
						operand1 = random.nextInt(1, 101);
					} else if (expressionOperator.equals("-")) {
						do {
							operand2 = random.nextInt(1, 101);
							operand1 = random.nextInt(1, 101);
						} while ((operand2 + operand1) < rightSubExpressionValue);
					} else if (expressionOperator.equals("*")) {
						if (rightSubExpressionValue > 31) {
							operand2 = random.nextInt(1, 6);
							operand1 = random.nextInt(1, 6);
						} else {
							operand2 = random.nextInt(1, 16);
							operand1 = random.nextInt(1, 16);
						}
					} else {
						do {
							operand2 = random.nextInt(1, 101);
							operand1 = random.nextInt(1, 101);
						} while ((operand2 + operand1) % rightSubExpressionValue != 0);
					}

					leftSubExpressionValue = operand1 + operand2;
				} else if (leftSubExpressionOperator.equals("-")) {
					if (expressionOperator.equals("+")) {
						operand2 = random.nextInt(1, 201);
						do {
							operand1 = random.nextInt(1, 201);
						} while (operand1 < operand2);
					} else if (expressionOperator.equals("-")) {
						do {
							operand2 = random.nextInt(1, 301);
							do {
								operand1 = random.nextInt(1, 301);
							} while (operand1 < operand2);
						} while ((operand2 - operand1) < rightSubExpressionValue);
					} else if (expressionOperator.equals("*")) {
						if (rightSubExpressionValue > 31) {
							operand2 = random.nextInt(1, 11);
							do {
								operand1 = random.nextInt(1, 11);
							} while (operand1 < operand2);
						} else {
							operand2 = random.nextInt(1, 31);
							do {
								operand1 = random.nextInt(1, 31);
							} while (operand1 < operand2);
						}
					} else {
						do {
							operand2 = random.nextInt(1, 201);
							do {
								operand1 = random.nextInt(1, 201);
							} while (operand1 <= operand2);
						} while ((operand2 + operand1) % rightSubExpressionValue != 0);
					}

					leftSubExpressionValue = operand1 - operand2;
				} else if (leftSubExpressionOperator.equals("*")) {
					if (expressionOperator.equals("+")) {
						operand2 = random.nextInt(0, 21);
						operand1 = random.nextInt(0, 21);
					} else if (expressionOperator.equals("-")) {
						do {
							operand2 = random.nextInt(0, 21);
							operand1 = random.nextInt(0, 21);
						} while ((operand2 * operand1) < rightSubExpressionValue);
					} else if (expressionOperator.equals("*")) {
						if (rightSubExpressionValue > 21) {
							operand2 = random.nextInt(0, 6);
							operand1 = random.nextInt(0, 6);
						} else {
							operand2 = random.nextInt(0, 11);
							operand1 = random.nextInt(0, 11);
						}
					} else {
						do {
							operand2 = random.nextInt(1, 21);
							operand1 = random.nextInt(1, 21);
						} while ((operand2 * operand1) % rightSubExpressionValue != 0);
					}

					leftSubExpressionValue = operand1 * operand2;
				} else {
					if (expressionOperator.equals("+")) {
						operand2 = random.nextInt(1, 21);
						operand1 = operand2 * random.nextInt(0, 21);
					} else if (expressionOperator.equals("-")) {
						do {
							operand2 = random.nextInt(1, 21);
							operand1 = operand2 * random.nextInt(0, 31);
						} while ((operand1 / operand2) < rightSubExpressionValue);
					} else if (expressionOperator.equals("*")) {
						if (rightSubExpressionValue > 31) {
							operand2 = random.nextInt(1, 6);
							operand1 = operand2 * random.nextInt(0, 3);
						} else {
							operand2 = random.nextInt(1, 6);
							operand1 = operand2 * random.nextInt(0, 6);
						}
					} else {
						do {
							operand2 = random.nextInt(1, 31);
							operand1 = operand2 * random.nextInt(1, 31);
						} while ((operand1 / operand2) % rightSubExpressionValue != 0);
					}

					leftSubExpressionValue = operand1 / operand2;
				}
			} else {
				leftSubExpressionOperator = null;

				if (expressionOperator.equals("+")) {
					operand = random.nextInt(0, 500);
				} else if (expressionOperator.equals("-")) {
					do {
						operand = random.nextInt(0, 500);
					} while (operand < rightSubExpressionValue);
				} else if (expressionOperator.equals("*")) {
					if (rightSubExpressionValue > 31) {
						operand = random.nextInt(0, 11);
					} else {
						operand = random.nextInt(0, 31);
					}
				} else {
					operand = rightSubExpressionValue * random.nextInt(1, 21);
				}

				leftSubExpressionValue = operand;
			}
		} else {
			hasLeftSubExpressionOperator = true;
			leftSubExpressionOperator = generateOperator();

			if (leftSubExpressionOperator.equals("+")) {
				if (expressionOperator.equals("+")) {
					operand2 = random.nextInt(1, 101);
					operand1 = random.nextInt(1, 101);
				} else if (expressionOperator.equals("-")) {
					do {
						operand2 = random.nextInt(1, 101);
						operand1 = random.nextInt(1, 101);
					} while ((operand2 + operand1) < rightSubExpressionValue);
				} else if (expressionOperator.equals("*")) {
					if (rightSubExpressionValue > 31) {
						operand2 = random.nextInt(1, 6);
						operand1 = random.nextInt(1, 6);
					} else {
						operand2 = random.nextInt(1, 16);
						operand1 = random.nextInt(1, 16);
					}
				} else {
					do {
						operand2 = random.nextInt(1, 101);
						operand1 = random.nextInt(1, 101);
					} while ((operand2 + operand1) % rightSubExpressionValue != 0);
				}

				leftSubExpressionValue = operand1 + operand2;
			} else if (leftSubExpressionOperator.equals("-")) {
				if (expressionOperator.equals("+")) {
					operand2 = random.nextInt(1, 201);
					do {
						operand1 = random.nextInt(1, 201);
					} while (operand1 < operand2);
				} else if (expressionOperator.equals("-")) {
					do {
						operand2 = random.nextInt(1, 301);
						do {
							operand1 = random.nextInt(1, 301);
						} while (operand1 < operand2);
					} while ((operand2 + operand1) < rightSubExpressionValue);
				} else if (expressionOperator.equals("*")) {
					if (rightSubExpressionValue > 31) {
						operand2 = random.nextInt(1, 11);
						do {
							operand1 = random.nextInt(1, 11);
						} while (operand1 < operand2);
					} else {
						operand2 = random.nextInt(1, 31);
						do {
							operand1 = random.nextInt(1, 31);
						} while (operand1 < operand2);
					}
				} else {
					do {
						operand2 = random.nextInt(1, 201);
						do {
							operand1 = random.nextInt(1, 201);
						} while (operand1 <= operand2);
					} while ((operand2 + operand1) % rightSubExpressionValue != 0);
				}

				leftSubExpressionValue = operand1 - operand2;
			} else if (leftSubExpressionOperator.equals("*")) {
				if (expressionOperator.equals("+")) {
					operand2 = random.nextInt(0, 21);
					operand1 = random.nextInt(0, 21);
				} else if (expressionOperator.equals("-")) {
					do {
						operand2 = random.nextInt(0, 21);
						operand1 = random.nextInt(0, 21);
					} while ((operand2 * operand1) < rightSubExpressionValue);
				} else if (expressionOperator.equals("*")) {
					if (rightSubExpressionValue > 21) {
						operand2 = random.nextInt(0, 6);
						operand1 = random.nextInt(0, 6);
					} else {
						operand2 = random.nextInt(0, 11);
						operand1 = random.nextInt(0, 11);
					}
				} else {
					do {
						operand2 = random.nextInt(1, 21);
						operand1 = random.nextInt(1, 21);
					} while ((operand2 * operand1) % rightSubExpressionValue != 0);
				}

				leftSubExpressionValue = operand1 * operand2;
			} else {
				if (expressionOperator.equals("+")) {
					operand2 = random.nextInt(1, 21);
					operand1 = operand2 * random.nextInt(0, 21);
				} else if (expressionOperator.equals("-")) {
					do {
						operand2 = random.nextInt(1, 21);
						operand1 = operand2 * random.nextInt(0, 31);
					} while ((operand1 / operand2) < rightSubExpressionValue);
				} else if (expressionOperator.equals("*")) {
					if (rightSubExpressionValue > 31) {
						operand2 = random.nextInt(1, 6);
						operand1 = operand2 * random.nextInt(0, 3);
					} else {
						operand2 = random.nextInt(1, 6);
						operand1 = operand2 * random.nextInt(0, 6);
					}
				} else {
					do {
						operand2 = random.nextInt(1, 31);
						operand1 = operand2 * random.nextInt(1, 31);
					} while ((operand1 / operand2) % rightSubExpressionValue != 0);
				}

				leftSubExpressionValue = operand1 / operand2;
			}
		}

		if (!hasLeftSubExpressionOperator) {
			leftSubExpression = String.valueOf(operand);
		} else {
			leftSubExpression = "(" + operand1 + " " + leftSubExpressionOperator + " " + operand2 + ")";
		}
	}

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

	public boolean isEvaluationCorrect() {
		if (predictedValue == expressionValue) {
			return true;
		} else {
			return false;
		}
	}

	public void playGame() {
		String choice;
		do {
			System.out.println("\nDifficulty Level: " + difficultyLevel);
			generateExpressionAndEvaluate();
			System.out.println("Expression: " + expression);
			try {
				System.out.println("Value of above expression: ");
				predictedValue = Integer.parseInt(scanner.nextLine().trim());
				if (isEvaluationCorrect()) {
					System.out.println("It is correct...\n");
				} else {
					System.out.println("It is wrong... value = " + expressionValue + "\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please provide a valid value\n");
			}
			System.out.println("Want to continue with same level?[yes/no]");
			choice = scanner.nextLine().trim().toLowerCase();
		} while (choice.equals("yes"));
	}

	public void startGame() {
		System.out.println("Welcome to Arithmetic Calculations Game..!");
		System.out.println("Game starts now...");
		String choice;
		do {
			System.out.println("Difficulty Levels-[easy, medium, hard]");
			System.out.println("Choose one:");
			difficultyLevel = scanner.nextLine().trim().toLowerCase();
			if (difficultyLevel.equals("easy") || difficultyLevel.equals("medium") || difficultyLevel.equals("hard")) {
				playGame();
			} else {
				System.out.println("Please choose a valid level\n");
			}
			System.out.println("Want to continue play? [yes/no]");
			choice = scanner.nextLine().trim().toLowerCase();
		} while (choice.equals("yes"));
		System.out.println("\n Thanks for giving it a try...");
	}

	public static void main(String[] args) {
		ArithmeticCalculations arithmeticCalculations = new ArithmeticCalculations();
		arithmeticCalculations.startGame();
	}
}
