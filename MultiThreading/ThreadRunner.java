import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class ThreadRunner {

	public static void main(String[] args) {
	       Scanner scan = new Scanner(System.in);
	        
	        System.out.println("Enter the first file to scan:");
	        File f1 = new File(scan.nextLine());
	        
	        System.out.println("Enter the second file to scan:");
	        File f2 = new File(scan.nextLine());
	        
	        System.out.println("Enter the third file to scan:");
	        File f3 = new File(scan.nextLine());
	        
	        Thread arr = new Thread();

	        ExecutorService thread = Executors.newCachedThreadPool();
	        thread.execute(new Thread(f1, arr));
	        thread.execute(new Thread(f2, arr));
	        thread.execute(new Thread(f3, arr));
	        thread.shutdown();
  
	        try {
	        	
	            boolean complete = thread.awaitTermination(1, TimeUnit.MINUTES);
	            
	            if (complete) 
	            	System.out.print(arr);
	            else 
	            	System.out.println("Timed out");
	            
	          } catch (Exception e) {
	        	  e.printStackTrace();
	          }
	        scan.close();

}
	
}
