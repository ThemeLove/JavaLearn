package com.theme.javalearn.test;

import java.io.File;
import java.util.Set;

/**
 *	@author:qingshanliao
 *  @date  :2017年3月16日
 */
public class CommonLearnTest {
	public static void main(String[] args) {
//		获取当前字节码文件所在的目录
		String path = CommonLearnTest.class.getResource(".").getPath();
		System.out.println("path------->"+path);
//		path------->/D:/workspace/MyEclipseSpace/javaSpace/JavaLearn/bin/com/theme/javalearn/
		
//		获取当前字节码所在包的顶层目录
		String path1 = CommonLearnTest.class.getResource("/").getPath();
		System.out.println("path1------->"+path1);
//		path1------->/D:/workspace/MyEclipseSpace/javaSpace/JavaLearn/bin/
		
//		获取当前类所在的路径
		String path2 = System.getProperty("user.dir");
		System.out.println("path2------->"+path2);
//		path2------->D:\workspace\MyEclipseSpace\javaSpace\JavaLearn
		
		String lineSeparator = System.lineSeparator();
		System.out.println("lineSeparator------->"+lineSeparator);
		System.out.println("FileSeparator------->"+File.separator);
		Set<Object> keySet = System.getProperties().keySet();
		System.out.println("当前系统属性如下：");
		for (Object key : System.getProperties().keySet()) {
			System.out.println(key.toString()+":------->"+System.getProperty(key.toString()));
		}
	}
}
