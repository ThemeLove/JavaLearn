package com.theme.javalearn.base;
/**
 * 该类是测试try  catch 语句中含有return 语句时，finally是否一定会执行的。
 * 结果：finally语句在return语句执行之后return返回之前执行的
 * @author lqs
 *
 */
public class ReturnFinallyTest {
	
	public static void main(String[] args) {
		
		int result = test(0);
		System.out.println("result:"+result);
	}

	private static int test(int dividend) {
		try {
			int a=10;
			System.out.println("try。。。before");
//			System.exit(0);
			int result=a/dividend;
			return result;
		} catch (Exception e) {
			System.out.println("catch...exception");
			e.printStackTrace();
		}finally{
			System.out.println("finally...before");
			return -1;
		}
		
	}
	
}

