package com.bhargav.romannumerals.cli;

import java.util.*;

public class RomanNumeralsCLITest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RomanNumeralsCLI romanNumeralsCLI = new RomanNumeralsCLI();
		int choice, number;
		String roman, continueChoice;

		System.out.println("Welcome to Roman <-> Number Conversions..");
		do {
			try {
				System.out.println("1-Number to Roman");
				System.out.println("2-Roman to Number");
				System.out.println("Choose 1 or 2:");
				choice = Integer.parseInt(scanner.nextLine().trim());
				if (choice == 1) {
					System.out.println("Enter a natural number (<=3000): ");
					number = Integer.parseInt(scanner.nextLine().trim());
					if (number >= 1 && number <= 3000) {
						roman = romanNumeralsCLI.convertToRoman(number);
						System.out.println("Roman equivalent: " + roman);
					} else {
						throw new Exception();
					}
				} else if (choice == 2) {
					System.out.println("Enter a roman number:");
					roman = scanner.nextLine().trim();
					if (!(roman.equals("") || roman.equals(null))) {
						number = romanNumeralsCLI.convertToNumber(roman);
						System.out.println("Number equivalent: " + number);
					} else {
						throw new Exception();
					}
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Invalid choice..");
			}

			System.out.println("\nAnother try [yes/no]:");
			continueChoice = scanner.nextLine().trim().toLowerCase();
			System.out.println("\n");
		} while (continueChoice.equals("yes"));

		System.out.println("Thanks for giving it a try..");
		scanner.close();
	}

}
