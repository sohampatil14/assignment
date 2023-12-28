package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Methods to achieve thread-safety -
 * 1. synchronized method/block
 * 2. volatile keyword
 * 3. atomic variables - when variables are shared by multiple threads, the atomic variable ensures that threads don’t crash into each other
 * 4. final variables - once assigned some reference of an object It cannot point to reference of another object 
 */

class AtomicValue {
	static AtomicInteger intAtomic = new AtomicInteger();
}

class ValueIncrementInitiator extends Thread {
	
	@Override
	public void run() {
		
		while(AtomicValue.intAtomic.intValue() < 10) {
		
			AtomicValue.intAtomic.getAndIncrement();
			System.out.println("From " + this.toString() + "." + this.getName() + " value incremented : " + AtomicValue.intAtomic.intValue());
			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
	
	@Override
	public String toString() {
		return this.getClass().getName();
	}
}

public class ThreadSafety {

	public static void main(String[] args) throws InterruptedException {
	
		ValueIncrementInitiator thread1 = new ValueIncrementInitiator();
		ValueIncrementInitiator thread2 = new ValueIncrementInitiator();
		ValueIncrementInitiator thread3 = new ValueIncrementInitiator();
		ValueIncrementInitiator thread4 = new ValueIncrementInitiator();
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		
		System.out.println("\nFinal value of AtomicValue.intAtomic: " + AtomicValue.intAtomic.intValue()); // always equals to 10; integrity across threads is maintained
		
	}

}
