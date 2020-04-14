import java.util.*;
public class Assign3 
{
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the number of Threads to be created");
    	int a =sc.nextInt();
    	System.out.println("Enter the number of Tasks to be created");
    	int b =sc.nextInt();
    	Scheduler threads = new Scheduler(a);// Creating 10 threads 
         
        for (int i = 1; i <= b; i++) //creating 20 tasks
        {
            TaskGenerator task = new TaskGenerator("Task " + i);
 
            threads.execute(task);
            if(i==b) {
            	threads.shutdown();
            	
            }
        }
        
    }
}