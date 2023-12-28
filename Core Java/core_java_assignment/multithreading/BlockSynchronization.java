package multithreading;

import java.util.ArrayList;

class AddElements {
	
	public void addObject(BlockSynchronized bsync) {
		for (int i = 0; i < 5; i++) {
			String localName = bsync.getName() + "-" + i + "-" + (BlockSynchronization.threadNames.size() + 1);
			synchronized (this) {
				BlockSynchronization.threadNames.add(localName);
				System.out.println(BlockSynchronization.threadNames);
			}
//			System.out.println(this.toString() + "." + bsync.getName() + ": " + BlockSynchronization.threadNames.size() + "-" + i);
		}
	}
	
	@Override
	public String toString() {
		return this.getClass().getName();
	}
}

class BlockSynchronized extends Thread {
	AddElements addStrings;
	
	public BlockSynchronized(AddElements addStrings) {
		this.addStrings = addStrings;
	}
	
	@Override	
	public void run() {
		this.addStrings.addObject(this);
	};
}

public class BlockSynchronization {

	public static ArrayList<String> threadNames = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		AddElements addStrings = new AddElements();
		
		BlockSynchronized thread1 = new BlockSynchronized(addStrings);
		BlockSynchronized thread2 = new BlockSynchronized(addStrings);
		thread1.start();
		thread2.start();
				
	}

}
