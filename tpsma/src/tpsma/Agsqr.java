package tpsma;

import java.math.*;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.io.*;
import java.lang.*;

public class Agsqr implements Runnable{
	
	private PipedWriter pw;
	private Semaphore sem;
	private ArrayList<Integer> array;
	
	
	public Agsqr(PipedWriter pw, ArrayList<Integer> array,Semaphore sem) {
		this.pw = pw;
		this.array= array;
		this.sem = sem;

	}
	
	int number = 0 ; 
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			boolean vaiable = false;
			int nsqr;
			while(!vaiable){	
				sem.acquire();
				nsqr = number*number;
				Agclass.classs="Agsqr";
				pw.write(nsqr);		
				Thread.sleep(1000);
				
				number++;					
			}
		//	pw.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	

}
