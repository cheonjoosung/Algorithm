package grammer;

import java.util.Arrays;

public class ThreadExample /*extends Thread*/ implements Runnable {
	String str;
	public ThreadExample(String str) { this.str = str; }
	
	@Override
	public synchronized void run() {
		for(int i=0 ; i<10 ; i++) {
			synchronized (this) {
				System.out.println(str);
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		/* ### Thread Test ###
		ThreadExample t1 = new ThreadExample("WOW");
		t1.start();*/		
		
		/* ### Runnable Test ###
		ThreadExample r1 = new ThreadExample("WOW");
		ThreadExample r2 = new ThreadExample("TEST");
		
		new Thread(r1).start();
		new Thread(r2).start();	*/	
	}
}
