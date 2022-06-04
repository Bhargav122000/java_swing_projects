package concept.thread;

public class ThreadIdentity extends Thread {
	public static void main(String[] args) throws InterruptedException {
		ThreadIdentity threadIdentity = new ThreadIdentity();
		threadIdentity.start();
		
		Thread.sleep(1000);
		
		Thread currentThread = Thread.currentThread();
		System.out.println("ID of current thread: " + currentThread.getId());
		System.out.println("Name of current thread: " + currentThread.getName());
		System.out.println("Priority of current thread: " + currentThread.getPriority());
		System.out.println("Class of current thread: " + currentThread.getClass());
	}
	
	public void run() {
		Thread currentThread = Thread.currentThread();
		System.out.println("ID of current thread: " + currentThread.getId());
		System.out.println("Name of current thread: " + currentThread.getName());
		System.out.println("Priority of current thread: " + currentThread.getPriority());
		System.out.println("Class of current thread: " + currentThread.getClass());
	}
}
