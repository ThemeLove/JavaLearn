package com.theme.javalearn.thread;

public class ThreadTest {
	
	public static void main(String[] args) {
		
		MyThread myThread = new MyThread();
		myThread.start();
		
		MyRunnable myRunnable = new MyRunnable();
		new Thread(myRunnable).start();
		
	}
	
	public static class MyThread extends Thread{
		
		
		
		public MyThread() {
			super();
		}

		@Override
		public void run() {
			super.run();
		}
	}
	
	
	
	public static class MyRunnable implements Runnable{
		
		@Override
		public void run() {
			
		}
		
	}
}
