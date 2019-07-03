package com.theme.javalearn.systemproperty;

import java.util.Properties;

/**
 *  本类是系统属性测试代码
 *	@author:qingshanliao
 *  @date  :2017年3月16日
 */
public class SystemPropertyTest {
	public static void main(String[] args) {
//		获取当前系统的属性
		Properties properties = System.getProperties();
		System.out.println("当前系统的属性如下：");
			for (Object property : properties.keySet()) {
				System.out.println(property.toString()+"----->"+System.getProperty(property.toString()));
		}
			
			
		System.out.println("换行符----->"+System.getProperty("line.separator"));
		System.out.println("目录分割符----->"+System.getProperty("file.separator"));
		System.out.println("路径分割符----->"+System.getProperty("path.separator"));
		System.out.println("当前项目目录----->"+System.getProperty("user.dir"));
		System.out.println("当前类的字节码目录----->"+SystemPropertyTest.class.getResource("."));
	}
	
	
}
