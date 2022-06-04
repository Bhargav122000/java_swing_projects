package com.bhargav.handCricket;

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
		return this.runsScored;
	}

	public int getRunsConceded() {
		return this.runsConceded;
	}

	public boolean isSecondInnings() {
		return this.isSecondInnings;
	}

	public boolean isTossWon(String choice) {
		String[] choices = {"heads", "tails"};
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
		if (this.getRunsScored() > this.getRunsConceded()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isDefendingDone() {
		if (this.getRunsConceded() > this.getRunsScored()) {
			return true;
		} else {
			return false;
		}
	}
}
