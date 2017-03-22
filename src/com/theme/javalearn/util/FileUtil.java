package com.theme.javalearn.util;

import java.io.File;
import java.io.IOException;

/**
 *  File相关工具类
 *	@author:qingshanliao
 *  @date  :2017年3月17日
 */
public class FileUtil {
	/**
	 * 删除文件
	 * @param file	将要删除的文件
	 * @return
	 */
	public static boolean deleteFile(File file){
		if (file.exists()) {
			return file.delete();
		}
		//如果不存在,直接返回成功
		return true;
	}
	
	/**
	 * 删除文件
	 * @param path	将要删除的文件路径
	 * @return
	 */
	public static boolean deleteFile(String path){
		File file = new File(path);
		if (file.exists()) {
			return file.delete();
		}
		//如果不存在，直接返回成功	
		return true;
	}
	
	/**
	 * 创建文件
	 * @param file
	 * @return
	 */
	public static boolean createFile(File file){
		try {
			boolean createNewFile = file.createNewFile();
			return  createNewFile;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static boolean createFile(String path){
		File file = new File(path);
		boolean mkdirs = file.mkdirs();
		return mkdirs;
	}
	
}
