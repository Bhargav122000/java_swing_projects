package com.bhargav.primeorcomposite.cli;

import java.util.Scanner;
import java.util.Random;

public class PrimeOrCompositeGame {
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
		int num = getUserNumber() + getGeneratedNumber()
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

	public boolean isPrime(int num) {
		if (num == 2) {
			return true;
		} else {
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) {
					return false;
				}
			}
			return true;
		}
	}
	
	public void startGame() {
		System.out.println("Prime Or Composite game started...");
		String continuePlay = null;
		String choice = null;

		do {
			try {
				System.out.print("\nEnter a positive integer (greater than 1): ");
				int num = Integer.parseInt(scanner.next());
				if (num <= 1) {
					throw new Exception();
				}
				setUserNumber(num);
				
				if (isPrime(getUserNumber())) {
					setUserChoice("prime");
				} else {
					setUserChoice("composite");
				}
				
				try {
					System.out.print("Choose prime/composite: ");
					choice = scanner.next().toLowerCase();
					if (choice.equals("prime") || choice.equals("composite")) {
						setUserExpectedChoice(choice);
					} else {
						throw new Exception();
					}
					System.out.println("");
					setGeneratedNumber(random.nextInt(2, 100));
					if (isPrime(getGeneratedNumber())) {
						setGeneratedChoice("prime");
					} else {
						setGeneratedChoice("composite");
					}
					setObtainedChoice(createObtainedChoice());
					setWon(decide());
					System.out.println("your number: " + getUserNumber());
					System.out.println("your choice:" + getUserChoice());
					System.out.println("generated number: " + getGeneratedNumber());
					System.out.println("generated choice: " + getGeneratedChoice());
					System.out.println("your expected choice: " + getUserExpectedChoice());
					System.out.println("obtained: " + getObtainedChoice());
					System.out.println(isWon());
				} catch (Exception e) {
					System.out.println("Invalid input!! choose either prime or composite");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invlid input!! choose an integer");
			} catch (Exception e) {
				System.out.println("Invalid input!! choose an integer greater than 1");
			}
			
			System.out.print("Do you want to continue play[yes/no]: ");
			continuePlay = scanner.next().toLowerCase();
		} while(continuePlay.equals("yes"));
		
		System.out.println("\nGame ended ...");
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Prime Or Composite Game..!");
		PrimeOrCompositeGame primeOrCompositeGame = new PrimeOrCompositeGame();
		primeOrCompositeGame.startGame();
	}
}
