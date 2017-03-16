package com.theme.javalearn.base;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

import com.theme.javalearn.thread.bean.User;



public class ReferenceTest {
	public static void main(String[] args) {
//		ReferenceQueue<T>
		User user = new User();//强引用
		
		//软引用:当我们把引用对象user=null置为空时，虽然有软引用还在引用着，内存中已经实例的对象也不能随便被JVM回收，只有当JVM内存不够时才可能回收。
		
		SoftReference<User> softReference = new SoftReference<>(user);
		
		//弱引用：当我们把引用对象user=null置为空时，虽然有弱引用还在引用着，内存中的user实例还是可以随时被JVM回收。
		WeakReference<User> weakReference = new  WeakReference<>(user);
		
		
		ReferenceQueue<User> referenceQueue = new  ReferenceQueue<User>();//引用队列
		
		//虚引用：当我们把引用对象user=null置为null时，虽然有虚引用在引用着，内存中的user实例在任何时候都可以被JVM回收。
		PhantomReference<User> phantomReference = new PhantomReference<User>(user, referenceQueue);//虚引用
		
		user=null;
		
		
		/**
		 * 总结：
		 * java中几种引用的强度关系。
		 * 强引用 (StrongReference)  > 软引用(SoftReference) > 弱引用(WeakReference) > 虚引用(PhantomReference)
		 * 
		 * 鉴于软引用和弱引用的这一区别:
		 * 1、软引用可以很好的用来实现缓存，当JVM需要内存时，垃圾回收器就会回收这些只有被软引用指向的对象。
		 * 2、弱引用非常适合存储元数据，例如：存储ClassLoader引用。如果没有类被加载，那么也没有指向ClassLoader的引用。一旦上一次的强引用被去除，只有弱引用的ClassLoader就会被回收。
		 * 另一个使用弱引用的例子是WeakHashMap，它是除HashMap和TreeMap之外，Map接口的另一种实现。WeakHashMap有一个特点：map中的键值(keys)都被封装成弱引用，也就是说一旦强引用被删除，WeakHashMap内部的弱引用就无法阻止该对象被垃圾回收器回收。
		 * 
		 */
		
		
		WeakHashMap<String, User> weakHashMap = new  WeakHashMap<String,User>( );
		
		for (int i = 0; i < 3; i++) {
			weakHashMap.put(i+"", user);
		}
		
		
		
		
		
		
	}
}
