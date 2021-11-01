package tpsma;

import java.net.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Semaphore;
import java.io.*;

//Code AgClass.java

//develope par : RSD G1



public class Agclass {
	static String WhoAreYou ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Semaphore sem = new Semaphore(1);
				
			int num ;
			PipedWriter pws = new PipedWriter();
			PipedReader prt = new PipedReader();
			pws.connect(prt);
			
			//Lists
			ArrayList<Integer> array = new ArrayList<Integer>();
			ArrayList<Integer> arraysqr = new ArrayList<Integer>();
			ArrayList<Integer> arrayfibo = new ArrayList<Integer>();
			
			
			
			//sqr thread
			Agsqr sqr = new Agsqr(pws,array,sem);
			Thread threadsqr =  new Thread(sqr); 
			

			//fib thread
			Agfib fib = new Agfib(pws,array,sem);
			Thread threadfib =  new Thread(fib);
			threadfib.start();
			threadsqr.start();
			
			
			while((num = prt.read()) != -1) {
				
				if(WhoAreYou.equals("Agsqr")) {
					arraysqr.add(num);
				}else if(WhoAreYou.equals("Agfib")) {
					arrayfibo.add(num);
				}
				System.out.println( WhoAreYou + " adds number  = "+ num);
				array.add(num);
				Collections.sort(array);
				
				System.out.println("Square number = " + arraysqr);
				System.out.println("Fibo number   = " +arrayfibo);
				System.out.println("Classeur      = " + array);
				System.out.println();
				sem.release();
				Thread.sleep(1000);
			}
			
			prt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
