package com.bhargav.handCricket.cli;

import java.util.*;

public class HandCricketGame {

	static Scanner scanner = new Scanner(System.in);
	static Random random = new Random();
	int runsScored = 0;
	int runsConceded = 0;
	boolean isSecondInnings = false;

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	public void setRunsConceded(int runsConceded) {
		this.runsConceded = runsConceded;
	}

	public void setIsSecondInnings(boolean isSecondInnings) {
		this.isSecondInnings = isSecondInnings;
	}

	public int getRunsScored() {
		return this.runsScored;
	}

	public int getRunsConceded() {
		return this.runsConceded;
	}

	public boolean isSecondInnings() {
		return this.isSecondInnings;
	}

	public void displayResult() {
		System.out.println("\n\nResult of Match-");
		System.out.println("Total Runs scored: " + this.getRunsScored());
		System.out.println("Total Runs conceded: " + this.getRunsConceded());
		if (this.getRunsScored() > this.getRunsConceded()) {
			System.out.println("");
			System.out.println("Congrats!!You won the game");
		} else if (this.getRunsScored() < this.getRunsConceded()) {
			System.out.println("");
			System.out.println("Sorry!!You lost the game");
		} else {
			System.out.println("");
			System.out.println("Oops!!It is a tie");
		}
	}

	public boolean toss() {
		System.out.println("Welcome to Hand Cricket..!");
		System.out.println("It is the Toss time");

		String choice = null;
		while (true) {
			System.out.print("Enter your choice[heads/tails]: ");
			choice = scanner.next().toLowerCase();
			if (choice.equals("heads") || choice.equals("tails")) {
				break;
			} else {
				System.out.println("Please choose a valid one");
			}
		}
		String[] choices = { "heads", "tails" };
		String generatedChoice = choices[random.nextInt(2)];

		if (choice.equals(generatedChoice)) {
			return true;
		} else {
			return false;
		}
	}

	public void batting() {
		int runs;
		int generatedRuns;
		int temp;
		boolean isOut = false;

		while (!isOut) {
			System.out.println("");
			System.out.print("Enter your choice(0-6): ");
			runs = Integer.parseInt(scanner.next());
			if (runs >= 0 && runs <= 6) {
				generatedRuns = random.nextInt(7);
				System.out.println("runs chosen:" + runs);
				System.out.println("runs generated:" + generatedRuns);
				if (runs == generatedRuns) {
					isOut = true;
					System.out.println("It's out");
				} else {
					temp = runs + this.getRunsScored();
					this.setRunsScored(temp);
					if (this.isSecondInnings()) {
						if (this.getRunsScored() > this.getRunsConceded()) {
							System.out.println("Done chasing..");
							break;
						}
					}
				}
			} else {
				System.out.println("Please choose a valid one");
			}
		}
		System.out.println("Your Total runs: " + this.getRunsScored());
	}

	public void bowling() {
		int runs;
		int generatedRuns;
		int temp;
		boolean isOut = false;

		while (!isOut) {
			System.out.println("");
			System.out.print("Enter your choice(0-6): ");
			runs = Integer.parseInt(scanner.next());
			generatedRuns = random.nextInt(7);
			System.out.println("runs chosen:" + runs);
			System.out.println("runs generated:" + generatedRuns);
			if (runs == generatedRuns) {
				isOut = true;
				System.out.println("It's out");
			} else {
				temp = generatedRuns + this.getRunsConceded();
				this.setRunsConceded(temp);
				if (this.isSecondInnings()) {
					if (this.getRunsConceded() >= this.getRunsScored()) {
						System.out.println("Done defending..");
						break;
					}
				}
			}
		}
		System.out.println("Total runs conceded: " + this.getRunsConceded());
	}

	public void userChoicePlay() {
		System.out.println("You won the toss..!");
		System.out.println("");

		String choice;

		while (true) {
			System.out.print("Enter your choice[bat/bowl]: ");
			choice = scanner.next().toLowerCase();
			if (choice.equals("bat") || choice.equals("bowl")) {
				break;
			} else {
				System.out.println("Please choose a valid one");
			}
		}
		if (choice.equals("bat")) {
			System.out.println("Your Batting Innings starts now..");
			this.batting();
			System.out.println("\nYou have given the target of " + (this.getRunsScored() + 1) + " runs");
			System.out.println("Your Bowling Innings starts now..");
			this.setIsSecondInnings(true);
			this.bowling();
		} else {
			System.out.println("Your Bowling Innings starts now..");
			this.bowling();
			System.out.println("\nYour target is to score " + (this.getRunsConceded() + 1) + " runs");
			System.out.println("Your Batting Innings starts now..");
			this.setIsSecondInnings(true);
			this.batting();
		}
	}

	public void computerChoicePlay() {
		System.out.println("You lost the toss..!");
		System.out.println("");

		String[] choices = { "bat", "bowl" };
		String choice = choices[random.nextInt(2)];

		if (choice.equals("bat")) {
			System.out.println("You are to bowl first");
			System.out.println("Your Bowling Innings starts now..");
			this.bowling();
			System.out.println("\nYour target is to score " + (this.getRunsConceded() + 1) + " runs");
			System.out.println("Your Batting Innings starts now..");
			this.setIsSecondInnings(true);
			this.batting();
		} else {
			System.out.println("You are to bat first");
			System.out.println("Your Batting Innings starts now..");
			this.batting();
			System.out.println("\nYou have given the target of " + (this.getRunsScored() + 1) + " runs");
			System.out.println("Your Bowling Innings starts now..");
			this.setIsSecondInnings(true);
			this.bowling();
		}
	}

	public void startPlay() {
		System.out.println("Welcome to Hand Cricket Game ..!");

		boolean hasWonToss;
		hasWonToss = this.toss();
		if (hasWonToss) {
			this.userChoicePlay();
		} else {
			this.computerChoicePlay();
		}
		this.displayResult();

	}

	public static void main(String[] args) {
		HandCricketGame obj = new HandCricketGame();
		obj.startPlay();
	}
}
