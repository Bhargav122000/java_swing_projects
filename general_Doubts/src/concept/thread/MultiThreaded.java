package concept.thread;

public class MultiThreaded extends Thread {
	public static void main(String[] args) throws InterruptedException {
		MultiThreaded multiThreaded = new MultiThreaded();
		multiThreaded.start();
		
		for (int j = 0; j < 19; j++) {
			System.out.println("In main - j : " + j);
			Thread.sleep(1000);
		}
	}
	
	public void run() {
		displayNumbers();
	}
	
	public void displayNumbers() {
		for (int i = 0; i < 19; i++) {
			System.out.println("In method - i : " + i);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception for child thread");
			}
		}
	}
}
