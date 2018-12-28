package com.io;
/*
 * 文件拷贝
 * 2017/7/8
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Templates;

class CopyUtil {
	/*
	 * 拷贝文件工具类 1、判断源文件是否存在 2、判断目标文件的父路径是否存在，如果不存在则创建 3、执行拷贝操作
	 * 不需要任何属性，所以建议构造方法私用话，使用static
	 * 
	 */
	private CopyUtil() {
	}

	/*
	 * 判断要拷贝的源路径是否存在
	 * 
	 * @param path输入烦人源路径信息
	 * 
	 * @return 路径存在返回true，否则返回false
	 */
	public static boolean fileExist(String path) {
		return new File(path).exists();
	}

	/*
	 * 判断父路径
	 * 
	 * @param path
	 */
	public static void createParentDirectory(String path) {
		File file = new File(path);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
	}

	/*
	 * 实现文件拷贝操作
	 * 
	 * @param 源路径，目标路径
	 * 
	 * @return 拷贝返回true，否则返回false
	 */
	public static boolean copy(String srcPath, String desPath) {
		boolean flag = false; // 文件拷贝标记
		File inFile = new File(srcPath);
		File outFile = new File(desPath);
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(inFile);
			output = new FileOutputStream(outFile);
			copyHandle(input, output); // 完成具体文件拷贝操作
			flag = true;
		} catch (FileNotFoundException e) {
			flag = false;
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/*
	 * 实现具体的文件操作
	 * 
	 * @param input输入流对象
	 * 
	 * @return output输出流对象
	 */
	private static void copyHandle(InputStream input, OutputStream output) throws IOException {
		long start = System.currentTimeMillis();
		// InputStream 读取单个字节 int read()
		// OutputStream 输出单个字节 void write(int data)
		int temp = 0;
		byte data[] = new byte[1024];
		// do{
		// temp = input.read();
		// output.write(temp);
		// }while(temp != -1);//如果有数据继续读取
		while ((temp = input.read(data)) != -1) {
			output.write(data, 0, temp);
		}
		// 一个字节太慢
		long end = System.currentTimeMillis();
		System.out.println("执行时间" + (end - start));
	}

}

public class CopyDemo {

	public static void main(String[] args) {
		String[] task = { "C:/Users/Anthony/Pictures/006fecvlly1fh70rq9r2uj30k00k0q4f.jpg", "C:/1.jpg" };
		if (task.length != 2) {
			System.out.println("错误");
			System.exit(1);
			;
		}
		if (CopyUtil.fileExist(task[0])) {// 判断文件存在
			CopyUtil.createParentDirectory(task[1]);// 创建父目录
			System.out.println(CopyUtil.copy(task[0], task[1]) ? "拷贝成功" : "拷贝失败");

		} else {
			System.out.println("源文件不存在");
		}
	}
}
