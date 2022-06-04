package concept.thread;

public class ThreadPriority extends Thread {

	public static void main(String[] args) {
		ThreadPriority threadPriority1 = new ThreadPriority();
		threadPriority1.setName("threadPriority1");
		threadPriority1.setPriority(MIN_PRIORITY);
		threadPriority1.start();
		
		ThreadPriority threadPriority2 = new ThreadPriority();
		threadPriority2.setName("threadPriority2");
		threadPriority2.setPriority(MAX_PRIORITY);
		threadPriority2.start();
	}
	
	public void run() {
		System.out.println("Current thread: " + Thread.currentThread().getName());
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 1000; j++) {
				
			}
			System.out.println("In " + Thread.currentThread().getName() + "-> i: " + i);
		}
		System.out.println();
	}

}
