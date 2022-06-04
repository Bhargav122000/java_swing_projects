package com.bhargav.game2048;

import java.util.Scanner;

public class LeftMove {

	int n;
	int[] row;

	public LeftMove(int n, int[] row) {
		this.n = n;
		this.row = row;
	}

	public void moveLeftByOne(int[] row, int start) {
		int i;
		for (i = start; i < row.length - 1; i++) {
			row[i] = row[i + 1];
		}
		row[i] = 0;
	}

	public boolean isAllZeroes(int[] row, int start) {
		boolean result = true;
		for (int i = start; i < row.length; i++) {
			if (row[i] != 0) {
				result = false;
				break;
			}
		}
		return result;
	}

	public void displayRow(int[] row) {
		System.out.print("row-");
		for (int i = 0; i < row.length; i++) {
			System.out.print(String.format("%6d", row[i]));
		}
		System.out.println("");
	}

	public void modifyRow(int[] row, int n) {
		int i, j;

		if (this.isAllZeroes(row, 0)) {
			System.out.println("the row is empty");
		} else {
			j = 0;
			while (j < n-1) {
				i = 0;
				while (i < n - 1) {
					if (row[i] == row[i + 1]) {
						row[i] += row[i + 1];
						moveLeftByOne(row, i + 1);
						i++;
					} else if (row[i] == 0) {
						if (this.isAllZeroes(row, i + 1)) {
							j++;
							i = 0;
						} else {
							this.moveLeftByOne(row, i);
						}
					} else {
						i++;
					}

					System.out.println("In loop...");
					this.displayRow(row);
				}
				j++;
			}

			System.out.println("the row is modified");
		}

	}

	public static void main(String[] args) {
		System.out.println("Welcome to the game board modification phase...");

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the row size(n): ");
			int n = scanner.nextInt();
			int[] row = new int[n];
			int i;
			System.out.println("Enter " + n + " numbers: ");
			for (i = 0; i < n; i++) {
				row[i] = scanner.nextInt();
			}

			LeftMove obj = new LeftMove(n, row);
			obj.modifyRow(row, n);
			scanner.close();
		}
	}

}
