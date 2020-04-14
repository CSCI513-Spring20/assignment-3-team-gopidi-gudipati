import java.util.LinkedList;
import java.util.Queue;

 

public class Scheduler 
{
    //Thread pool size
    private final int poolSize;
     
    //Internally pool is an array
    private final WorkerThread[] workers;
     
    // Using a FIFO queue to give the first task generated to the thread generated or waiting 
    private final Queue<Runnable> queue;
 
    public Scheduler(int poolSize) 
    {
        this.poolSize = poolSize;
        queue = new LinkedList<Runnable>();
        workers = new WorkerThread[poolSize];
 
        for (int i = 0; i < poolSize; i++) {
            workers[i] = new WorkerThread();
            workers[i].start();
        }
    }
 
    public void execute(Runnable task) {
        synchronized (queue) {
            queue.offer(task);
            queue.notify();
        }
    }
 
    private class WorkerThread extends Thread {
        public void run() {
            Runnable task;
 
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                        }
                    }
                    task = (Runnable) queue.poll();
                }
 
                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                }
            }
        }
    }
 
    public void shutdown() {
        
        for (int i = 0; i < poolSize; i++) {
            workers[i] = null;
        }
        
    }
}