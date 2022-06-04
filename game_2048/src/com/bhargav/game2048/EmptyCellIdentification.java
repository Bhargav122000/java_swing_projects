package com.bhargav.game2048;

import java.util.Random;
import java.util.Scanner;

public class EmptyCellIdentification {

	int n;
	int[][] cells;

	public EmptyCellIdentification(int n, int[][] cells) {
		this.n = n;
		this.cells = cells;
	}

	public void displayGameBoard(int n, int[][] cells) {
		System.out.println("The game board-");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(String.format("%6d", cells[i][j]));
			}
			System.out.println("");
		}
	}

	public void fillEmptyCell(int n, int[][] cells) {
		System.out.println("");
		System.out.println("Generating value(2 or 4) and filling an empty cell...");

		Random random = new Random();
		int number;
		int i, j;
		while (true) {
			number = random.nextInt(n * n);
			i = number / n;
			j = number % n;
			if (cells[i][j] == 0) {
				if (random.nextBoolean() == true) {
					cells[i][j] = 2;
				} else {
					cells[i][j] = 4;
				}
				break;
			}
		}
	}

	public boolean isGameBoardEmpty(int n, int[][] cells) {
		boolean result = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (cells[i][j] == 0) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Empty cell identification phase...");

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the game board size(n for nxn): ");
		int n = scanner.nextInt();

		System.out.println("Enter " + (n * n) + " values (0 or in 2^x form): ");
		int[][] cells = new int[n][n];
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				cells[i][j] = scanner.nextInt();
			}
		}

		EmptyCellIdentification obj = new EmptyCellIdentification(n, cells);
		while (obj.isGameBoardEmpty(n, cells)) {
			System.out.println("");
			System.out.println("Before filling the empty cell...");
			obj.displayGameBoard(n, cells);
			obj.fillEmptyCell(n, cells);
			System.out.println("");
			System.out.println("After filling the empty cell...");
			obj.displayGameBoard(n, cells);
		}
		System.out.println("");
		System.out.println("The game board is not empty");
	}

}
