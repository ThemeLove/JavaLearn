package com.theme.javalearn.base;
import java.util.HashMap;

import com.theme.javalearn.thread.bean.User;



public class HashTest {

	public static void main(String[] args) {
		User userA = new User();
		userA.name="张三";
		userA.age=24;
		userA.score=90;
		
		User userB=new User();
		HashMap<User, Integer> hashMap = new HashMap<User,Integer>();
		hashMap.put(userA, 1);
		
		Integer integer1 = hashMap.get(userA);
		System.out.println("integer1===="+integer1);
		
		userB.score=100;
//      因为我们重写了HashCode()方法。userB.score=100;会改变hashCode的值，
//		这时我们在HashMap中放入UserA时和取出UserA时，hashCode不一样，所以这时取出的值为null
//		所以我们一般将equals和hashCode()方法要同时重写。
		Integer integer2 = hashMap.get(userA);//值为null
		System.out.println("integer2===="+integer2);
	}
}
