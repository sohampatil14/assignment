package multithreading;

/**
 * Create Thread using -
 * 1. Implementing Runnable Interface
 * 2. Extending Thread class
 */

class ThreadByRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("From " + this.toString() + ": " + i);
		}
	}
	
	@Override
	public String toString() {
		return this.getClass().getName();
	}
}

class ExtendingThread extends Thread {
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("From " + this.toString() + ": " + i);
		}
	}
	
	@Override
	public String toString() {
		return this.getClass().getName();
	}
}

public class ThreadBasics {

	public static void main(String[] args) {

		ThreadByRunnable tByRunnable = new ThreadByRunnable();
		Thread usingRunnable = new Thread(tByRunnable);
		usingRunnable.start();
		
		ExtendingThread eThread = new ExtendingThread();
		eThread.start();
	}

}
