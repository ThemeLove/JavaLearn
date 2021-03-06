package com.theme.javalearn.base;
import java.util.Arrays;


public class sortTest {

	public static void main(String[] args) {
		
		int[] a=new  int []{12,34,657,83,24,76,2324,2,6};
		System.out.println("str:"+Arrays.toString(a));
//		selectSort1(a);
//		selectSort(a);
		bubbleSort(a);
//		selectSort(a);
		System.out.println(Arrays.toString(a));
		
		int index = binnarySearch(83, a);
		System.out.println("index:"+index);
		
		
//		交换测试
		int m=5;
		int n=6;
		exchangePosition(m, n);
	}

	/**
	 * 冒泡排序
	 * @param array
	 */
	public static  void bubbleSort(int[] array){
		System.out.println("冒泡排序：每一层外循环完就会将一个较小或较大的数排在后面");
		int loopCount=0;
		for (int i = 0; i < array.length; i++) {//控制循环次数
			for (int j = 0; j < array.length-i-1; j++) {//-1表示防止数组角标越界,因为后续比较的时候在array[j+1]中已经加了1
					if (array[j]>array[j+1]) {
						int temp=array[j];
						array[j]=array[j+1];
						array[j+1]=temp;
						
					}
					loopCount++;
			}
		}
		System.out.println("bubbleSort总循环次数："+loopCount);
	}
	

	
	/**
	 * 选择排序
	 * @param array
	 */
	public static void selectSort(int [] array){
		System.out.println("选择排序：每一层外循环完就会将一个较小或较大的数排在前面");
		int loopCount=0;
		for (int i = 0; i < array.length-1; i++) {//外层循环可以减1
			for (int j = i+1; j < array.length; j++) {
				 if (array[i]>array[j]) {
					 int temp=array[i];
					 array[i]=array[j];
					 array[j]=temp;
				}
				 loopCount++;
			}
			
		}
		System.out.println("selectSort总循环次数："+loopCount);
	}

	
	/**
	 * 二分查找：对于2分查找的数组，一定要是已经排好序号的。
	 * @param target
	 * @param array
	 */
	private static int binnarySearch(int target ,int [] array) {

		int start=0;
		int end=array.length-1;
		
		while (end>=start) {
			
			int middleIndex=(start+end)/2;
			int middleValue=array[middleIndex];	
			if (target>middleValue) {
				start=middleIndex+1;
			}else if(target<middleValue){
				end=middleIndex-1;
			}else if(target==middleValue){
				return middleIndex;
			}
		}
		
		return -1;
		
	}
	
	
	/**
	 * 交换2个变量的值，位运算效率最高
	 * @param m
	 * @param n
	 */
	public static void exchangePosition(int m,int n){
		m=m^n;
		n=m^n;
		m=m^n;
		System.out.println("m:"+m+"\n"+"n:"+n);
	}
}

