package com.offer;

import java.util.Scanner;

/*	二维数组中的查找
 * 在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，
 * 输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class find {
	public boolean Find(int target, int [][] array) {
		

		for (int i = 0; i < array.length; i++) {
			for (int j = 0;j < array[i].length; j++) {
				if(target == array[i][j]) {
					return true;
				}
			}
		}
		return false;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入行数");
		int rowNum = sc.nextInt();
		System.out.println("输入列数");
		int colNum = sc.nextInt();
		System.out.println("输入二维数组第一个数");
		int firstNum = sc.nextInt();
		int [][] array = new int[rowNum][colNum];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = firstNum++;
			}
		}
		System.out.println("输入目标数字");
		int target = sc.nextInt();
		find find = new find();
		boolean result = find.Find(target, array);
		System.out.println(result);
	}
}
