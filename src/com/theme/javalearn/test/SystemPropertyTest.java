package com.theme.javalearn.test;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Test;

/**
 *	@author:qingshanliao
 *  @date  :2019年7月3日
 */
public class SystemPropertyTest {

	@Test
	public void propertyTest() {
		Properties properties = System.getProperties();
		for (Entry<Object,Object> entry : properties.entrySet()) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		
	}

	@Test
	public void envTest(){
		Map<String, String> envs = System.getenv();
		for (Entry<String,String> entry : envs.entrySet()) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
}
