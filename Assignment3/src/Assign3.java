

class Assign3 implements Runnable {  
     
     public void run() {  
    	 
        for(int i=1;i<10;i++) {
        	if(i%2==0) {
        		System.out.println("Even "+i+" "+Thread.currentThread().getName());
        	}
        	else {
        		System.out.println("Odd "+i+" "+Thread.currentThread().getName());
        	}
        }
    	 
    }  


  
     public static void main(String[] args) {  
       
    	 
    	 Scheduler sc = new Scheduler(); 
    	 new Thread(sc).start();
    	 //Thread t1 = new Thread(sc);
    	 //t1.start();
       
       
    }  
 }  