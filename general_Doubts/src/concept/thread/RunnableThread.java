package concept.thread;

public class RunnableThread implements Runnable {

	@Override
	public void run() {
		System.out.println("In run method");
	}

	public static void main(String[] args) {
		RunnableThread runnableThread = new RunnableThread();
		Thread thread = new Thread(runnableThread);
		thread.start();
	}

}
