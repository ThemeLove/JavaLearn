package com.theme.javalearn.thread;
import java.util.Vector;


public class ProductorConsumerTest {
	
	public static void main(String[] args) {
		
		Vector<Object> vector = new Vector<>();
		new Thread(new ProductorRunnable(vector)).start();
		new Thread(new ConsumerRunnable(vector)).start();
	}
	
}
