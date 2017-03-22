package com.theme.javalearn.base;

import java.io.File;

import com.theme.javalearn.util.FileUtil;

/**
 *	@author:qingshanliao
 *  @date  :2017年3月17日
 */
public class FileTest {
		public static void main(String[] args) {
			String basePath = System.getProperty("user.dir");
			System.out.println(basePath);
			
			File deleteFile = new File(basePath+File.separator+"res"+File.separator+"test.txt");
			File newFile = new File(basePath+File.separator+"res"+File.separator+"abc.txt");
			
			System.out.println(FileUtil.createFile(newFile));
			System.out.println(FileUtil.createFile(basePath+File.separator+"res"+File.separator+"abc.txt"));
			System.out.println(FileUtil.deleteFile(deleteFile));
			
//			newFile.createNewFile();		创建一个文件，
//			newFile.mkdirs();   			创建多级目录，可能是文件，也可能是目录
//			newFile.mkdir();				创建目录,如果父目录不存在，则失败
			
		}
}
