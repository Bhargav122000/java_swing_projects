package com.bhargav.arithmeticcalculations.cli;

import java.util.*;

public class ArithmeticCalculationsCLI {
	private Scanner scanner;
	private String difficultyLevel;
	private ArithmeticCalculations arithmeticCalculations;

	public ArithmeticCalculationsCLI() {
		scanner = new Scanner(System.in);
		difficultyLevel = null;
		arithmeticCalculations = null;
	}

	public void playGame() {
		int value;
		String choice;
		do {
			System.out.println("\nDifficulty Level: " + difficultyLevel);
			arithmeticCalculations.generateExpressionAndEvaluate();
			System.out.println("Expression: " + arithmeticCalculations.getExpression());
			try {
				System.out.println("Value of above expression: ");
				value = Integer.parseInt(scanner.nextLine().trim());
				arithmeticCalculations.setPredictedValue(value);
				if (arithmeticCalculations.isEvaluationCorrect()) {
					System.out.println("It is correct...\n");
				} else {
					System.out.println("It is wrong... value = " + arithmeticCalculations.getExpressionValue() + "\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please provide a valid value\n");
			}
			System.out.println("Want to continue with same level?[yes/no]");
			choice = scanner.nextLine().trim().toLowerCase();
		} while (choice.equals("yes"));
	}

	public void startGame() {
		System.out.println("Welcome to Arithmetic Calculations Game..!");
		System.out.println("Game starts now...");
		String choice;
		do {
			System.out.println("Difficulty Levels-[easy, medium, hard]");
			System.out.println("Choose one:");
			difficultyLevel = scanner.nextLine().trim().toLowerCase();
			if (difficultyLevel.equals("easy")) {
				arithmeticCalculations = new EasyArithmeticCalculations();
				playGame();
			} else if (difficultyLevel.equals("medium")) {
				arithmeticCalculations = new MediumArithmeticCalculations();
				playGame();
			} else if (difficultyLevel.equals("hard")) {
				arithmeticCalculations = new HardArithmeticCalculations();
				playGame();
			} else {
				System.out.println("Please choose a valid level\n");
			}
			System.out.println("Want to continue play? [yes/no]");
			choice = scanner.nextLine().trim().toLowerCase();
		} while (choice.equals("yes"));
		System.out.println("\n Thanks for giving it a try...");
	}

	public static void main(String[] args) {
		ArithmeticCalculationsCLI arithmeticCalculationsCLI = new ArithmeticCalculationsCLI();
		arithmeticCalculationsCLI.startGame();
	}
}
