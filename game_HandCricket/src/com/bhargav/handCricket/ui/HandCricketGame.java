// Model class
package com.bhargav.handCricket.ui;

import java.util.*;

public class HandCricketGame {

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
		return runsScored;
	}

	public int getRunsConceded() {
		return runsConceded;
	}

	public boolean isSecondInnings() {
		return isSecondInnings;
	}

	public boolean isTossWon(String choice) {
		String[] choices = { "heads", "tails" };
		int index = HandCricketGame.random.nextInt(2);
		choice = choice.toLowerCase();

		if (choice.equals(choices[index])) {
			return true;
		} else {
			return false;
		}
	}

	public String getComputerChoiceForBatBowl() {
		int n = HandCricketGame.random.nextInt(2);

		if (n == 0) {
			return "bat";
		} else {
			return "bowl";
		}
	}

	public int getComputerGeneratedRun() {
		return HandCricketGame.random.nextInt(7);
	}

	public boolean isOut(int runsSelected, int runsGenerated) {
		if (runsSelected == runsGenerated) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isChasingDone() {
		if (getRunsScored() > getRunsConceded()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isDefendingDone() {
		if (getRunsConceded() > getRunsScored()) {
			return true;
		} else {
			return false;
		}
	}
}
