// Model Class
package com.bhargav.rps.ui;

import java.util.*;

public class RPSGameModel {

	static Random random = new Random();
	private String userChoice;
	private String computerChoice;
	private String result;

	public String getUserChoice() {
		return userChoice;
	}

	public void setUserChoice(String userChoice) {
		this.userChoice = userChoice;
	}

	public String getComputerChoice() {
		return computerChoice;
	}

	public void setComputerChoice(String computerChoice) {
		this.computerChoice = computerChoice;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void generateComputerChoice() {
		int num = random.nextInt(3);

		if (num == 0) {
			computerChoice = "rock";
		} else if (num == 1) {
			computerChoice = "paper";
		} else if (num == 2) {
			computerChoice = "scissor";
		}
	}

	public void updateResult() {
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
	}

}
