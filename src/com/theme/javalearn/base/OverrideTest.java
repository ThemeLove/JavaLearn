package com.theme.javalearn.base;
public class OverrideTest {

	public static void method1(){
		System.out.println("我 是静态测试方法1");
	}
	
	public void method2(int int1,String str){
		
	}
	
	public void method2(String str,int int1){
		System.out.println("我是非静态方法2");
	}
}
