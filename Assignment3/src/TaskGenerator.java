import java.util.concurrent.TimeUnit;
 
public class TaskGenerator implements Runnable {
    private String name;
    
    public TaskGenerator(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    public void run() {	//creating tasks that use random time to complete.
        try {
        		synchronized(this) {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Running  : " + name +"  with thread "+Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(duration);
            System.out.println("Finished : " + name +"  with thread "+Thread.currentThread().getName());
        } 
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
}