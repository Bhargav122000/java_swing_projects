package com.bhargav.arithmeticcalculations.ui;

import java.util.*;

public class MediumArithmeticCalculations extends ArithmeticCalculations {
	private Random random;

	public MediumArithmeticCalculations() {
		super();
		random = new Random();
	}

	@Override
	public void generateRightSubExpressionAndEvaluate() {
		int operand = -1;
		int operand1 = -1, operand2 = -1;

		super.setHasRightSubExpressionOperator(random.nextBoolean());

		if (super.isHasRightSubExpressionOperator()) {
			super.setRightSubExpressionOperator(super.generateOperator());

			if (super.getRightSubExpressionOperator().equals("+")) {
				if (super.getExpressionOperator().equals("+")) {
					operand2 = random.nextInt(1, 51);
					operand1 = random.nextInt(1, 51);
				} else if (super.getExpressionOperator().equals("-")) {
					operand2 = random.nextInt(1, 101);
					operand1 = random.nextInt(1, 101);
				} else if (super.getExpressionOperator().equals("*")) {
					operand2 = random.nextInt(1, 16);
					operand1 = random.nextInt(1, 16);
				} else {
					operand2 = random.nextInt(1, 21);
					operand1 = random.nextInt(1, 21);
				}

				super.setRightSubExpressionValue(operand1 + operand2);
			} else if (super.getRightSubExpressionOperator().equals("-")) {
				if (super.getExpressionOperator().equals("+")) {
					operand2 = random.nextInt(1, 201);
					do {
						operand1 = random.nextInt(1, 201);
					} while (operand1 < operand2);
				} else if (super.getExpressionOperator().equals("-")) {
					operand2 = random.nextInt(1, 301);
					do {
						operand1 = random.nextInt(1, 301);
					} while (operand1 < operand2);
				} else if (super.getExpressionOperator().equals("*")) {
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

				super.setRightSubExpressionValue(operand1 - operand2);
			} else if (super.getRightSubExpressionOperator().equals("*")) {
				if (super.getExpressionOperator().equals("+")) {
					operand2 = random.nextInt(0, 21);
					operand1 = random.nextInt(0, 21);
				} else if (super.getExpressionOperator().equals("-")) {
					operand2 = random.nextInt(0, 21);
					operand1 = random.nextInt(0, 21);
				} else if (super.getExpressionOperator().equals("*")) {
					operand2 = random.nextInt(0, 21);
					operand1 = random.nextInt(0, 21);
				} else {
					operand2 = random.nextInt(1, 11);
					operand1 = random.nextInt(1, 11);
				}

				super.setRightSubExpressionValue(operand1 * operand2);
			} else {
				if (super.getExpressionOperator().equals("+")) {
					operand2 = random.nextInt(1, 21);
					operand1 = operand2 * random.nextInt(0, 21);
				} else if (super.getExpressionOperator().equals("-")) {
					operand2 = random.nextInt(1, 21);
					operand1 = operand2 * random.nextInt(0, 31);
				} else if (super.getExpressionOperator().equals("*")) {
					operand2 = random.nextInt(1, 11);
					operand1 = operand2 * random.nextInt(0, 11);
				} else {
					operand2 = random.nextInt(1, 6);
					operand1 = operand2 * random.nextInt(1, 11);
				}

				super.setRightSubExpressionValue(operand1 / operand2);
			}
		} else {
			super.setRightSubExpressionOperator(null);

			if (super.getExpressionOperator().equals("+")) {
				operand = random.nextInt(0, 500);
			} else if (super.getExpressionOperator().equals("-")) {
				operand = random.nextInt(0, 500);
			} else if (super.getExpressionOperator().equals("*")) {
				operand = random.nextInt(0, 31);
			} else {
				operand = random.nextInt(1, 21);
			}

			super.setRightSubExpressionValue(operand);
		}

		if (!super.isHasRightSubExpressionOperator()) {
			super.setRightSubExpression(String.valueOf(operand));
		} else {
			String str = "(" + operand1 + " " + super.getRightSubExpressionOperator() + " " + operand2 + ")";
			super.setRightSubExpression(str);
		}
	}

	@Override
	public void generateLeftSubExpressionAndEvaluate() {
		int operand = -1;
		int operand1 = -1, operand2 = -1;

		super.setHasLeftSubExpressionOperator(random.nextBoolean());

		if (super.isHasLeftSubExpressionOperator()) {
			super.setLeftSubExpressionOperator(super.generateOperator());

			if (super.getLeftSubExpressionOperator().equals("+")) {
				if (super.getExpressionOperator().equals("+")) {
					operand2 = random.nextInt(1, 101);
					operand1 = random.nextInt(1, 101);
				} else if (super.getExpressionOperator().equals("-")) {
					do {
						operand2 = random.nextInt(1, 101);
						operand1 = random.nextInt(1, 101);
					} while ((operand2 + operand1) < super.getRightSubExpressionValue());
				} else if (super.getExpressionOperator().equals("*")) {
					if (super.getRightSubExpressionValue() > 31) {
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
					} while ((operand2 + operand1) % super.getRightSubExpressionValue() != 0);
				}

				super.setLeftSubExpressionValue(operand1 + operand2);
			} else if (super.getLeftSubExpressionOperator().equals("-")) {
				if (super.getExpressionOperator().equals("+")) {
					operand2 = random.nextInt(1, 201);
					do {
						operand1 = random.nextInt(1, 201);
					} while (operand1 < operand2);
				} else if (super.getExpressionOperator().equals("-")) {
					do {
						operand2 = random.nextInt(1, 301);
						do {
							operand1 = random.nextInt(1, 301);
						} while (operand1 < operand2);
					} while ((operand1 - operand2) < super.getRightSubExpressionValue());
				} else if (super.getExpressionOperator().equals("*")) {
					if (super.getRightSubExpressionValue() > 31) {
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
					} while ((operand1 - operand2) % super.getRightSubExpressionValue() != 0);
				}

				super.setLeftSubExpressionValue(operand1 - operand2);
			} else if (super.getLeftSubExpressionOperator().equals("*")) {
				if (super.getExpressionOperator().equals("+")) {
					operand2 = random.nextInt(0, 21);
					operand1 = random.nextInt(0, 21);
				} else if (super.getExpressionOperator().equals("-")) {
					do {
						operand2 = random.nextInt(0, 21);
						operand1 = random.nextInt(0, 21);
					} while ((operand2 * operand1) < super.getRightSubExpressionValue());
				} else if (super.getExpressionOperator().equals("*")) {
					if (super.getRightSubExpressionValue() > 21) {
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
					} while ((operand2 * operand1) % super.getRightSubExpressionValue() != 0);
				}

				super.setLeftSubExpressionValue(operand1 * operand2);
			} else {
				if (super.getExpressionOperator().equals("+")) {
					operand2 = random.nextInt(1, 21);
					operand1 = operand2 * random.nextInt(0, 21);
				} else if (super.getExpressionOperator().equals("-")) {
					do {
						operand2 = random.nextInt(1, 21);
						operand1 = operand2 * random.nextInt(0, 31);
					} while ((operand1 / operand2) < super.getRightSubExpressionValue());
				} else if (super.getExpressionOperator().equals("*")) {
					if (super.getRightSubExpressionValue() > 31) {
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
					} while ((operand1 / operand2) % super.getRightSubExpressionValue() != 0);
				}

				super.setLeftSubExpressionValue(operand1 / operand2);
			}
		} else {
			super.setLeftSubExpressionOperator(null);

			if (super.getExpressionOperator().equals("+")) {
				operand = random.nextInt(0, 500);
			} else if (super.getExpressionOperator().equals("-")) {
				do {
					operand = random.nextInt(0, 500);
				} while (operand < super.getRightSubExpressionValue());
			} else if (super.getExpressionOperator().equals("*")) {
				if (super.getRightSubExpressionValue() > 31) {
					operand = random.nextInt(0, 11);
				} else {
					operand = random.nextInt(0, 31);
				}
			} else {
				operand = super.getRightSubExpressionValue() * random.nextInt(1, 21);
			}

			super.setLeftSubExpressionValue(operand);
		}

		if (!super.isHasLeftSubExpressionOperator()) {
			super.setLeftSubExpression(String.valueOf(operand));
		} else {
			String str = "(" + operand1 + " " + super.getLeftSubExpressionOperator() + " " + operand2 + ")";
			super.setLeftSubExpression(str);
		}
	}

}
