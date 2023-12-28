package multithreading;

class Output {
	
	synchronized public void outputOnConsole(MethodSynchronized msync) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(this.toString() + "." + msync.getName() + ": " + i);
		}
	}
	
	@Override
	public String toString() {
		return this.getClass().getName();
	}
}

class MethodSynchronized extends Thread {
	Output out;
	
	public MethodSynchronized(Output out) {
		this.out = out;
	}
	
	@Override	
	public void run() {
		this.out.outputOnConsole(this);
	};
}

public class MethodSynchronization {

	public static void main(String[] args) {
		
		Output out = new Output();
		
		MethodSynchronized thread1 = new MethodSynchronized(out);
		MethodSynchronized thread2 = new MethodSynchronized(out);
		thread1.start();
		thread2.start();
				
	}

}
