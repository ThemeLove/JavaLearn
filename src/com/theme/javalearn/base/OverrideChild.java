package com.theme.javalearn.base;
public class OverrideChild extends OverrideTest {

	@Override
	public void method2(int int1, String str) {
		// TODO Auto-generated method stub
		super.method2(int1, str);
	}

	@Override
	public void method2(String str, int int1) {
		// TODO Auto-generated method stub
		super.method2(str, int1);
		method1();
	}

/*	public static void method1(){
		System.out.println("我 是静态测试方法1");
	}*/
	
}
