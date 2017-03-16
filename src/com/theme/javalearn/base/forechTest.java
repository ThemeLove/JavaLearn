package com.theme.javalearn.base;
public class forechTest {

	
	public static void main(String[] args) {
		int returnResult = returntest();
		System.out.println("returnResult:"+returnResult);
		
		int breakResult = breakTest();
		System.out.println("breakResult:"+breakResult);
		
		int continueResult = continueTest();
		System.out.println("continueResult:"+continueResult);
		
	}

	
	private static int continueTest() {
		for (int i = 0; i < 15; i++) {
			if (i==10) {
				continue;//跳出本次循环
			}
			System.out.println("continue..."+i);
		}
		System.out.println("continue...continue");
		return -1;
	}

	
	private static int  returntest() {
		for (int i = 0; i < 15; i++) {
			System.out.println("return..."+i);
			if (i==10) {
				return i;//直接返回，不会走下面的输出语句
			}
		}
		
		System.out.println("return...return");
		return -1;
	}
	
	
	private static int breakTest() {
		for (int i = 0; i <15; i++) {
			System.out.println("break..."+i);
			if (i==10) {
				break;//跳出当前循环，继续走下面的代码   System.out.println("break...break");
			}
		}
		System.out.println("break...break");
		return -1;
	}
	
}
