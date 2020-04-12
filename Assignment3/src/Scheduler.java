public class Scheduler implements Runnable{

	
	Assign3 a3 = new Assign3();
	public void run()
	{
		System.out.println("HI ya");
		
		
	}
	public Scheduler() {
		Scheduler sc = new Scheduler();
		Thread t1 = new Thread(sc);
		t1.start();
	}
}