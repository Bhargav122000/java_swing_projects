package com.bhargav.arithmeticcalculations.cli;

import java.util.*;

public class EasyArithmeticCalculations extends ArithmeticCalculations {
	private Random random;

	public EasyArithmeticCalculations() {
		super();
		random = new Random();
	}

	@Override
	public void generateRightSubExpressionAndEvaluate() {
		int operand = -1;

		super.setHasRightSubExpressionOperator(false);
		super.setRightSubExpressionOperator(null);

		if (super.getExpressionOperator().equals("+")) {
			operand = random.nextInt(0, 100);
		} else if (super.getExpressionOperator().equals("-")) {
			operand = random.nextInt(0, 100);
		} else if (super.getExpressionOperator().equals("*")) {
			operand = random.nextInt(0, 21);
		} else {
			operand = random.nextInt(1, 10);
		}

		super.setRightSubExpressionValue(operand);
		super.setRightSubExpression(String.valueOf(operand));
	}

	@Override
	public void generateLeftSubExpressionAndEvaluate() {
		int operand = -1;

		super.setHasLeftSubExpressionOperator(false);
		super.setLeftSubExpressionOperator(null);

		if (super.getExpressionOperator().equals("+")) {
			operand = random.nextInt(0, 100);
		} else if (super.getExpressionOperator().equals("-")) {
			do {
				operand = random.nextInt(0, 100);
			} while (operand < super.getRightSubExpressionValue());
		} else if (super.getExpressionOperator().equals("*")) {
			operand = random.nextInt(0, 21);
		} else {
			operand = super.getRightSubExpressionValue() * random.nextInt(1, 10);
		}

		super.setLeftSubExpressionValue(operand);
		super.setLeftSubExpression(String.valueOf(operand));
	}
}
