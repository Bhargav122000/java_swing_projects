package com.bhargav.romannumerals.ui;

public class HardRomanNumerals extends RomanNumerals {

	public HardRomanNumerals() {
		super();
	}

	@Override
	public void generateInputValue() {
		setExpression(generateExpression());
	}

	@Override
	public void convert() {
		int result;
		int operand1, operand2;

		if (getOperandType().equals("number")) {
			operand1 = getNumberValue1();
			operand2 = getNumberValue2();
		} else {
			operand1 = convertToNumber(getRomanValue1());
			operand2 = convertToNumber(getRomanValue2());
		}

		if (getOperator() == '+') {
			result = operand1 + operand2;
		} else {
			result = operand1 - operand2;
		}

		setActualRomanValue(convertToRoman(result));
	}

	@Override
	public void updateScore() {
		int score = getScore();
		if (getProvidedRomanValue().equals(getActualRomanValue())) {
			score += 350;
		} else {
			score -= 175;
			if (score < 0) {
				score = 0;
			}
		}
		setScore(score);
	}

}
