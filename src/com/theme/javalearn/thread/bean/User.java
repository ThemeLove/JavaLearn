package com.theme.javalearn.thread.bean;

public class User {
	public String name;
	public int    age;
	public static int    score;
	

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	
	@Override
	public int hashCode() {
		return 31*score;
	}
	
}
