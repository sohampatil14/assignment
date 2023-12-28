package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class OutputMultiples implements Runnable {

	int numberMultipleOf;
	
	public OutputMultiples(int number) {
		this.numberMultipleOf = number;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("From " + this.toString() + ": " + this.numberMultipleOf + "x" + i + " = " + (this.numberMultipleOf*i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + this.numberMultipleOf;
	}
}

class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
        System.out.println(task.toString() + " is not admitted to pool.");
    }

}

class MonitorThread implements Runnable {
	
	private ThreadPoolExecutor executor;
    private int seconds;
    private boolean run=true;

    public MonitorThread(ThreadPoolExecutor executor, int delay)
    {
        this.executor = executor;
        this.seconds=delay;
    }
    
    public void shutdown(){
        this.run=false;
    }
    
	@Override
	public void run() {
		
		while(run){
        
			System.out.println(
            		String.format(
            				"[MonitorThread] " +
            				"["+ this.executor.getPoolSize() + "/" + this.executor.getCorePoolSize() + "] "
            				+ "Active: " + this.executor.getActiveCount() + ", "
            				+ "Completed: " + this.executor.getCompletedTaskCount() + ", "
            				+ "Task: " + this.executor.getTaskCount() + ", "
            				+ "isShutdown: " + this.executor.isShutdown() + ", "
            				+ "isTerminated: " + this.executor.isTerminated()
					)
            );
			
            try {
            	Thread.sleep(seconds*1000);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}
}

public class ThreadPools {

	public static void main(String[] args) {
		OutputMultiples om = new OutputMultiples(2);
		Thread t1 = new Thread(om);
		t1.start();
		
		//RejectedExecutionHandler implementation
        CustomRejectedExecutionHandler rejectionHandler = new CustomRejectedExecutionHandler();
        //Get the ThreadFactory implementation to use
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        //creating the ThreadPoolExecutor
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
        //start the monitoring thread
        MonitorThread monitor = new MonitorThread(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
        //submit work to the thread pool
        for(int i=2; i<10; i++){
            executorPool.execute(new OutputMultiples(i));
        }
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        //shut down the pool
        executorPool.shutdown();
        //shut down the monitor thread
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        monitor.shutdown();
		
	}

}
