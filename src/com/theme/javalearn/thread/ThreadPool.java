package com.theme.javalearn.thread;
import java.awt.SystemColor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class ThreadPool {
//	javaSE 中系统维护好的线程池
	ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
	ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
	ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
	ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

	private static ThreadPoolExecutor myThreadPool;

	public static void main(String[] args) {
		
		LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>(15);
		
		ThreadFactory threadFactory = new ThreadFactory() {
			
			AtomicInteger atomicInteger = new AtomicInteger(0);
			
			@Override
			public Thread newThread(Runnable r) {
				//线程工厂真正创建线程
				Thread thread = new Thread(r);
				thread.setName("thread"+atomicInteger.getAndIncrement());
				return thread;
			}
		};
		
		myThreadPool = new ThreadPoolExecutor(0, 10, 1, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
		method();
	}
	
	/**
	 * 
	 */
	public static void method(){
		for (int i = 0; i <25; i++) {
			final int temp=i;
			myThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						System.out.println("序号："+temp+"====="+Thread.currentThread().getName()+"进来了");
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()+"出去了");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
