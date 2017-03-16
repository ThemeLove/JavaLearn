package com.theme.javalearn.zip;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @author:lqs
 * @date  :2017年3月4日
 */
public class UnZipManager {
	
	/**
	 * 压缩文件或文件夹
	 * @param sourcePath
	 * @param zipPath
	 */
	@SuppressWarnings("resource")
	public static void zip(String sourcePath,String zipPath){
		File sourceFile = new File(sourcePath);
		File zipFile = new File(zipPath);
		if (sourceFile.isFile()) {
			zipFile(sourceFile, zipFile);
		}else{
//			zipFloder(sourcePath, zipPath);
		}
		
	}
	
	/**
	 * 解压文件或文件夹
	 * @param zipPath
	 * @param sourcePath
	 */
	public static void unZip(String zipPath,String sourcePath){
		
	}
	
	
	/**
	 * 压缩文件
	 */
	private static void zipFile(File sourceFile, File zipFile) {
		try {
			FileInputStream fis = new FileInputStream(sourceFile);

			FileOutputStream fos = new FileOutputStream(zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);
			
			ZipEntry zipEntry = new ZipEntry(sourceFile.getName());
			zos.putNextEntry(zipEntry);
			byte[] bys = new byte[1024];
			int len = 0;
			while ((len = fis.read(bys))!= -1) {
				zos.write(bys, 0, len);
			}
			zos.close();//该流一定要关闭，不然压缩的文件打开时会报错： 不可到达的文件末端
			fis.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void zipFloder(File sourceFile,File zipFile){
		
		for (File file : sourceFile.listFiles()) {
			File zipFileTemp = new File(zipFile.getAbsolutePath()+"\\"+file.getName());
			if (file.isFile()) {
				zipFile(file, zipFileTemp);
			}else{
				zipFloder(file, zipFileTemp);
			}
		}
		
		//  sourceFile是文件
		if (sourceFile.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(sourceFile);
				FileOutputStream fos = new FileOutputStream(zipFile);
				
				ZipOutputStream zos = new ZipOutputStream(fos);
				byte[] bys=new byte[1024];;
				int len=0;
				while ((len=fis.read(bys))>0) {
					zos.write(bys, 0, len);
				}
				
				fis.close();
				fos.close();
				zos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{// sourceFile是文件夹
			
		}
	}
	
}
