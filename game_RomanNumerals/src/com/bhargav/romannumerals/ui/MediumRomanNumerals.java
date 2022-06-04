package com.bhargav.romannumerals.ui;

public class MediumRomanNumerals extends RomanNumerals {

	public MediumRomanNumerals() {
		super();
	}

	@Override
	public void generateInputValue() {
		int number = generateNumber();
		setNumberValue(number);
	}

	@Override
	public void convert() {
		String roman = convertToRoman(getNumberValue());
		setActualRomanValue(roman);
	}

	@Override
	public void updateScore() {
		int score = getScore();
		if (getProvidedRomanValue().equals(getActualRomanValue())) {
			score += 250;
		} else {
			score -= 125;
			if (score < 0) {
				score = 0;
			}
		}
		setScore(score);
	}

}
