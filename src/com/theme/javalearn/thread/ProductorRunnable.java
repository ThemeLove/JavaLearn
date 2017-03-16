package com.theme.javalearn.thread;
import java.util.List;

/**
 * 模拟生产者
 * @author lqs
 *
 */
public class ProductorRunnable implements Runnable{
	private List mList;
	public ProductorRunnable(List list){
		mList=list;
	}

	@Override
	public void run() {
		
		synchronized (mList) {
			while (true) {
				try {
					if (mList != null && mList.size() != 0) {
							mList.wait();
					}
					
					mList.add("a new good");
					mList.notify();
					System.out.println("Producter:goods are ready");
					Thread.sleep(500);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
