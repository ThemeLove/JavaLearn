package com.theme.javalearn.base;

import java.util.ArrayList;

/**
 *  测试java中的深拷贝和浅拷贝
 *	@author:qingshanliao
 *  @date  :2017年11月7日
 *  
 *  java 中基本数据类型是在stack中，引用类型是在堆内存中的
 */
public class StringTest {
	public static void main(String[] args) {
		String a="abc";
		String b=a;
		System.out.println("a:"+a.hashCode());
		System.out.println("b:"+b.hashCode());
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("xzy");
		list1.add("lqs");
		ArrayList<String> list2 = list1;
		System.out.println("list1_HashCode:"+list1.hashCode());
		System.out.println("list2_HashCode:"+list2.hashCode());
		ArrayList<String> list3 = (ArrayList<String>) list1.clone();
		System.out.println("list3_HashCode:"+list3.hashCode());
		list3.add("lover");
		System.out.println("list1:"+list1);
		System.out.println("list3:"+list3);		
		System.out.println("list1_HashCode:"+list1.hashCode());
		System.out.println("list3_HashCode:"+list3.hashCode());
		
	}
}
