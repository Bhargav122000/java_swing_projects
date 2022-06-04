package com.bhargav.rps;

import java.util.*;

public class RPSGame {

	static Random random = new Random();
	private String userChoice;
	private String computerChoice;
	private String result;

	public void setUserChoice(String userChoice) {
		this.userChoice = userChoice;
	}

	public void setComputerChoice(String computerChoice) {
		this.computerChoice = computerChoice;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUserChoice() {
		return this.userChoice;
	}

	public String getComputerChoice() {
		return this.computerChoice;
	}

	public String getResult() {
		return this.result;
	}

	public void generateComputerChoice() {
		int num = random.nextInt(3);

		if (num == 0) {
			this.setComputerChoice("rock");
		} else if (num == 1) {
			this.setComputerChoice("paper");
		} else if (num == 2) {
			this.setComputerChoice("scissor");
		}
	}

	public void playGame() {
		String userChoice = this.getUserChoice();
		String computerChoice = this.getComputerChoice();
		String result = null;

		if (userChoice.equalsIgnoreCase("rock")) {
			if (computerChoice.equalsIgnoreCase("rock")) {
				result = "draw";
			} else if (computerChoice.equalsIgnoreCase("paper")) {
				result = "lost";
			} else if (computerChoice.equalsIgnoreCase("scissor")) {
				result = "won";
			}
		} else if (userChoice.equalsIgnoreCase("paper")) {
			if (computerChoice.equalsIgnoreCase("rock")) {
				result = "won";
			} else if (computerChoice.equalsIgnoreCase("paper")) {
				result = "draw";
			} else if (computerChoice.equalsIgnoreCase("scissor")) {
				result = "lost";
			}
		} else if (userChoice.equalsIgnoreCase("scissor")) {
			if (computerChoice.equalsIgnoreCase("rock")) {
				result = "lost";
			} else if (computerChoice.equalsIgnoreCase("paper")) {
				result = "won";
			} else if (computerChoice.equalsIgnoreCase("scissor")) {
				result = "draw";
			}
		}
		this.setResult(result);
	}

}
