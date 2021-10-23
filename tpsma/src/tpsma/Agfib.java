package tpsma;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Agfib implements Runnable {
	
	private PipedWriter pw;
	private ArrayList<Integer> array;
	private Semaphore sem;
	
	
	public Agfib(PipedWriter pw,ArrayList<Integer> array,Semaphore sem){
		this.pw = pw;
		this.array= array;
		this.sem=sem;
	}


	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		try {
			int number ; 
			 int previousNumber = 0;
			 int nextNumber = 1;
		
				
			boolean variable = false;
			while(!variable){
				sem.acquire();
				Agclass.classs="Agfib";
	            pw.write(previousNumber);
	             
	            Thread.sleep(1000);
	            int sum = previousNumber + nextNumber;
	            previousNumber = nextNumber;
	            nextNumber = sum;	
	            
	        }
	//		pw.close();
			
		}catch(Exception e){
			
		}
		  
		
	}
		
	

}

