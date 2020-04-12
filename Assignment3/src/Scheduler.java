public class Scheduler implements Runnable{

	public void run() {
		
		
		Assign3 w1;
		for(int i =0;i<10;i++) {
	    	   w1 = new Assign3();
	    	   Thread ti = new Thread(w1);
	    	   ti.start(); }
	}
	
	
}