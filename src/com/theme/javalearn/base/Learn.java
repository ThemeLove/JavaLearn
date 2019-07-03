package com.theme.javalearn.base;
import java.util.HashMap;


public class Learn {

	public static void main(String[] args) {
		String a="abc";
//		a = a.replace('a', 'b'); 用a接收了，相当于重新赋值
//		a.replace('a', 'b');没有用a接收，相当于在内存中新生成了了字符串常量"bbc"
		System.out.println(a);
		Object object = new Object();
		HashMap<Object,Object> hashMap = new HashMap<>();
	}
}
