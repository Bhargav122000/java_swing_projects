package com.bhargav.oddOrEven.cli;

import java.util.Scanner;
import java.util.Random;

public class OddOrEvenGame {
	static Scanner scanner = new Scanner(System.in);
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

	public void startGame() {
		System.out.println("Odd Or Even game started...");
		String continuePlay = null;
		String choice = null;

		do {
			try {
				System.out.print("\nEnter an integer: ");
				setUserNumber(Integer.parseInt(scanner.next()));
				if ((getUserNumber() % 2) == 0) {
					setUserChoice("even");
				} else {
					setUserChoice("odd");
				}

				try {
					System.out.print("Choose odd/even: ");
					choice = scanner.next().toLowerCase();
					if (choice.equals("odd") || choice.equals("even")) {
						setUserExpectedChoice(choice);
					} else {
						throw new Exception();
					}
					System.out.println("");
					setGeneratedNumber(random.nextInt(10));
					if ((getGeneratedNumber() % 2) == 0) {
						setGeneratedChoice("even");
					} else {
						setGeneratedChoice("odd");
					}
					setObtainedChoice(createObtainedChoice());
					setWon(decide());
					System.out.println("your number: " + getUserNumber());
					System.out.println("your choice:" + getUserChoice());
					System.out.println("generated number: " + getGeneratedNumber());
					System.out.println("generated choice: " + getGeneratedChoice());
					System.out.println("your expected choice: " + getUserExpectedChoice());
					System.out.println("obtained: " + getObtainedChoice());
					if (isWon()) {
						System.out.println("You Won");
					} else {
						System.out.println("You Lost");
					}
				} catch (Exception e) {
					System.out.println("Invalid input!! choose either odd or even");
				}
			} catch (Exception e) {
				System.out.println("Invlid input!! choose an integer");
			}

			System.out.print("Do you want to continue play[yes/no]: ");
			continuePlay = scanner.next().toLowerCase();
		} while (continuePlay.equals("yes"));

		System.out.println("\nGame ended ...");
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Odd or Even game..!");
		OddOrEvenGame oddOrEvenGame = new OddOrEvenGame();
		oddOrEvenGame.startGame();
	}
}
