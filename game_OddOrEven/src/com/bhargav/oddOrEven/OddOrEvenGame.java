package com.bhargav.oddOrEven;

import java.util.Random;

public class OddOrEvenGame {
	static Random random = new Random();

	private int userNumber;
	private String userChoice;
	private String userExpectedChoice;
	private int generatedNumber;
	private String generatedChoice;
	private String obtainedChoice;
	private boolean isWon;

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserChoice() {
		return userChoice;
	}

	public void setUserChoice(String userChoice) {
		this.userChoice = userChoice;
	}

	public String getUserExpectedChoice() {
		return userExpectedChoice;
	}

	public void setUserExpectedChoice(String userExpectedChoice) {
		this.userExpectedChoice = userExpectedChoice;
	}

	public int getGeneratedNumber() {
		return generatedNumber;
	}

	public void setGeneratedNumber(int generatedNumber) {
		this.generatedNumber = generatedNumber;
	}

	public String getGeneratedChoice() {
		return generatedChoice;
	}

	public void setGeneratedChoice(String generatedChoice) {
		this.generatedChoice = generatedChoice;
	}

	public String getObtainedChoice() {
		return obtainedChoice;
	}

	public void setObtainedChoice(String obtainedChoice) {
		this.obtainedChoice = obtainedChoice;
	}

	public boolean isWon() {
		return isWon;
	}

	public void setWon(boolean isWon) {
		this.isWon = isWon;
	}

	public String createObtainedChoice() {
		if ((getUserNumber() + getGeneratedNumber()) % 2 == 0) {
			return "even";
		} else {
			return "odd";
		}
	}

	public boolean decide() {
		if (getObtainedChoice().equals(getUserExpectedChoice())) {
			return true;
		} else {
			return false;
		}
	}

	public void generateNumberAndChoice() {
		int num = random.nextInt(10);
		setGeneratedNumber(num);
		if ((num % 2) == 0) {
			setGeneratedChoice("even");
		} else {
			setGeneratedChoice("odd");
		}
	}
}
