package com.theme.javalearn.base;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import com.theme.javalearn.thread.bean.User;


/**
 * 比较测试
 * @author lqs
 *
 */
public class CompareTest {

	/**
	 * 集合排序测试
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<User> list = new ArrayList<User>();
		for (int i = 0; i <10; i++) {
			User user = new User();
			user.age= 10+i;
			user.name="student"+i;
			user.score=80+i;
			list.add(user);
		}
		
		Collections.sort(list , new Comparator<User>() {

			@Override
			public int compare(User user1, User user2) {
				return user2.age-user1.age;
			}
		});
		
		System.out.println(list);
	}
}
