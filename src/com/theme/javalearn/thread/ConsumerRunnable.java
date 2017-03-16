package com.theme.javalearn.thread;
import java.util.List;


/**
 * 模拟消费者
 * @author lqs
 *
 */
public class ConsumerRunnable implements Runnable{
	private List  mList;
	
	public ConsumerRunnable(List list){
		mList=list;
	}

	@Override
	public void run() {
		synchronized (mList) {
			
			while (true) {
				if (mList != null && mList.size() == 0) {
					try {
						mList.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
				System.out.println("Consumer:goods have been taken");
				System.out.println("Consumer size: " + mList.size());
				
				mList.clear();
				mList.notify();

			}
			
		}
	}
	
}
