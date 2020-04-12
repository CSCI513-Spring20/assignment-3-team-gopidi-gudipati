

class WorkerThread implements Runnable {  
     
     public void run() {  
    	 synchronized(this){
        for(int i=1;i<3;i++) {
        	if(i%2==0) {
        		System.out.println("Even "+i+" "+Thread.currentThread().getName());
        	}
        	else {
        		System.out.println("Odd "+i+" "+Thread.currentThread().getName());
        	}
        }
    	 }
    }  
    private void processmessage() {  
        try {  Thread.sleep(2000);  } catch (InterruptedException e) { e.printStackTrace(); }  
    }  
}  


public class Assign3 {  
     public static void main(String[] args) {  
       WorkerThread w1;
       
       for(int i =0;i<10;i++) {
    	   w1 = new WorkerThread();
    	   Thread ti = new Thread(w1);
    	   ti.start();
       }
       
    }  
 }  