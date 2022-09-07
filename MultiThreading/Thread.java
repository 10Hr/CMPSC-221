import java.io.File;
import java.io.*;
import java.util.*;
import java.lang.Runnable;

public class Thread implements Runnable {
	
	  private ArrayList<Integer> 
	  
	  low = new ArrayList<Integer>(),
	  mid = new ArrayList<Integer>(), 
	  high = new ArrayList<Integer>();
	  
	  private String fName;
	  private Thread arrayThread;
	  
	  public Thread() {}
	  
	  public Thread(File name, Thread arr) {
		   fName = name.toString();
		   arrayThread = arr;
		   System.out.println("Array writer for " +  fName + " starts");
	  }

	  public synchronized void add(int num) {
		  
	    if (num >= 1 && num <= 100) 
	    	low.add(num);
	    else if (num >= 101 && num <= 200) 
	    	mid.add(num);
	    else if (num >= 201 && num <= 300) 
	    	high.add(num);
	  }

	@Override
	public void run() {
		
		 try {
		      File file = new File(fName);
		      Scanner scan = new Scanner(file);

		      while (scan.hasNext()) {
		        int num = scan.nextInt();
		        arrayThread.add(num);
		      }
		      
		    } catch (Exception e) { 
		    	 e.printStackTrace(); 
		    }
	}
	@Override 
  	public String toString() {
		    return "Array Low:\n" + low + "\nArray Middle:\n" + mid + "\nArray array:\n" + high;
  	}
}
