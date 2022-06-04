package com.bhargav.game2048;
import java.util.Scanner;

public class FetchRowColumn {
	
	int n;
	int[][] cells;
	
	public FetchRowColumn(int n, int[][] cells) {
		this.n = n;
		this.cells = cells;
	}
	
	public void leftSelection(int n, int[][] cells) {
		System.out.println("In left...");
		int i, j;
		for(i=0; i<n; i++) {
			for(j=0; j<n; j++) {
				System.out.print(String.format("%6d", cells[i][j]));
			}
			System.out.println("");
		}
	}
	
	public void rightSelection(int n, int[][] cells) {
		System.out.println("In right...");
		int i, j;
		for(i=0; i<n; i++) {
			for(j=n-1; j>=0; j--) {
				System.out.print(String.format("%6d", cells[i][j]));
			}
			System.out.println("");
		}
	}
	
	public void upSelection(int n, int[][] cells) {
		System.out.println("In up...");
		int i, j;
		for(j=0; j<n; j++) {
			for(i=0; i<n; i++) {
				System.out.print(String.format("%6d", cells[i][j]));
			}
			System.out.println("");
		}
	}
	
	public void downSelection(int n, int[][] cells) {
		System.out.println("In down...");
		int i, j;
		for(j=0; j<n; j++) {
			for(i=n-1; i>=0; i--) {
				System.out.print(String.format("%6d", cells[i][j]));
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the row, column fetching phase...");
		
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
		
		FetchRowColumn obj = new FetchRowColumn(n, cells);
		
		System.out.println("Directions to choose: left, right, up or down");
		System.out.println("To quit choose: quit");
		String direction;
		do {
			System.out.print("Enter your choice of direction: ");
			direction = scanner.next();
			System.out.println(direction);
			
			switch(direction) {
				case "left": 	obj.leftSelection(n, cells);
								break;
				case "right":	obj.rightSelection(n, cells);
								break;
				case "up":		obj.upSelection(n, cells);
								break;
				case "down":	obj.downSelection(n, cells);
								break;
				case "quit":	System.out.println("quitting...");
								break;
				default :		System.out.println("Choose within given options...");
			} 
		} while(!direction.equals("quit"));
	}

}
