package com.tool;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class test {

public static void main(String[] args) {
    File f =new File("TileTest.java");

    String fileName=f.getName();

    String fileLast=fileName.substring(fileName.lastIndexOf("."));
  
	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");//设置日期格式
	String date = df.format(new Date());
	int userId = 1;
	fileName = userId + date + fileLast;
	System.out.println(fileName);
	
	int nums[] = {2,3,4,7,8};
	String result = Arrays.toString(nums);
	System.out.println(result);
	System.out.println(result.substring(1,nums.length*3-1).replace(" ",""));
	System.out.println(result.substring(1,nums.length*3-1).replace(" ","").length());

}
}
