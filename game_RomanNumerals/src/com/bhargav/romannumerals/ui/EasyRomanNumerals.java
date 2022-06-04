package com.bhargav.romannumerals.ui;

public class EasyRomanNumerals extends RomanNumerals {

	public EasyRomanNumerals() {
		super();
	}

	@Override
	public void generateInputValue() {
		String roman = generateRoman();
		setRomanValue(roman);
	}

	@Override
	public void convert() {
		int number = convertToNumber(getRomanValue());
		setActualNumberValue(number);
	}

	@Override
	public void updateScore() {
		int score = getScore();
		if (getProvidedNumberValue() == getActualNumberValue()) {
			score += 150;
		} else {
			score -= 75;
			if (score < 0) {
				score = 0;
			}
		}
		setScore(score);
	}

}
