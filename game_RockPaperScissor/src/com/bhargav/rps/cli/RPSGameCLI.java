package com.bhargav.rps.cli;

import java.util.Random;
import java.util.Scanner;

public class RPSGameCLI {

	static Scanner scanner = new Scanner(System.in);
	static Random random = new Random();

	public void displayInstructions() {
		System.out.println("Choices: rock, paper, scissor");
		System.out.println("Rules: [rock>scissor][scissor>paper][paper>rock]");
		System.out.println("Use 'quit' to stop playing.");
		System.out.println("");
	}

	public void displayResult(int totalMatches, int wins, int draws) {
		System.out.println("");
		System.out.print("Total Matches played: " + totalMatches + "\n");
		System.out.print("#Matches won:" + wins + "\n");
		System.out.print("#Matches drawn:" + draws + "\n");
		System.out.print("#Matches lost: " + (totalMatches - wins - draws));
	}

	public void playGame() {
		this.displayInstructions();

		boolean isEnough = false;
		String userChoice;
		String computerChoice;
		int totalMatches = 0;
		int wins = 0;
		int draws = 0;
		String[] choices = { "rock", "paper", "scissor" };

		while (!isEnough) {
			System.out.print("Enter your choice: ");
			userChoice = scanner.next();
			computerChoice = choices[random.nextInt(3)];

			System.out.println("computer's choice: " + computerChoice);
			if (userChoice.equalsIgnoreCase("rock")) {
				if (computerChoice.equalsIgnoreCase("rock")) {
					System.out.println("drawn..");
					draws += 1;
				} else if (computerChoice.equalsIgnoreCase("paper")) {
					System.out.println("you lost :(");
				} else if (computerChoice.equalsIgnoreCase("scissor")) {
					System.out.println("you won :)");
					wins += 1;
				}
				totalMatches += 1;
			} else if (userChoice.equalsIgnoreCase("paper")) {
				if (computerChoice.equalsIgnoreCase("rock")) {
					System.out.println("you won :)");
					wins += 1;
				} else if (computerChoice.equalsIgnoreCase("paper")) {
					System.out.println("drawn..");
					draws += 1;
				} else if (computerChoice.equalsIgnoreCase("scissor")) {
					System.out.println("you lost :(");
				}
				totalMatches += 1;
			} else if (userChoice.equalsIgnoreCase("scissor")) {
				if (computerChoice.equalsIgnoreCase("rock")) {
					System.out.println("you lost :(");
				} else if (computerChoice.equalsIgnoreCase("paper")) {
					System.out.println("you won :)");
					wins += 1;
				} else if (computerChoice.equalsIgnoreCase("scissor")) {
					System.out.println("drawn..");
					draws += 1;
				}
				totalMatches += 1;
			} else if (userChoice.equalsIgnoreCase("quit")) {
				isEnough = true;
			} else {
				System.out.println("please choose a valid one..");
			}
			System.out.println("");
		}

		this.displayResult(totalMatches, wins, draws);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Rock-Paper-Scissor game..!!");

		RPSGameCLI rpsGame = new RPSGameCLI();
		rpsGame.playGame();
	}

}
