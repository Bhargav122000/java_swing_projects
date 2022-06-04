package concept.thread;

import java.util.Scanner;

public class MultiThreadedJoin extends Thread {
	static int n;
	static long factorial = 1l;
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		System.out.println("Computes the factorial of given integer 'n'...");
		System.out.println("Enter a positive integer:");
		Scanner scanner = new Scanner(System.in);
		MultiThreadedJoin.n = scanner.nextInt();
		
		MultiThreadedJoin multiThreadedJoin = new MultiThreadedJoin();
		multiThreadedJoin.start();
		try {
			multiThreadedJoin.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("The factorial of " + MultiThreadedJoin.n + " is: " + MultiThreadedJoin.factorial);
		scanner.close();
		
		long end = System.currentTimeMillis();
		System.out.println("Time taken to calculate factorial is: " + (end - start) / 1000 + " seconds.");
	}
	
	public void run() {
		for (int i = 1; i <= MultiThreadedJoin.n; i++) {
			MultiThreadedJoin.factorial *= i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("In run-factorial :" + MultiThreadedJoin.factorial);
		}
	}
}
