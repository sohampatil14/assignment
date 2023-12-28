package multithreading;

class Value {
	static volatile int intValue = 0;
}

class ValueChanger extends Thread {
	
	@Override
	public void run() {
		int threadLocalValue = Value.intValue;
		while(threadLocalValue < 5) {
			threadLocalValue++;
			Value.intValue = threadLocalValue;
			System.out.println("From " + this.toString() + " value incremented : " + threadLocalValue);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String toString() {
		return this.getClass().getName();
	}
}

class ValueChangeDetector extends Thread {
	
	@Override
	public void run() {
		int threadLocalValue = Value.intValue;
		while(threadLocalValue < 5) {
			if(threadLocalValue != Value.intValue) {
				System.out.println("From " + this.toString() + " value change detected : " + Value.intValue);
				threadLocalValue = Value.intValue;
			}
		}
	}
	
	@Override
	public String toString() {
		return this.getClass().getName();
	}
}

public class VolatileKeyword {

	public static void main(String[] args) {
		
		new ValueChanger().start();
		new ValueChangeDetector().start();
	}

}
