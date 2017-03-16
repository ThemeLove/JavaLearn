package com.theme.javalearn.zip;
/**
 * 压缩解压缩工具
 * @author:lqs
 * @date  :2017年3月4日
 */
public class UnZipTool {
	
	private static String sourcePath="E:/WorkSpace/MyEclipse/Java/压缩文件Test.txt";
	private static String zipPath="E:/WorkSpace/MyEclipse/Java/压缩文件Test.zip";
	
	public static void main(String[] args) {
		UnZipManager.zip(sourcePath, zipPath);
	}
}
